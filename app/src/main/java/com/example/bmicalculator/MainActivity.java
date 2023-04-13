package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText heightEt,weightEt;
    RadioGroup genderRg;
    Button btn;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightEt= findViewById(R.id.height_et);
        weightEt= findViewById(R.id.weight_et);
        btn= findViewById(R.id.bmi_btn);
        genderRg=findViewById(R.id.gender_rg);
        genderRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male_rb) {
                    gender = "male";
                }else{
                    gender = "female";
                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String HeightVal= heightEt.getText().toString().trim();
               String WeightVal= weightEt.getText().toString().trim();
                float height= Float.parseFloat(HeightVal);
                float weight= Float.parseFloat(WeightVal);
                float bmi= calBMI(height,weight);

                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("bmi",bmi);
                intent.putExtra("gender",gender);
                startActivity(intent);
            }
        });


    }
    public float calBMI(float h,float w){
       float bmi= 0;
       float h_m = h/100;
       bmi= w/(h_m*h_m);
       return bmi;

    }
}