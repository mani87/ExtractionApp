package com.example.extractionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "";

    private TextView mTvLessThan15, mTvLessThan18, mTvMoreThan18;
    private Button mBtnNext;
    int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        // apply click listeners here
        mTvLessThan15.setOnClickListener(this);
        mTvLessThan18.setOnClickListener(this);
        mTvMoreThan18.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }


    // initialize variables
    private void init() {
        mTvLessThan15 = findViewById(R.id.tv_lessThan15);
        mTvLessThan18 = findViewById(R.id.tv_lessThan18);
        mTvMoreThan18 = findViewById(R.id.tv_moreThan18);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_lessThan15:
                answer = 1;
                mTvLessThan15.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvLessThan18.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvMoreThan18.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_lessThan18:
                answer = 2;
                mTvLessThan15.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvLessThan18.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvMoreThan18.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_moreThan18:
                answer = 3;
                mTvLessThan15.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvLessThan18.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvMoreThan18.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btn_next:
                if (answer == 1) {
                    Toast.makeText(this, "Please Consult a Dentist!", Toast.LENGTH_SHORT).show();
                } else {
                    if (answer == 2 || answer == 3) {
                        Intent intent = new Intent(this, GenderActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Please select an option to continue!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                break;
        }
    }
}
