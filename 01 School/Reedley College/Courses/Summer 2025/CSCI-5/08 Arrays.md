---
📕 Courses:
  - "[[!!Java Programming]]"
tags:
  - ComputerScience
  - ComputerScience/Java
Date Created:
---
```table-of-contents
```
---
# What is an Array?
- An array is a collection of values of the same data type stored in a container object
- Can be any number of values
- Length of the array is set when the array is declared
- Size is fixed once the array is declared
![[Pasted image 20250604172018.png|550]]
## Array Elements
- Every value is called an element
- Each element is accessed by an index
- Index must be an integer
- Index always starts at 0
## Array Data Types
- Arrays may contain any data type, such as:
	- Primitive
	- Pre-defined objects, such as Strings from the Java API
	- Programmer-Defined objects, such as instances of a class that you create
# Declaring an Array
- There are three parts to declaring an array
	- Data type
	- Variable name
	- Array size
## Example of Declaring an Array
- An array declaration can be done in one or two lines
- Both examples below are equivalent array declarations
```java
data_type[] variable_name;
variable_name = new data_type[size];
// array declared in two lines of code
```

```java
data_type[] variable_name = new data_type[size];
// array declared in one line of code
```
## Alternative Array Declaration Syntax
- An alternative way to declare arrays is to place the brackets used to declare an array on either side of the array identifier

| **Syntax Introduced**  | **Alternate Syntax**   |
| ---------------------- | ---------------------- |
| `int[] primeNumbers;`  | `int primeNumbers[];`  |
| `double[][] prices;`   | `double prices[][];`   |
| `String[] words;`      | `String words[];`      |
| `Point[] coordinates;` | `Point coordinates[];` |
- Either declaration will work
	- The Alternate Syntax is similar to that used in the language of C
	- The syntax used to introduce arrays actually reads much clearer
	- The first line would read "Integer array primeNumbers."

# Initializing an Array
- Once you declare an array, you must initialize it to set the values for specified indexes
- There are three components to initializing an array:
	- Variable name
	- Index
	- Value
## Ways to Initialize an Array
- An array can be initialized in two different ways:
	- Declare an array, then initialize each element
	- Have declaration and initialization occur in the same step
- Example of declaring and initializing in two steps:
```java
data_type[] variable_name = new data_type[size];
variable_name[index] = value; // repeat for each index
```
- Example of declaring and initializing in one step:
```java
data_type[] variable_name = {val1, val2, ...};
```
## Initializing an Array Example
- Multiple lines
```java
String[] myBouquet = new String[6]
myBouquet[0] = "Rose";
myBouquet[1] = "Sunflower";
myBouquet[2] = "Daisy";
myBouquet[3] = "Dandelion";
myBouquet[4] = "Violet";
myBouquet[5] = "Lily";
```
- Single line
```java
String myBouquet = {"Rose", "Sunflower", "Daisy", "Dandelion", "Violet", "Lily"};
```

# Array Representation
- When arrays are declared but not yet initialized, the elements are given the default value associated with the data type
- For example, the default for numeric data types, such as int, is 0
- The default for Object types, such as String, is ""(null)
- When the array is declared, the representation in the table is as follows
```java
int[] myArray = new int[5];
```

| **Index:** | 0   | 1   | 2   | 3   | 4   |
| ---------- | --- | --- | --- | --- | --- |
| **Value:** | 0   | 0   | 0   | 0   | 0   |
## Updated Array Representation
- Once you begin to initialize elements, the array is updated
- The new representation in the table is as follows
```java
myArray[0] = 32;
myArray[3] = 27;
```

| **Index:** | 0   | 1   | 2   | 3   | 4   |
| ---------- | --- | --- | --- | --- | --- |
| **Value:** | 32  | 0   | 0   | 27  | 0   |

# Arrays Object Types
- Arrays are not restricted to storing primitive data types
- They can store any object type including types you define
- For example, if a Flower class existed
	- The flowers could be stored in the array rather than storing the flower type as a String
	- Since we know what flowers to include, the second notation can be used to initialize myBouquet of six Flowers
```java
Flower[] myBouquet = {new Flower("Rose"), new Flower("Sunflower"),
					  new Flower("Daisy"), new Flower("Dandelion"),
					  new Flower("Violet"), new Flower("Lily")};
```

# Accessing Array Length
- With each declaration of an array, you must define a size, or length, of the array
- The length is stored as an instance variable for that object and can be accessed using the `arrayName.length` notation
- This technique is useful in the following example:
	- Establish an array with a size based on the user input
	- Enter a segment of code where the user's input is no longer in scope
	- You would need to access the instance variable length for that array
	- In short, arr.length returns the length of the array, arr

# Iterate Through an Array
- To iterate through, or traverse, an array means to progress through each element of the array by index number
- Iterating through an array is useful when:
	- You wish to access each element of an array in order
	- You wish to initialize the elements of an array as all the same value
- Use .length when iterating rather than the integer value entered when declaring the array
- This will assure that you do not receive an index out of bounds error
## Array Iteration Example
```java
int[] allTwos = new int[10];
for (int index = 0; index < allTwos.length; index++) {
	allTwos[index] = 2;
} // end for
```
- The initialized counter within the for loop can be used for incrementing through the indexes, as shown
## The for-each Loop
- Java offer a for-each loop, an alternative to using the initialized counter to iterate through an array
	- When used to access the elements of an array, the for-each lop works the same way as the for loop, but is implemented in a similar way
```java
for (String myFlower : myBouquet) {
	System.out.println(myFlower);
} //end for
```
- The for-each loop accesses and (one-at-a-time) returns all elements of an array
	- Changes to the array elements cannot be made using a for-each loop
### for-each Loop Example
- Both implementations of the code below will display the information about the array elements
```java
public class Bouquet {
	public static void main(String[] args){
		String[] myBouquet = {"Rose", "Sunflower", "Daisy", "Dandelion", "Violet", "Lily"};
		
		// using FOR LOOP
		for(int i = 0; i < myBouquet.length; i++) {
			System.out.println(myBouwuet[i]);
		}
		
		// using FOR EACH LOOP
		for(String myFlower : myBouquet) {
			System.out.println(myFlower);
		}
	}
}
```

# What We Know About Arrays
- What we know about arrays:
	- Arrays are an object type that can store any primitive or object type
	- Therefor, arrays can store arrays
	- The concept of storing an array of arrays is called a two-dimensional array

# Two-Dimensional Array
- A two-dimensional array, called an "array of arrays", is an array that stores other arrays
- The number of arrays contained within the array is defined upon declaration
- The number of items in each internal array is also defined upon declaration
## Two-Dimensional Array Example
- A two-dimensional array can be visualized as a table with rows and columns
- The example below has two rows and three columns
```java
int[][] nums = { {14, 51, 16}, {12, 73, 87} };
```
## Declaring a Two-Dimensional Array
- Components of two-dimensional arrays:
	- Data type
	- Variable name
	- Array size
- To declare a two-dimensional array, use either of the syntax examples below
```java
data_type[][] variable_name;
variable_name = new data_type[size1][size2];
// declare it using two lines of code
```

```java
data_type[][] variable_name = new data_type[size1][size2];
// declare it using one line of code
```
## Initializing a Two-Dimensional Array
- Two-dimensional arrays, just like single-dimension arrays, can be initialized using two different methods
- Method 1:
	- i is the index of the internal array (row) and j is the index of the element within that array (column) that is being initialized
```java
public class TwoDTester{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] nums = new int[3][2];
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++){
				System.out.println("Enter a value for 
				row " + i + ", column " + j);
				nums[i][j] = in.nextInt();
			} // end for
		} // end for
	} // end main
} // end class
```
- Method 2:
	- Declares and initializes all arrays and all elements within those arrays in the same line of code
		- However, you must know the values that you want the array to contain to initialize the array at the same time that it is declared
```java
public class TwoDTester2 {
	public static void main(String[] args) {
		int[][] nums = {{2,3,7}, {15,98,2}};
	} //end main
} // end class
```
## Accessing Data in a Two-Dimensional Array
- To access data in a two-dimensional array, you must know:
	- The index of the array to access
	- The index of the content in that array to access
### Example
- To access the color of a rose in myBouquet, use the index of the Rose array (0) and the index of the first color (0)
```java
String[][] myBouquet = String[][] {
					{"Red", "Peach", "Yellow"},
					{"Yellow", "White", "Blue"},
					{"Green", "Blue", "Purple"},
					{"White", "White", "White"},
					{"Purple", "Pink", "Violet"},
					{"Pink", "Orange", "White"}
					};
String rose1 = myBouquet[0][0]; //accesses first element of first array
```
## Accessing the Length of Two-Dimensional Arrays
- Length is an instance variable defined by the size of each declared array
- Two-dimensional arrays have two different lengths:
	- Length of the outer array
	- Length of the internal arrays
### Length of Outer and Inner Arrays
- The length of the outer array, which is the length that describes the number of arrays contained (rows), is accessed like a typical array
```java
int numArrays = arrayName.length;
```
- The length of the internal arrays, which is the length that describes the number of elements each array contains (columns), is accessed using the following notation
- Brackets [] tell the program that it is accessing the length of the internals arrays, and row says which array
```java
int numElementsInEach = arrayName[row].length;
```

# Two-Dimensional Arrays Object Types
- Just like single-dimensional arrays, two-dimensional arrays can store any type of object
- How can we organize the students in a classroom into three groups, with five students per group as an array?
	- Answer: Declare a two-dimensional array that holds three arrays, one for each group
	- Each array stores five students
- A class Student has been defined, which has a constructor that takes in the student's first name
- The following code declares the array that stores the group of students
```java
Student[][] groups = new Student[3][5];
```
## Placing Students in the Two-Dimensional Array
- Given a String array containing names of the 15 students in the groups, how could you perform the tasks?
	- Iterate through the existing array
	- Create new student for each provided name
	- Place each student into one of the three groups

# Nested for Loops
- A nested for loop:
	- Is a for loop inside a for loop
	- Can be used to iterate through two-dimensional arrays using the outer for loop counter as the index for the arrays (rows) and the inner for loop counter as the index for the elements of each array (columns)
- Consider the following two-dimensional array declaration:
```java
Student[][] groups = new Student[3][5];
```
- To iterate through the array and initialize each student as "Temp", use nested for loops as shown below
```java
// i keeps track of the rows
for(int i = 0; i < groups.length; i++) {
	// j keeps track of the columns
	for(int j = 0; i < groups[i].length; j++) {
		groups[i][j] = new Student("Temp");
	} // end for
} // end for
```

# Command Line Arguments
- An array has always been a part of the main method
- The String array args is always a parameter for the main method
```java
public static void main(String[] args)
```
## Adding Extra Arguments
- If you run a Java program from a command line environment, you can type in extra arguments as follows:
`java Test apples peaches pumpkin pie`
- The keyword java tells the command line environment to use the JVM to run the program Test
- The array args gets populated with the Strings: apples, peaches, pumpkin, and pie
- Using a Java IDE, we avoid the command line environment; however, we can use command line arguments in a Java IDE
## Using Command Line Arguments in Eclipse
- Access the arguments tab for your program by going to the Run menu and choosing Open Run Dialog
- Click the Arguments tab and type in the Strings: Apples Peaches Pumpkin Pie
![[Pasted image 20250604205308.png|600]]
---
# References
1. [[Arrays and Vectors]]