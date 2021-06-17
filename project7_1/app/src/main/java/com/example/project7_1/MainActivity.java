package com.example.project7_1;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button button;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    ImageView imagePet;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("연습문제 7-6");
        button = findViewById(R.id.btnConfirm);
        radioGroup = findViewById(R.id.Rgroup1);
        radioButton1 = findViewById(R.id.imgDog);
        radioButton2 = findViewById(R.id.imgCat);
        radioButton3 = findViewById(R.id.imgRabbit);
        radioButton4 = findViewById(R.id.imgHorse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                imagePet = dialogView.findViewById(R.id.imagePet);
                dlg.setView(dialogView);

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.imgDog:
                        dlg.setTitle("강아지");
                        imagePet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.imgCat:
                        dlg.setTitle("고양이");
                        imagePet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.imgRabbit:
                        dlg.setTitle("토끼");
                        imagePet.setImageResource(R.drawable.rabbit);
                        break;
                    case R.id.imgHorse:
                        dlg.setTitle("말");
                        imagePet.setImageResource(R.drawable.horse);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                        break;
                }
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });


    }
}
