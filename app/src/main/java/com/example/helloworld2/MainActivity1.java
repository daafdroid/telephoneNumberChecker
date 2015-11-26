package com.example.helloworld2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity1 extends Activity {
    int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void passNumber(View view)
    {
        TextView theTextView = (TextView) findViewById(R.id.editText1);
        if(view.getId()==R.id.A)
            theTextView.setText(theTextView.getText()+"1");
        if(view.getId()==R.id.B)
            theTextView.setText(theTextView.getText()+"2");
        if(view.getId()==R.id.C)
            theTextView.setText(theTextView.getText()+"3");
        if(view.getId()==R.id.D)
            theTextView.setText(theTextView.getText()+"4");
        if(view.getId()==R.id.E)
            theTextView.setText(theTextView.getText()+"5");
        if(view.getId()==R.id.F)
            theTextView.setText(theTextView.getText()+"6");
        if(view.getId()==R.id.G)
            theTextView.setText(theTextView.getText()+"7");
        if(view.getId()==R.id.H)
            theTextView.setText(theTextView.getText()+"8");
        if(view.getId()==R.id.I)
            theTextView.setText(theTextView.getText()+"9");
        if(view.getId()==R.id.J)
            theTextView.setText(theTextView.getText()+"+");
        if(view.getId()==R.id.K)
            theTextView.setText(theTextView.getText()+"0");

    }

    public void onClick(View view) {
        //called from button click

        //one line below for simply starting intent, passing no data
        //    	startActivity(new Intent("com.example.helloworld2.SecondScreen"));

        //lines below for passing data via intent object
        Intent myIntent = new Intent("com.example.helloworld2.SecondScreen");

        //Find textview element
        TextView theTextView = (TextView) findViewById(R.id.editText1);
        //Get text
        String sText = theTextView.getText().toString();

        //name-pair value
        myIntent.putExtra("theString", sText);
        //alternative was to create a bundle object. see page 66 - 67

        startActivityForResult(myIntent, request_code);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //no need to do anything but the code can be handled here as can the Intent data
        TextView theTextView = (TextView) this.findViewById(R.id.editText1);
        String phoneNumber = getIntent().getStringExtra("theString").toString();
        theTextView.setText((phoneNumber));


        //show toast aswell for demo
        String theText = "Returned from SecondScreen with resultCode (OK = " + RESULT_OK + "): " + resultCode;
        Toast.makeText(this, theText, Toast.LENGTH_LONG).show();

    }


}
