package com.saae.taskreminder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Saae on 6/18/2017.
 */

public class ListExample extends AppCompatActivity {


    ArrayList<ExpireDatesModel> list;
    ExpireDatesModel expireDatesModel;
    Integer integer[] = {1, 5, 7, 30};
    String string[] = {"Expires in 1 day", "Expires in 5 days", "Expires in 7 days"
            , "Expires in 30 days"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        ListView lv = (ListView) findViewById(R.id.list);
        list = new ArrayList();

        for (int i = 0; i < integer.length; i++) {
            expireDatesModel = new ExpireDatesModel();
            expireDatesModel.setData(string[i]);
            expireDatesModel.setDate(integer[i]);
            list.add(expireDatesModel);
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ExpireDatesModel expireDatesModel = list.get(i);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, expireDatesModel.getDate());
                String date = "Expires on" + sdf.format(calendar.getTime());

                Toast.makeText(ListExample.this, date + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
