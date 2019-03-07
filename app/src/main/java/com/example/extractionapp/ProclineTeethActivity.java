package com.example.extractionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProclineTeethActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvProclineYes, mTvProclineNo;
    private int answer = 33;
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procline_teeth);

        init();

        // set on click listeners here
        mTvProclineNo.setOnClickListener(this);
        mTvProclineYes.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }

    private void init() {
        mTvProclineYes = findViewById(R.id.tv_ProclineYes);
        mTvProclineNo = findViewById(R.id.tv_ProclineNo);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_ProclineNo:
                answer = 0;
                mTvProclineNo.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvProclineYes.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_ProclineYes:
                answer = 1;
                mTvProclineYes.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvProclineNo.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.btn_next:
                if (answer == 33) {
                    Toast.makeText(this, "Please select an option!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent oldIntent = getIntent();
                    int nasolabialAngle = oldIntent.getIntExtra("nasolabialAngle", 0);
                    int crowding = oldIntent.getIntExtra("crowding", 0);

                    Intent newIntent = new Intent(this, OverjetActivity.class);
                    newIntent.putExtra("nasolabialAngle", nasolabialAngle);
                    newIntent.putExtra("crowding", crowding);
                    newIntent.putExtra("proclination", answer);
                    startActivity(newIntent);
                    finish();
                }
                break;
            default:
                break;
        }
    }
}
