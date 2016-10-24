package com.example.viknox.facebookintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    LoginButton bt_login;
    TextView tv_login;
    private CallbackManager mcallBackManager;
    String[] permissions = { "public_profile", "user_friends", "email", "user_birthday" };
    private FacebookCallback<LoginResult> fbCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            final AccessToken accessToken = loginResult.getAccessToken();
            final Profile profile = Profile.getCurrentProfile();
            GraphRequest request = GraphRequest.newMeRequest(
                    accessToken,
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {
                            Log.v("LoginActivity Response ", response.toString());

                            try {
                                String Name = object.getString("name");
                                String Gender = object.getString("gender");
                                Character ugend = Gender.charAt(0);
                                String dob = object.getString("birthday");
                                int age;
                                age = 2016 - Integer.parseInt(dob.substring(dob.length()-4));
                                String  FEmail = object.getString("email");
                                JSONObject PicURLObj = object.getJSONObject("picture");
                                JSONObject data = PicURLObj.getJSONObject("data");
                                String PicUrl = data.getString("url");
                                Log.v("JSON", PicURLObj.toString() + data + PicUrl);
                                Toast.makeText(getApplicationContext(), "Name " + Name, Toast.LENGTH_LONG).show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender,birthday,picture");
            request.setParameters(parameters);
            request.executeAsync();
            startActivity(new Intent(MainActivity.this, OverviewActivity.class));
            // TODO Create POST HTTPS to server
            //TODO move to next screen


            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {
            Toast.makeText(getApplicationContext(), "Login Canceled!", Toast.LENGTH_LONG);
        }

        @Override
        public void onError(FacebookException error) {
            Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        mcallBackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initUI() {
        bt_login = (LoginButton) findViewById(R.id.login_button);
        tv_login = (TextView)    findViewById(R.id.tv_hello);
        bt_login.setReadPermissions(permissions);
        bt_login.registerCallback(mcallBackManager, fbCallback);
    }

}
