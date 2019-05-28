# Journal
## By Levy van der Linde 
## Minor Programmeren

Once someone opens this "3-screen-app", a screen will popup that shows a list of the users journals by the mainactivity. 
The user is able to see the details of each journal by clicking on it in the list.
Next to that the user can add new journals to the list by clicking the floating button with the "+" icon. 
The app will go to the next screen and (inputactivity).

### Opening the app
<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58507290-b517fd00-8191-11e9-9a6f-c96c8c7567ef.png">

*(The first journals give a date saying 'null' because the implementation of the app showing the current date and time wasn't done yet.)*

### Creating a new journal
A journal consists of a title, it's content and the users mood. After making the journal the user can submit is by pressing the 'submit entry' button.
<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58507290-b517fd00-8191-11e9-9a6f-c96c8c7567ef.png">

### List of journals
After submitting new journals, the mainactivity will add them to it's list view on the firstscreen. 
<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58507290-b517fd00-8191-11e9-9a6f-c96c8c7567ef.png">

### A journals details
Once someone presses a journal from the listview, the app will show it's details in detailactivity containing: the title, date, users mood when creating the journal and ofcourse the content. This is a method through the OnItemClicklistener.
<img width="150" alt="image" src="https://user-images.githubusercontent.com/47352487/58507519-3c657080-8192-11e9-8e60-4d1f5786f05d.png">

