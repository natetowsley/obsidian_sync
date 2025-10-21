---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Design
  - ComputerScience/Android
Date Created:
---
```table-of-contents
```
---
# LifeCycle Methods
- At various times in the life of an App methods are called
- We are already familiar with one of these: onCreate()
	- We have been using this in all our apps
- Unsurprisingly, this is what is called when an app begins, and the current view is created
## Example LifeCycle Methods
```java
@Override
protected void onCreate(Bundle savedInstance) {
	...
}

@Override
public void onStart() {
	super.onStart();
	Log.d(TAG, "onResume() called");
}

@Override
public void onResume() {
	super.onResume();
	Log.d(TAG, "onResume() called);
}

@Override
public void onPause() {
	super.onPause();
	Log.d(TAG, "onPause() called");
}

@Override
public void onStop() {
	super.onStop();
	Log.d(TAG, "onStop() called");
}

@Override
public void onDestroy() {
	super.onDestroy();
	Log.d(TAG, "onDestroy() called");
}
```
![[Pasted image 20251021101612.png|300]]
## Further Information about Life Cycle States

| **State**    | **In Memory?** | **Visible to User?** | **In Foreground?** |
| ------------ | -------------- | -------------------- | ------------------ |
| non-existant | no             | no                   | no                 |
| stopped      | yes            | no                   | no                 |
| paused       | yes            | yes/partially        | no                 |
| resumed      | yes            | yes                  | yes                |

# Saving Values
> Bundle it together
## Bundle
- Ever wonder what his business is all about?
![[Pasted image 20251021101859.png|350]]
- A **Bundle** is an implementation of a **Parcel**
### Bundle is Basically a Data Structure
- It allows us to store and retrieve values between states
	- Unless we hit the back button, in which case Android decides we are finished
- We are going to use it by overriding the **onSavedInstanceState** method
- First we need a label for our state value
	- This will go at the top of the MainActivity.java file
![[Pasted image 20251021102236.png]]
- Updating onCreate()
	- With the following lines we preserve our data
![[Pasted image 20251021102355.png]]
- Overriding onSaveInstanceState
![[Pasted image 20251021102427.png]]
- We never call onSaveInstanceState
	- Android calls it for us
	- When our app is stopped a call is made
![[Pasted image 20251021102549.png|400]]


---
# References
1. 