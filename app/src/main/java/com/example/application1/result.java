package com.example.application1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class result extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();
        Intent intent = getIntent();
        TextView text_score = findViewById(R.id.text_score);
        text_score.setText(intent.getStringExtra("data_overall"));
        TextView text_advice_fat = findViewById(R.id.text_advice_fat);
        text_advice_fat.setText(intent.getStringExtra("data_advice_fat"));
        TextView text_advice_water = findViewById(R.id.text_advice_water);
        text_advice_water.setText(intent.getStringExtra("data_advice_water"));
        TextView text_advice_muscle = findViewById(R.id.text_advice_muscle);
        text_advice_muscle.setText(intent.getStringExtra("data_advice_muscle"));
        TextView text_advice_bone = findViewById(R.id.text_advice_bone);
        text_advice_bone.setText(intent.getStringExtra("data_advice_bone"));
        TextView text_advice_metabolism = findViewById(R.id.text_advice_metabolism);
        text_advice_metabolism.setText(intent.getStringExtra("data_advice_metabolism"));
        //TextView text_advice = findViewById(R.id.text_advice);
        //text_advice.setText(intent.getStringExtra("data_advice"));
        ImageView homepage = (ImageView) findViewById(R.id.homepage);
        homepage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(result.this, MainActivity.class);
                Intent intent_data = getIntent();
                String stature = intent_data.getStringExtra("data_stature");
                String weight = intent_data.getStringExtra("data_weight");
                String bmi = intent_data.getStringExtra("data_bmi");
                String fat = intent_data.getStringExtra("data_fat");
                String water = intent_data.getStringExtra("data_water");
                String muscle = intent_data.getStringExtra("data_muscle");
                String bone = intent_data.getStringExtra("data_bone");
                String metabolism = intent_data.getStringExtra("data_metabolism");
                String score_overall = intent_data.getStringExtra("data_overall");
                String grade_stature = intent_data.getStringExtra("data_grade_stature");
                String grade_weight = intent_data.getStringExtra("data_grade_weight");
                String grade_bmi = intent_data.getStringExtra("data_grade_bmi");
                String grade_fat = intent_data.getStringExtra("data_grade_fat");
                String grade_water = intent_data.getStringExtra("data_grade_water");
                String grade_muscle = intent_data.getStringExtra("data_grade_muscle");
                String grade_bone = intent_data.getStringExtra("data_grade_bone");
                String grade_metabolism = intent_data.getStringExtra("data_grade_metabolism");
                String grade_overall = intent_data.getStringExtra("data_grade_overall");
                intent.putExtra("data_stature",stature);
                intent.putExtra("data_weight", weight);
                intent.putExtra("data_bmi",bmi);
                intent.putExtra("data_fat",fat);
                intent.putExtra("data_water",water);
                intent.putExtra("data_muscle",muscle);
                intent.putExtra("data_bone",bone);
                intent.putExtra("data_metabolism",metabolism);
                intent.putExtra("data_grade_stature",grade_stature);
                intent.putExtra("data_grade_weight",grade_weight);
                intent.putExtra("data_grade_bmi",grade_bmi);
                intent.putExtra("data_grade_fat",grade_fat);
                intent.putExtra("data_grade_water",grade_water);
                intent.putExtra("data_grade_muscle",grade_muscle);
                intent.putExtra("data_grade_bone",grade_bone);
                intent.putExtra("data_grade_metabolism",grade_metabolism);
                intent.putExtra("data_overall",score_overall);
                intent.putExtra("data_grade_overall",grade_overall);
                startActivity(intent);
            }
        });

        ImageView restart = findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(result.this, test.class);
                startActivity(intent);
            }
        });
    }
}
