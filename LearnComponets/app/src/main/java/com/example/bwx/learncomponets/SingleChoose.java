package com.example.bwx.learncomponets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class SingleChoose extends AppCompatActivity {
    private Button btnSubmit;
    private RadioButton rbB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choose);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        rbB = (RadioButton) findViewById(R.id.rbB);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbB.isChecked())
                {
                    Toast.makeText(SingleChoose.this,"不高兴",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SingleChoose.this,"SB",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
