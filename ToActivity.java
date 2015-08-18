package com.example.okos.mylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ToActivity extends AppCompatActivity {

    ListView listView2;
    ArrayList<String> selectedItems = new ArrayList<>();
    ArrayList<String> favorite_channels;
    ArrayList<String> all_channels = new ArrayList<>();
    String[] channel_list = {"1","2","A3","Neox","Mega","Boing","Nova"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);

        listView2 = (ListView) findViewById(R.id.listView2);
        Button button = (Button) findViewById(R.id.button2);

        // Get favorite channels from main activity
        favorite_channels = getIntent().getStringArrayListExtra("FAVORITES");
        all_channels.addAll(Arrays.asList(channel_list));

        // Remove favorite channels from list of all channels
        for (String s:favorite_channels)
            if (all_channels.contains(s)) all_channels.remove(s);

        // Display listView2
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, all_channels);
        listView2.setAdapter(adapter);
        listView2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Press OK
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Get all checked items
                int cntChoice = listView2.getCount();
                SparseBooleanArray sparseBooleanArray = listView2.getCheckedItemPositions();
                for(int i = 0; i < cntChoice; i++)
                    if(sparseBooleanArray.get(i) == true)
                        selectedItems.add(listView2.getItemAtPosition(i).toString());

                // Return result to main activity
                Intent intent = new Intent();
                intent.putExtra("SELECTED", selectedItems);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

}
