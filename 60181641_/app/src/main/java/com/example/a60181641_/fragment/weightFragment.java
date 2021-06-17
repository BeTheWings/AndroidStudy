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

public class weightFragment extends Fragment {
    private TextView textView;
    private Button exitBtn;
    private ViewGroup rootView;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_weight, container, false);
        imageView = rootView.findViewById(R.id.weightImage);
        imageView.setImageResource(R.drawable.swanstrech);
        textView = rootView.findViewById(R.id.weightText);
        textView.setText("1. 바닥에 엎드려 손바닥을 바닥에 붙이고, 손으로 바닥을 밀면서 허리를 뒤로 젖혀준다.\n" +
                "2.이때 손과 어깨를 일직선으로 놓으면서 팔꿈치를 쫙 펴주고, 심호흡을 하면서 60초 유지한다.");
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
