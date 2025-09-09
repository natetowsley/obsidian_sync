---
📕 Courses:
  - "[[!!Internet Programming]]"
tags:
  - ComputerScience
  - ComputerScience/JavaScript
Date Created: 2025-09-07
---
```table-of-contents
```
---
# JavaScript Purpose
- Make web pages interactive (image carousel, search autocomplete, etc.)
- Change web page content and style programmatically
- Create games

# JS Code Placement
- JS Code can be
	- embedded within the HTML file
	- In a separate "js" file
## JS code embedded in the HTML file
- The code must be within `<script> </script>`
- The `<script>` tags can be **anywhere**, but by convention, they're placed just above the closing `</body>` tag
## JS code in an External File
- Best practice is to keep the JS code in an external js file
- To link the **js** file within the **html** file, use:
```html
<script src="js/script.js"></script>
```
- `js/script.js` is the path to the **js** file
	- The folder and file names are case sensitive
	- The closing `</script>` tag is NOT optional!

# JS Variables
- JS variables can be declared using the keywords:
	- `var`: Global scope, its use is discontinued
	- `let`: Global and local scope
	- `const`:
	- To declare variables that can't be changed
- Variable names should no start with a number, should not include spaces or operators (`+, -, *, /`)
- JavaScript is a loosely typed language
	- No need to specify data type
	- Variables can be assigned different data types
```js
var // KEYWORD FOR VARIABLE (CANNOT BE REASSIGNED)

let // KEYWORD FOR VARIABLE (CAN BE REASSIGNED TO ANY DATA TYPE)
```

# JS Console
- The JS Console can be used to:
	- Display values - more efficient than Alert()
	- Debug code
	- Execute code snippets
- To display values in the console use:
	- `console.log()`: displays values as strings
	- `console.dir()` displays interactive list of properties
- Most browsers include a JS Console but consider using **Chrome's inspect tool**

# Debugging Tools
- Most browsers provide a tool to trace the code execution
- In Chrome's inspect tool, go to the "Sources" tab and select the JavaScript file to trace
	- Click on the numbers to add breakpoints to stop the execution of the code
![[Pasted image 20250909161539.png|400]]

# Conditions
- The syntax of the **if statement** is:
```js
if (contition1) {
	//code if contition1 is true
}
else if (condition2) {
	//code if condition2 is true
}
```
- The condition must be within parentheses `()`
- Two types of equality symbols
	- == ignores data types
	- === considers data type
```js
if (5 == "5") { /* condition is TRUE, ignores data type */ }

if (5 === "5") { /* condition is FALSE, data type compared */ }
```

# Function Declaration
- The syntax of a **function declaration** is:
```js
function functionName(parameters*) {
	//code
}
```
- Functions can be used as values, but **must** use the `return` keyword
```js
let x = functionName(args*);

function functionName(parameters*) {
	return value;
}
```
- `*Parameters` and `arguments` are optional

# Document Object Model (DOM)
- So far, we've displayed information in the console and in an Alert popup box
- To display information within the actual web page, we need to know about the DOM
- The DOM is an API that JavaScript uses to access HTML elements
	- There are several ways to access HTML elements via JavaScript code, but all of them use the DOM
```js
document.querySelector("h1");
document.getElementById("elementId");
```
## DOM Visual Representation as a Hierarchical Tree
![[Pasted image 20250909162805.png|500]]

# Displaying Content with JS in Web Page
- To display content within the web page using JS:
	1. Identify the HTML element to add the content into. If the element does not exist yet, create it
	2. Ensure that the HTML element is unique, if not, add an **id** attribute, e.g. `<h2 id="output"></h2>"`
	3. Access the element using `let element = document.querySelector(selector);`
		- Use similar *selector* as in CSS: id, class, element
	4. Use the **textContent** property to add content:
		- `element.textContent = "New content";`

# JS Events
- An **event** refers to code that gets executed in response to an action, such as:
	- Clicking on something
	- Hovering over something
	- Pressing a key
	- Typing something
- Events can be added **inline** or through **Event Listeners**
	- Inline event example:
```html
<h1 onclick="functionName()"> Click me </h1>
```
- Other events are `onmouseover`, `onkeypress`, etc.
- Inline JS events are discouraged
## JS Event Listeners
- Event Listeners are a better alternative to inline events
- Event listener syntax:
```js
document.querySelector("selector").addEventListener("event", functionName);
```
- `selector` can be an id, class, or element
- `event` can be an event such as **click**, **change**, **mouseover**
- `functionName` should not include parentheses()
- EX:
```js
document.querySelector("h1").addEventListener("click", displayTime);
```
- The function `displayTime` is executed when clicking on the h1 element

# Getting User Input: Text Boxes
- HTML includes several elements for user input:
	- text
	- radio buttons
	- check boxes
	- dropdown menu
- Text box Syntax:
```js
<input type="text" id="inputId">
```
- Syntax to get the user's input:
```js
document.querySelector("#inputId").value;
```

# Template Literals
- **Template Literals** allow us to interpolate variables and expressions into strings
- Syntax:
	- `` `string ${variable} string` `` 
```js
let firstName = "John";
let lastName = "Doe";

let text = `Welcome ${firstName}, ${lastName}!`;
```
- The old method was using the `+` operator:
```js
let text = "Welcome " + firstName + ", " + lastName + "!";
```
---
# References
1. 