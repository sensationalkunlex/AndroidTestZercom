package com.example.user.testcrud;

import android.support.v7.app.AppCompatActivity;




import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import  android.content.Intent;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {



    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
login( mEmailView.getText().toString().trim(), mPasswordView.getText().toString().trim() );
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);





        Button pData =(Button) findViewById(R.id.btnsign_Up);
        pData.setOnClickListener(new OnClickListener(){

         @Override
            public void onClick(View view) {

          Intent  open = new Intent(LoginActivity.this, Register.class);
          startActivity(open);

         }

        } );

    }


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */


    private void login(String Username, String Password) {
        if (TextUtils.isEmpty(mEmailView.getText().toString().trim()) || TextUtils.isEmpty(mPasswordView.getText().toString().trim())) {

            mEmailView.setError("pls enter the Username");
            mPasswordView.setError("pls enter the Password");

        } else {
            PojoObject pr= new PojoObject(Username, Password);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://icanlectures.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //retrofit.create();

            ApiCall api = retrofit.create(ApiCall.class);
            api.loginwith(pr).enqueue(new
                                              Callback<com.example.user.testcrud.Response>() {
                                                  @Override
                                                  public void onResponse(Call<com.example.user.testcrud.Response> call, Response<com.example.user.testcrud.Response> response) {
                                                      if(response.isSuccessful()){


                                                          //JSONObject object = new JSONObject();
                                                          //object.put()
                                                          //Gson gson= new Gson();
                                                          //Data rson=gson.toJson(response.body().getData());



                                                          Log.e("first", "Error");
                                                          Data da=response.body().getData();
                                                          try {

                                                              // I need path to the token
                                                             // if (da.getToken().isEmpty()) {

                                                             if(da.getStatus().equals("error")){
                                                                  Log.e("Title", "Error");
                                                                  Toast.makeText(LoginActivity.this, da.getMessage(), Toast.LENGTH_SHORT).show();
                                                             }
                                                             else{
                                                             Toast.makeText(LoginActivity.this, "You are Logged in /n"+da.getStatus(), Toast.LENGTH_SHORT ).show();

                                                             }

                                                        /*  else {
                                                              Log.i("verify Data", da.getToken());
                                                              Toast.makeText(LoginActivity.this, da.getToken(), Toast.LENGTH_SHORT).show();
                                                          }*/
                                                          }



                                                          catch (Exception ee){
                                                              Log.e("", ee.getMessage());

                                                              Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

                                                          }
                                                      }
                                                      else{

                                                          Toast.makeText(LoginActivity.this, "incorrect Password", Toast.LENGTH_SHORT).show();

                                                      }
                                                  }

                                                  @Override
                                                  public void onFailure(Call<com.example.user.testcrud.Response> call, Throwable t) {
                                                      Toast.makeText(LoginActivity.this, "Network failure", Toast.LENGTH_SHORT).show();

                                                  }
                                              });


        }
    }
/*
Response<PojoObject> user = api.loginwith(pr).enqueue(new Callback<com.example.user.testcrud.Response>() {
    @Override
    public void onResponse(Call<com.example.user.testcrud.Response> call, Response<com.example.user.testcrud.Response> response) {

    }

    @Override
    public void onFailure(Call<com.example.user.testcrud.Response> call, Throwable t) {

    }
});*/


            //Retrofit
           // Snackbar.make(this, "Login", LENGTH_SHORT).show();




            //




        }


