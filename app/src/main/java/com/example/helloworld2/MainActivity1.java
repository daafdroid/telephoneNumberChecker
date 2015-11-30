package com.example.helloworld2;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.inputmethodservice.InputMethodService;


public class MainActivity1 extends Activity {
    int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1);
    }

    public void onClick(View view) {
        //called from button click

        //lines below for passing data via intent object
        Intent myIntent = new Intent("com.example.helloworld2.SecondScreen");

        //Find textview element
        TextView theTextView = (TextView) findViewById(R.id.editText1);

        //Get text
        String number = theTextView.getText().toString();

        //name-pair value
        myIntent.putExtra("theString", number);

        startActivity(myIntent);
    }
}
