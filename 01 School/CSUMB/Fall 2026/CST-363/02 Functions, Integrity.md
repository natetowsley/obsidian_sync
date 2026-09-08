---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience/Databases
Date Created: 2026-09-08
---
```table-of-contents
```
---
# Entity Relationship Diagram Aside
![[Pasted image 20260908120706.png]]
## ER Diagram - Crow's Foot Notation
![[Pasted image 20260908120753.png]]

# Identifying vs Non-Identifying Relationships
- Dotted line - **non-identifying** relationship
	- The *child* references the *parent's* primary key as a foreign key, but the child's own primary key does not depend on it
	- The child still has its own identity
	- FK exists, but not part of PK
- Solid line - **identifying** relationship
	- FK is part of PK
![[Pasted image 20260908120706.png]]
- In the diagram above
	- Identifying (solid)
		- Example: `student` -> `advisor`
		- advisor is identified by the student:
		- **PK**: `(s_id)`
	- Non-identifying (dashed)
		- Example: `department` -> `course`
		- course has its own **PK** (`course_id)`
		- `dept_name` is **FK** but not part of course **PK** -> non-identifying

# SELECT DISTINCT
- SQL tables and query results can contain duplicate rows
- To force the elimination of duplicates, insert the keyword `DISTINCT` after `SELECT`
	- `DISTINCT` applies to the entire selected row (all selected columns), not each column independently
- Find the department names of all instructors, and remove duplicates
```sql
SELECT dept_name
FROM instructor;
```
![[Pasted image 20260908121450.png]]
```sql
SELECT DISTINCT dept_name
FROM instructor
```
![[Pasted image 20260908121539.png]]

# "Scalar" Functions
- A scalar function returns one value per row (or per call) - not a table/result set
	- SQL supports a variety of string operators such as
		- Concatenation
			- `CONCAT(last_name, ', ', first_name)`
		- Converting from upper to lower case (and vice versa)
			- `UPPER(name), LOWER(name)`
		- Finding string length, extracting substrings, find a substring etc
			- `LENGTH(name), SUBSTRING(name, 3, 4)`
			- `SELECT POSITION('SU' IN 'CSUMB');` -> returns 2
			- SQL string positions are 1 based
		- Numeric Functions include
			- `ROUND(23.6666, 1)` -> 23.7
			- `ROUND(24.6666)` -> 24

# LIKE Predicate
- The predicate `LIKE` uses patterns to match strings that are described using two special characters
	- percent (`%`)
		- Matches any substring
	- underscore (`_`)
		- Matches any character
- Find the names of all instructors whose name includes the substring 'dar'
```sql
SELECT instructor_name
FROM instructor
WHERE instructor_name LIKE '%dar%';
```
## Examples
- `LIKE '100\%' ESCAPE '\'` matches the string 100%
- `LIKE 'Intro%'` matches any string beginning with 'Intro'
- `LIKE '%Comp%'` matches any string containing "Comp" as a substring
- `LIKE '___'` matches any string of exactly three characters
- `LIKE '___%'` matches any string of at least three characters

# BETWEEN Predicate
- SQL includes a `BETWEEN` comparison operator
- EX: find the names of all instructors with salary between $90,000 and $100,000
```sql
SELECT instructor_name
FROM instructor
WHERE salary BETWEEN 90000 AND 100000;
```
equivalent to:
```sql
SELECT instructor_name
FROM instructor
WHERE salary >= 90000 AND salary <= 100000
```

# Tuple Comparison
```sql
SELECT instructor_name, dept_name
FROM instrcutor
WHERE (ID, dept_name) = ('45565', 'Comp. Sci.');
```
equivalent to:
```sql
SELECT instructor_name, dept_name
FROM instructor
WHERE ID = '45565' AND dept_name = 'Comp. Sci.';
```

# Null Values
- The predicate `IS NULL` can be used to check for null values
- EX: find all instructors whose salary is `NULL`
```sql
SELECT instructor_name
FROM instructor
WHERE salary IS NULL;
```
- The predicate `IS NOT NULL` succeeds if the value on which it is applied is not null
- Ordinary arithmetic involving `NULL` yields `NULL`
- EX: `5 + NULL` returns `NULL`
- Ordinary comparisons such as =, <>, <, etc involving `NULL` evaluate to UNKNOWN
	- EX: `5 < NULL` or `NULL <> NULL` or `NULL = NULL
- The predicate in a `WHERE` clause can involve Boolean operations (`AND`, `OR`); thus the definitions of the Boolean operator need to be extended to deal with the value **unknown**
	- `AND`: (true AND unknown) = unknown, 
	  (false AND unknown) = false,
	  (unknown AND unknown) = unknown
	- `OR`: (unknown OR true) = true,
	  (unknown OR false) = unknown,
	  (unknown OR unknown) = unknown
- `WHERE` keeps a row only when the predicate evaluates to `TRUE`; `FALSE` and `UNKNOWN` are filtered out
- '= NULL' never works; use `IS NULL`

# Integrity Constraints
- An integrity constraint is a condition on data
- If an integrity constraint doesn't hold, there is a problem (or inconsistency) with the data
- Integrity constraint can involve
	- Invalid key value
	- Invalid data value
	- Uniqueness
## Recall: Constraints
- `PRIMARY KEY` = `UNIQUE` + `NOT NULL`
- `FOREIGN KEY` = must reference an existing parent key
- `CHECK` = rejects a row only when its expression is `FALSE`
	- `TRUE` or `UNKNOWN` passes
```sql
CREATE TABLE course (
	course_id VARCHAR(8) PRIMARY KEY,
	title VARCHAR(50), 
	dept_name VARCHAR(20), 
	credits NUMERIC(2, 0), 
	CHECK ( 
		dept_name <> 'Comp. Sci.' OR 
		course_id LIKE 'CS-%' 
	) 
);
```
- If `dept_name` is "Comp. Sci." then `course_id` must start with "CS-"
- `<>` can also be written in PostgreSQL as `!=`
---
# References
1. 