package com.example.extractionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NasolabialAngleActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvAcute, mTvObtuse, mTvAverage;
    private int answer = 0;
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasolabial_angle);

        init();

        // Click listeners here
        mTvObtuse.setOnClickListener(this);
        mTvAcute.setOnClickListener(this);
        mTvAverage.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }


    // initialsie all variable here
    private void init() {
        mTvAcute = findViewById(R.id.tv_acute);
        mTvObtuse = findViewById(R.id.tv_obtuse);
        mTvAverage = findViewById(R.id.tv_average);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_acute:
                answer = 3;
                mTvAcute.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvObtuse.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvAverage.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_obtuse:
                answer = 1;
                mTvObtuse.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvAcute.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvAverage.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_average:
                answer = 2;
                mTvAverage.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvObtuse.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvAcute.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.btn_next:
                if (answer == 0) {
                    Toast.makeText(this, "Please select an option!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, CrowdingActivity.class);
                    intent.putExtra("nasolabialAngle", answer);
                    startActivity(intent);
                    finish();
                }
                break;
            default:
                break;
        }
    }
}


