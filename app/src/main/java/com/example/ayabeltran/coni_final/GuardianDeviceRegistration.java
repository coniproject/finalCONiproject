package com.example.ayabeltran.coni_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GuardianDeviceRegistration extends AppCompatActivity {

    Button btncontinue;
    EditText txtlastname, txtfirstname, txtage,txtemail,txtnumber;
    RadioButton rdbtnmale, rdbtnfemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardian_device_registration);

        btncontinue = findViewById(R.id.btncontinue);
        txtlastname = findViewById(R.id.editlastname);
        txtfirstname = findViewById(R.id.editfirstname);
        txtage = findViewById(R.id.editage);
        rdbtnmale = findViewById(R.id.rdbmale);
        rdbtnfemale = findViewById(R.id.rdbfemale);
        txtemail = findViewById(R.id.editemailadd);
        txtnumber = findViewById(R.id.editcontactnumber);

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toAccountDetails = new Intent(GuardianDeviceRegistration.this,AccountDetailsRegistration.class);
                startActivity(toAccountDetails);
            }
        });
    }
}
