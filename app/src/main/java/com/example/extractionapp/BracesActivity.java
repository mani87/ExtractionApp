package com.example.extractionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BracesActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvBracesYes, mTvBracesNo;
    private Button mBtnNext;
    int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braces);

        init();

        // set on click listeners here
        mTvBracesYes.setOnClickListener(this);
        mTvBracesNo.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }

    // initialise all variables
    private void init() {
        mTvBracesYes = findViewById(R.id.tv_bracesYes);
        mTvBracesNo = findViewById(R.id.tv_bracesNo);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_bracesYes:
                answer = 1;
                mTvBracesYes.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvBracesNo.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_bracesNo:
                answer = 2;
                mTvBracesYes.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvBracesNo.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btn_next:
                if (answer == 2) {
                    Intent intent = new Intent(this, NasolabialAngleActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    if(answer == 1){
                        Intent intent = new Intent(this, PermanentTeethActivity.class);
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
