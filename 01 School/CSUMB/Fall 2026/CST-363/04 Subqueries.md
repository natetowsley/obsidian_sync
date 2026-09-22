---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience
  - ComputerScience/Databases
Date Created: 2026-09-22
---
```table-of-contents
```
---
# Set Membership
- List courses offered in either 2009 or 2010
```sql
SELECT DISTINCT course_id
FROM section
WHERE section_year IN (2009, 2010);
```

- List instructors excluding Einstein and Wu
```sql
SELECT DISTINCT instructor_name
FROM instructor
WHERE instructor_name NOT IN ('Einstein', 'Wu');
```

# Subqueries
- A `SELECT` nested inside another SQL statement
	- `SELECT` / `INSERT` / `UPDATE` / `DELETE`
- Common uses:
	- perform tests for set membership
	- make set comparisons
	- determine set cardinality by nesting subqueries in the where clause
- Can be nested in `WHERE` clause, or in `FROM` clause
- A class of subqueries called **scalar subqueries** can appear wherever an expression returning a value can occur
	- 0 Rows -> result is `NULL`
	- 1 Row -> error
## Set Membership with Subqueries
- Find courses offered in both Fall 2009 and in Spring 2010
```sql
SELECT DISTINCT course_id
FROM section
WHERE semester = 'Fall' AND section_year = 2009
AND course_id IN (
	SELECT course_id
	FROM section
	WHERE semester = 'Spring' AND section_year = 2010
);
```

- Find courses offered in Fall 2009 but not in Spring 2010
```sql
SELECT DISTINCT course_id
FROM section
WHERE semester = 'Fall' AND section_year = 2009
AND course_id NOT IN (
	SELECT course_id
	FROM section
	WHERE semester = 'Spring' AND section_year = 2010
);
```

## Comparison
- Find the total number of (distinct) students who have taken course sections taught by the instructor with ID `10101`
### Set Membership with Subqueries
```sql
SELECT COUNT(DISTINCT student_id)
FROM takes
WHERE (course_id, section_id, semester, section_year) IN (
 SELECT course_id, section_id, semester, section_year
 FROM teaches
 WHERE teaches.instructor_id = '10101'
);
```
### Set Membership with Join
```sql
SELECT COUNT(DISTINCT takes.student_id)
FROM takes
JOIN teaches USING (course_id, section_id, semester, section_year)
WHERE teaches.instructor_id = '10101';
```

# Test for Empty Relations
- The `EXISTS` construct returns the value `true` if the argument subquery is nonempty (returns at least one row)
	- `EXISTS (subquery)`
- The `NOT EXISTS` construct returns the value `true` if the argument subquery is empty (returns no rows)
	- `NOT EXISTS (subquery)`
## Correlated subqueries and EXISTS
- A correlated subquery references the outer query inside the inner query
	- Depends on values from outer query
	- Can often be rewritten using joins or aggregation
- Find instructors who have taught more than one distinct course
```sql
SELECT DISTINCT t1.instructor_id
FROM teaches AS t1
WHERE EXISTS (
	SELECT 1
	FROM teaches AS t2
	WHERE t2.instructor_id = t1.instructor_id
		AND t2.course_id <> t1.course_id
);
```
## Select 1 inside EXISTS
- `EXISTS (subquery)` doesn't care about the columns you select
	- It only checks whether at least one row is returned
- Once that database finds a qualifying row, it can stop looking and return `TRUE`
- `SELECT 1` means, "we don't care about the data, just the existence of a row"
### Rewritten with GROUP BY and HAVING
```sql
SELECT instructor_id
FROM teaches
GROUP BY instructor_id
HAVING COUNT(DISTINCT course_id) > 1;
```
## Use of "EXISTS" Clause
- Yet *another* way of specifying the query "Find all courses offered in both the Fall 2009 semester and in the Spring 2010 semester"
```sql
SELECT DISTINCT S.course_id
FROM section S
WHERE semester = 'Fall'
 AND section_year = 2009
 AND EXISTS (
 SELECT 1
 FROM section T
 WHERE semester = 'Spring'
 AND section_year = 2010
 AND S.course_id = T.course_id
 );
```
## Correlated subqueries and NOT EXISTS
- Find all students who have taken every course in the Biology department
```sql
SELECT DISTINCT s.student_id, s.student_name
FROM student AS s
WHERE NOT EXISTS (
	SELECT 1
	FROM course as c
	WHERE c.dept_name = 'Biology'
		AND NOT EXISTS (
			SELECT 1
			FROM takes AS t
			WHERE t.course_id = c.course_id AND t.student_id = s.student_id
		)
);
```
## Subquery in the FROM Clause
- A subquery in the `FROM` clause acts like a derived table within the outer query
- Give the derived table an alias so it can be referenced by the outer query
- Find departments whose average instructor salary is greater than 70,000
```sql
SELECT dept_name, avg_salary
FROM (
	SELECT dept_name, AVG(salary) AS avg_salary
	FROM instructor
	GROUP BY dept_name
) AS dept_avg
WHERE avg_salary > 70000;
```

# Scalar Subqueries
- A **scalar** subquery is one which is used where a single value is expected
- List all departments along with the number of instructors in each department
```sql
SELECT dept_name
	(SELECT COUNT(*)
	FROM instructor
	WHERE department.dept_name = instructor.dept_name) AS num_instructors
FROM department;
```
## Scalar Subquery Rewritten as Aggregation
- List all departments along with the number of instructors in each department
```sql
SELECT dept_name, COUNT(instructor_id)
FROM instructor
GROUP BY dept_name;
```
- Both queries ultimately answer "how many instructors per department?", but the do it in different ways
	- Aggregation approach only looks at `instructor` table
	- This simpler aggregation works for departments having at least one instructor, but omits departments with zero instructors
## Scalar Subqueries Rewritten as Aggregation and Outer Join
- List all departments along with the number of instructors in each department
```sql
SELECT d.dept_name, COUNT(i.instructor_id)
FROM department d
LEFT JOIN instructor i USING (dept_name)
GROUP BY d.dept_name;
```

# With Clause
- The `WITH` clause provides a way of defining a temporary relation whose definition is available only to the query in which the with clause occurs
- Find all departments with the maximum budget
```sql
WITH max_budget AS (
	SELECT MAX(budget) AS mbudget
	FROM department
)
SELECT d.dept_name
FROM department d
JOIN max_budget mb ON d.budget = mb.mbudget;
```
## Complex Queries using With Clause
- Find departments whose total salary is greater than the average total summary among departments with at least one instructor
```sql
WITH dept_total AS (
 SELECT dept_name, SUM(salary) AS total
 FROM instructor
 GROUP BY dept_name
),
dept_total_avg AS (
 SELECT AVG(total) AS avg_total
 FROM dept_total
)
SELECT dt.dept_name
FROM dept_total dt
JOIN dept_total_avg dta ON dt.total > dta.avg_total;
```

# Updates with Scalar Subqueries
- Recompute and update `tot_cred` value for all students
```sql
UPDATE student AS s
SET tot_cred = (
 SELECT SUM(c.credits)
 FROM takes AS t
 JOIN course AS c
 ON c.course_id = t.course_id
 WHERE t.student_id = s.student_id
 AND t.grade <> 'F'
 AND t.grade IS NOT NULL
);
```
- **Note:** Sets `tot_cred` to `NULL` for students with no qualifying completed courses
---
# References
1. 