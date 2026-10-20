---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience
  - ComputerScience/Databases
Date Created: 2026-10-20
---
```table-of-contents
```
---
# Why Normalize?
## Complication: Redundant Attributes
- From previous design lecture, a 1:N relationship translates naturally to a foreign key on the N side:
```sql
department(dept_name [PK], building, budget)
instructor(ID [PK], name, salary, dept_name [FK])
```
- Each instructor works in one department
- `department.dept_name` identifies a department
- `instructor.dept_name` references that department
- This is not a problem, the foreign key is how the relationship is represented
## Where Redundancy Appears
- Suppose instead we combine instructor and department info:
```sql
instructor_department(
	ID,
	name,
	salary,
	dept_name,
	building,
	budget
)
```
- If several instructors work in the same department
	- building is repeated for each instructor
	- budget is repeated for each instructor
	- changing a department fact may require changing many rows
- The problem is not the foreign key - it is storing the same department facts repeatedly
## Removing the Redundancy
- Separate facts according to what they describe:
```sql
department(dept_name [PK], building, budget)

instructor(
	ID [PK],
	name,
	salary,
	dept_name [FK]
)
```
- Department facts are stored once in `department`
- Instructor facts are stored once in `instructor`
	- `instructor.dept_name` remains because it represents the 1:N relationship
	- building and budget do not belong in every instructor row
- Store each fact where its meaning belongs

# Recall: Weak Entities
- A weak entity depends on an owner for its domain identity
- Its relational key includes:
	- the owner's key, and 
	- the weak entity's partial key
- The owner key becomes both:
	- a foreign key, and
	- part of the composite primary key
```sql
Section key = (course_id, sec_no, semester, year)
```

# Normal Forms
## Features of Good Relational Designs
- Suppose we combine `instructor` and `department` information into one relation
![[Pasted image 20261020104504.png]]
## The Issue
- Department information is repeated across multiple rows
	- `building` and `budget` are repeated for every instructor in that department
- This redundancy can lead to:
	- insert anomolies
	- delete anomalies
	- update anomalies

# Insert Anomaly
- **Insert anomaly**: Occurs when one fact cannot be inserted without also inserting unrelated or redundant information
- What if you want to add a new department, but currently no instructor works in that department?
	- In this design, if `ID` is the primary key, a department cannot be recorded unless and instructor row exists for it

# Delete Anomaly
- **Delete anomaly**: Occurs when deleting one fact accidentally removes another fact that should be preserved
- What happens if we delete the last instructor in a department?
	- We also lose the only stored copy of that department's information, such as its building and budget

# Update Anomaly
- **Update anomaly**: Occurs when the same fact is stored in multiple rows
	- If one copy is updated and another is not, the data becomes inconsistent
- What if the Physics department budget is updated in Einstein's row, but not in Gold's row?
	- Then the database contains two different budget values for the same department

# Functional Dependency
- A functional dependency `X -> Y` means:
	- If two rows agree on X, they must also agree on Y
	- EX: `student_id -> name`
		- If `student_id` identifies a student, then the same `student_id` cannot appear with two different names

# Normalization Intuition
- In a well designed relation, every non-key attribute should depend on:
	- The key, the whole key, and nothing but the key
	- **The whole key** -> No partial dependency
	- **Nothing but the key** -> No transitive dependency
- This helps avoid redundancy and update anomalies
## Example
- `student (student_id, name, dept_name, tot_creds)`
- `student_id -> (name, dept_name, tot_creds)`
	- Each `student_id` refers to exactly one student record
	- Once we know `student_id`, we also know that student's `name`, `dept_name`, and `tot_creds`
	- So two rows with the same `student_id` cannot disagree on those values

# Normal Forms - 1NF, 2NF
- **1NF (First Normal Form)**
	- Each field contains only atomic (indivisible) values
	- No repeating groups or multi-valued attributes in a single row
- **2NF (Second Normal Form)**
	- The relation is already in 1NF
	- Every non-key attribute is fully functionally dependent on the entire primary key
	- No partial dependencies on part of a composite key
## 1NF Violation?
| `student_id` | `name`  | `courses`            |
| ------------ | ------- | -------------------- |
| `1001`       | Alice   | `CS101`, `MATH200`   |
| `1002`       | Bob     | `CS101`              |
| `1003`       | Charlie | `PHYS300`, `MATH200` |
- `courses` contains multiple values in one field, so the relation is not in 1NF
## 2NF Violation?
| `student_id` | `course_id` | `student_name` | `grade` |
| ------------ | ----------- | -------------- | ------- |
| `1001`       | `CS101`     | Alice          | A       |
| `1002`       | `MATH200`   | Alice          | B+      |
| `1003`       | `CS101`     | Bob            | B       |
- Assuming the key is (`student_id`, `course_id`), `student_name` depends only on `student_id`
- This is a partial dependency, so the relation is not in 2NF

# Third Normal Form (3NF)
- The relation must already be in 2NF
- Every non-key attribute must depend directly on the key
- No non-key attribute should depend on another non-key attribute
## 3NF Violation?
| `employee_id` | `student_name` | `department_id` | `department_name` |
| ------------- | -------------- | --------------- | ----------------- |
| `2001`        | Alice          | D10             | Accounting        |
| `2002`        | Alice          | D20             | HR                |
| `2003`        | Bob            | D10             | Accounting        |
- `employee_id` determines `depatment_id`, and `department_id` determines `department_name`
- So `department_name` is transitively dependent on `employee_id`, which violates 3NF

# Denormalization and Tradeoffs
- Normalization improves data integrity and reduces redundancy
- But highly normalized schemas can require more joins
- More joins can make some queries slower or more complex
- In read-heavy systems, we may intentionally denormalize
	- To simplify queries
	- To reduce join cost
	- To improve reporting or analytics performance
- This is a tradeoff:
	- **Normalization** favors consistency and maintainability
	- **Denormalization** favors read performance and convenience
---
# References
1. 