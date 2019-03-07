package com.example.extractionapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NumberOfTeethActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvOneTeeth, mTvTwoTeeth;
    private int answer;
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_of_teeth);

        init();

        // click listeners here
        mTvOneTeeth.setOnClickListener(this);
        mTvTwoTeeth.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }


    // initialise all variables
    private void init(){
        mTvOneTeeth = findViewById(R.id.tv_teethOne);
        mTvTwoTeeth = findViewById(R.id.tv_teethTwo);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_teethOne:
                answer = 1;
                mTvOneTeeth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvTwoTeeth.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_teethTwo:
                answer = 2;
                mTvOneTeeth.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvTwoTeeth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btn_next:
                if (answer == 1) {
                    Intent intent = new Intent(this, NasolabialAngleActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Please consult a dentist, This test cannot be performed.", Toast.LENGTH_SHORT).show();
                }
            default:
                break;
        }
    }
}
