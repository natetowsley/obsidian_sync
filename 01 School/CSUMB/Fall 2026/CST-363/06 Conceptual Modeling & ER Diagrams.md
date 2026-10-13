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
# The Design Problem
>Suppose someone asks: "Can you model the data for my business or organization?"
- **Questions**:
	- Where do you begin?
	- Who knows the domain?
	- What are the important things?
	- How are those things associated?
	- Should you write tables immediately?
- **Desired first model**
	- **Conceptual:** About the domain
	- **Readable:** Useful to stakeholders
	- **Visual:** Easy to inspect
	- **Precise enough:** Captures important distinctions
	- **Implementation-independent:** Can later become a schema

# Design Phases
1. **Requirements analysis** - talk to users and domain experts
2. **Conceptual design** - entities, relationships, attributes, constraints
3. **Logical design** - convert the conceptual model into a relational schema
4. **Physical design** - indexes, storage, performance

- This unit focuses on **conceptual and logical design**:
![[Pasted image 20261013110134.png]]
- The relational schema is the logical design. PostgreSQL DDL is the concrete language we write in

# ER Model Building Blocks
- **Entities:** Distinguishable things in the domain
- **Relationships:** Associations among entities
- **Attributes:** Properties of entities or relationships
- Three example domains, three jobs:

| **Domain**             | **Role in this unit**               |
| ---------------------- | ----------------------------------- |
| University Records     | We model it together                |
| Campaign contributions | One model, followed across the unit |
| Music Library          | Yours to build                      |
## Entities and Entity Sets
- An **entity** is one distinguishable thing
	- Examples: one student, one instructor, one course section, one album, one track
- An **entity set** is a collection of similar entities
	- Examples: `student`, `instructor`, `course`, `album`, `track`
## Attributes and Domains
- An **attribute** is a property of an entity or relationship
- Every attribute has a **domain**: the permitted values for that attribute

| **Domain** | **Example**           |
| ---------- | --------------------- |
| `integer`  | track number, year    |
| `text`     | name, title, ZIP code |
| `date`     | release date          |
| `money`    | contribution amount   |
- Domain choice carries meaning
	- A ZIP code is `text`, not `integer` because leading zeroes matter
### More About Attributes
- **Simple** - one value, not decomposed here: `salary`, `title`, `year`
- **Composite** - made of smaller parts: `address` = `strees + city + state + zip`
- **Multivalued** - multiple values for one entity. `phones` for an instructor
- **Nullable** - value may be unknown or not applicable: `middle name`, `grade` before completion
- **All four are translated explicitly when we move to PostgreSQL
## Distinguishing Entities, Informally
- A model must let us distinguish one entity from another
	- Two students may share the same name
	- Two albums may share the same title
- So we choose an **identifier**: attributes that pick out one entity from the entity set
- For now:
> Identifier = how we tell them apart
- Formal key machinery comes when we decide constraints:
![[Pasted image 20261013111458.png]]
## Relationships and Roles
- A **relationship** is an association among entities
- Examples:
	- student Shankar is advised by instructor Gold
	- track "So What" appears on album *Kind of Blue*
- A **relationship set** is a collection of relationships of the same kind
	- Examples: `advisor`, `takes`, `appears on`, `performed by`
- Sometimes the same entity set participates more than once
- Example: `prerequisite` uses `course` twice: the course being taken and the prerequisite course
> Role names prevent ambiguity
### Attributes of relationship sets
- Relationships can have attributes too
	- `takes` has a `grade`
	- `advisor` has a `start date`
	- `contribution` has `amount` and `contribution date`
- These attributes describe the association, not either entity alone

# Weak Entity Sets
- A **weak entity sets** cannot be identified by its own attributes alone
- It depends on an **owner entity set** for identification
	- `course` is strong: `course id` identifies a course
	- `section` is weak: `sec_id`, `semester`, `year` identify a section only *within* a particular course
- A section is identified by:
![[Pasted image 20261013120759.png]]
> The weak entity has a partial key; the owner contributes the rest

# From Model to Picture
- A conceptual model is useful only if people can inspect and discuss it
- Stakeholders often know the domain better than the database designer, but they may not know SQL
- A diagram helps everyone ask concrete questions:
	- What things are we tracking?
	- How are those things related?
	- What properties matter?
	- What assumptions are we making?
- Now we move from **identifying** the model to **reading** the diagram

# ER Notation Varies
- Same conceptual idea: e.g., *contributors make contributions to candidates*
	- A contribution has an `amount` and a `contribution`

| **Notation** | **Main Idea**                                                          |
| ------------ | ---------------------------------------------------------------------- |
| Chen         | entities as rectangles, relationships as diamonds, attributes as ovals |
| Hybrid       | attributes move into boxes, relationships stay as diamonds             |
| Crow's Foot  | boxes plus relationship lines with cardinality/optionality glyphs      |
- All three express the same model
	- **Notation is not semantics**
> We commit to Crow's Foot for the rest of the unit
## Crow's Foot - Our Notation
![[Pasted image 20261013121444.png|400]]
- Entity boxes list conceptual attributes and domains
- `PK` marks the chosen identifies
- We represent this M:N relationship as an associative entity because the relationship has attributes
- Identifier for `contribution`? We have not decided yet
> The missing identifier is deliberate. It becomes a constraint question
### Crow's Foot Anatomy and Modeling Rule
- **Entity boxes** - name, attributes, conceptual domains, `PK` marker for the chosen identifier
- **Relationship lines** - relationship name, optionality and cardinality glyphs at each end
- **Relationship attributes** - shown with the relationship or associative entity
#### Modeling rule for this unit
- Conceptual diagrams carry **no foreign-key attributes**
	- Conceptual ERD: **What relationships exist**
	- Relational schema: **Where the foreign keys go**
## Weak-Entity Notation
![[Pasted image 20261013121943.png|300]]
- `section` is weak: its identity includes the owner's key
- `sec_id`, `semester`, `year` are the partial key
- The `||` at the course end says every section has exactly one owner course
- The owner key is not drawn as an FK attribute yet
## Crow's Foot Glyph Reference
![[Pasted image 20261013122037.png]]
### Decode: 1:1 and 1:N
#### 1:1 `office_of`
![[Pasted image 20261013122130.png|500]]
- Each office is assigned to zero or one instructor
- Each instructor has zero or one office
#### 1:N `advisor`
![[Pasted image 20261013122245.png|500]]
- Each instructor may advise zero or many students
- Each student has zero or one advisor
### Decode: M:N and optionally
#### M:M `takes`
![[Pasted image 20261013122346.png]]
- Each student may take zero or many sections
- Each section may be taken by zero or many students
	- This is **many-to-many**
#### Optionally as minimum cardinality
- Minimum participation - first marker
	- circle = zero
	- bar = one
- Maximum cardinality - second marker
	- bar = one
	- crow's foot = many

# Keys Formalized
- We need to distinguish entities and relationships
	- A **superkey** is any set of attributes that uniquely identifies an entity
	- A **candidate key** is a minimal superkey
	- A **primary key** is the candidate key we choose as the main identifier
- Example:
	- `student_id` may be a candidate key for `student`
	- `(student_id, name)` is a superkey, but not minimal
- The first part gave intuition, now we formalize it
---
# References
1. 