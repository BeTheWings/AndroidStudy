package com.example.a60181641_.menu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.a60181641_.R;
import com.example.a60181641_.fragment.legFragment;
import com.example.a60181641_.fragment.neckFragment;
import com.example.a60181641_.fragment.shoulderFragment;
import com.example.a60181641_.fragment.weightFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class StrechMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strechmenu);

        //tab메뉴의 아이디를 가지고온다.
        ViewPager pager = findViewById(R.id.viewpager);
        pageAdapter pageAdapter = new pageAdapter(getSupportFragmentManager());
        //pageAdapter를 ViewPager에 설정해준다.
        pager.setAdapter(pageAdapter);
        //tab을 가지고온다.
        TabLayout tab = findViewById(R.id.strechTab);
        //tab을 눌렀을때 페이지도 같이 옮겨질수 있게 설정한다.
        tab.setupWithViewPager(pager);


    }

    class pageAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> items = new ArrayList<Fragment>();
        private ArrayList<String> itext = new ArrayList<String>();

        public pageAdapter(FragmentManager fm) {
            super(fm);
            //생성된 fragment를 넣어준다.
            items.add(new neckFragment());
            items.add(new weightFragment());
            items.add(new legFragment());
            items.add(new shoulderFragment());
            //각 fragment의 text를 넣어준다.
            itext.add("목");
            itext.add("허리");
            itext.add("다리");
            itext.add("어깨");

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return itext.get(position);
        }


        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

    }

}
