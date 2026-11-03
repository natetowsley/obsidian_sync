---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience
  - ComputerScience/Databases
Date Created: 2026-11-03
---
```table-of-contents
```
---
# Why this Matters?
- Real-World Impact: Poorly designed storage and indexes can cause queries to slow down dramatically as data grows
- Trade-offs: Indexing can boost read performance but slow down write times
- Performance: The right data layout can make or break application responsiveness

# Top Down - Start with Query Processing
> What happens when we run an SQL Query?
## Query Processing
- General Steps:
	1. Parse & Rewrite: Convert SQL text into an internal tree structure
	2. Plan & Optimize: Explore possible execution paths (e.g., table scan vs. index scan)
	3. Execute: Execute the chosen plan, reading/writing data from/to storage
- The DBMS picks a plan based on estimated cost; how that cost is calculated depends heavily on how data is physically stored and accessed
![[Pasted image 20261103113247.png]]
### Example
- Find the names of all instructors in the Music department along with the title of all the courses they teach
```sql
SELECT i.name, c.title
FROM instructor AS i
JOIN teaches AS t ON t.id = i.id
JOIN course AS c ON c.course_id = t.course_id
WHERE i.dept_name = 'Music';
```
#### Transforming the Relational Algebra
- The relational algebra expression of the last slide
![[Pasted image 20261103113442.png]]
- The expression on the right gives the same result, but the `selection` is pushed down, reducing the size of intermediate results - usually better!
![[Pasted image 20261103113525.png]]

# Cost-Based Optimizer Essentials
- Cost Estimation Factors
- CPU operations per row or per operation
- I/O costs (particularly random vs. sequential reads)
	- Data distribution (row count, statistics, histograms)
- Example
	- The optimizer weighs a Seq Scan vs an Index Scan for e.g., `WHERE dept_name = 'Music'` by:
		- Estimating the fraction of rows matching "Music"
		- The cost of scanning those rows
		- The overhead of random I/O with an index

# From Query Plans to Physical Storage
- Physical Operations:
	- Sequential Read: Reads entire table in order, good when many rows match or the table is small
	- Random Read: Jumping to a specific location (index scans). May be more expensive if repeated many times
- Influence  on Query Plan:
	- If the data is scattered and the result set is large, the optimizer might prefer a sequential scan
	- If the data is small and well-indexed, the index scan could be faster, even with some random I/O
- High level plan choices map down to real I/O patterns

# Storage Performance Metrics
- Access Time vs Transfer Rate
	- Access Time: The overhead to reach the first byte (seek latency)
	- Transfer Rate: Speed of continuous read/write once found
- Sequential vs Random I/O
	- Sequential I/O is typically cheaper (good for large range scans)
	- Random I/O is typically costlier, especially on HDDs (requires more "seeks")
- Measurement Units
	- IOPS (Input/Output Operations per Second)
	- MB/s throughput
	- Latency (ms) per operation
## Key Point
- Underlying hardware is optimized for sequential operations
- Frequent random I/O operations can degrade performance
![[Pasted image 20261103115745.png]]

# Data Storage Structures
- Row-Oriented Storage
	- Data is stored tuple-by-tuple, typical "heap" structure in PostgreSQL
	- PostgreSQL stores tables and indexes in fixed-size pages/blocks (typically 8 KiB)
- Volatile vs Non-Volatile Memory
	- Volatile (RAM): Fast, but lost on power-down
	- Non-Volatile (SSD/HDD): Persistent storage but slower
![[Pasted image 20261103120201.png]]

# PostgreSQL Heap Organization Structure
- Table data stored in an unordered heap structure, with rows (tuples) stored in 8 KiB pages
- Persistent disk-based storage for tables
- Supports tuple versioning (Multi-Version Concurrency Control or MVCC) for concurrency
## Aside: Multi-Version Concurrency Control (MVCC)
- Postgres can keep multiple row versions
- Every `UPDATE` -> new row version
	- Old version stays until no active transaction needs it
- `DELETE` is not the same as remove
	- It marks a version dead; `VACUUM` later reclaims space
## Example: The "products" table structure
```sql
CREATE TABLE products (
	product_id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL UNIQUE,
	description TEXT,
	price DECIMAL(10, 2) NOT NULL CHECK (price >= 0)
);
```

```
-- Check the block size
SHOW block_size;
```
- Accessing a row means PostgreSQL works with the containing 8 KiB page

# From Heap Storage to Indexing
- Python Homework 4 stores rows in 8 KiB blocks
- The bitmap tells us which row slots are occupied
- `lookup_by_key()` still has to search the heap
- As the table grows, that means examining more rows/pages
> Can we find the row without searching the whole heap?
![[Pasted image 20261103120757.png]]

# Indexing Strategies (Overview)
- An index is a data structure that improves the speed of data retrieval without scanning the entire table
	- It maps keys (column values) to pointers (row locations), reducing search time
- Why Indexes?
	- Speed up lookups and queries
	- Cost: Slower writes (`INSERT`, `UPDATE`, `DELETE`) due to index maintenance
- Single-Level indexing
	- Simple structure: Sorted list of (key, pointer)
- Multi-Level indexing
	- Tree-based approach (e.g., B-Tree) with multiple levels for large data sets
	- Fan-out depends on block size & key size

# B-Trees in PostgreSQL
- Balanced Tree: All leaf pages are at the same level
- Internal Nodes store partial keys/pointers
- Leaf Pages contain the actual (key, pointer-to-table-row)
- Insertion: Splits occur is a page is full

# Review: Trees
- A tree organizes data into **parent / child relationships**
	- One node is the root
	- Nodes can have children
	- Nodes with no children are leaves
	- Searching means following a path from the root toward a leaf

# Review: Binary Trees
- A binary tree allows each node to have at most two children
	- Left child
	- Right child
- Binary trees are easy to visualize, but database indexes usually want many children per node
![[Pasted image 20261103121309.png]]

# From Binary Trees to m-Way Trees
- An m-way search tree allows a node to hold several keys and branch in several directions
	- A node can contain multiple sorted keys
	- The keys divide the search space into ranges
	- If a node has $k$ keys, it can have up to $k + 1$ children
	- At each node, choose the child containing the range you need
- Example:
	- A node containing:
		- `50 | 60 | 80`
	- Can direct a search toward:
		- `< 50 | 50 - 60 | 60 - 80 | > 80`
## Example: 4-way Search Tree
![[Pasted image 20261103121540.png]]
- To search:
	1. Compare the value with the keys in the current node
	2. Follow the matching range
	3. Repeat until the value is found or we reach a leaf
	4. More branching means fewer levels to traverse

# What Makes a B-Tree Special?
- A B-tree is a balanced m-way search tree designed to stay shallow
	- Each node can contain **many keys**
	- Nodes are kept reasonably full
	- **All leaves are at the same level**
	- Insertions may cause a full node to **split**
- Why databases like B-trees:
	- High fan-out + balanced height = only a few levels to search

# Why B-Trees Work Well for Databases
- A B-tree node can correspond roughly to a storage page
- Each page contains many keys
- Each level narrows the search dramatically
- Even a very large index can remain only a few levels deep
![[Pasted image 20261103121834.png]]

# B-Tree Insertions in Action
```sql
INSERT INTO products (name, description, price)
VALUES ('GeoStore Basic HX', 'Compact geothermal heat exchanger', 1499.99);
```
- Heap Insert: Creates a new row in products
- Index Update: The new price value of (`1499.99`)  is added to `idx_price`
- If leaf node is full, Postgres splits the B-tree page
- Performance Tip: Frequent inserts + many indexes -> can slow write operations

# Seq Scan vs Bitmap Heap Scan
![[Pasted image 20261103122354.png]]

# Hash-Based Storage & Indexing
- Hash Index
	- Uses hash function (e.g., modulo-based) to bucket row locations
	- Good for equality lookups (=), not for ranges (<, >, BETWEEN)
	- Less common in production, but fully WAL-logged since PostgreSQL 10
	- WAL = Write-Ahead Log (more on this in our module on Transactions)
- Handling Updates
	- Bucket splits if the number of entries grows large
	- Potential for collisions - requires conflict resolution

# Sorting & Organization of Data
- Sorted Table Structures
	- Physical order of rows follows sort column(s). (Not default PostgreSQL)
	- Useful if the workload benefits heavily from sequential range scans
	- Can speed range scans on that column but costly to maintain if data is update frequently
	- `CLUSTER` Command
		- Rewrites a table on disk according to an index's order
		- `CLUSTER` command can reorder table data based on an index
		- Note: The table won't stay clustered automatically. Over time, inserts/updates can reduce the clustering effect

# Optimizing Query Performance with Indexes
- When to use an Index
	- High read/select workloads
	- Columns frequently used in WHERE predicates or JOIN conditions
- Avoid Over-Indexing
	- Each index must be maintained on INSERT / UPDATE / DELETE
	- Too many indexes -> slower write performance
- Choosing the Right Index Type
	- B-Tree:  Most typical for equality and range queries
	- Hash: Pure equality
	- GIN/GIST: Full-text search, geo data, JSONB, etc

# Multi-Column & Unique Indexes
- Multi-Column Index
	- Used when queries filter on multiple columns frequently
	- B-tree multicolumn indexes are usually most effective when queries constrain the leading columns
- Unique Index
	- Enforces uniqueness constraint
	- PostgreSQL automatically creates a unique index for PRIMARY KEY or UNIQUE constraints

# Joins & Index Usage
- How indexes help with JOIN
	- If foreign key columns or join columns are indexed, lookups become faster
- Nested Loop Join
	- Ideal if the inner table can be quickly searched via index
- Hash Join
	- Works well for large tables
	- Builds an in-memory hash table (if memory allows)
- Optimizer Choice
	- PostgreSQL chooses the cheapest plan based on statistics & cost

# Trade-Offs & Performance Tips
- Balance Read vs Write
	- Many indexes help reads, but hurt writes
- Maintenance
	- VACUUM / ANALYZE are important for heavily updated tables
- Covering Indexes
	- Include columns in the index to avoid table lookups
- Clustering
	- Periodic `CLUSTER` can improve range scan performances but is expensive
---
# References
1. 