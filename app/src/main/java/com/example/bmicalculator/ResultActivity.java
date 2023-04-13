package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
String gender;
float bmi;
TextView messageTv,bmiTv;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        bmi= getIntent().getFloatExtra("bmi",-1);
        gender=getIntent().getStringExtra("gender");
        messageTv=findViewById(R.id.message_tv);
        bmiTv=findViewById(R.id.bmi_tv);
        img=findViewById(R.id.img);
        String msg;
        if (bmi<10){
            msg = "You are underweight";
            if(gender.equals("male")){
                img.setBackgroundResource(R.drawable.boy_normal);
            }else{
                img.setBackgroundResource(R.drawable.girl_normal);
            }
        } else if (bmi >18 & bmi < 24) {
            msg = "You are fit.";
            if(gender.equals("male")){
                img.setBackgroundResource(R.drawable.boy_normal);
            }else{
                img.setBackgroundResource(R.drawable.girl_normal);
            }
        }else{
            msg = "You are Overweight.";
            if(gender.equals("male")){
                img.setBackgroundResource(R.drawable.boy_overweight);
            }else{
                img.setBackgroundResource(R.drawable.girl_overweight);
            }
        }
        messageTv.setText(msg);
        bmiTv.setText(String.format("%.2f",bmi));
    }
}