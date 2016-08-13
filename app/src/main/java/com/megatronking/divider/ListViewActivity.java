package com.megatronking.divider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    private static final String[] LIST = new String[]{"TestA", "TestB", "TestC", "TestD", "TestE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView list = (ListView) findViewById(R.id.list);
        if (list != null) {
            list.setAdapter(new ArrayAdapter<>(this, R.layout.item_list, R.id.item_text, LIST));
        }
    }

}
