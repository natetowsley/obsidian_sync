---
📕 Courses:
  - "!!Intro to Databases"
tags:
  - ComputerScience
  - ComputerScience/Databases
Date Created: 2026-10-13
---
```table-of-contents
```
---
# Translation is rule-based
- Two transformation, three levels:

| **ER Construct**        | **Relational Construct**         | **PostgreSQL syntax**         |
| ----------------------- | -------------------------------- | ----------------------------- |
| entity set              | relation                         | `CREATE TABLE`                |
| identifier              | primary key                      | `PRIMARY KEY`                 |
| relationship set        | foreign key or junction relation | `REFERENCES` / junction table |
| participation (FK side) | required or optional reference   | `NOT NULL` or nullable        |
- The goal is not to memorize isolated cases
- The goal is to see how conceptual decisions become executable constraints

# Before Relationships: Translate Attributes
![[Pasted image 20261013123917.png]]

| **Conceptual attribute** | **Relational Translation** |
| ------------------------ | -------------------------- |
| simple                   | one column                 |
| composite                | component columns          |
| multivalued              | separate table             |
| nullable                 | column may be NULL         |

# Multivalued Attribute Example
- Conceptual `instructor_phones` is multivalued
```sql
CREATE TABLE instructor_phone (
 instructor_id INTEGER NOT NULL REFERENCES instructor (instructor_id),
 phone_number TEXT NOT NULL,
 PRIMARY KEY (instructor_id, phone_number)
);
```
- Why a separate table?
	- A column should hold one value for one row
	- Multiple phones require multiple rows
	- The FK connects each phone back to its instructor
---
# References
1. 