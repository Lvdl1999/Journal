# Journal
## By Levy van der Linde 
## Minor Programmeren

Once someone opens this "3-screen-app", a screen will popup that shows a list of the users journals by the mainactivity. 
The user is able to see the details of each journal by clicking on it in the list.
Next to that the user can add new journals to the list by clicking the floating button with the "+" icon. 
The app will go to the next screen and (inputactivity).

###Creating a new journal

A journal consists of a title, it's content and the users mood. After making the journal the user can submit is by pressing the 'submit entry' button.

###List of journals
After submitting new journals, the mainactivity will add them to it's list view on the firstscreen. 

###A journals details
Once someone presses a journal from the listview, the app will show it's details in detailactivity containing: the title, date, users mood when creating the journal and ofcourse the content. This is a method through the OnItemClicklistener.

### Removing journals
The app also has a ListLongClicklistener which calls a method to remove the journal once someon click long on an item in the listview. The method first gets the position in the listview that was clickes and deletes it.
