package com.gdgmanama.todoapp;

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
