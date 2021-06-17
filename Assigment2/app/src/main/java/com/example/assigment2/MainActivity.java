package com.example.assigment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button1,button2,button3,button4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("FourButton");

        //버튼 색상 변경
        button1 = (Button) findViewById(R.id.button1);
        button1.setBackgroundColor(Color.GRAY);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //홈페이지열기
                Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                startActivity(mintent);
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setBackgroundColor(Color.GREEN);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //전화걸기
                Intent mIntent2 = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:911"));
                startActivity(mIntent2);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setBackgroundColor(Color.RED);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //갤러리 열기

                Intent miIntent3 = new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"));
                startActivity(miIntent3);
            }
        });
        button4 = findViewById(R.id.button4);
        button4.setBackgroundColor(Color.YELLOW);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //어플리케이션종료
                finish();
            }
        });
    }
}
