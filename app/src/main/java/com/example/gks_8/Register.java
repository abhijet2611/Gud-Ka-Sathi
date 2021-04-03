package com.example.gks_8;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {

    EditText name,address,aadhar,gstin,accno,phhno,emmail;
    Button regbtn;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name    = findViewById(R.id.prdtnm);
        address = findViewById(R.id.ppk);
        aadhar  = findViewById(R.id.qty);
        gstin = findViewById(R.id.dc);
        accno = findViewById(R.id.desc);
        phhno = findViewById(R.id.phno);
        emmail = findViewById(R.id.email);
        regbtn    = findViewById(R.id.submitbtn);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saadhar = aadhar.getText().toString().trim();
                String sgstin = gstin.getText().toString().trim();
                String saccno = accno.getText().toString().trim();
                String sname = name.getText().toString().trim();
                String sphhno = phhno.getText().toString().trim();
                String semail = emmail.getText().toString().trim();
                String saddress = address.getText().toString().trim();

                if(TextUtils.isEmpty(sname)||TextUtils.isEmpty(sphhno)||TextUtils.isEmpty(saddress)||TextUtils.isEmpty(saadhar)||TextUtils.isEmpty(sgstin)||TextUtils.isEmpty(saccno))
                        {Toast.makeText( Register.this , "खाली बॉक्स की अनुमति नहीं है", Toast.LENGTH_LONG).show();}
                else if(saadhar.length()!=12)
                        {aadhar.setError("ठीक 12 संख्या दर्ज करें");}
                else if(sgstin.length()<12)
                        {gstin.setError("12 या अधिक वर्ण दर्ज करें");}
                else if(saccno.length()<12)
                        {accno.setError("12 या अधिक वर्ण दर्ज करें");}
                else if(sphhno.length()!=10)
                        {phhno.setError("ठीक 10 अक्षर दर्ज करें");}
                else
                        {Toast.makeText(Register.this, "उपयोगकर्ता बन गया", Toast.LENGTH_LONG).show();}

                Intent launchNextActivity;
                launchNextActivity = new Intent(getApplicationContext(), Home.class);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(launchNextActivity);


            };
            });

        }
    }