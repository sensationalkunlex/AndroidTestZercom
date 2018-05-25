package com.example.user.testcrud;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity {

    Button Btn_Register;
    EditText mName, mEmail, mPassword, mConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Btn_Register = findViewById(R.id.btn_signup);
        mPassword = findViewById(R.id.signup_input_password);
        mConfirmPassword = findViewById(R.id.confirmPassword);
        mEmail = findViewById(R.id.EmailAdd);
        mName = findViewById(R.id.Names);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open = new Intent(Register.this, LoginActivity.class);
                startActivity(open);
            }
        });
        Btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Register();
            }
        });


    }


    public void Register() {

        // This validation can be nested
        if (TextUtils.isEmpty(mConfirmPassword.getText().toString().trim()) || TextUtils.isEmpty(mEmail.getText().toString().trim()) || TextUtils.isEmpty(mName.getText().toString().trim()) || TextUtils.isEmpty(mPassword.getText().toString().trim())) {

            mConfirmPassword.setError("pls enter the Username");
            mEmail.setError("pls enter the Email");

            mName.setError("pls enter the Username");
            mPassword.setError("pls enter the Password");

        } else {

            Toast.makeText(Register.this, "Validated", Toast.LENGTH_LONG).show();


        }

    }
}
