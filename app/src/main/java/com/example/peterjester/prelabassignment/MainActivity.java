package com.example.peterjester.prelabassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button clickHereButton = null;
    private Button anotherButton = null;
    private Button toolButton = null;
    private Button passParamButton = null;

    private EditText nameEdit = null;
    private EditText phoneEdit= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.nameEdit);
        phoneEdit = findViewById(R.id.phoneEdit);

        toolButton = findViewById(R.id.externalButton);
        clickHereButton = findViewById(R.id.clickHereButton);
        anotherButton = findViewById(R.id.anotherButton);
        passParamButton = findViewById(R.id.passParamButton);

        // Set onClickListener to the anotherButton Button
        anotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.anotherClickMessage, Toast.LENGTH_LONG).show();
            }
        });

        toolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // In this case, we are using the Intent-filter "ACTION_SEND" for allowing this feature
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");

                startActivity(intent);
            }
        });

        passParamButton.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                // In this case, we are using the Intent-filter "ACTION_SEND" for allowing this feature
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                myIntent.putExtra("name_key", nameEdit.getText().toString()); //Optional parameters
                myIntent.putExtra("phone_key", phoneEdit.getText().toString()); //Optional parameters

                MainActivity.this.startActivity(myIntent);

                Log.i("MainActivity", "onLongClick: ");

                return true;
            }
        });
    }

    public void simpleClick(View view){
        Toast.makeText(getApplicationContext(), R.string.simpleClickMessage, Toast.LENGTH_LONG).show();
    }

}
