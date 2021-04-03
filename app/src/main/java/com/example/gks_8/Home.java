package com.example.gks_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Home extends AppCompatActivity {
    Button addbtn;
    private TextView name1,qty1,ppk1;
    private long bpt;
    private Toast bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        name1=findViewById(R.id.nametext22);
        qty1=findViewById(R.id.qtytext22);
        ppk1=findViewById(R.id.ppktext22);


        name1.setText(getIntent().getStringExtra("name"));
        qty1.setText(getIntent().getStringExtra("qty"));
        ppk1.setText(getIntent().getStringExtra("ppk"));



        String sppk = ppk1.getText().toString().trim();
        String sqt = qty1.getText().toString().trim();
        String rs = "Rs.";
        String kg = " Kg.";
        String pkg = "/Kg.";
        String sppk0 = rs.concat(sppk);
        String sppk1 = sppk0.concat(pkg);
        String sqt0 = sqt.concat(kg);

        qty1.setText(sqt0);
        ppk1.setText(sppk1);



        //Initialize and assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        //Set home as selected
        bottomNavigationView.setSelectedItemId(R.id.home);
        //Perform ItemSelectedListner
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        addbtn    = findViewById(R.id.addproductbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), addproduct.class));
            }
        });
    }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        }
        else {
            Toast.makeText(this, "बाहर निकलने के लिए वापस दबाएँ.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }


}
