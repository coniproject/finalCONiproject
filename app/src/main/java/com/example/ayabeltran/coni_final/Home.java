package com.example.ayabeltran.coni_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button btnlogin, btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnlogin = findViewById(R.id.btn_login);
        btnsignup = findViewById(R.id.btn_signup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toUserLogin = new Intent(Home.this, UserLogin.class);
                startActivity(toUserLogin);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toRegistration = new Intent(Home.this, GuardianDeviceRegistration.class);
                startActivity(toRegistration);
            }
        });

    }
}
