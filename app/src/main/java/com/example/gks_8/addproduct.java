package com.example.gks_8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addproduct extends AppCompatActivity {
    EditText pname, ppk, qty, dc, desc;
    Button submitbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);
        pname = findViewById(R.id.prdtnm);
        ppk = findViewById(R.id.ppk);
        qty = findViewById(R.id.qty);
        dc = findViewById(R.id.dc);
        desc = findViewById(R.id.desc);
        submitbtn = findViewById(R.id.submitbtn);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdc = dc.getText().toString().trim();
                String spname = pname.getText().toString().trim();
                String sppk = ppk.getText().toString().trim();
                String sdesc = desc.getText().toString().trim();
                String sqty = qty.getText().toString().trim();

                if (TextUtils.isEmpty(sdc) || TextUtils.isEmpty(spname) || TextUtils.isEmpty(sppk) || TextUtils.isEmpty(sdesc) || TextUtils.isEmpty(sqty)) {
                    Toast.makeText(addproduct.this, "खाली बॉक्स की अनुमति नहीं है", Toast.LENGTH_LONG).show();
                }
//                Intent intent = new Intent(addproduct.this, Home.class);

                Intent launchNextActivity;

                launchNextActivity = new Intent(getApplicationContext(), Home.class);
                launchNextActivity.putExtra("name", spname);
                launchNextActivity.putExtra("ppk", sppk);
                launchNextActivity.putExtra("qty", sqty);

                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(launchNextActivity);

            }
        });
    }
}
