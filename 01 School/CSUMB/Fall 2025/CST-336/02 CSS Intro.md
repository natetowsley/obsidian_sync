---
📕 Courses:
  - "[[!!Internet Programming]]"
tags:
  - ComputerScience
  - ComputerScience/CSS
Date Created: 2025-09-02
---
```table-of-contents
```
---
# Definition
- Cascading Style Sheets (CSS) is a language that defines the layout and formatting of a web page
- **Layout:** Positioning, alignment, margin, padding, etc.
- **Formatting:** Color, size, font family, background, etc.

# Methods of Styling
- There are three ways to add styles to a web page:
	- Inline
	- Internal
	- External
## Inline Styles
- The style is included within an opening tag using the `"style"` attribute
- Example:
```html
<h1 style="color:red; background-color:yellow">
```
- USING INLINE STYLE IS DISCOURAGED! NOT A GOOD PRACTICE!
## CSS Rule Syntax for Internal and External Styles
- A CSS rule consists of a selector and its declaration
```css
h1 /* SELECTOR (HTML element) */
{
	color: #0000FF; /* DECLARATION */
	text-align: center;
}
```
- Each **declaration** consists of two parts
	- `property:value;`
- Values must not be in quotes
	- `color:"red";` (INORRECT)
- Each declaration must end with a semicolon
## Internal/ Embedded Styles
- Internal styles are included within the `<head></head>` section of an HTML file
- Must be surrounded by the `<style></style>` tags
- Their scope is limited just to the current web page (HTML file)
- By default, the style closest to the HTML element will take precedence
```html
<head>
	<style>
		h1 {
			color:red;
		}
	</style>
</head>
```

# Styling Block Elements
- HTML elements have a default display value, either as **block** or **inline**
- **Block** elements take the entire width of the window
- **Block** elements start in a new line
- The width of **Block** elements can be set through CSS
- To center **the content inside** a **Block** element use:
	- `text-align: center;`
- To center the actual **Block** element itself, use:
	- `margin: 0 auto;`

# Styling Inline Elements
- **Inline** elements do not start on a new line
- **Inline** elements only take up as much width as necessary
- Most common **Inline** elements: `img`, `a` , `span`
- The `span` element is mainly intended to style a part of a text
```html
<p>Quoth the Raven <span>"Nevermore."</span></p>
```
- Quoth the Raven *"Nevermore."*

# CSS Box Model
- Every HTML element is represented as a rectangular container or box
- The Box Model refers to the spacing and border styles
![[Pasted image 20250903104031.png|500]]
- **"padding"** refers to the space between border and content
- **"margin"** refers to the space between other elements

# CSS Selectors
- There are three main types of CSS Selectors: **HTML element**, **id**, and **class**
- When using the HTML element, the styles are applied to **all those elements**
```css
h2 {
	color:beige; /* Will apply to all h2 elements */
}
```
- The id selector uses an **id** attribute, which must be unique on the web page:
```html
<h2 id="subheading">
```

```css
#subheading {
	color:beige; /* Will only apply to h2 with id "subheading" */
}
```
- The class selector uses the **Class** attribute
- Styles group of elements(All that share class name)
```html
<h2 class="subheading">
```

```css
.subheading {
	color:beige; /* Applies to all elements in "subheading" class */
}
```

# CSS Flexbox
- Flexbox facilitates creation of a multi-column layout
- To display containers next to each other:
	1. Containers must be included within a parent container
	2. The parent container must use the CSS declaration `display:flex;`
```html
<div class="row">
	<div> Container 1 </div>
	<div> Container 2 </div>
</div>
```

```css
.row {
	display:flex;
}
```
## CSS Flexbox Styles
- When using Flexbox consider including the following styles:
```css
.row {
	display:flex;
	flex-wrap:wrap; /* Wraps content */
	justify-content:space-evenly; /* Centers horizontally */
	align-items:center; /* centers vertically */
}
```

# Pseudo-Classes
- Pseudo-classes allow applying styles when interacting on elements such as hovering over or clicking on them
- Examples:
```css
h1:hover{ /* Applies style when hovering over h1 heading */
	color:red;
}
.heading:active { /* Applies styles when clicking on element in heading class
	color:blue;
}
```
- Pseudo-classes are mainly used for links
- :active MUST BE BELOW :hover
---
# References
1. [[Properties]]
2. [[Syntax & Selectors]]