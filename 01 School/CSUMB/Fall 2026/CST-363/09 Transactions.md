---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience
  - ComputerScience/Databases
Date Created: 2026-10-27
---
```table-of-contents
```
---
# Foundations
## What is a Transaction?
- A **transaction** is a unit of work that transforms the database from one consistent state to another
- Boundaries: `BEGIN ... COMMIT / ROLLBACK`
	- Default: Each SQL statement runs in its own transaction and is committed automatically (autocommit)
- Groups multiple statements so they succeed or fail together (atomicity)
- Visibility: reads see a snapshot; writes become visible to other transactions after `COMMIT`
### EX: Bank Transfer
- Transaction to transfer $50 from account A to account B
	- Debit A, Credit B
		1. `read(A)`
		2. `A := A - 50`
		3. `write(A)`
		4. `read(B)`
		5. `B := B + 50`
		6. `write(B)`
- All must complete or else rollback
### Quick SQL Demo: BEGIN / COMMIT / ROLLBACK
```sql
-- create isolated playground in PSQL
CREATE TEMP TABLE demo(x int);

BEGIN; -- start a transaction
INSERT INTO demo VALUES (1),(2);
SELECT COUNT(*) FROM demo; -- 2
ROLLBACK; -- undo the whole transaction
SELECT COUNT(*) FROM demo; -- 0

BEGIN;
INSERT INTO demo VALUES (1),(2);
COMMIT; -- make it durable
SELECT COUNT(*) FROM demo; -- 2
```

# Statements vs Transactions vs Sessions
- **Statement**: A single SQL command
	- by default (autocommit) each statement is its own transaction
- **Transaction**: One or more statements executed atomically between `BEGIN` and `COMMIT` / `ROLLBACK`
- **Session/connection**: A long-lived context that can execute many transactions and hold settings (e.g. isolation level)
- PostgreSQL default: autocommit ON; explicit `BEGIN` groups statements
## Savepoints (Subtransactions)
```sql
BEGIN;
INSERT INTO demo VALUES (1);
SAVEPOINT s1;
UPDATE demo SET x = x + 1;
ROLLBACK TO s1; -- undo the UPDATE only
COMMIT; -- keeps the INSERT
```

# ACID in Practice
- **Atomicity**: All or nothing
	- Aborted/failed transactions leave no visible effects
- **Consistency**: Constraints & invariants must hold after commit
- **Isolation**: Concurrent transactions should not interfere incorrectly
	- at the strongest level, execution should behave like some serial (one-at-a-time) order
- **Durability**: Once commit is acknowledged, effects survive crashes

# WAL (Write-Ahead Logging) & Crash Recovery
- "Log first, data later": commit is durable when commit record is flushed to disk with WAL
- On crash: REDO from WAL; uncommitted versions remain invisible
- Checkpoints bound recovery time; full-page writes protect against torn-page corruption during recovery

# Transaction Lifecycle
- States: Start -> Active -> Partially Committed -> Committed
- Error Path: Failed -> Aborted
- Commit in PostgreSQL: commit record flushed to disk -> success reported; crash before = abort; after = REDO

# Schedules & Serializability
> How we judge correctness
## Transaction Schedules
- A schedule shows how the operations of multiple transactions are interleaved when run concurrently
	- Serial: Transactions run one after another (no interleaving)
	- Concurrent: operations are interleaved to improve throughput
	- A schedule represents the actual order of operations (reads, writes, commits)
	- Goal: A concurrent schedule should be **as correct as** some serial order -> **serializability**
### Example
- Let **T1** and **T2** be two transactions:
```sql
T1: R(A), W(A)
T2: R(B), W(B)

Schedule:
R(A) (T1)
R(B) (T2)
W(B) (T2)
W(A) (T1)
```
- This is an **interleaved schedule** - a specific ordering of the operations from $T_1$ and $T_2$ during concurrent execution
## Serializable Schedules
- A schedule is **serializable** if its effect is equivalent to some serial schedule (where transactions run one after the other)
	- **Serial Schedule**: $T_1$ then $T_2$ (or $T_2$ then $T_1$), no interleaving
	- **Serializable Schedule**: interleaved, but behaves like one of the serial options
- Serializable schedules ensure correctness, even with concurrency
## Conflict Serializability and Precedence Graphs
- A precedence graph (also called a serializability graph) shows how transactions depend on one another based on conflicting operations
- A schedule is conflict serializable if and only if its precedence graph has no cycles
	- We can rearrange its non-conflicting operations to get an equivalent serial schedule
	- We can prove that a schedule is equivalent to a serial one, by checking the order of conflicting operations
- Use the graph to check: draw an edge from $T_1$ to $T_2$ if $T_1$'s operation process and conflicts with $T_2$'s
### Precedence Graph to Check for Conflict Serializability
- Each node represents a transaction (T1, T2, T3)
- Draw a directed edge from $T_i$ to $T_j$ if:
	- $T_i$ performs an operation before $T_j$ in the schedule
	- Both access the same data item, and
	- At least one operation is a write (conflict)
### Precedence graph example
![[Pasted image 20261027120917.png]]
- $T_1$ -> $T_2$ because $T_1$ reads A before $T_2$ writes A
- $T_1$ -> $T_3$ because $T_1$ reads B before $T_3$ writes B
- $T_3$ -> $T_2$ because $T_3$ reads C before $T_2$ writes C
- There are no cycles in the graph, so this schedule is conflict serializable
### Conflict Serializability: A Two-Transaction Cycle
![[Pasted image 20261027121157.png]]
### Conflict Serializability: A Cycle in a Larger Schedule
![[Pasted image 20261027121224.png]]

# Anomalies
> Names, quick tests, fixes
## Examples of Concurrency Problems
- Lost update
- Inconsistent Read
- Write Skew
- Phantom
## Lost Update Problem
- Two concurrent programs both read and increment the value of record A which has a starting value of 0
- After programs run, the value of A in the database is 1, not 2 as expected
	- One of the two increments is overwritten, so one update is lost
![[Pasted image 20261027121441.png]]
## Inconsistent Rad Problem
- Program `T1` is transferring 100 from account 1 to account 2
- At start
	- Account 1 = 500
	- Account 2 = 100
	- Total = 600
- Program `T2` reads the total amounts in accounts 1 and 2. Program `T2` gets an incorrect total of 700 because it reads one account before the transfer and the other after the transfer
![[Pasted image 20261027121645.png]]
## Write Skew (Constraint Violation)
- A rule says one person may go "off duty" only if the other remains "on duty"
- Each transaction checks the other person's status, sees that the other is still on duty, and then updates its own row to off duty
- If both transaction run concurrently, both may commit, leaving **both off duty** and violating the rule
![[Pasted image 20261027121806.png]]
## Phantom Read
- T1 runs a query based on a condition
- T2 inserts a new row that matches that condition and commits
- If T1 repeats the same query, it may see a different set of rows
![[Pasted image 20261027121920.png]]

# Why Use Concurrent Transactions?
- Performance gain from running transactions concurrently
	- Hardware has multiple CPU cores
	- I/O is slow. While one transaction waits for I/O, another can run
	- In memory databases
	- Data-access may avoid disk I/O
	- Some systems can serialize execution efficiently (e.g. Redis)
- Transactions that access independent data may not interfere
	- Different rows can still be related by a shared constraint
## Concurrency Control Approaches
- **Pessimistic Locking**
	- Assume conflicts may occur
	- Acquire locks before conflicting access
- **Timestamp Ordering**
	- Use timestamps to enforce a consistent order among transactions
	- Not the main concurrency-control mechanism used by PostgreSQL
- **Optimistic Concurrency Control**
	- Assume conflicts are relatively rare
	- Allow transactions to proceed, then detect/validate conflicts
	- Conflicting transactions may be aborted and retried
## Lock-Based Protocols
- A lock is a mechanism to control concurrent access to a data item
- Data items can be locked in two modes:
	- **Exclusive** (X) mode: the transaction may read or write the item
	- **Shared** (S) mode: the transaction may read the item
- Lock requests are made to concurrency-control manager. Done by the DBMS on behalf of the program
	- Program must obtain S lock before reading and X lock before writing
	- When are locks released?
	- Depends on the locking protocol
	- Stricter protocols may hold locks until commit/rollback
- Program can proceed only after request is granted
- Lock compatibility matrix

|     | s   | x   |
| --- | --- | --- |
| s   | ✓   | X   |
| x   | X   | X   |
- A transaction may be granted a lock on an item if the requested lock is compatible with locks already held on the item by other transactions
- Any number of transactions can hold shared locks on an item
- But if any transaction holds an exclusive on the item no other transaction may hold any lock on the item
- A transaction can upgrade an S lock to an X lock
	- If no other transaction has an S lock, then upgrade is granted
	- Otherwise, the transaction must wait until the other S lock holders release their locks
## Two-Phase Locking (2PL): Foundation for Isolation
- Phase 1 (Growing): Transaction acquires locks
- Phase 2 (Shrinking): Transaction releases locks
- Ensures conflict serializability
- Used as the basis for stricter protocols like Strict 2PL and Conservative 2PL
![[Pasted image 20261027124117.png]]
## Strict Two-Phase Locking
- In the classical textbook model of strict 2PL:
	- A transaction acquires shared (S) locks before reading
	- Acquires exclusive (X) locks before writing
	- Holds its write locks until commit or abort
- This model:
	- Guarantees conflict serializability
	- Avoids cascading aborts
	- Can still produce deadlocks
![[Pasted image 20261027124322.png]]
## Deadlock from Lock Upgrade
- Two concurrent transactions both read `A = 0` and hold shared (S) locks
- Both then try to upgrade to an exclusive (X) lock so they can update `A`
- Neither transaction can make progress
- **Deadlock**
	- `T1` waits for `T2` to release its S lock
	- `T2` waits for `T1` to release its S lock
	- The DBMS must break the deadlock, typically by aborting one transaction
![[Pasted image 20261027125129.png]]
## Resolving the Deadlock
- The DBMS detects the deadlock
- T2 is chosen as the victim and rolled back
- T2 releases its S lock
- T1 writes A = 1 and commits
- T2 may retry:
	- Reads the new value A = 1
	- Writes A = 2 and commits
![[Pasted image 20261027153507.png]]
## Avoiding Deadlock
- Use `SELECT ... FOR UPDATE`
	- lock the row when it is read if the program will later update or delete it
	- another `SELECT ... FOR UPDFATE`, `UPDATE`, or `DELETE` on that row may have to wait
	- This can avoid some lock-upgrade deadlocks
- Programs should acquire locks on rows in a consistent order
	- program 1 updates rows from table A, then rows from table B
	- program 2 updates rows from table B, then rows from table A
	- `FOR UPDATE` alone does not eliminate this kind of deadlock
	- Both programs should access A first, then B
## Deadlock Strategies
- Detection: PostgreSQL uses a waits-for graph to detect cycles and resolve deadlocks by aborting one transaction
- Timeouts: Alternative strategy - abort if wait exceeds a threshold
- Prevention protocols (conceptual):
	- Wait-Die: older waits, younger dies (timestamps)
	- Wound-Wait: older preempts (wounds) younger if conflict
	- Conservative 2PL: request all locks up front to avoid circular wait (less concurrency)

# Isolation Levels
- Textbooks usually present isolation levels in terms of which concurrency anomalies are allowed or prevented
- This gives a useful conceptual model:
	- Weaker levels allow more concurrency
	- Stronger levels prevent more anomalies
	- **Serializable** is the strongest standard level
![[Pasted image 20261027154300.png]]
## SQL Isolation Levels: Textbook Model
![[Pasted image 20261027154321.png]]
---
# References
1.