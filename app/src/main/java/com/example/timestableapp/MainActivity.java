package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;
import static java.util.Arrays.asList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public void generateTimeTable(int timesTableNum){
        ArrayList<String> tablesList = new ArrayList<String>();
        for(int j=1; j<=100; j++){
            tablesList.add(Integer.toString(j * timesTableNum));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tablesList);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myListView);
        SeekBar seekBar = findViewById(R.id.seekBar);

        int max = 20;
        int startingPos = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPos);

        generateTimeTable(startingPos);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNum;

                if(i<min){
                    timesTableNum = min;
                    seekBar.setProgress(min);
                }else{
                    timesTableNum = i;
                }

                Log.i("OnProgress Value: ", Integer.toString(timesTableNum));

//                ArrayList<String> tablesList = new ArrayList<String>();
//                for(int j=1; j<=10; j++){
//                    tablesList.add(Integer.toString(j * timesTableNum));
//                }

                generateTimeTable(timesTableNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

//        ArrayList<Integer> tablesList = new ArrayList<Integer>();
//        tablesList.add(2);
//        tablesList.add(4);
//        tablesList.add(6);
//        tablesList.add(8);
//        tablesList.add(10);
//        tablesList.add(12);
//        tablesList.add(14);
//        tablesList.add(16);
//        tablesList.add(18);
//        tablesList.add(20);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tablesList);
//        listView.setAdapter(arrayAdapter);

    }
}