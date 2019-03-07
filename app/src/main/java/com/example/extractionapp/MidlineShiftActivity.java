package com.example.extractionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MidlineShiftActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvShiftYes, mTvShiftNo;
    private Button mBtnCalculate;
    private int answer = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midline_shift);

        init();

        mTvShiftNo.setOnClickListener(this);
        mTvShiftYes.setOnClickListener(this);
        mBtnCalculate.setOnClickListener(this);
    }


    // initialize all variables
    private void init() {
        mTvShiftYes = findViewById(R.id.tv_ShiftYes);
        mTvShiftNo = findViewById(R.id.tv_ShiftNo);
        mBtnCalculate = findViewById(R.id.btn_calculate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_ShiftNo:
                answer = 0;
                mTvShiftNo.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvShiftYes.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_ShiftYes:
                answer = 1;
                mTvShiftYes.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvShiftNo.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.btn_calculate:
                if (answer == 33){
                    Toast.makeText(this, "Please select an option to continue!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = getIntent();
                    int nasolabialAngle = intent.getIntExtra("nasolabialAngle", 0);
                    int crowding = intent.getIntExtra("crowding", 0);
                    int proclination = intent.getIntExtra("proclination", 0);
                    int overjet = intent.getIntExtra("overjet", 0);

                    double result = -4.833 + (0.973*nasolabialAngle)  -(0.184*overjet) + (2.347*proclination) + (1.2*answer) + (0.328*crowding);
                    Toast.makeText(this, result + "", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
