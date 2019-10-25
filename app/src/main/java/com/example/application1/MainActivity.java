package com.example.application1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();
        ImageView start_1 = (ImageView) findViewById(R.id.start_1);
        Intent intent = getIntent();
        TextView text_stature = findViewById(R.id.text_stature);
        text_stature.setText(intent.getStringExtra("data"));
        start_1.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, test1.class);
                startActivity(intent);
            }
        });
    }
}
