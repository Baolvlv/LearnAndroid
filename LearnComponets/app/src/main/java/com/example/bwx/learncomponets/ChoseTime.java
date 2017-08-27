package com.example.bwx.learncomponets;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class ChoseTime extends AppCompatActivity {
    private Button btnChoseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_time);

        btnChoseTime = (Button) findViewById(R.id.btnChoseTime);
        btnChoseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(ChoseTime.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String time = String.format("%d : %d",hourOfDay,minute);
                        System.out.println(time);

                        btnChoseTime.setText(time);
                    }
                },0,0,true).show();
            }
        });
    }
}
