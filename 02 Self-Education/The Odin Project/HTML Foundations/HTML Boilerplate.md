---
tags:
  - ComputerScience
  - ComputerScience/HTML
Date Created: 2025-06-05
---
```table-of-contents
```
---
# Creating an HTML File
- To let the computer know we want to create an html file, we must append the file name with the `.html` extension
	- EX: index.html
- It is worth noting that we names our HTML file `index`
	- Should always name the file containing the homepage of our website index
	- Web servers will by default look for an `index.html` page when users land on out website - not having one causes big problems

# The DOCTYPE
- Every HTML page starts with a doctype declaration
	- doctype's purpose is to tell the browser what version of HTML it should use to render the document
- The latest version of HTML is HTML5, and the doctype for that version is `<!DOCTYPE html>`
- The doctypes for older versions of HTML are a bit more complicates
	- EX: HTML $
```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
```

# HTML Element
- After declaring the doctype, we need to provide an `<html>` element
- This is what's known as the root element of the document, meaning every other element in the document will be a descendant of it
	- More important when manipulating HTML with JavaScript
```html
<!DOCTYPE html>
<html lang="en">
</html>
```
- `lang` in this example represents an HTML attribute which is associated with the given HTML tag i.e. `<html>` in this case
## What is the lang attribute?
- `lang` specifies the language of the text content in that element
- This attribute is primarily used for improving accessibility of the webpage
- Allows assistive technologies, for example screen readers, to adapt according to the language and invoke correct pronunciation

# Head Element
- The `<head>` element is where we put important meta-information about our webpages, and stuff required for our webpages to render correctly in the browser
- Inside the `<head>` we should not use any element that displays content of the webpage
- The `<head>` element goes inside the `<html>` element and should always be the first element under the opening `<html>` tag
```html
<!DOCTYPE html>

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>My First Webpage</title>
	</head>
</html>
```
## Meta Element
- We should always have a `<meta>` tag with the charset encoding of the webpage in the `<head>` element: `<meta charset="UTF-8">`
- Setting the encoding is very important because it ensures that the webpage will display special symbols and characters from different languages correctly in the browser
## Title Element
- Another element we should always include in the head of an HTML document is the `<title>` element: `<title>My First Webpage</title>`
- This element is used to give webpages a human-readable title, which is displayed in our webpage's browser tab
- If we didn't include a `<title>` element, the webpage's title would default to its file name

# Body Element
- The final element needed to complete the HTML boilerplate is the `<body>` element
- This is where all the content that will be displayed to users will go
	- text, images, lists, links ,etc
- The `<body>` element goes within the `<html>` element and is always below the `<head>` element
```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>My First Webpage</title>
	</head>

	<body>
	</body>
</html>
```

# VSCode Boilerplate Shortcut
- VSCode has a built-in shortcut you can use for generating all the boilerplate in one go
	- Only works with .html files
- To trigger shortcut, enter `!` on the first line of an empty .html file
	- Then, hitting enter on the `!` option will populate a boilerplate for you
---
# References
1. 