package com.example.ayabeltran.coni_final;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UserLogin extends AppCompatActivity {

    DBHelper mydb;
    public static EditText usernamelogin, passwordlogin;
    Button btn_login;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        mydb= new DBHelper(this);

        btn_login = findViewById(R.id.btn_login);
        usernamelogin = findViewById(R.id.usernamelogin);
        passwordlogin = findViewById(R.id.passwordlogin);

        Login();
    }

    private void Login() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = mydb.getReadableDatabase();
                String username = usernamelogin.getText().toString();
                String password = passwordlogin.getText().toString();
                Cursor res = mydb.login(username, password, sqLiteDatabase);

                if(res.moveToFirst()){
                    Intent intent = new Intent(UserLogin.this,UserProfile.class);
                    startActivity(intent);

                    Toast.makeText(UserLogin.this, "Welcome "+username+"!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(UserLogin.this, "your username and password do not match.", Toast.LENGTH_LONG).show();
                    usernamelogin.setText("");
                    passwordlogin.setText("");
                   usernamelogin.requestFocus();
                }
            }

        });
    }
}
