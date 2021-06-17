package com.example.a60181641_.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a60181641_.MainActivity;
import com.example.a60181641_.R;

public class WeightMenu2 extends Activity {
    private ImageView imageView;
    private TextView textView;
    private Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_menu2);

//intent를 통해 보내진 데이터들이 존재하는지 확인한후 받아오는 if문과 각 보내진 데이터를 받아와 셋팅해주는 곳이다.
        if (getIntent().hasExtra("image")) {
            byte[] byteArray = getIntent().getByteArrayExtra("image");
            Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imageView = findViewById(R.id.setImage);
            imageView.setImageBitmap(image);
        }

        textView = findViewById(R.id.setText);
        if (getIntent().hasExtra("context")) {
            textView.setText(getIntent().getStringExtra("context"));
        }
        returnBtn = findViewById(R.id.BtnReturn2);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
