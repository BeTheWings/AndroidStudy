package com.example.a60181641_.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a60181641_.MainActivity;
import com.example.a60181641_.R;

public class neckFragment extends Fragment {
    private TextView textView;
    private Button exitBtn;
    private ViewGroup rootView;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_neck, container, false);
        imageView = rootView.findViewById(R.id.neckImage);
        imageView.setImageResource(R.drawable.neckstrechimage);
        textView = rootView.findViewById(R.id.neckText);
        textView.setText(
                "1. 허리를 펴고 고개와 어깨선을 수평으로 유지한다\n" +
                "2. 머리에 손을 얹은 후 옆으로 천천히 당겨준다(10초 유지)\n" +
                "3. 5번 반복해준 뒤 반대쪽도 마찬가지로 따라해준다");

        exitBtn = rootView.findViewById(R.id.btnExit);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rootView.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
