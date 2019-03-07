package com.example.extractionapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "";

    private TextView mTvMale, mTvFemale;
    private Button mBtnNext;
    private int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        init();

        // set on click listeners here
        mTvFemale.setOnClickListener(this);
        mTvMale.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }


    // initialise all variables
    private void init() {
        mTvMale = findViewById(R.id.tv_male);
        mTvFemale = findViewById(R.id.tv_female);
        mBtnNext = findViewById(R.id.btn_next);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_male:
                answer = 1;
                mTvMale.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                mTvFemale.setTextColor(getResources().getColor(android.R.color.darker_gray));
                break;
            case R.id.tv_female:
                answer = 2;
                mTvMale.setTextColor(getResources().getColor(android.R.color.darker_gray));
                mTvFemale.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btn_next:
                if (answer == 1) {
                    showDialog(this, "IMPORTANT", "Results will be 60-70% accurate.\nDo you still want to Continue?");
                } else {
                    if (answer == 2) {
                        Intent intent = new Intent(this, BracesActivity.class);
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


    // dialog-box when anwer is 1 i.e. Male
    public void showDialog(Activity activity, String title, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        if (title != null) builder.setTitle(title);

        builder.setMessage(message);
        builder.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), BracesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
