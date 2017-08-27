package com.example.bwx.learncomponets;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ChoseADate extends AppCompatActivity {
    private Button btnChoseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_adate);

        btnChoseData = (Button) findViewById(R.id.btnChoseDate);
        btnChoseData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(ChoseADate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String theDate = String.format("%d-%d-%d",year,month+1,dayOfMonth);
                        System.out.println(theDate);

                        btnChoseData.setText(theDate);

                    }
                },2016,11,5).show();

            }
        });
    }
}
