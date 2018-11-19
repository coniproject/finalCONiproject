package com.example.ayabeltran.coni_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AccountDetailsRegistration extends AppCompatActivity {
    DBHelper mydb;

    Button btnregister;
    EditText txtusername, txtpassword, txtconfirmpass;
    CheckBox chkterms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details_registration);
        mydb= new DBHelper(this);

        btnregister = findViewById(R.id.btnregister);
        txtusername = findViewById(R.id.usernamereg);
        txtpassword = findViewById(R.id.passwordreg);
        txtconfirmpass = findViewById(R.id.confirmpass);
        chkterms = findViewById(R.id.chkconditions);
//        btnregister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent toUserProfile = new Intent(AccountDetailsRegistration.this, UserProfile.class );
//                startActivity(toUserProfile);
//            }
//        });
        Register();

    }
    public void Register(){
            btnregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = mydb.addlogin (
                            txtusername.getText().toString(),
                            txtpassword.getText().toString());



                    if (isInserted) {

                        Toast.makeText(AccountDetailsRegistration.this, "You are now Registered.", Toast.LENGTH_LONG).show();

                        Intent toUserProfile = new Intent(AccountDetailsRegistration.this, UserProfile.class);
                        startActivity(toUserProfile);


                        txtusername.setText("");
                        txtpassword.setText("");
                        txtconfirmpass.setText("");



                    } else {
                        Toast.makeText(AccountDetailsRegistration.this, "Your username or email does already exists.", Toast.LENGTH_LONG).show();

                    }
                }
            });


    }
}
