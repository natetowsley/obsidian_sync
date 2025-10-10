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
# MVC Model
![[Pasted image 20251009171530.png|500]]

# Express
- Express is the most popular Node.js **MVC web application framework**
- It's written entirely in JavaScript
- It's very lightweight, it comes with the bare minimum to start a web server

# Express App Setup - Code Snippet
```js
import express from 'express'; //imports express application
const app = express(); //creates constant to refer to express

app.set("view engine", "ejs"); //use ejs as view engine
app.use(express.static("public")); //name of folder for static files (images, css)

// ROUTES
//root route (or home route)
app.get('/', (req, res) => {
   res.send('Hello Express app!')
});  

//starts the web server
app.listen(3000, () => { //3000 is port number
   console.log('server started');
});
```
---
# References
1. 