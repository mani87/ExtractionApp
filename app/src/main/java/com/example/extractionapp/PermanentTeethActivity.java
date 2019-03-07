package com.example.extractionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PermanentTeethActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTeethNo, mTvTeethYes;
    private int answer;
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permanent_teeth);

        init();

        // set on click listeners here
        mTvTeethNo.setOnClickListener(this);
        mTvTeethYes.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }

    // initialise all variables
    private void init() {
        mTvTeethYes = findViewById(R.id.tv_TeethYes);
        mTvTeethNo = findViewById(R.id.tv_TeethNo);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_TeethYes:
                answer = 1;
                mTvTeethYes.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvTeethNo.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_TeethNo:
                answer = 2;
                mTvTeethYes.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvTeethNo.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btn_next:
                if (answer == 2) {
                    Intent intent = new Intent(this, NasolabialAngleActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    if (answer == 1){
                        Intent intent = new Intent(this, NumberOfTeethActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(this, "Please select an option to continue!", Toast.LENGTH_SHORT).show();
                    }
                }
            default:
                break;
        }
    }
}
