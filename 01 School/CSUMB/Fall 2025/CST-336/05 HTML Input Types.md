---
📕 Courses:
  - "[[!!Internet Programming]]"
tags:
  - ComputerScience
  - ComputerScience/HTML
Date Created:
---
```table-of-contents
```
---
# Textbox
- A textbox allows users to input short text(one line)
- Syntax:
	- `<input type="text" id="textInput">`
- To get the value through JS:
	- `document.querySelector("#textInput").value;`
- Optional attributes:
	- `placeholder:` Hint about the value to enter
	- `value:` Initial value to be displayed within the box

# Label Element
- For accessibility purposes, every input element should be associated with a `label` element
- Syntax:
	- Just surround the input element with the label tags, including the prompt text
```html
<label>
Prompt:<input type="text" id="textInput">
</label>
```
- When clicking on the prompt text, the input element will be activated

# Text Area Element
- A text area allows users to input multiple lines of text
- Syntax:
```html
<textarea id="textAreaInput">
</textarea>
```
- To get the value through JS:
```js
document.querySelector("#textAreaInput").value;
```

# Number Element
- A **number** input lets users enter numbers, preventing non-numeric values
- Syntax
	- `<input type="number" id="numberINput">`
- To get the value through JS:
	- `document.querySelector("#numberInput").value;`
- Optional attributes:
	- `min` - Minimum value
	- `max` - Maximum value
	- `step` - Value to increase/decrease

# Select Element
- The select element lets users choose an option from a dropdown menu
- Syntax:
```html
<select id="selectInput">
	<option> Option Value </option>
</select>
```
- To get the value through JS:
```js
document.querySelector("#selectInput").value;
```
- Each option can include the "value" attribute:
	- `<option value=""> Option Value </option>`

# Checkbox Element
- A checkbox allows users to select or deselect an option
- Syntax:
```html
<input type="checkbox" id="chbx" value="value">
```
- To get the value through JS:
	- First we need to verify that it's checked
```js 
if (document.querySelector("#chbx").checked) {
	document.querySelector("#chbx").value;
}
```

# Radio Element
- From a group of choices, users can select one choice
- It must include the "name" attribute
- Syntax:
	- `<input type="radio" name="group" value="value"`
```html
<input type="radio" name="sex" value="M">Male
<input type="radio" name="sex" value="F">Female
```
- To get the value through JS:
	- `document.querySelector("input[name=group]:checked").value;`

# Creating Input Elements with JS
- There are two ways to create HTML elements dynamically with JS
![[Pasted image 20250916171151.png|600]]
---
# References
1. 