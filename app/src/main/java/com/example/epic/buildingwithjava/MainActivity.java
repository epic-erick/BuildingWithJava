package com.example.epic.buildingwithjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout; //manually imported
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources; // used for converting DIP to PIX
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //using a relative layout
        RelativeLayout epicLayout = new RelativeLayout(this);
        epicLayout.setBackgroundColor(Color.GREEN);

        //Button
        Button redButton = new Button(this);
        redButton.setText(R.string.clickME);
        redButton.setBackgroundColor(Color.RED);
        redButton.setId(R.id.button_one); //this gets the id from xml file ids.xml

            //setting button in center horizontally & vertically
            RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
            buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);


                                                    //


        //Username Input
        EditText username = new EditText(this);
        username.setId(R.id.EDITTEXTUSERNAME); //this gets the ID from the ids.xml file that was created

            //setting details for username input
            RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
            usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
            usernameDetails.setMargins(0,0,0,50);

        //SETTING DIP DEVICE PIXELS -> to pixel values
        Resources r = getResources(); //gets information about your app
        int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());
        //          ^ gets typecasted into an int,^Unit that were trying to convert ^how many, ^gets the metrics from phoneapp
        username.setWidth(px);

        //Set button to layout
        epicLayout.addView(redButton, buttonDetails); //adds button and button details to the layout or widget
        epicLayout.addView(username, usernameDetails);

        //Set layout to display on screen
        setContentView(epicLayout); //makes this layout the main screen, meaning that the button will display
    }
}
