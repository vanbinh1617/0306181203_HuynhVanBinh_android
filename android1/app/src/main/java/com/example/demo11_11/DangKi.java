package com.example.demo11_11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

<<<<<<< HEAD
<<<<<<< HEAD:android1/app/src/main/java/com/example/demo11_11/DangKi.java
public class DangKi extends AppCompatActivity {
=======
public class dangnhap extends AppCompatActivity {
>>>>>>> parent of 4831487... van binh 2h t.5:android1/app/src/main/java/com/example/demo11_11/dangnhap.java
=======
<<<<<<< HEAD:android1/app/src/main/java/com/example/demo11_11/dangnhap/dangnhap.java

//facebook
import com.example.demo11_11.MainActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.example.demo11_11.R;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;
=======
public class DangKi extends AppCompatActivity {
>>>>>>> a42e3f70e8a6792c7dbd55a5429bd4348ac5a9e5:android1/app/src/main/java/com/example/demo11_11/DangKi.java
>>>>>>> 267cd7171c98da55c806595b0211e89f68debc33

public class dangnhap extends AppCompatActivity {
    private static final String TAG = dangnhap.class.getSimpleName();
    CallbackManager callbackManager;
    LoginButton fbLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:android1/app/src/main/java/com/example/demo11_11/dangnhap/dangnhap.java
        setContentView(R.layout.activity_dangnhap);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        fbLoginButton = (LoginButton) findViewById(R.id.login_button);
        //https://developers.facebook.com/docs/facebook-login/permissions#reference
        fbLoginButton.setReadPermissions("email");

        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "======Facebook login success======");
                Log.d(TAG, "Facebook Access Token: " + loginResult.getAccessToken().getToken());
                Toast.makeText(dangnhap.this, "Login Facebook success.", Toast.LENGTH_SHORT).show();

                getFbInfo();
            }

            @Override
            public void onCancel() {
                Toast.makeText(dangnhap.this, "Login Facebook cancelled.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "======Facebook login error======");
                Log.e(TAG, "Error: " + error.toString());
                Toast.makeText(dangnhap.this, "Login Facebook error.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void getFbInfo() {
        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(final JSONObject me, GraphResponse response) {
                            if (me != null) {
                                Log.i("Login: ", me.optString("name"));
                                Log.i("ID: ", me.optString("id"));

                                Toast.makeText(dangnhap.this, "Name: " + me.optString("name"), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,link");
            request.setParameters(parameters);
            request.executeAsync();
        }
=======
        setContentView(R.layout.activity_dang_ki);
>>>>>>> a42e3f70e8a6792c7dbd55a5429bd4348ac5a9e5:android1/app/src/main/java/com/example/demo11_11/DangKi.java
    }
}