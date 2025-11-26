---
📕 Courses:
  - "[[!!Software Design]]"
tags:
  - ComputerScience
  - ComputerScience/Android
Date Created:
---
```table-of-contents
```
---
# Alert Dialogs
- These are used to get our users to answer question with known responses
- We do this by creating an alert dialog builder
	- assign the message to display
	- set the responses
	- set the actions needed for the response
![[Pasted image 20251118100729.png|200]]
```kotlin
AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SecretActivity.this);
final AlertDialog alertDialog = alertBuilder.create();

alertBuilder.setMessage("Return to previous?\n");

alertBuilder.setNeutralButton("Meh.", new DialogInterface.OnClickListener() {
	@Override
	public void onClick(DialogInterface dialog, int which) {
	//Toast.makeText(getApplicationContext(),"meh",Toast.LENGTH_SHORT).show();
		}
	});
	alertBuilder.setPositiveButton("Go back to the other Screen", new DialogInterface.OnClickListener() {
	@Override
	public void onClick(DialogInterface dialogInterface, int i) {
		Utils.ToastMaker(getApplicationContext(), R.string.yes, Gravity.BOTTOM);
		Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(mainMenu);
	}
});

alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
	@Override
	public void onClick(DialogInterface dialogInterface, int i) {
		Utils.ToastMaker(getApplicationContext(),R.string.no);
		alertDialog.dismiss();
	}
});
alertBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
	@Override
	public void onCancel(DialogInterface dialog) {
		Utils.ToastMaker(getApplicationContext(),R.string.cancel_dialog, Gravity.CENTER);
	}
});
	AlertDialog goodAlert = alertBuilder.create();
	goodAlert.show();
	}
});
```
---
# References
1. 