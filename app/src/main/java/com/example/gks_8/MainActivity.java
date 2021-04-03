package com.example.gks_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName, editPassword;

    Button buttonSubmit, buttonReset;
    @Override protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName  = (EditText) findViewById(R.id.editAddress);
        editPassword = (EditText) findViewById(R.id.editPassword);

        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonReset = (Button) findViewById(R.id.buttonReset);



        /*
            Submit Button
        */
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                String s = "" ;
                String l="1234";
                String p="7233090239";
                openNewActivity();
                if(name.equals(s) || password.equals(s)) {
                    // If name or password is not entered
                    Toast.makeText(getApplicationContext(), "खाली बॉक्स की अनुमति नहीं है", Toast.LENGTH_LONG).show();
                }
                else if(name.equals(p) && password.equals(l)) {
                    openNewActivity();
                }
                else{
                    Toast.makeText(getApplicationContext(), "अमान्य प्रविष्टि", Toast.LENGTH_LONG).show();
                }
            }
        });
        /*
            Reset Button
        */
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editPassword.setText("");
                editName.requestFocus();
            }
        });
    }
    public void openNewActivity(){
        startActivity(new Intent(getApplicationContext(), Register.class));
    }
}
