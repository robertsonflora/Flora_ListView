package com.example.robertson.flora_listview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.robertson.flora_listview.Adapter.CustomAdapter;
import com.example.robertson.flora_listview.Model.College;
import com.example.robertson.flora_listview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] colleges;
    String[] year;
    int[] logo;
    ListView lv_Colleges;
    ArrayList<College> listColleges;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colleges = getResources().getStringArray(R.array.Colleges);
        year = getResources().getStringArray(R.array.Year);

        lv_Colleges = (ListView) findViewById(R.id.Colleges);
        listColleges = new ArrayList<College>();

        logo = new int[]{R.drawable.engg, R.drawable.med, R.drawable.pharma, R.drawable.iics};


        for(int i = 0; i < colleges.length; i++){
            listColleges.add(new College(logo[i], colleges[i], year[i]));
        }

        adapter = new CustomAdapter(MainActivity.this, listColleges);
        lv_Colleges.setAdapter(adapter);

        lv_Colleges.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String message = "You clicked " + colleges[i];

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

