package com.thereversenotation.splashscreen;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by bryan on 16/3/2016.
 */
public class Display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }
}
