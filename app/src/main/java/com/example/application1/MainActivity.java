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
        ImageView start_1 = findViewById(R.id.start_1);
        Intent intent = getIntent();
        TextView text_stature = findViewById(R.id.text_stature);
        text_stature.setText(intent.getStringExtra("data_stature"));
        TextView text_weight = findViewById(R.id.text_weight);
        text_weight.setText(intent.getStringExtra("data_weight"));
        TextView text_bmi = findViewById(R.id.text_bmi);
        text_bmi.setText(intent.getStringExtra("data_bmi"));
        TextView text_fat = findViewById(R.id.text_fat);
        text_fat.setText(intent.getStringExtra("data_fat"));
        TextView text_water = findViewById(R.id.text_water);
        text_water.setText(intent.getStringExtra("data_water"));
        TextView text_muscle = findViewById(R.id.text_muscle);
        text_muscle.setText(intent.getStringExtra("data_muscle"));
        TextView text_bone = findViewById(R.id.text_bone);
        text_bone.setText(intent.getStringExtra("data_bone"));
        TextView text_metabolism = findViewById(R.id.text_metabolism);
        text_metabolism.setText(intent.getStringExtra("data_metabolism"));
        TextView text_overall = findViewById(R.id.text_overall);
        text_overall.setText(intent.getStringExtra("data_overall"));
        TextView text_grade_stature = findViewById(R.id.text_grade_stature);
        text_grade_stature.setText(intent.getStringExtra("data_grade_stature"));
        TextView text_grade_weight = findViewById(R.id.text_grade_weight);
        text_grade_weight.setText(intent.getStringExtra("data_grade_weight"));
        TextView text_grade_bmi = findViewById(R.id.text_grade_bmi);
        text_grade_bmi.setText(intent.getStringExtra("data_grade_bmi"));
        TextView text_grade_fat = findViewById(R.id.text_grade_fat);
        text_grade_fat.setText(intent.getStringExtra("data_grade_fat"));
        TextView text_grade_water = findViewById(R.id.text_grade_water);
        text_grade_water.setText(intent.getStringExtra("data_grade_water"));
        TextView text_grade_muscle = findViewById(R.id.text_grade_muscle);
        text_grade_muscle.setText(intent.getStringExtra("data_grade_muscle"));
        TextView text_grade_bone = findViewById(R.id.text_grade_bone);
        text_grade_bone.setText(intent.getStringExtra("data_grade_bone"));
        TextView text_grade_metabolism = findViewById(R.id.text_grade_metabolism);
        text_grade_metabolism.setText(intent.getStringExtra("data_grade_metabolism"));
        TextView text_grade_overall = findViewById(R.id.text_grade_overall);
        text_grade_overall.setText(intent.getStringExtra("data_grade_overall"));

        start_1.setOnClickListener(new View.OnClickListener(){
            @Override

                    public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, test.class);
                startActivity(intent);
            }
        });
    }
}
