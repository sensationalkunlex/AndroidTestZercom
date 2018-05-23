package com.example.user.testcrud;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiCall {


    //This method is used for "POST"
    @POST("/1/api/login")
      Call<Response> loginwith(@Body PojoObject pojoObject);

}
