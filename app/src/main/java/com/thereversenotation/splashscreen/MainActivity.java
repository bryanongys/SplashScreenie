package com.thereversenotation.splashscreen;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    CheckBox RmbmeCheckBox;
    ImageButton imageConfirmButton;
    TextView forgotPassword;
    ImageView imageCookieButton;
    MyDBHandler helper = new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageConfirmButton = (ImageButton) findViewById(R.id.buttonLogin);
        imageCookieButton = (ImageView) findViewById(R.id.buttonSignUp);
        editTextUsername= (EditText)findViewById(R.id.editTextUsername);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);

        imageConfirmButton.setOnClickListener(myButtonListener);
        imageCookieButton.setOnClickListener(myButtonListener);
        forgotPassword.setOnClickListener(myButtonListener);
    }

    public View.OnClickListener myButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.buttonLogin) {
                EditText a = (EditText) findViewById(R.id.editTextUsername);
                String str = a.getText().toString();
                EditText b = (EditText) findViewById(R.id.editTextPassword);
                String pass = b.getText().toString();

                String password = helper.searchPass(str);
                if (pass.equals(password)) {
                    Intent i = new Intent(MainActivity.this, Display.class);
                    i.putExtra("Username", str);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "The Username/Password you have entered is incorrect.Please try again.",
                            Toast.LENGTH_SHORT).show();
                }
            }
            if(v.getId() == R.id.buttonSignUp){
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        }
    };
};





























/*public class MainActivity extends AppCompatActivity {

    ImageView imageCookieButton;
    TextView forgotPassword;
    ImageButton imageConfirmButton;
    CheckBox RmbmeCheckBox;
    EditText editTextUsername, editTextPassword;
    MyDBHandler db = new MyDBHandler(this, null, null, 1);
    Storage info = new Storage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageConfirmButton = (ImageButton) findViewById(R.id.buttonLogin);
        imageCookieButton = (ImageView) findViewById(R.id.buttonSignUp);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        RmbmeCheckBox = (CheckBox) findViewById(R.id.saveLoginCheckBox);
        editTextUsername= (EditText)findViewById(R.id.editTextUsername);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        imageConfirmButton.setOnClickListener(myButtonListener);
        imageCookieButton.setOnClickListener(myButtonListener);
        forgotPassword.setOnClickListener(myButtonListener);
        RmbmeCheckBox.setOnClickListener(myButtonListener);

        SharedPreferences pref = getSharedPreferences("MySettings", MODE_PRIVATE);
        String username = pref.getString("username", "");
        String password = pref.getString("password", "");
        Boolean checked = pref.getBoolean("CheckBoxChecked", false);
        if((username==null)||(password==null)){
            username="";
            password="";
        }
        editTextUsername.setText(username);
        editTextPassword.setText(password);
        RmbmeCheckBox.setChecked(checked);
    }

    public View.OnClickListener myButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonLogin:
                    if((editTextUsername.getText().toString().equals(""))||(editTextPassword.getText().toString().equals(""))){
                        Toast.makeText(getApplicationContext(), "Please fill in the required fields.",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(db.findUser(editTextUsername.getText().toString())==null){
                        Toast.makeText(getApplicationContext(), "The username you have entered is incorrect.Please try again.",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(db.findUser(editTextPassword.getText().toString())==null){
                        Toast.makeText(getApplicationContext(), "The password you have entered is incorrect.Please try again.",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(info.getPass().equals(editTextPassword.getText().toString())){
                        //Toast.makeText(getApplicationContext(), "You have entered the wrong password.",
                               // Toast.LENGTH_SHORT).show();
                        imageConfirmButton();

                    }
                    break;

                case R.id.buttonSignUp:
                    imageCookieButton();
                    break;
                case R.id.forgotPassword:
                    setForgotPassword();
                    break;
                case R.id.saveLoginCheckBox:
                    if (RmbmeCheckBox.isChecked()) {
                        SharedPreferences pref = getSharedPreferences("MySettings", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("username", editTextUsername.getText().toString());
                        editor.putString("password", editTextPassword.getText().toString());
                        editor.putBoolean("CheckBoxChecked", true);
                        editor.commit();
                    } else {

                        SharedPreferences pref = getSharedPreferences("MySettings", MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("username", "");
                        editor.putString("password", "");
                        editor.putBoolean("CheckBoxChecked", false);
                        editor.commit();
                    }
                    break;
            }
        }
    };

    public void setForgotPassword(){
                Intent intent = new Intent("com.thereversenotation.SignUp");
                startActivity(intent);
        }

    public void imageConfirmButton() {
                Intent intent = new Intent("com.thereversenotation.loginActivity");
                startActivity(intent);
            }
    public void imageCookieButton() {
        Intent intent = new Intent("com.thereversenotation.SignUp");
        startActivity(intent);
    }

    } */




