package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myList;

    public void generateTable(int num){

        ArrayList<String> myArray= new ArrayList<String>();

        for( int i = 1; i<=12; i++){
            myArray.add(Integer.toString(i*num));
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, myArray);

        myList.setAdapter(arrayAdapter);





    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar= findViewById(R.id.seekBar);
        myList= findViewById(R.id.myList);

        int max=20;
        int start=10;


        seekBar.setMax(max);
        seekBar.setProgress(10);

        generateTable(start);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int min=1;
                int num;
                if (progress<min){
                    num= min;
                    seekBar.setProgress(min);
                } else {
                    num = progress;
                }

                Log.i("SeekBar value", Integer.toString(num));

                generateTable(num);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });










    }
}
