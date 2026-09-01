---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience/Databases
Date Created: 2026-09-01
---
```table-of-contents
```
---
# Database Schema
- A **schema** is the design or structure of a specific database
- An **instance** is a schema "instantiated" with data
**Schema**
```sql
table roster {
	class: string,
	student: string
}
```
![[Pasted image 20260901121626.png]]

# Database Queries
- A **query** is a statement requesting the retrieval of information from a database
- Example `SQL` queries
```sql
SELECT *
FROM customers
WHERE country = 'Guam';
```

```sql
SELECT *
FROM customers
WHERE city = 'Berlin' OR city = 'Munich';
```

# Transactions
- A **transaction** is the *unit of change* in a database
- Transactions contain a set of database operations
- A transaction must succeed, or fail "completely"
- For example, a transaction might be used for moving a student from one class to another

# A Relational DB is a Group of Tables
- A column is also called an **attribute**
- Each attribute has a **domain**, which is a set of values that are allowed in the column
- A row is also called a **tuple**
![[Pasted image 20260901122040.png]]

# Tuples
- A tuple represents a relationship between the values of the tuple
- A table represents a mathematical relation
	- So a table is also called a "relation". This is why we say "relational database"
![[Pasted image 20260901122207.png]]

# Null Values
- Sometimes we don't know a value, or the value doesn't exist
- In relational DBs we deal with this by using special `null` values
![[Pasted image 20260901122318.png]]

# Relation Schema and Instances
- **relation schema**: Gives the names and domains of the attributes (domains not shown here)
	- `student(student_id, student_name, dept_name, tot_cred)`
- **relation instance**: An instance of a *relation schema* (also called a "table")
![[Pasted image 20260901122603.png]]

# Database Schema and Instances
- **database schema**: The relation schemas for all the relations in a database
```sql
student(student_id, student_name, dept_name, tot_cred)
department(dept_name, building, budget)
```
- **database instance**: all the tables of the database
![[Pasted image 20260901122803.png]] 

# All the Names
- In databases there seem to be two or three ways to say everything
	- **schema** = relation schema
	- **table** = relation = relation instance = instance
	- tuple = **row**
	- **attribute** = column

# "Functions" on Tables
- In programming we define objects, and methods on those objects
- For example, for strings we have operations like
	- `substring(string, first, last)`
	- `concat(string1, string2)`
- In relational databases the objects are tables, and we define functions (operations) on tables

# "Selection" Operator: Pick out Rows of a Table
![[Pasted image 20260901123116.png]]

# "Projection" Operator: Pick out Columns of a Table
![[Pasted image 20260901123200.png]]

# "Union" Operator: Add the Rows of Two Tables
![[Pasted image 20260901123230.png]]

# Removing Duplicate Rows
- As part of applying an operation of relation algebra, duplicate rows should be removed
- Duplicate rows aren't technically allowed in a valid table
- SQL query results may include duplicates unless you use `DISTINCT`

# Defining the Operations
- `selection(table, condition)
	- return the rows of table that meet the condition
	- ex: `t = selection(student, tot_cred > 100)`
- `projection(table, attributes)`
	- returns the specified columns of table
	- ex: `t = projection(student, ["student_name", "student_id"])`
- `union(table1, table2)`
	- returns the table containing the rows of `table1` and `table2`
	- ex: `t = union(student1, student2)
---
# References
1. 