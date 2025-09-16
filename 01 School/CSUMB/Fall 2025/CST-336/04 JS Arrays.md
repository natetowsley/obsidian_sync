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
# Array Declaration
- Arrays allow you to store a list of values
- Declaration Syntax:
```js
let arrayName = []; // empty array
let arrayName = [item1, item2, item3];
```

# Adding Values to an Array
- The `push()` method allows you to append items at the **end** of the array
```js
let vowels = ["i"];
vowels.push("o","u");
```
- The `unshift()` method allows to insert items at the **start** of the array
```js
vowels.unshift("a","e");
```

# Accessing Array Items
- Syntax:
	- Use `arrayName[index]`
	- Index starts with 0
```js
let vowels = ["a","e","i","o","u"];
console.log(vowels[1]); // Displays "e"

vowels[0] = vowels[vowels.length-1];
console.log(vowels[0]); // Displays "u"

console.log(vowels[vowels.length]); // Undefined (out of range)
```

# Swapping Array Items
- Syntax:
	- `[arrayName[index1], arrayName[index2]] = [arrayName[index2], arrayName[index1]]
```js
let vowels = ["a", "e", "i", "o", "u"];
[vowels[0], vowels[4]] = [vowels[4], vowels[0]];
console.log(vowels); // "u", "e", "i", "o", "a"
```

# Deleting Items from an Array
- Use the `splice()` method to remove or replace items
- Syntax:
	- `splice(index, howMany, item1, item2...)`
	- index starts from 0
	- `howMany`: number of items to be deleted or replaced
	- `item1`: item to be added (optional)
```js
let vowels = ["a", "e", "i", "o", "u"];
vowels.splice(2,1); // Removes "i"
vowels.splice(0, 2, "A", "E"); // Replaces a,e with A,E
```

# Randomizing an Array
- There is no built-in JS method to shuffle an array
- Write a `shuffle()` function
	- Randomize array in-place using Durstenfield shuffle algorithm
```js
function shuffleArray(array) {
	for (let i = array.length - 1; i > 0; i--) {
		let j = Math.floor(Math.random() * (i + 1));
		[array[i], array[j]] = [array[j], array[i]];
	}
}
```
- Alternatively, use [Underscore Library](https://underscorejs.org/)
	- `let shuffledArray = _.shuffle(arrayName);`

# Looping Through an Array
- `let vowels = ["a", "e", "i", "o", "u"];`
```js
for (let i = 0; i < vowels.length; i++) {
	console.log(vowels[i]);
}
```

```js
for (let i of vowels) {
	console.log(i);
}
```

```js
for (let vowel of vowels) {
	console.log(vowel);
}
```

# Other Array Methods
- [JS Array Methods](https://javascript.info/array-methods)
- [Useful JS Array Methods](https://chibueze.hashnode.dev/useful-javascript-array-methods)
![[Pasted image 20250916165203.png|450]]
---
# References
1. 