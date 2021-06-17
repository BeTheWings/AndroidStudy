package com.example.a60181641_.menu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a60181641_.R;

public class SportInfoMenu extends Activity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_info_menu);
        btn1 = findViewById(R.id.Btn1);
        btn1.setText("뱃살");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //각 버튼을 누르면 등록된 Uri유튜브영상으로 이동하게 된다.
                Intent mIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0L5gAT1fJaM"));
                startActivity(mIntent1);
            }
        });
        btn2 = findViewById(R.id.Btn2);
        btn2.setText("허리");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=f-mgnsrDWHg"));
                startActivity(mIntent1);
            }
        });
        btn3 = findViewById(R.id.Btn3);
        btn3.setText("상체");
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=54tTYO-vU2E"));
                startActivity(mIntent1);
            }
        });
        btn4 = findViewById(R.id.Btn4);
        btn4.setText("하체");
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=pDFuLG0xrsU"));
                startActivity(mIntent1);
            }
        });
        btnReturn = findViewById(R.id.BtnReturn);
        btnReturn.setText("돌아가기");
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
