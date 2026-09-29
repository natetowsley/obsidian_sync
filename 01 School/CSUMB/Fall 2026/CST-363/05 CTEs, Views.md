---
📕 Courses: 
tags: 
Date Created:
---
```table-of-contents
```
---
# Common Table Expressions (CTEs)
## What is a CTE (Common Table Expression)?
- A Common Table Expression (CTE) is a temporary result result set that is defined within a SQL statement using the `WITH` keyword
- It makes complex queries easier to read, write, and debug
- CTEs act like temporary named subqueries
- They only exist for the duration of a single query (unlike views, which are permanent)
- A CTE can be referenced multiple times in the same query, reducing redundancy
## Basic CTE Syntax
```sql
WITH cte_name AS (
	SELECT column1, column2
	FROM some_table
	WHERE some_condition
)
SELECT * FROM cte_name;
```
- The `WITH` keyword defines a Common Table Expression (CTE)
- `cte_name` is the name of the CTE, which you can reference in the main query
## CTEs vs Subqueries
- CTEs (Common Table Expressions) provide an alternative to subqueries
- Advantages of CTEs over subqueries
	- Improves readability by separating logic
	- Can be reused multiple times within the same query
	- Reduces deep nesting, making complex queries easier to maintain
## Problem: Find all customers who have spent > $500
- Using subquery:
```sql
SELECT first_name, last_name
FROM customer
WHERE customer_id IN (
	SELECT s.customer_id
	FROM sales_order s
	GROUP BY s.customer_id
	HAVING SUM(s.total_amount) > 500
);
```
- With a CTE (Improved Readability):
```sql
WITH qualifying_customers AS (
	SELECT s.customer_id
	FROM sales_order s
	GROUP BY s.customer_id
	HAVING SUM(s.total_amount) > 500
);

SELECT c.first_name, c.last_name
FROM customer c
JOIN qualifying_customers qc
	ON c.customer_id = qc.customer_id;
```
## Using Multiple CTEs
- SQL standards (and most databases) require that all CTEs for a query are declared together in one `WITH` clause, separated by commas
- A later CTE can reference an earlier CTE
```sql
WITH cte1 AS (...),
 cte2 AS (...)
SELECT ...
FROM cte1
JOIN cte2 ON ...
```

# Views
## What is a View?
- A **view** is a virtual table defined by a SQL query
	- It does not store data physically; it computes results dynamically
	- Once created, a view can be referenced by any user with appropriate permissions
- **Benefits:**
	- Abstraction: Hide underlying table complexity
	- Security: Limit data exposure
	- Maintainability: Centralize logic for common queries
## Creating a View in PostgreSQL
- EX: Create a view to display active employees
```sql
CREATE VIEW employee_view AS
SELECT employee_id, first_name, last_name, department
FROM employee
WHERE active = TRUE;
```
- EXPLANATION: This view shows only active employees, abstracting away the filtering logic
## Querying a View
- Query the view just like a regular table
```sql
SELECT * FROM employee_view
```
- Views can simplify reporting
- Performance considerations
	- Regular views do not have indexes of their own
	- Base-table indexes can still be used
## Materialized Views Basics
- **Definition:** Similar to views but store the query's result set physically (in a separate table-like structure) at creation or upon refresh
- **Refresh Mechanism:** You must explicitly call `REFRESH MATERIALIZED VIEW` to update the data
![[Pasted image 20260929122024.png]]

# Key Takeaways
- **Subqueries**
	- Nested queries used as part of another SQL statement
	- Correlated subqueries reference values from the outer query
- **CTEs**
	- Named temporary results defined with `WITH`
	- Useful for readability, reuse, and reducing nesting
- **Views**
	- Persistent database objects that store a query definition
	- Results reflect the current underlying data
---
# References
1. 