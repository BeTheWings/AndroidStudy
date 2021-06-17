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

public class legFragment extends Fragment {
    private TextView textView;
    private Button exitBtn;
    private ViewGroup rootView;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_leg, container, false);
        imageView = rootView.findViewById(R.id.legImage);
       //이미지 뷰에 legstrech사진을 셋팅해준다.
        imageView.setImageResource(R.drawable.legstrech);

        //돌아가기 버튼이다.
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
