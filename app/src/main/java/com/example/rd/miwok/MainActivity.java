package com.example.rd.miwok;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ImageView) findViewById(R.id.w)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("tel:9597111044"));   //by default number display...


                startActivity(i);
                Toast.makeText(getBaseContext(), "Providing you our whatsapp number", Toast.LENGTH_SHORT).show();

            }
        });

        ((ImageView) findViewById(R.id.call)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("tel:8851798223"));   //by default number display...

                startActivity(i);
                Toast.makeText(getBaseContext(), "Connecting you to our number", Toast.LENGTH_SHORT).show();

            }
        });
        ((ImageView) findViewById(R.id.web)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);

                i.setData(Uri.parse("https://www.google.co.in/search?q=google+translate&rlz=1C1CHBF_enIN726IN726&source=lnms&sa=X&ved=0ahUKEwjdmcvuu6jXAhXIu48KHX7UB6UQ_AUICSgA&biw=1536&bih=723&dpr=1.25"));   //by default site display...

                startActivity(i);
                Toast.makeText(getBaseContext(), "Getting you to our website", Toast.LENGTH_SHORT).show();

            }
        });
        ((ImageView) findViewById(R.id.mail)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                {
                    Log.i("Send email", "");

                    Toast.makeText(getBaseContext(), "There is no email client installed", Toast.LENGTH_SHORT).show();
                    String[] TO = {"mani.saksham12@gmail.com"};
                    String[] CC = {"xyz@gmail.com"};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");


                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_CC, CC);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here...");

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                        finish();
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this,
                                "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                }
//                Intent i=new Intent();
//                i.setAction(Intent.ACTION_VIEW);
//
//                i.setData(Uri.parse("https://www.gmail.com"));   //by default site display...
//
//                startActivity(i);
//
//                Toast.makeText(getBaseContext(),"There is no email client installed",Toast.LENGTH_SHORT).show();
            }

        });


    /*Set onClick Listener for NmubersActivity*/
        TextView numbers = (TextView)findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Opening Numbers List", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(in);
            }
        });

    /*SetOnClickListener for FamilyActivity*/
        TextView family = (TextView)findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Opening Family List", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(in);
            }
        });

        /*SetOnClickListener for PhrasesActivity*/
        TextView phrases = (TextView)findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Opening Phrases List", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(in);
            }
        });

        /*SetOnClickListener for ColorsActivity*/


        TextView colors = (TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Opening Colors List", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(in);
            }
        });


    }


}
