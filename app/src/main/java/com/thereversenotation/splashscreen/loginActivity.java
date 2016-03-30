package com.thereversenotation.splashscreen;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class loginActivity extends AppCompatActivity {

    Button OutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        OutButton = (Button) findViewById(R.id.buttonSignOut);

        OutButton.setOnClickListener(myButtonListener);
    }

    public View.OnClickListener myButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonSignOut:
                    OutButton();
                    break;
            }
        }

    };

    public void OutButton() {
        Intent intent = new Intent("com.thereversenotation.MainActivity");
        startActivity(intent);
    }
}
