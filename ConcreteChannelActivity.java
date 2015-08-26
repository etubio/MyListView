package com.example.okos.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ConcreteChannelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concrete_channel);

        TextView textView = (TextView) findViewById(R.id.ch_name);
        String ch_name = getIntent().getStringExtra("CH_NAME");
        textView.setText(ch_name);

    }


}
