---
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created: 2025-06-06
---
```table-of-contents
```
---
# Anchor Elements
- To create a link in HTML, we use the anchor element
- An **anchor element** is defined by wrapping the text or another HTML element we want to be a link with an `<a>` tag
```html
<a>About The Odin Project</a>
```
- Doing this alone won't cause clicking on the link to do anything
	- We must tell the link where to go by using an HTML attribute
- An HTML attribute gives additional information to an HTML element and always goes in the element's opening tag
- An attribute is usually made up of two parts
	- A name
	- A value
- However, not all attributes require a value
```html
<a href="https://www.theodinproject.com/about">About The Odin Project</a>
```
- In this case, href is out name and the link is our value
- href links can link to more than just other html documents
	- Videos
	- pdf files
	- Images
	- etc.

# Opening Links in a New Tab
- The default behavior of most browsers is to open the link in the same tab it is clicked in
- This can be changes using the `target` attribute
- If the attribute is not present, then by default,  it will take on the `_self` value
	- This is what opens the link in the current tab
- To open the link in a new tab or window (depends on browser settings) the attribute can be set to `_blank`
```html
<a href="https://www.theodinproject.com/about" target="_blank" rel="noopener noreferrer">About The Odin Project</a>
```
- The `rel` attribute above is used to describe the relation between the current page and the linked document
## noopener & noreferrer
- `noopener`: The `noopener` value of the `rel` attribute ensures that a link opened in a new tab or window cannot interact with or access the original page
	- Without it, the new page can use JavaScript to manipulate the original page, which poses a security risk
	- **noopener** prevents _phishing attacks_, where the opened link may change the original webpage with a different one to trick users
		- Also called _tabnabbing_
- `noreferrer`: The `norefferer` value of the `rel` attribute provides both privacy and security
	- It prevents the new page from knowing where the user came from (hiding the referrer) and also includes the behavior of `noopener`, preventing the new page from accessing the original page
- You may be fine if you forget to add `rel="noopener noreferrer"` as more recent versions of browsers provide security when `target="_blank` is present
	- Recommended to always pair `target=_blank` with `rel="noopener noreferrer`

# Absolute and Relative Links
- Generally, there are two kinds of links one creates:
	- Links to pages on other websites on the internet
	- Links to pages located on our own websites
## Absolute Links
- Links to pages on other websites on the internet are called absolute links
	- Typically made up of the following parts `scheme://domain/path`
## Relative Links
- Links to other pages within our own website are called relative links
- Relative links do not include the domain name, since it is another page on the same site, it assumes the domain name will be the same as the page we create the link on
	- Relative links only include the file path to the other page, _relative_ to the page the link is created on
	- This works because the files are in the same directory
- Relative links can also navigate through directories EX: `pages/about.html`
	- Search issues are possible, and can be fixed by prepending `./` before the link
		- This tells the code to begin looking in the current directory
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Homepage</h1>
    <a href="https://www.theodinproject.com/about" target="_blank">About The Odin Project</a>
    <p>
        <a href="./pages/about.html">About</a>
    </p>
</body>
</html>
```
## Links Metaphor
>Think of your domain name (town.com) as a town, the directory in which your website is located (/museum) as a museum, and each page on your website as a room in the museum (/museum/movie_room.html and /museum/shops/coffee_shop.html). Relative links like ./shops/coffee_shop.html are directions from the current store to another room. Absolute links, on the other hand, are full of directions including the protocol (https), and domain name (town.com) and the path from that domain name
- Relative (`/museum/shops/coffee_shop.html`)
- Absolute (`https://town.com/museum/shops/coffee_shop.html`)

# Images
- To display an image in HTML, we use the `<img>` element
	- `<img>` is a void element, so it does not need a closing tag
- This element embeds an image using a `src` attribute which tells the browser where the image file is located
	- The `src` attribute works much like the `href` attribute for anchor tags
	- Can embed an image using both absolute and relative paths
## Alt Attribute
- Besides the `src` attribute, every image element should also have an `alt` (alternative text) attribute
- This attribute is used to describe an image
	- Will replace the image if the image cannot be loaded
	- Can also help screen readers describe image to the visually impaired
## Image Size Attributes
- While not strictly required, specifying height and width attributes in image tags helps the browser layout the page without causing the page to jump and flash
- It is good habit to specify these attributes on every image, even when the image is the correct size or you are using CSS to modify it
```html
<img src="../images/dog.jpg" alt="pup" width="400">
```

# Parent Directories
- What if we want to use the dog image in the about page?
	- We would first have to go up one level out of the pages directory into its parent directory os we could then access the images directory
- To go to the parent directory we need to use two dots in the relative filepath like so: `img src="../images/dog.jpg>`
	- To break this down:
		1. First, we go to the parent directory of our current directory (pages) which is `odin-links-and-images`
		2. The, from that directory, we enter the `images` directory
		3. Finally, we access `dog.jpg`
---
# References
1. 