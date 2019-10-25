package com.example.application1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();
        ImageView homepage = (ImageView) findViewById(R.id.homepage);
        homepage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(result.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView restart = (ImageView) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(result.this, test1.class);
                startActivity(intent);
            }
        });
    }
}
