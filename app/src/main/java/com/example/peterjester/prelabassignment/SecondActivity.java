package com.example.peterjester.prelabassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView nameView = null;
    TextView phoneView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameView = findViewById(R.id.secondActivityNameView);
        phoneView = findViewById(R.id.secondActivityPhone);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name_key");
        String phone = intent.getStringExtra("phone_key");

        String msg = "OnCreate: " + name.toString();

        Log.i("SecondAcvitiy", msg);

        nameView.setText(name);
        phoneView.setText(phone);


    }
}
