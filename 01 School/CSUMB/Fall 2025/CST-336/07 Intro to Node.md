---
📕 Courses:
  - "[[!!Internet Programming]]"
tags:
  - ComputerScience
  - ComputerScience/JavaScript
Date Created:
---
```table-of-contents
```
---
# Full Stack Development
- Front end
	- HTML
	- CSS
	- JavaScript
		- Vue
		- Angular
		- React
- Backend / server
	- Php
	- Ruby
	- Python
		- Django
	- Java
		- SpringBoot
	- JavaScript
		- Node

# Static Web Servers
![[Pasted image 20251009160722.png|450]]
- Requesting files

# Web Application Frameworks
![[Pasted image 20251009160806.png|450]]
- Requesting "routes"

# Backend Programming Benefits
- Hide information
	- Web API keys
	- Answers
	- Variable values
- Partials
	- One set of code
- Templating
- Database access
- Web API creation

# What is Node?
- Node.js is an open-source, cross-platform, back-end JavaScript **runtime environment** that executes JavaScript outside a web browser
- https://nodejs.org/en/
## Node is not associated with a DOM
- Node does not work with a Web document
	- No `document.querySelector`
	- No `alert()`
	- No HTML Elements
- Essentially a terminal interface
- Plain JavaScript

# Node Package Manager (npm)
- Not libraries, rather **packages**
- Npmjs.com
	- A very large collection of packages
	- Alternatively, use socket.dev
## Steps to use a Node Package
1. Look for a package to shuffle array (e.g. fast-shuffle)
2. Install it
3. Import it into your `index.mjs` file
4. Refer to documentation to use it
- From terminal use:
	- `npm install package_name`
- The package name will be added into the `package.json` file as a dependency
- The package code will be added into the `node_modules` folder
## Two Ways to Embed Packages in Node
```js
import function from `packageName`; //latest

const xyz = require(`packageName`); //deprecated

//instead, use
const xyz = (await import(`packageName`)).default;
```

# Function Declaration vs Function Expression
- Function Declarations
	- Order doesn't matter
	- They are "hoisted"
```js
function function_name() {

}
```

- Function Expression
	- Order DOES matter
	- Functions can be passed as parameters to other functions
	- Allow for using "arrow" syntax
```js
const function_name = function() {

}
```

# Arrow Syntax
```js
//without arrow syntax
const function_identifier = function(){
}

//with arrow syntax
const function_identifier = () => {
}
```
- Allows writing more concise code
```js
function timesTwo(params) {
	return params * 2;
}

const timesTwo = params => params * 2;
```
- Arrow functions inherit the value of the keyword 'this'

# Fetching Data from Web APIs
- Use `node-fetch` package
	- fetch can be used outside of a function!
```js
let response = await fetch(url);
let data = await response.json();
```
---
# References
1. 