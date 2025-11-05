---
📕 Courses:
  - "[[!!Internet Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Databases
Date Created:
---
```table-of-contents
```
---
>One to Many: pointer to
>Many to Many: new table pointing to both
---
# Database Design
## Basic Database Concepts
- **Field**: Identifier for single piece of data, such as "first name", "age", "gender", etc.
- **Record**: Collection of the fields that compose an entity. Also known as "row" of information
- **Table**: Collection of related records
- **Database**: Collection of related tables
- **Relational Database**: Collection of tables that are related among them by using common fields
- **Primary Key**: Field or set of fields that identify uniquely each record
	- There cannot be two primary keys with an identical value. Primary key examples: SSN, OtterID
- **Foreign Key**: Primary key that is included in another table in order to relate both tables
	- Having the SSN or OtterID in another table as a reference
![[Pasted image 20251028160158.png]]
## Database Design Process
1. **Determine the Purpose of the Database**
	- Since a database is a collection of *related* tables, having a purpose helps determining what tables belong or do not belong in it
	- The purpose should specify the goal of collecting data on a specific set of tables
2. **Analyze data-generation processes**
	- Become familiar with the existing processes involved in the generation of the data that will be collected
		- Also, analyze any future processes that might be needed and the data that they will generate
3. **Analyze any reports that need to be generated**
	- Make sure that you're including in your database design all of the data required for generating the reports
4. **NORMALIZE your data**
	- Normalization refers to the process or organizing the data to be collected into sets of fields and tables with the goal of reducing **redundancy** and **dependency**
	- Two ways to normalize a database are:
		1. Implementing each of the three Normal Forms, and
		2. Creating an Entity-Relational database
## Normal Forms
### First Normal Form (1NF)
- The 1NF eliminates redundancy within a record:
	- Each record MUST have a unique identifier (Primary Key)
	- The value of each field MUST contain only single values
	- Fields MUST NOT contain the same kind of data
- For instance the following table design violates three times the 1NF

|                          |                                    |
| ------------------------ | ---------------------------------- |
| Student:                 | John White                         |
| Student_email_addresses: | jwhite@csumb.edu, jwhite@gmail.com |
| Teacher1:                | Mary Smith                         |
| Teacher2:                | Jane Snow                          |
| Teacher3:                | Mark Rivera                        |
- The table structure doesn't have a Primary Key
- "Student_email_addresses" is allowing multiple value entries
- The fields "Teacher1", "Teacher2", and "Teacher3" contain the SAME kind of data
### Second Normal Form (2NF)
- Each field must depend on the entire Primary Key Fields
- For instance, the following table design intends to keep track of the courses taken by a student:

|                 |                      |
| --------------- | -------------------- |
| studentOtterId: | whit1234             |
| courseId:       | cst336               |
| semester:       | fall 2025            |
| courseName:     | Internet Programming |
- On the above table structure, the Primary Key is composed the fields: studentOtterId and courseId because BOTH fields identify uniquely each record
	- The first "semester" depends entirely on the Primary Key
	- However the field "courseName" depends only on the "courseID" field, thus this field is violating the 2NF
### Third Normal Form (3NF)
- Non-primary fields MUST NOT depend on any other non-primary fields
- For instance, the following table structure stores data about a client:

|           |                     |
| --------- | ------------------- |
| cliendId: | 1234                |
| name:     | John Snow           |
| email:    | jsnow@gmail.com     |
| phone:    | 312-123-4567        |
| address:  | 789 N Winterfell st |
| city:     | Seaside             |
| state:    | California          |
| zip:      | 93955               |
- This table structure violates the 3NF because the "zip" field depends on the "city" field, and the "city" field depends on the "state" field
### In Summary:
- 1NF: Requires the existence of a Primary Key
- 2NF: Requires that non-key fields be dependent on the whole Primary Key
- 3NF: Ensures 2NF by further requiring that non-key fields be dependent on "nothing but the key"

# Entity - Relationship (E-R) Model
- The E-R Model is used to design and normalize relational databases
- In this model, an **entity** refers to any object in the real world with an independent existence that can be differentiated from other objects
	- Each entity consists of a set of attributes (fields)
- An entity might be:
	- An object with physical existence (e.g. a student, a book, a car)
	- An object with conceptual existence (e.g. a course, a job, a position)
- A **relationship** refers to the way two entities are related or connected
	- For instance, if students can take only one major relationship between the entity "major" and the entity "student" would be a one-to-many (1:M), meaning that a major can be selected by many students and that one specific student can not be in more than one major
## Relationship Types:
- **One-to-One (1:1)**:
	- One entity is related to one other entity and vice versa
		- The fields for both entities should belong in the **same** table
- **One-to-Many (1:M):**
	- An instance of an entity is related to many instances of another entity
	- For example, the "department" - "employee" relationship is 1:M because one specific department can have multiple employees; however, one specific employee belongs to only one department at a given time
		- The primary Key of the table of the "one' entity should be a Foreign Key in the table of the "many

# SELECT: Data Retrieval
## SELECT Statement
- This statement is used to retrieve records from one or more tables
- Its basic syntax is:
```sql
SELECT field_name, field_name2 FROM table_name WHERE expression;
```
- To retrieve ALL fields in the record use:
```sql
SELECT * FROM table_name
```
- If the `WHERE` clause is omitted, the query will retrieve ALL records. Otherwise, it will retrieve just the records that fulfill the WHERE expression
- For instance, the following clause would retrieve all fields corresponding to female students
```sql
SELECT * FROM student WHERE gender = "Female";
```
## The LIKE Qualifier
- The LIKE qualifier allows conducting searches in parts of the string
- For example, let's suppose there is a table called "Movie"
	- To get all the movie titles that end in the word "wind", we can use
```sql
SELECT * FROM movie WHERE movieTitle LIKE "%wind";
```
- The % symbol works as a wildcard character with the LIKE Qualifier
- The following query will search for movie tables with the word "wind" anywhere within the title (not just at the end):
```sql
SELECT * FROM movie WHERE movieTitle LIKE "%wind%";
```

# SQL Joins
- **Inner Join:** Returns the records that have a common value in **both** tables
![[Pasted image 20251028160344.png|450]]
```sql
SELECT *
FROM employee e
INNER JOIN department d
ON e.deptId = d.deptId
```
- **Natural Join:** Similar to the Inner Join, it returns the records that have a common value in **both** tables, however, the common fields must have the **exact same name**
![[Pasted image 20251028160555.png|450]]
```sql
SELECT *
FROM employee
NATURAL JOIN department /*No need for the "ON" clause*/
```
---
# References
1. SELECT authorId, firstName FROM `authors` WHERE profession = 'Physicist';