# ToDoApp
Simple Android To-do app. One Activity that displays a list of data which is stored in an Array List. 
A Flotation Action Button (FAB) is used to show a dialog box with an input field for the user to add new items to his list. 
This project is part of a workshop titled "Introduction to Android" aimed to help beginners get into Android.

# Screenshots 
<img src="/screenshot/screenshot1.png" width="220" height="400"> <img src="/screenshot/screenshot2.png" width="220" height="400"> 
<img src="/screenshot/screenshot3.png" width="220" height="400"> 

# Step to re-crearte 


1. Create a new project in Android Studio (Choose the Empty Activity)
2. [Dwnload this Image](app/src/main/res/drawable/plus.png) and insert it into the drawable folder inside your project
3. Navigate to app/res/layout/activity_main.xml
4. Open the "Text" view and the replace the xml code with the below code 
The Code below will add to elements to the Layout:
    1. ListView that will display all the data in a List 
    2. A FAB button 
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout  xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent">

    <ListView
        android:id="@+id/listView1"
        android:layout_height="fill_parent"
        android:layout_width="fill_parent" />


    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        android:layout_margin="16dp"
        android:clickable="true"
        android:src="@drawable/plus"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintRight_toRightOf="parent" />

</android.support.constraint.ConstraintLayout >
```

5. Open the java file for the main activity by opening the MainActivity.java from the following path app/java/"The first folder"/MainActivity.java
6. Replace the code in that file with the below code ("Dont remove the first line starting with package")

```

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Define an Array list to store all the data that will be displyed
    ArrayList<String> items = new ArrayList<String>();

    //Variable to store the dialog text input
    private String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add data to the array
        items.add("Milk");
        items.add("Butter");
        items.add("Yogurt");
        items.add("Toothpaste");
        items.add("Ice Cream");

        //Define a listview
        ListView listView1 = (ListView) findViewById(R.id.listView1);

        //Define an array adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);

        //Connect the Listview to the adapter
        listView1.setAdapter(adapter);

        //Defining the Fab Button
        FloatingActionButton fab = findViewById(R.id.fab);

        //Add onclick listener to the Fab button that will trigger when the fab button is clicked
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating the dialog box
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Add to the list");

                // Set up the input
                final EditText input = new EditText(MainActivity.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT );

                //Ading the Edit text to the dialog bo
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        items.add(m_Text);
                    }
                });
                //Set up the Cancel button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                //To show the Dialog box
                builder.show();

                //To update the list View
                adapter.notifyDataSetChanged();

            }
        });


    }

}

```
Thank you!
