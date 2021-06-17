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

public class shoulderFragment extends Fragment {
    private TextView textView;
    private Button exitBtn;
    private ViewGroup rootView;
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_shoulder, container, false);
        imageView = rootView.findViewById(R.id.shoulderImg);
        imageView.setImageResource(R.drawable.shoulderstrech);
        textView = rootView.findViewById(R.id.shoulderText);
        textView.setText("1.어깨 돌리기(안쪽/바깥쪽 5회씩)\n " +
                "2.어깨와 팔 펴기(10초 유지)\n");
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
