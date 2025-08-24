---
📕 Courses:
  - "[[!!Internet Programming]]"
tags:
  - ComputerScience
  - ComputerScience/HTML
Date Created: 2025-08-23
---
```table-of-contents
```
---
# HTML Definition
- HTML stands for **Hyper Text Markup Language**
- It is a "markup language" for creating web pages
	- A "markup language" is a computer language that uses special characters or tags to structure and display content
- HTML uses "tags" to **display content** and **provide structure** to web pages
- Example:
```html
<h1> This is the main heading </h1>
```

# HTML Tag Syntax
- The syntax for a single **opening** HTML tag is:
	1. An opening angle bracket `<`
	2. The tag name
	3. A closing angle bracket `>`
- EX: `<html>`
- The syntax for a single **closing** HTML tag is:
	1. An opening angle bracket `<`
	2. A forward slash `/`
	3. The tag name
	4. A closing angle bracket `>`
- EX: `</html>`

# HTML Elements
- HTML Elements are the individual components of a web page
- They consist of:
	1. An opening tag
	2. The content (if any)
	3. The corresponding closing tag (if any)
- EX:
```html
<!-- CORRECT h1 Element -->
<h1> Main Heading </h1>

<!-- INCORRECT h1 Element -->
<h1> Main Heading <h1>
<h1> Main Heading </h2>
<h1> Main Heading
```

> **All Content Elements** must be included within the `<body>` element
## Content Elements: Headings 
- HTML Elements are used to display content such as:
	1. Headings
	2. Links
	3. Images
	4. Lists
- There are six heading elements, from `<h1>` to `<h6>`
## Content Elements: Links
- Links are created with the `a` element ("anchor"), for example:
```html
<a href="https://csumb.edu" target="_blank"> Visit CSUMB </a>
```
- It must have content and a closing tag
- It must have the `href` attribute, specifying the web address to open
- The target attribute is optional, with the `"_blank"` value, it opens a new tab
## Content Elements: Images
- Images are displayed using the `img` element, for example:
```html
<img src="img/dog.png" alt="cute dog">
```
- It doesn't have content or a closing tag!
- It must have the `src` attribute (source), specifying the path to the image
- The image path is case sensitive and must match the file name
- It must have the `alt` attribute to describe the image (for accessibility purposes)
- The image must be in a web server (not in your local computer)
## Content Elements: Lists
- Bulleted lists are created with the **ul** and the **li** elements, for example:
```html
<ul>
	<li> Monday </li>
	<li> Tuesday </li>
	<li> Wednesday </li>
</ul>
```
- Numbered lists are created with the **ol** element (**ol** instead of **ul**)
	- **ol** stands for "ordered list" and **ul** for "unordered list"

# HTML - Basic Web Page Structure
```html
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>

</body>
</html>
```

## Structural Elements: `br`, `p`
- Line breaks must be explicitly created by using the `br` element: `<br>`
	- It does not have a closing tag
- Each paragraph should use the `p` element: `<p>`
	- It must use a closing tag
- Example:
```html
<p>Somewhere in la Mancha, in a place whose name I do not care to remember, a gentleman lived not long ago, one of those who has a lance and ancient shield on a shelf and keeps a slinny nag and a greyhound for racing</p>
```

# Semantic Elements
- Semantic elements delineate sections of content based on their purpose
- The most common semantic elements are
	- header
	- nav
	- main
	- article
	- figure
	- aside
	- section
	- footer
- It's best practice to structure the web page using semantic tags
![[Pasted image 20250823162815.png|400]]

# HTML Tables
- HTML tables are intended to display data in rows and columns
- Tables should not be used for layout!

| **Movie** | **Director**  | **Oscars** |
| --------- | ------------- | ---------- |
| Titanic   | James Cameron | 11         |
| Ben-Hur   | William Wyler | 11         |
- Syntax:
```html
<table>
	<tr>
		<th> Movie   </th>
		<th> Director </th>
	</tr>
	<tr>
		<td> Titanic   </td>
		<td> J. Cameron </td>
	</tr>
</table>
```

# Div Element
- Defines a **div**ision or container (box) in a web page
- It's usually used with CSS to style a group of elements
- It's used to create a multi- column layout
```html
<div>

<!-- group of elements -->

</div>
```

---
# References
1. [[HTML Boilerplate]]