---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience/Databases
Date Created: 2026-09-15
---
```table-of-contents
```
---
# Aggregate Functions
- `COUNT(*)` →  number of rows in result set
- `COUNT(col_name)` → number of rows with a non- NULL value in col_name
- `COUNT(DISTINCT col_name)` → number of distinct non- NULL values
- `SUM(col_name)` → sum of non- NULL column values
- `AVG(col_name)` → average of non- NULL column values
- `MIN(col_name)` → minimum non- NULL value in a column
- `MAX(col_name)` → maximum non- NULL value in a column
## `COUNT(*)` vs `COUNT(col_name)`

| **id** | **name** | **advisor_id** |
| ------ | -------- | -------------- |
| 1      | Olistan  | 10             |
| 2      | Ravira   | *NULL*         |
| 3      | Jorvick  | 12             |
- `COUNT(*)` returns 3 (all rows)
- `COUNT(advisor_id)` returns 2 (ignore Ravira's *NULL*)
## Aside: Introducing Aliases
- Column aliases
	- You can rename a column in the result set using `AS`
		- `SELECT first_name AS fname, last_name AS lname FROM employees;`
		- Result set headers will show `fname` and `lname` instead of first_name and last_name
- Aliasing expressions
	- Can alias computed values
	- `SELECT COUNT(*) AS total_employees FROM employees;`
## Aggregate Functions - `GROUP BY`
- `GROUP BY` is used to aggregate rows that have the same values in one or more columns into summary  rows
- Most often paired with aggregate functions like `COUNT()`, `SUM()`, `MIN()`, and `MAX()`
- Rows are grouped based on specific column(s), then for each group aggregates are computed
- For this course, use the portable rule that every selected column must either:
		- appear in the `GROUP BY` clause, or
		- be used inside an aggregate function
### Example
- Find the average salary of instructors in each department:
```sql
SELECT dept_name, ROUND(AVG(salary), 0) AS avg_salary
FROM instructor
GROUP BY dept_name;
```
## Filter Groups with `HAVING`
- `HAVING` is a filter for groups which filters after grouping/aggregation
- `WHERE` filters rows before grouping/aggregation
1. Take all rows
2. Apply `WHERE` (filter rows)
3. Combine rows into groups with `GROUP BY`
4. Calculate aggregates (`SUM`, `COUNT`, etc)
5. Apply `HAVING` (filter groups)
6. Return results

# Copy Data from One Table to Another
- Make each student in the Biology department who has earned more than 100 credit hours an instructor in the Biology department with a salary of $30,000
```sql
INSERT INTO instructor (instructor_id, instructor_name, dept_name, salary)
SELECT student_id, student_name, dept_name, 30000
FROM student
WHERE dept_name = 'Biology' AND tot_cred > 100;
```
- The `SELECT ... FROM ... WHERE` query is evaluated before its result rows are inserted into the table

# Updates
- Increase salaries over $100,000 by 3% and all other non-`NULL` salaries by 5%
- Write two `UPDATE` statements
```sql
UPDATE instructor
SET salary = salary * 1.03
WHERE salary > 100000;

UPDATE instructor
SET salary = salary * 1.05
WHERE salary <= 100000;
```
- The order is important
	- Running the second statement first could cause some salaries to be updated twice
- This is safer as one statement using a `CASE` expression

# `CASE` Expression for Conditional Updates
- Can use a `CASE` expression inside an `UPDATE` to conditionally set column values
```sql
UPDATE table_name
SET column_name = CASE
 WHEN condition1 THEN result1
 WHEN condition2 THEN result2
 ELSE default_result
END
WHERE <filter_condition>;
```
## Example
- Apply exactly one raise to each non-`NULL` salary
```sql
UPDATE instructor
SET salary = CASE
				WHEN salary <= 100000 THEN salary * 1.05
				ELSE salary * 1.03
			END;
```

# Set Operations
- Find courses that ran in Fall 2009 or in Spring 2010 ***UNION***
```sql
(
 SELECT course_id
 FROM section
 WHERE semester = 'Fall' AND section_year = 2009
)
UNION
(
 SELECT course_id
 FROM section
 WHERE semester = 'Spring' AND section_year = 2010
);
```
- Find courses that ran in Fall 2009 and in Spring 2010 ***INTERSECT***
```sql
(
 SELECT course_id
 FROM section
 WHERE semester = 'Fall' AND section_year = 2009
)
INTERSECT
(
 SELECT course_id
 FROM section
 WHERE semester = 'Spring' AND section_year = 2010
);
```
- Find courses that ran in Fall 2009 but not in Spring 2010 ***EXCEPT***
```sql
(
 SELECT course_id
 FROM section
 WHERE semester = 'Fall' AND section_year = 2009
)
EXCEPT
(
 SELECT course_id
 FROM section
 WHERE semester = 'Spring' AND section_year = 2010
);
```
- `UNION`, `INTERSECT`, and `EXCEPT` eliminate duplicate result rows by default
- `ALL` uses **multiset semantics** instead
	- `UNION ALL` appends every input row
	- `INTERSECT ALL` keeps the smaller occurrence count from the two inputs
	- `EXCEPT ALL` subtracts right-side occurrences from left-side occurrences
- Support varies by database system

# Joined Relations
- **Join operations** take two relations and return as a result another relation
- A Cartesian product contains every possible pair of rows from the two relations
- An **inner join** keeps only the pairs for which its predicate is true
- Join operations are table expressions used in the `FROM` clause
![[Pasted image 20260915123824.png]]
## Ways to Specify an Inner Join
`<table> [INNER] JOIN <table> ON <predicate>`
- Standard explicit join
- The keyword `INNER` is optional
`<table> NATURAL JOIN <table>`
- Joins automatically on all columns with the same name in both tables
- Can be convenient but dangerous if new columns with the same name are added later
`<table> [INNER] JOIN <table> USING (column_name [, ...])`
- Shorthand when joining identically named columns

# Basic Query Structure
- A qeury over multiple tables has the form
```sql
SELECT A1, A2, ..., An
FROM R1
JOIN R2 ON P12
JOIN R3 ON P23 ...
WHERE P
ORDER BY A1, ..., Am
```
- $A_i$ represents an attribute
- $R_i$ represents a relation
- $P$ is a predicate

# How Joins Work
![[Pasted image 20260915124228.png]]
1. Cartesian product
2. Selection
3. Projection
## Inner Join Visualized
- Use the overlap as a mnemonic for **matched rows**, not as a literal set intersection
- SQL joins pair rows according to a predicate and preserve duplicate matches
- An inner join excludes rows that have no matching partner
![[Pasted image 20260915124407.png]]
## JOIN Condition
- The `ON` condition allows a general predicate over the relations being joined
- This predicate is written like a `WHERE` predicate, but uses the keyword `ON`
- EX:
```sql
SELECT *
FROM student
JOIN takes ON student.student_id = takes.student_id
```
- The `ON` condition matches a student row with a takes row when their `student_id` values are equal
- Since `student_id` appears in both tables, qualify it with the table name
- If there is no such match (that is, the student has not taken any courses yet), the student row does not appear in the result
## Natural Join
- A natural join matches rows on equal values in every common column and retains only one copy of each common column
- List the names of students along with course ID of the courses that they have taken
```sql
SELECT student.student_name, course_id
FROM student
JOIN takes ON student.student_id = takes.student_id;
```
- This is equivalent only because `student_id` is the sole column name shared by `student` and `takes`
```sql
SELECT student.student_name, course_id
FROM student NATURAL JOIN takes;
```
- The `FROM` clause can combine multiple relations using `NATURAL JOIN`
```sql
SELECT A1, A2, ..., An
FROM r1
NATURAL JOIN r2 NATURAL JOIN ... NATURAL JOIN rn
WHERE P;
```
## Danger in Natural Join
- Beware of unrelated columns with the same name: a natural join equates them automatically

# Outer Join
- An outer join preserves unmatched rows as well as matched rows
- Columns from a missing match are filled with `NULL`
- Three forms of outer join:
	- `LEFT JOIN` - preserves every row from the left relation
	- `RIGHT JOIN` - preserves every row from the right relation
	- `FULL JOIN` - preserves every row from both relations
![[Pasted image 20260915130710.png]]
## Left Outer Join
```sql
SELECT *
FROM course
LEFT JOIN prereq USING (course_id);
```
![[Pasted image 20260915130740.png]]
## Right Outer Join
```sql
SELECT *
FROM course
RIGHT JOIN prereq USING (course_id);
```
![[Pasted image 20260915131118.png]]
## Full Outer Join
```sql
SELECT *
FROM course
FULL JOIN prereq USING (course_id);
```
![[Pasted image 20260915131141.png]]
---
# References
1. 