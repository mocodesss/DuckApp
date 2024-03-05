package com.quackfactory.duckapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button toFactsButton;
    Button toPicButton;
    Button giveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toFactsButton = findViewById(R.id.to_facts_button);
        toFactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFactsActivity();
            }
        });

        toPicButton = findViewById(R.id.to_pic_button);
        toPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicActivity();
            }
        });

        giveButton = findViewById(R.id.to_give_button);
        giveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String giveURL = "https://www.heifer.org/gift-catalog/animals/gift-of-ducks.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(giveURL));
                startActivity(i);
            }
        });
    }

    public void openFactsActivity(){
        Intent intentFact = new Intent(this, FactActivity.class);
        startActivity(intentFact);
    }

    public void openPicActivity(){
        Intent intentPic = new Intent(this,PicActivity.class);
        startActivity(intentPic);
    }
}