package com.example.application1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class test extends AppCompatActivity {


    private EditText edit_stature;                               //身高
    private EditText edit_weight;                                //体重
    private EditText edit_gender;                                //性别
    private EditText edit_age;                                   //年龄


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();
        final ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(test.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView start = findViewById(R.id.start);
        edit_stature = findViewById(R.id.edit_stature);
        edit_weight = findViewById(R.id.edit_weight);
        edit_gender = findViewById(R.id.edit_gender);
        edit_age = findViewById(R.id.edit_age);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stature = edit_stature.getText().toString().trim();
                String weight = edit_weight.getText().toString().trim();
                String gender = edit_gender.getText().toString().trim();
                String age = edit_age.getText().toString().trim();//获取输入的数据


                int gender_num;
                if (gender.equals("男")) gender_num = 1;
                else if (gender.equals("女")) gender_num = 0;
                else gender_num = 2;

                double stature_1 = Double.parseDouble(stature);
                double weight_1 = Double.parseDouble(weight);
                int age_1 = Integer.parseInt(age);
                double bmi = weight_1 / (stature_1 * stature_1 * 0.0001);

                if (stature.isEmpty()||weight.isEmpty()||age.isEmpty()||gender.isEmpty())
                {Toast.makeText(test.this,"输入不能为空",Toast.LENGTH_LONG).show();}
                if (gender_num == 2)
                { Toast.makeText(test.this, "性别输入有误", Toast.LENGTH_LONG).show(); }
                if (age_1<16)
                { Toast.makeText(test.this,"年龄范围：16-99岁",Toast.LENGTH_LONG).show(); }
                if (stature_1>250 || stature_1<120 )
                { Toast.makeText(test.this, "身高范围：120-250cm", Toast.LENGTH_LONG).show(); }
                if (weight_1>150 || weight_1<35)
                { Toast.makeText(test.this, "体重范围：35-150kg", Toast.LENGTH_LONG).show(); }

                if ((gender_num!=2 && age_1>=16 && stature_1>=120&&stature_1<=250 && weight_1>=35&&weight_1<=150)
                    &&(!(("".equals(stature))||("".equals(weight))||("".equals(age))||("".equals(gender)))))
                { Intent intent = new Intent(test.this, result.class);

                    if (gender_num == 1) {
                        if (stature_1 >= 160)
                            intent.putExtra("data_grade_stature", "标准");
                        else
                            intent.putExtra("data_grade_stature", "偏低");
                    } else if (gender_num == 0) {
                        if (stature_1 >= 150)
                            intent.putExtra("data_grade_stature", "标准");
                        else
                            intent.putExtra("data_grade_stature", "偏低");
                    }


                    double standard_weight;
                    if (gender_num == 1) standard_weight = (stature_1 - 80) * 0.7;
                    else standard_weight = (stature_1 - 70) * 0.6;
                    double weight_up_1 = 1.1 * standard_weight;
                    double weight_up_2 = 1.2 * standard_weight;
                    double weight_down_1 = 0.9 * standard_weight;
                    double weight_down_2 = 0.8 * standard_weight;
                    if (weight_1 <= weight_up_1 && weight_1 >= weight_down_1)
                        intent.putExtra("data_grade_weight", "正常");
                    else if (weight_1 <= weight_up_2 && weight_1 > weight_up_1)
                        intent.putExtra("data_grade_weight", "偏重");
                    else if (weight_1 >= weight_down_2 && weight_1 < weight_down_1)
                        intent.putExtra("data_grade_weight", "偏轻");
                    else if (weight_1 > weight_up_2)
                        intent.putExtra("data_grade_weight", "肥胖");
                    else intent.putExtra("data_grade_weight", "营养不良");

                    int score_bmi = 0;
                    if (bmi >= 10 && bmi <= 18.5) {
                        score_bmi = 75;
                        intent.putExtra("data_grade_bmi", "过轻");
                    } else if (bmi > 18.5 && bmi <= 24) {
                        score_bmi = 100;
                        intent.putExtra("data_grade_bmi", "正常");
                    } else if (bmi > 24 && bmi <= 28) {
                        score_bmi = 80;
                        intent.putExtra("data_grade_bmi", "超重");
                    } else if (bmi > 28 && bmi <= 35) {
                        score_bmi = 60;
                        intent.putExtra("data_grade_bmi", "肥胖");
                    }
                    intent.putExtra("data_score_bmi", score_bmi);

                    double fat = 1.2 * bmi + 0.23 * age_1 - 5.4 - 10.8 * gender_num;
                    int score_fat = 0;
                    if (gender_num == 1) {
                        if (fat > 8 && fat <= 15) {
                            score_fat = 70;
                            intent.putExtra("data_grade_fat", "过瘦");
                            intent.putExtra("data_advice_fat", "体脂率过低，建议多吃营养丰富的食物，适度运动");
                        } else if (fat > 15 && fat <= 25) {
                            score_fat = 100;
                            intent.putExtra("data_grade_fat", "正常");
                            intent.putExtra("data_advice_fat", "体脂率正常，继续保持");
                        } else if (fat > 25 && fat <= 35) {
                            score_fat = 70;
                            intent.putExtra("data_grade_fat", "超重");
                            intent.putExtra("data_advice_fat", "体脂率过高，建议减少热量摄入，加大运动量");
                        }
                    } else {
                        if (fat > 10 && fat <= 20) {
                            score_fat = 70;
                            intent.putExtra("data_grade_fat", "过瘦");
                            intent.putExtra("data_advice_fat", "体脂率过低，建议多吃营养丰富的食物，适度运动");
                        } else if (fat > 20 && fat <= 30) {
                            score_fat = 100;
                            intent.putExtra("data_grade_fat", "正常");
                            intent.putExtra("data_advice_fat", "体脂率正常，继续保持");
                        } else if (fat > 30 && fat <= 45) {
                            score_fat = 70;
                            intent.putExtra("data_grade_fat", "超重");
                            intent.putExtra("data_advice_fat", "体脂率过高，建议减少热量摄入，加大运动量");
                        }
                    }
                    intent.putExtra("data_score_fat", score_fat);

                    double muscle;
                    int score_muscle = 0;
                    if (gender_num == 1) {
                        muscle = 78 / (weight_1 * 2);
                        if (muscle <= 0.6) {
                            score_muscle = 60;
                            intent.putExtra("data_grade_muscle", "偏低");
                            intent.putExtra("data_advice_muscle", "肌肉率过低，建议加大运动强度");
                        }
                        if (muscle > 0.6 && muscle <= 0.65) {
                            score_muscle = 80;
                            intent.putExtra("data_grade_muscle", "正常");
                            intent.putExtra("data_advice_muscle", "肌肉率正常，可以加强锻炼以达到优秀水平");

                        }
                        if (muscle > 0.65 && muscle <= 0.7) {
                            score_muscle = 100;
                            intent.putExtra("data_grade_muscle", "优秀");
                            intent.putExtra("data_advice_muscle", "肌肉率优秀，继续保持");
                        }
                    } else {
                        muscle = 56 / (weight_1 * 2);
                        if (muscle <= 0.55) {
                            score_muscle = 60;
                            intent.putExtra("data_grade_muscle", "偏低");
                            intent.putExtra("data_advice_muscle", "肌肉率过低，建议加大运动强度");
                        }
                        if (muscle > 0.55 && muscle <= 0.6) {
                            score_muscle = 80;
                            intent.putExtra("data_grade_muscle", "正常");
                            intent.putExtra("data_advice_muscle", "肌肉率正常，可以加强锻炼以达到优秀水平");
                        }
                        if (muscle > 0.6 && muscle <= 0.65) {
                            score_muscle = 100;
                            intent.putExtra("data_grade_muscle", "优秀");
                            intent.putExtra("data_advice_muscle", "肌肉率优秀，继续保持");
                        }
                    }
                    intent.putExtra("data_score_muscle", score_muscle);
                    muscle = muscle * 100;

                    double water;
                    int score_water;
                    if (gender_num == 1) water = 1.2 * muscle;
                    else water = 1.3 * muscle;
                    if (water < 70) {
                        score_water = 70;
                        intent.putExtra("data_grade_water", "偏低");
                        intent.putExtra("data_advice_water", "水分率偏低，建议多喝水，多吃蔬菜水果");
                    } else if (water >= 70 && water <= 80) {
                        score_water = 100;
                        intent.putExtra("data_grade_water", "正常");
                        intent.putExtra("data_advice_water", "水分率正常，继续保持");
                    } else {
                        score_water = 70;
                        intent.putExtra("data_grade_water", "偏高");
                        intent.putExtra("data_advice_water", "水分率偏高，建议调节饮食，加快水分消耗");
                    }
                    intent.putExtra("data_score_water", score_water);


                    double bone = (weight_1 - age_1) * 0.2;
                    int score_bone = 0;
                    if (bone < -4) {
                        score_bone = 50;
                        intent.putExtra("data_grade_bone", "风险高");
                        intent.putExtra("data_advice_bone", "骨质风险高，建议多吃含钙量高的食物");
                    }
                    if (bone >= -4 && bone <= -1) {
                        score_bone = 70;
                        intent.putExtra("data_grade_bone", "中度风险");
                        intent.putExtra("data_advice_bone", "骨质存在中度风险，建议多吃含钙量高的食物");
                    }
                    if (bone > -1) {
                        score_bone = 100;
                        intent.putExtra("data_grade_bone", "风险低");
                        intent.putExtra("data_advice_bone", "骨质风险低，继续保持");
                    }
                    intent.putExtra("data_score_bone", score_bone);

                    double metabolism;
                    int score_metabolism;
                    if (gender_num == 1) {
                        metabolism = (13.7 * weight_1) + (5.0 * stature_1) - (6.8 * age_1) + 66;
                        if (metabolism < 1300) {
                            score_metabolism = 70;
                            intent.putExtra("data_grade_metabolism", "偏低");
                            intent.putExtra("data_advice_metabolism", "代谢偏低，建议多吃含高纤维的食物");
                        } else if (metabolism > 1300 && metabolism <= 1900) {
                            score_metabolism = 100;
                            intent.putExtra("data_grade_metabolism", "正常");
                            intent.putExtra("data_advice_metabolism", "代谢正常，继续保持");
                        } else {
                            score_metabolism = 70;
                            intent.putExtra("data_grade_metabolism", "偏高");
                            intent.putExtra("data_advice_metabolism", "代谢偏高，建议适当加大进食量，适度运动");
                        }
                    } else {
                        metabolism = 9.6 * weight_1 + 1.8 * stature_1 - 4.7 * age_1 + 655;
                        if (metabolism < 1100) {
                            score_metabolism = 70;
                            intent.putExtra("data_grade_metabolism", "偏低");
                            intent.putExtra("data_advice_metabolism", "代谢偏低，建议多吃含高纤维的食物");
                        } else if (metabolism >= 1100 && metabolism <= 1500) {
                            score_metabolism = 100;
                            intent.putExtra("data_grade_metabolism", "正常");
                            intent.putExtra("data_advice_metabolism", "代谢正常，继续保持");
                        } else {
                            score_metabolism = 70;
                            intent.putExtra("data_grade_metabolism", "偏高");
                            intent.putExtra("data_advice_metabolism", "代谢偏高，建议适当加大进食量，适度运动");
                        }
                    }
                    intent.putExtra("data_score_metabolism", score_metabolism);

                    //if (score_fat == 100 && score_water == 100 && score_muscle >= 80 && score_bone == 100 && score_metabolism == 100)
                        //intent.putExtra("data_advice", "健康状况良好，继续保持");

                    double score_overall = score_bmi * 0.5 + score_fat * 0.1 + score_water * 0.1 + score_muscle * 0.1 + score_bone * 0.1 + score_metabolism * 0.1;
                    if (score_overall>=85) intent.putExtra("data_grade_overall","优秀");
                    else if (score_overall<85&&score_overall>=70) intent.putExtra("data_grade_overall","良好");
                    else if (score_overall<70) intent.putExtra("data_grade_overall","较差");


                    intent.putExtra("data_stature", stature);//""是编号 后面是实际传递的数据 根据编号获取数据
                    intent.putExtra("data_weight", weight);
                    intent.putExtra("data_gender", gender);
                    intent.putExtra("data_age", age);
                    intent.putExtra("data_bmi", String.format("%.1f", bmi));//保留一位小数
                    intent.putExtra("data_fat", String.format("%.1f%%", fat));
                    intent.putExtra("data_water", String.format("%.1f%%", water));
                    intent.putExtra("data_muscle", String.format("%.1f%%", muscle));
                    intent.putExtra("data_bone", String.format("%.1f", bone));
                    intent.putExtra("data_metabolism", String.format("%.1f", metabolism));
                    intent.putExtra("data_overall", String.format("%.0f", score_overall));

                    startActivity(intent);

                }
            }
        });
    }
}