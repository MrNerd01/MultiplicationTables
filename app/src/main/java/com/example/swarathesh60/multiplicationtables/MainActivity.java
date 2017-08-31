package com.example.swarathesh60.multiplicationtables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int number;
    List<String> data = new ArrayList<String>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        Button button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.list);
        final EditText editText = (EditText) findViewById(R.id.editText);


        //trigger button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = Integer.parseInt(editText.getText().toString());
                if(number<10000){
                PopulateData(number);
                seekBar.setMax(number);
                seekBar.setProgress(number);
                seekBar.setVisibility(View.VISIBLE);
                listView.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(getApplicationContext(),"the "+number+" is too long enter smalleer number",Toast.LENGTH_LONG).show();
                }

            }
        });
        //trigger seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min =1;
                int temp;

                if(i<min){
                    temp = min;
                    seekBar.setProgress(1);
                }else {
                    temp = i;
                }
                PopulateData(temp);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);


    }

    private void PopulateData(int number) {
        data.clear();
        for (int i = 1 ; i <= 20 ; i++ ){
            data.add(number+" *  "+i+"  =  "+number*i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }
}
