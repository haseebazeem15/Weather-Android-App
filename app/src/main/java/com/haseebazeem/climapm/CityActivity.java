package com.haseebazeem.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class CityActivity extends AppCompatActivity {

    private EditText cityText;
    private ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        cityText = (EditText) findViewById(R.id.queryET);
        backBtn = (ImageButton) findViewById(R.id.backButton);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cityText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String city = cityText.getText().toString();

                Intent cityIntent = new Intent(CityActivity.this, WeatherController.class);
                cityIntent.putExtra("city", city);
                startActivity(cityIntent);
                return false;
            }
        });
    }
}
