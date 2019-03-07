package com.example.extractionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OverjetActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtOverjet;
    private Button mBtnNext;
    private int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overjet);

        mEtOverjet = findViewById(R.id.et_overjet);
        mBtnNext = findViewById(R.id.btn_next);

        mBtnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String value = mEtOverjet.getText().toString().trim();

        if (!value.equals("")) {
            answer = Integer.parseInt(value);

            Intent oldIntent = getIntent();
            int nasolabialAngle = oldIntent.getIntExtra("nasolabialAngle", 0);
            int crowding = oldIntent.getIntExtra("crowding", 0);
            int proclination = oldIntent.getIntExtra("proclination", 0);

            Intent newIntent = new Intent(this, MidlineShiftActivity.class);
            newIntent.putExtra("nasolabialAngle", nasolabialAngle);
            newIntent.putExtra("crowding", crowding);
            newIntent.putExtra("proclination", proclination);
            newIntent.putExtra("overjet", answer);
            startActivity(newIntent);
            finish();

        } else {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
        }
    }
}
