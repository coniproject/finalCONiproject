package com.example.ayabeltran.coni_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AccountDetailsRegistration extends AppCompatActivity {

    Button btnregister;
    EditText txtusername, txtpassword, txtconfirmpass;
    CheckBox chkterms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details_registration);

        btnregister = findViewById(R.id.btnregister);
        txtusername = findViewById(R.id.usernamereg);
        txtpassword = findViewById(R.id.passwordreg);
        txtconfirmpass = findViewById(R.id.confirmpass);
        chkterms = findViewById(R.id.chkconditions);

        Intent toUserProfile = new Intent(AccountDetailsRegistration.this, UserProfile.class );
        startActivity(toUserProfile);

    }
}
