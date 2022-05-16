package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Set a button called button1
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Allow users click button1 to game page
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    //Set it to open MainActivity2 (Game Page) using intent
    public void openNewActivity(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}