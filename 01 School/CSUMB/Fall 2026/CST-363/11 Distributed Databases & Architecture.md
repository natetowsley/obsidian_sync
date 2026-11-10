---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience
  - ComputerScience/Databases
Date Created:
---
```table-of-contents
```
---
# Server Scaling - Scale-up VS Scale-out
## Scale-Up (one bigger machine)
![[Pasted image 20261110103523.png]]
- Add more CPU, RAM, and storage to one database server
- **Pros**
	- Simpler to manage
	- Low single-request latency
- **Cons**
	- Hardware limits
	- Single point of failure
## Scale-Out (more machines)
![[Pasted image 20261110103631.png]]
- Add more servers and split the data or workload across them
- **Pros**
	- Grows capacity step-by-step
	- Can improve availability
- **Cons**
	- Requires partitioning, coordination, and replication

- Simple Rule: 
	- Scale-out is often cheaper **when your data and workload can be split across machines**
- Why scale-up has limits:
	- In one large server, many CPUs still share the same memory and storage system
	- As more CPUs compete for those shared resources, each hardware upgrade tends to deliver **smaller gains**
- Where the money goes:
	- **Scale-up costs**: Premium hardware, expensive high-end servers, and sometimes higher software licensing costs
	- **Scale-out costs**: More engineering complexity - partitioning, replication, routing, failover, and monitoring

# Mini-Glossary
- **High availability (HA)**: The system keeps working if a machine fails
- **Node:** One database server instance in the cluster
- **Sharding (partitioning):** Splitting data across machines
- **Replication**: Keeping extra copies of data on other nodes or machines
- **Replica**: One copy of data stored on a node
- **Shard key / distribution key**: The value used to decide which machine stores the data

# A Distributed Database Does Two Things
- **Distribution**
	- Place partitions of data on different machines
- **Replication**
	- Place copies of data on different machines
- Goal:
	- Higher availability
	- Higher durability
	- Better performance / scalability
- Reality:
	- Distributed systems usually make tradeoffs in functionality, transactions, or performance

# Sharding
## What it is
- **Sharding**: Split one large table or collection into smaller pieces (**Shards**), each stored on a different server
- Pick a **shard key** (for example, `user_id`)
	- The shard key determines which shard stores each row or document
- **Range Example:** keys `1-100,000` -> shard 1; `100,001-200,000` -> shard 2
- A router or coordinator uses the shard key to send reads and writes to the correct shard
- Queries that do not use the shard key may need to contact many shards and merge the results
## Key Range vs Hash
### Key Range (e.g. `last_name`)
![[Pasted image 20261110104843.png]]
```sql
name LIKE 'M%'
```
- Query can target one shard
- Good for range / prefix lookups
- Risk: uneven data and hot spots
### Hash (e.g. `hash(last_name))
![[Pasted image 20261110104951.png]]
```sql
name LIKE 'M%'
```
- Query may touch many shards
- Better load balance
- Worse for range / prefix lookups
## Balancing Partitions
- Keeping partitions balanced in size and workload is a major challenge
	- Real systems split large partitions and may move data between machines
	- Rebalancing can happen while the system stays online
## Pros and Cons
- **Positives:**
	- Enables horizontal scaling of storage and query workload
	- Simplest case: One large table partitioned using a well-chosen shard key
- **Drawbacks:**
	- Not transparent - queries must be routed correctly
	- Queries over non-key columns must be done on all servers and the results merged together
	- Aggregations, joins, subqueries more complicated
	- When a database is overloaded, moving part of its load to another server is not easy
	- More servers means more opportunities for failure
	- Need to keep replicas to ensure availability, which is more work for application

# Distributed RDBMS
### Data Placement
- While relational databases explored scale-out early, general-purpose application developers in the Postgres/MySQL world started demanding it much more in the 2010s
	- A distributed relational database also partitions data using a **distribution key**
	- **Range distribution**
		- Each shard stores a range of distribution-key values
	- **Hash distribution**
		- Each shard is assigned part of the hash space of the distribution key
	- Shards can later be **moved, split, or merged** to rebalance the cluster
### Co-Location and Reference Tables
- **Co-location**
	- Keep related rows from different tables on the same node
	- Enables faster joins on the distribution key
- **Reference tables**
	- Small tables replicated to every node
	- Useful for joins, lookup tables, and shared dimensions
- Key idea:
	- Distribution design affects which joins are cheap
### Distribution vs Replication
- **Distribution**
	- Which node stores the primary copy of a row or shard?
- **Replication**
	- Which other nodes store extra copies of that same data?
- Distribution helps with scale
- Replication helps with availability and durability
#### Leader-Follower Replication
1. One replica is designated as the leader
	- All write requests are sent to leader; leader updates its local store
2. Other replicas are followers
	- Leader sends data change to followers
		- Followers update their local copy, and acknowledge the leader
3. Read requests can be sent to any replica
	- For consistency, send read requests to leader
		- Reading from a follower may result in stale data but distributes the read workload
![[Pasted image 20261110110341.png]]
#### Multi-Leader (Peer-to-Peer) Replication
- Another replication design pattern
- Multiple replicas can accept write requests
- Clients can send writes to a nearby writable replica
- Changes are propagated to other replicas
- Concurrent writes can cause conflicts that must be resolved
![[Pasted image 20261110110519.png]]

# Replication Issues

| **Issue**                                                     | **Leader-Follower**                                                                                 | **Peer-to-Peer**                                                 |
| ------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------- |
| **Consistency**<br>- Most current reads?<br>- See own writes? | Follower reads may be stale<br>Reads from master for stronger consistency                           | Reads may get stale data                                         |
| **Consistency**<br>- When is a write complete?                | After master only?<br>Master + 1 follower?<br>All followers?<br>Master may crash before propogation | Same.                                                            |
| **Consistency**<br>- Eventual consistency                     | Followers eventually sync with master                                                               | Eventual consistency, but concurrent replica writes can conflict |
| **Availability**                                              | If master fails, elect the most up-to-date replica                                                  |                                                                  |
| **Performance**                                               | Write load may bottleneck at the master                                                             | Write load can be balanced more evenly                           |
## From Replication to Tradeoffs
- Replication improves availability and fault tolerance
- But replication also creates hard questions:
	- Can reads be stale?
	- When is a write considered complete?
	- What happens if machines cannot communicate?
- These questions lead to a bigger idea
	- In a distributed database, consistency and availability can come into conflict
# CAP Theorem Definitions
- **Consistency**
	- Every client sees the same, most up-to-date data
- **Availability**
	- Every request gets a response, even if some nodes have failed
- **Partition tolerance**
	- The system continues operating even if messages are lost or delayed between nodes
## CAP Theorem (Brewer's Theorem)
- In a distributed system, network failures can split nodes apart
- Because of that, **partition tolerance is not optional**
- During a partition, a system must lean towards:
	- **Consistency**: Return current data or an error
	- **Availability**: Always return a response, even if data may be stale
![[Pasted image 20261110111421.png]]

# CAP in Practice
- Suppose a network failure splits the cluster into two groups of nodes
- A system that favors **consistency**
	- May reject some reads or writes
	- Avoids returning stale or conflicting data
- A system that favors **availability**
	- Continues answering requests
	- May return older data until replicas catch up

# Citus: Distributed PostgreSQL
- Citus is a **PostgreSQL extension** for distributes tables
- It helps with:
	- **data modeling for scale** through a distribution key
	- **horizontal scaling** across multiple nodes
	- **distributed query execution** across workers
- Strength:
	- Stay in PostgreSQL / SQL
	- Good performance when data is well co-located
	- Can start on one node and scale out later
- Tradeoffs:
	- Query plans depend heavily on the distribution key
	- Some joins, foreign keys, and transaction patterns become harder
## What Using It Looks Like
- Start with ordinary PostgreSQL tables
- Choose a **distribution column**
	- For example, `tenant_id` in a multi-customer Software as a Service (Saas) app
		- Or `customer_id` in a retail system
- Convert a table into a **distributed table**
- Mark small shared lookup tables as **reference tables**
- Goal:
	- Keep related data on the same node
	- Make common joins cheaper
	- Scale out later without changing SQL completely
## Mini-Demo: Distributed PostgreSQL with Citus
```sql
CREATE EXTENSION citus;

CREATE TABLE orders (
 tenant_id int,
 order_id int,
 amount numeric,
 PRIMARY KEY (tenant_id, order_id)
);

CREATE TABLE tenants (
 tenant_id int PRIMARY KEY,
 name text
);

SELECT create_distributed_table('orders', 'tenant_id');
SELECT create_reference_table('tenants');
```
- `orders` is distributed by `tenant_id`
- `tenants` is copied to all nodes as a reference table
	- `tenant_id` = the customer or organization using the shared application
- Queries that join on `tenant_id` scale better because related rows stay on the same node
### Example Join
- This is still SQL, but performance depends on how the data was distributed
```sql
SELECT t.name, count(*)
FROM orders o
JOIN tenants t USING (tenant_id)
GROUP BY t.name;
```

# NoSQL: What it is and Why it Grew
- **NoSQL** refers to **non-relational** databases
- Common types:
	- key-value
	- document
	- column-family
	- graph
- Origins of the modern NoSQL wave: mid-to-late 2000s Web-scale applications needed:
	- Horizontal scaling
	- High write throughput
	- Flexible schema
- Broader industry popularity: early 2010s
- Today: NoSQL's hype has declined, but not its relevance
## Why NoSQL if Distributed SQL Already Exists?
- Distributed relational databases can scale out
- But they still depend heavily on:
	- Good distribution-key choices
	- Co-located joins
	- Query patterns that match the data layout
- Some applications also want:
	- Flexible schema
	- Nested / semi-structured data
	- Simpler document-oriented modeling
- That is where document databases like MongoDB become attractive

# MongoDB Architecture
- Diagram shows example of 3 shards, each with replicas for reliability
![[Pasted image 20261110121824.png]]
## MongoDB: Sharding and Query Routing
- Clients connect to a `mongos` router, which forwards requests to the appropriate shards
- A query specifying an exact value for the **full shard key** can be routed to a single shard (**targeted query**)
	- `_id` only works this way when it is the shard key
- Queries that cannot be targeted are sent to all shards (**scatter-gather**); `mongos` merges the result
- **Config servers** maintain metadata mapping shard-key ranges (**chunks**) to shards
	- `mongos` caches this metadata for routing
	- Config servers typically use a 3-member replica set for reliability
## MongoDB: Replication and Read Consistency
- Each shard is typically a **replica set** using primary-secondary replication
- Writes go to the primary, which replicates changes to secondaries
- **Read preference** controls which replica serves a read
	- Default: `primary`
	- Example: `secondaryPreferred` allows reads from secondaries
- **Read Concern** controls consistency guarantees
	- `local`: Data may later be rolled back
	- `majority`: Returns majority-committed data that will not be rolled back
- **Write Concern** controls how many replicas must acknowledge a write before it is considered successful
## CAP in Practice (MongoDB Example)
- **Partition tolerance (P) is non-negotiable**
	- Networks can partition, so distributed databases must handle lost communication between nodes
- **MongoDB favors consistency of primary leadership over write availability**
	- A replica set needs a majority of voting members to elect and maintain a primary
	- During an election, writes are unavailable
	- A minority partition cannot maintain a primary, but reads from secondaries may still be possible
- **Write concern affect acknowledgment and durability**
	- `w:1`: Acknowledge after the primary accepts the write; faster, but the write may be rolled back
	- `w:"majority"`: Wait for majority acknowledgment; stronger durability, but potentially slower or unavailable if acknowledgments cannot be obtained
- Read preferences
	- `primary` (strong consistency)
	- `secondaryPreferred` (higher availability, possible stale reads)
- When to pick which
	- A-leaning for logging or analytics where occasional data lag is fine
	- C-leaning for financial transactions or user profile updates where correctness is critical

# Two Architectural Paths
- **Distributed PostgreSQL (Citus)
	- Keeps the relational model
	- Works best when data can be distributed by the right key
- **MongoDB**
	- Uses a document model
	- Works well for flexible schema and nested data
- Both rely on:
	- Partitioning
	- Replication
	- Tradeoffs between consistency and availability
---
# References
1. 