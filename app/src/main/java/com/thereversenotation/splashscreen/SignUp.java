package com.thereversenotation.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends Activity {
    MyDBHandler db = new MyDBHandler(this);
    Button SignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUpButton = (Button) findViewById(R.id.buttonSignUp);

        SignUpButton.setOnClickListener(myButtonListener);
    }

    public View.OnClickListener myButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.buttonSignUp){
                EditText username = (EditText)findViewById(R.id.accUser);
                EditText pass1 = (EditText)findViewById(R.id.accPass);
                EditText pass2 = (EditText)findViewById(R.id.cfmPass);

                String userstr = username.getText().toString();
                String pass1str = pass1.getText().toString();
                String pass2str = pass2.getText().toString();

                if(!pass1str.equals(pass2str))
                {
                    Toast.makeText(getApplicationContext(), "Password doesn't match!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Storage u = new Storage();
                    u.setUserName(userstr);
                    u.setPass(pass1str);

                    db.addUser(u);
                }

            }
        }

    };

}