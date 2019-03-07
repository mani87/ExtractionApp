package com.example.extractionapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CrowdingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvLessThan5, mTvBetween5and10, mTvMoreThan10;
    private int answer = 0;
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crowding);

        init();

        // Click listeners here
        mTvLessThan5.setOnClickListener(this);
        mTvBetween5and10.setOnClickListener(this);
        mTvMoreThan10.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }


    // initialsie all variable here
    private void init() {
        mTvLessThan5 = findViewById(R.id.tv_lessThan5);
        mTvBetween5and10 = findViewById(R.id.tv_between5and10);
        mTvMoreThan10 = findViewById(R.id.tv_moreThan10);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_lessThan5:
                answer = 1;
                mTvLessThan5.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvBetween5and10.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvMoreThan10.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_between5and10:
                answer = 2;
                mTvBetween5and10.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvLessThan5.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvMoreThan10.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_moreThan10:
                answer = 3;
                mTvMoreThan10.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvBetween5and10.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvLessThan5.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.btn_next:
                if (answer != 0){
                    Intent intent = getIntent();
                    int nasolabialAngle = intent.getIntExtra("nasolabialAngle", 0);

                    Intent nextIntent = new Intent(this, ProclineTeethActivity.class);
                    nextIntent.putExtra("nasolabialAngle", nasolabialAngle);
                    nextIntent.putExtra("crowding", answer);
                    startActivity(nextIntent);
                    finish();
                    break;
                }else{
                    Toast.makeText(this, "Please select an option to continue!", Toast.LENGTH_SHORT).show();
                }
            default:
                break;
        }
    }
}
