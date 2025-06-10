---
tags:
  - ComputerScience
  - ComputerScience/HTML
Date Created: 2025-06-05
---
```table-of-contents
```
---
# Paragraphs
- When the browser encounters new lines in HTML, it will compress them down into one single space
	- The result of this compression is that all of the text is clumped together into one long line
- The paragraph element is needed to create paragraphs in html
	- `<p>` and `</p>`

# Headings
- Headings are different from other HTML text elements
	- They are displayed larger and bolder than other text to signify that they are headings
- There are 6 different levels of headings starting from `<h1>` to `<h6>`
- The number within a heading tag represents that heading's level
	- h1 being the largest/ most important, to h6 being the smallest/ least important
```html
<html>
	<head>
	</head>
	<body>
		<h1>This is a heading 1</h1>
	    <h2>This is a heading 2</h2>
	    <h3>This is a heading 3</h3>
	    <h4>This is a heading 4</h4>
	    <h5>This is a heading 5</h5>
	    <h6>This is a heading 6</h6>
  </body>
 </html>
```
![[Pasted image 20250605211901.png|300]]
- Using correct heading level is important as levels provide a hierarchy to the content

# Strong Element
- The `<strong>` element makes text bold
- It also semantically marks the text as important
	- This affects tools, like screen readers, that users with visual impairments will rely on to use your website
```html
<html>
  <head>
  </head>
  <body>
    <strong>Lorem ipsum dolor</strong>
   </body>
 </html>
```
- Most likely you'll find yourself using the strong element in combination with other text elements
```html
<html>
  <head>
  </head>
  <body>
    <p>Lorem ipsum <strong>dolor sit</strong> amet, consectetur adipiscing elit.</p>
  </body>
</html>
```
- Making text bold without considering it important must be done in CSS

# Em Element
- The `<em>` element makes text italic
- Also semantically places emphasis on the text
	- This also affects things like screen readers
```html
<html>
	<head>
	</head>
	<body>
		<em>Some emphasized text</em>
	</body>
</html>
```
- Like the strong element, you will often find yourself using `<em>` with other text elements

# HTML Comments
- HTML comments are not visible in the browser
	- They allow us to comment on out code so that other developers or our future selves can read them and get some context about something that might not be clear in the code
- Comments in html are made by enclosing the comment with `<!--` and `-->` tags
```html
<h1> This text will appear in browser </h1>

<!-- This text will not appear -->

<p> This paragraph will appear </p>

<!-- This comment will not! -->
```
---
# References
1. 