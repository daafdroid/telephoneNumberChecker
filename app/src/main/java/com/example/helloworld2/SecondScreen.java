package com.example.helloworld2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;


public class SecondScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen2);

        //get back the text passed through the intent
        String phoneNumberToCheck = getIntent().getStringExtra("theString").toString();

        //find TextView and set text
        TextView numberEntered = (TextView) this.findViewById(R.id.enterNumberTextValue);
        numberEntered.setText(phoneNumberToCheck);

        String regionCode = null;
        Boolean validNumber;

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            // phone number must begin with '+'
            PhoneNumber numberProto = phoneUtil.parse(phoneNumberToCheck, "");
            regionCode = phoneUtil.getRegionCodeForNumber(numberProto);
            validNumber = phoneUtil.isValidNumber(numberProto);

            if (validNumber) {
                TextView theTextView = (TextView) this.findViewById(R.id.validNumberText);
                theTextView.setText(R.string.number_valid);
                theTextView.setTextColor(getResources().getColor(R.color.darkgreen));
            }

        } catch (NumberParseException e) {
            //
            System.err.println("NumberParseException was thrown: " + e.toString());
        }

        // Edit TextView for
        if (regionCode != null) {
            TextView theTextView = (TextView) this.findViewById(R.id.regionCodeText);
            theTextView.setText("Country of origin: " + regionCode);
        }
    }


    public void onClick(View view) {
        //called from button back click

        finish();
    }

    public void realCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + getIntent().getStringExtra("theString").toString()));
        startActivity(intent);
    }

}
