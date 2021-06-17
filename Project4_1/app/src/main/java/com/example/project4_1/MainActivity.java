package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    EditText ET1,ET2;
    Button BT1,BT2,BT3,BT4;
    String num1,num2;
    Integer result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단계산기");


        ET1 =findViewById(R.id.EditText1);
        ET2 = findViewById(R.id.EditText2);
        BT1 = findViewById(R.id.Button1);
        BT2 = findViewById(R.id.Button2);
        BT3 = findViewById(R.id.Button3);
        BT4 = findViewById(R.id.Button4);
        tv1 = findViewById(R.id.tv1);

        BT1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ET1.getText().toString();
                num2 = ET2.getText().toString();
                result = Integer.parseInt(num1 )+Integer.parseInt(num2);
                tv1.setText(" 계산 결과 : "+result.toString());
                return false;
            }
        });

        BT2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ET1.getText().toString();
                num2 = ET2.getText().toString();
                result = Integer.parseInt(num1 )-Integer.parseInt(num2);

                tv1.setText(" 계산 결과 : "+result.toString());
                return false;
            }
        });

        BT3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ET1.getText().toString();
                num2 = ET2.getText().toString();
                result = Integer.parseInt(num1 )*Integer.parseInt(num2);
                tv1.setText(" 계산 결과 : "+result.toString());
                return false;
            }
        });
        BT4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = ET1.getText().toString();
                num2 = ET2.getText().toString();
                result = Integer.parseInt(num1 )/Integer.parseInt(num2);
                tv1.setText(" 계산 결과 : "+result.toString());
                return false;
            }
        });
    }
}
