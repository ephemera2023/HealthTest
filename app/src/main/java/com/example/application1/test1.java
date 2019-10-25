package com.example.application1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class test1 extends AppCompatActivity {

    private EditText edit_stature;                               //输入身高的文本框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();
        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(test1.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView start = (ImageView) findViewById(R.id.start);
        edit_stature = (EditText) findViewById(R.id.edit_stature);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String stature=edit_stature.getText().toString().trim();
                Intent intent = new Intent(test1.this, result.class);
                intent.putExtra("data",stature);//""是编号 后面是实际传递的数据 根据编号获取数据
                startActivity(intent);
            }
        });

    }
}
