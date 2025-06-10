---
tags:
  - ComputerScience
  - ComputerScience/CSS
Date Created: 2025-06-08
---
```table-of-contents
```
---
# Basic Syntax
- At the most basic level, CSS is made up of various rules
- These rules are made up of a selector and a semicolon-separated list of *declarations*
	- Each declaration being made up of a property-value pair
![[Pasted image 20250610131022.png|350]]
>A `<div>` is one of the basic HTML elements. It is an empty container. In general, it is best to use other tags such as `<h1>` or `<p>` for content in your projects, but you'll find that there are many cases where the thing you need is just a container for other elements

# Selectors
- Selectors refer to the HTML elements to which CSS rules apply; they're what is actually being "selected" for each rule
## Universal Selector
- The universal selector will select elements of every type (as in the whole document), hence the name "universal"
	- The syntax for it is a simple asterisk `*`
- In the example below, all elements would have the `color: purple;` style applied to it
```CSS
* {
	color: purple;
}
```
## Type Selectors
- A type selector (or element selector) will select all elements of the given element type, and the syntax is just the name of the element:
```html
<!-- index.html -->

<div>Hello, World!</div>
<div>Hello again!</div>
<p>Hi...</p>
<div>Okay, bye</div>
```

```css
/* styles.css */

div {
	color: white;
}
```
- Here, all three `<div>` elements would be selected, while the `<p>` element wouldn't be
## Class Selectors
- Class selectors will select all elements with the given class, which is just an attribute you place on an HTML element
- How to add a class to an HTML tag:
```html
<!-- index.html -->

<div class="alert-text">Please agree to our terms of service.</div>
```
- How to select it in CSS
```css
/* styles.css */

.alert-text {
	color: red;
}
```
- Note the period immediately followed by the case-sensitive value of the class attribute
- Classes aren't required to be specific to a particular element, so you can use the same class on as many elements as you want
- Multiple classes can be added to a single element in a space-separated list
	- `class="alert-text severe-alert"`
	- Since whitespace separates classes, never use it for multi-worded class names
## ID Selectors
- ID selectors are similar to class selectors
- They select an element with a given ID, which is another attribute you place on an HTML element
- An element can only have **one** ID
```html
<!-- index.html -->

<div id="title">My Awesome 90's Page</div>
```

```css
/* styles.css */

#title {
	background-color: red;
}
```
- For IDs, instead of a period, we use a hashtag immediately followed by the case-sensitive value of the ID attribute
- You should use IDs sparingly if at all
## The Grouping Selector
- What is we have two groups of elements that share some of their style declarations?
```css
.read {
	color: white;
	background-color: black;
	/* several unique declarations */
}

.unread {
	color: white;
	background-color: black;
	/* several unique declarations */
}
```
- Here, both `.read` and `.unread` selectors share the `color: white;` and `background-color: black;` declarations, but otherwise have several of their own unique declarations
- To cut down repetition, we group these two selectors together as a comma separated list:
```css
.read,
.unread {
	color: white;
	background-color: black;
}

.read {
	/* several unique declarations */
}

.unread {
	/* several unique declarations */
}
```
- Both examples above will have the same result, but the second example reduces the repetition of declarations and makes it easier to edit either the `color` or `background-color` for both classes at once
## Chaining Selectors
- Another way to use selectors is to chain them as a list without any separation
- Consider the following HTML:
```html
<div>
	<div class="subsection header">Latest Posts</div>
	<p class="subsection preview">This is where a preview for a post might go.</p>
</div>
```
- We have two elements with the `subsection` class that have some sort of unique styles, but what if we only want to apply a separate rule to the element that also has `header` as a second class?
- We could chain both the class selectors together in our CSS like so:
```css
.subsection.header {
	color: red;
}
```
- What this does is selects any element that has both the `subsection` and `header` classes
- Notice how there isn't any space between `.subsection` and `.header`
- This syntax works for chaining any combination of selectors except for chaining more than one type selector
- This can also be used to chain a class and an ID as seen below:
```html
<div>
	<div class="subsection header">Latest Posts</div>
	<p class="subsection" id="preview">
		This is where a preview for a post might go.
	</p>
</div>
```

```css
.subsection.header {
	color: red;
}

.subsection#preview {
	color: blue;
}
```
- You can't chain more than one type selector since an element can't be two different types at once
	- Chaining `div` and `p` would give us the selector `divp` (won't work)
	- The selector would try to find a literal `<divp>` element, which doesn't exist
## Descendant Combinator
- Combinators allow us to combine multiple selectors differently than either grouping or chaining them
- The **descendant combinator** is represented in CSS by a single space between selectors
- A descendant combinator will only cause elements that match the last selector to be selected if they also have an ancestor (parent, grandparent, etc.) that matches the previous selector
- EX:
	- Something like `.ancestor .child` would select an element with the class `child` if it has an ancestor with the class `ancestor`
	- `child` will only be selected if nested in `ancestor`
```html
<!-- index.html -->

<div class="ancestor">
	<!-- A -->
	<div class="contents">
		<!-- B -->
		<div class="contents"><!-- C --></div>
	</div>
</div>

<div class="contents"><!-- D --></div>
```

```css
/* styles.css */

.ancestor .contents {
	/*some declarations */
}
```
- In the example above, the first two elements with the `contents` class (B and C) would be selected, but the last element (D) wouldn't be selected
- There is no limit to how many combinators you can add to a rule
---
# References
1. 