package com.example.ayabeltran.coni_final;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GuardianDeviceRegistration extends AppCompatActivity {

    DBHelper mydb;
SQLiteDatabase pf;
    private static final String Tag = "GuardianRegistration";
    Button btncontinue;
    EditText txtlastname, txtfirstname, txtmi, txtage, txtemail, txtnumber;
    RadioButton rdbtnmale, rdbtnfemale;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private TextView txtbdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardian_device_registration);

        mydb= new DBHelper(this);

        btncontinue = findViewById(R.id.btncontinue);
        txtlastname = findViewById(R.id.editlastname);
        txtfirstname = findViewById(R.id.editfirstname);
        txtmi = findViewById(R.id.editmi);
        txtbdate = findViewById(R.id.editbdate);
        txtage = findViewById(R.id.editage);
        rdbtnmale = findViewById(R.id.rdbmale);
        rdbtnfemale = findViewById(R.id.rdbfemale);
        txtemail = findViewById(R.id.editemailadd);
        txtnumber = findViewById(R.id.editcontactnumber);
//        btncontinue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent toAccountDetails = new Intent(GuardianDeviceRegistration.this, AccountDetailsRegistration.class);
//                startActivity(toAccountDetails);
//            }
//        });
       Register();

       //DATE

//        txtbdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        GuardianDeviceRegistration.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        mDataSetListener, year, month, day
//                );
//                txtage.setText(Integer.toString(calculateAge(cal.getTimeInMillis())));
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//
//            }
//        });
//
//        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                month = month + 1;
//                Log.d(Tag, "onDateSet: mm/dd/yyyy: " + month + "/" + dayOfMonth + "/" + year);
//                String date = month + "/" + dayOfMonth + "/" + year;
//                txtbdate.setText(date);
//
//
//            }
//        };


    }

//    //RDBUTON
//    public void RadioButtonClicked(View view) {
//
////This variable will store whether the user was male or female
//        String gender = "";
//// Check that the button is  now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//// Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.rdbfemale:
//                if (checked)
//                    gender = "female";
//                break;
//            case R.id.rdbmale:
//                if (checked)
//                    gender = "male";
//                break;
//        }
//        pf.execSQL("INSERT INTO tblguardian VALUES('"+gender+"');");
//    }
    public void Register(){
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.addguardian (
                        txtlastname.getText().toString(),
                        txtfirstname.getText().toString(),
                        txtmi.getText().toString(),
                        txtbdate.getText().toString(),
                        txtage.getText().toString(),
                        rdbtnfemale.getText().toString(),
                        txtemail.getText().toString(),
                        txtnumber.getText().toString());

                if (isInserted) {

                    Toast.makeText(GuardianDeviceRegistration.this, "you are now registered.", Toast.LENGTH_LONG).show();

                    Intent toAccountDetails = new Intent(GuardianDeviceRegistration.this, AccountDetailsRegistration.class);
                    startActivity(toAccountDetails);


                    txtfirstname.setText("");
                    txtlastname.setText("");
                    txtmi.setText("");
                    txtage.setText("");
                    txtbdate.setText("");
                    txtnumber.setText("");
                    txtemail.setText("");

                } else {
                    Toast.makeText(GuardianDeviceRegistration.this, "your email or username is already in use.", Toast.LENGTH_LONG).show();

                }
            }
        });


    }


   private int calculateAge(long bdate) {
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(bdate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }

}

