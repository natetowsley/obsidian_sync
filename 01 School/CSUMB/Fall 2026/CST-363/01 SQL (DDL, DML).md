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
# What is SQL?
- SQL = "Structured Query Language"
- Originally developed at IBM in the early 70's
- Pronounced "sequel" or S-Q-L
- A special-purpose language that lets you express questions about you relational data in a precise way
- SQL serves as the interface between the database and the users/applications
## Parts of SQL
- SQL is not just for writing queries:
- Data-definition language (DDL)
	- create/delete/modify schemas
	- define integrity constraints
	- define views
	- drop tables
- Data-manipulation language (DML)
	- define queries
	- modify tables (insert/delete/modify tuples)
- TCL (Transaction Control Language): `BEGIN`, `COMMIT`, `ROLLBACK`
- DCL (Data Control Language): `GRANT`, `REVOKE`

# Defining a Relation Schema
- What info do you provide when you define a relation schema?
	- Name of table
	- Names and domains of each attribute
	- Primary key
	- Optionally
		- whether an attribute is allowed to have a null value
		- foreign keys
## SQL for Defining a Relation Schema
- Relation schema: `student(student_id, student_name, dept_name, tot_cred, department)`
- DDL table definition:
```sql
CREATE TABLE department (
	student_id VARCHAR(20) PRIMARY KEY,
	student_name VARCHAR(20) NOT NULL,
	dept_name VARCHAR(20),
	tot_cred NUMERIC(3, 0),
	FOREIGN KEY (dept_name) REFERENCES department(dept_name)
);
```
- For each attribute we give the attribute name and type
- We also give the primary key
- The foreign key constraint says:
	- every `dept_name` value in the student table must equal the key of some rows in the department table
- The `NOT NULL` constraint says:
	- no name value in the student table can be `NULL`
- PostgreSQL requires referenced tables exist before creating FKs 
	- `department` needs to be created first

# SQL Constraints Review
- `PRIMARY KEY` = `UNIQUE` + `NOT NULL`
- `FOREIGN KEY` enforces relational integrity
- `NOT NULL` disallows missing values

# Attribute Types
- Recall that attributes can only be simple values, like integers, and strings
- `VARCHAR(n)`: A variable-length string of length at most `n`
- `INT`: an integer - `integer` is also okay
- `NUMERIC(p, d)`: a fixed-point number of `p` total digits, with `d` digits to the right of the decimal point
	- Ex: 123.45 is `numeric(5,2)`
- `FLOAT(p)`: A floating-point number with either 4 byte or 8 byte precision
	- Alternatively can use `REAL` (4 bytes) and `DOUBLE PRECISION` (8 bytes)

# Cascaded Deletes
![[Pasted image 20260901125603.png]]
- `ID` in the **teaches** table is a foreign key that "points to" the `ID` field of the **instructor** table
- What to do when the first row is deleted from the instructor table?
	- Default: delete is rejected if referenced
		- `CASCADE`: referencing rows are deleted automatically
		- `CASCADE` is powerful; use intentionally

# Inserting Rows into a Table
![[Pasted image 20260901125926.png]]
## More Efficient Insert
- PostgreSQL supports multi-row insert
![[Pasted image 20260901130014.png]]

# Deleting or Modifying a Table
```sql
DROP TABLE IF EXISTS instructor;
```
- `DROP TABLE` deletes the table definition (and its data)
```sql
ALTER TABLE instructor ADD office VARCHAR(5);
```
- adds attribute `office` to the instructor schema
- value of office is initialized to `null`
# References
1.
