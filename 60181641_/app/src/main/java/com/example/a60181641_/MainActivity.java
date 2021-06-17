package com.example.a60181641_;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a60181641_.menu.RunningMenu;
import com.example.a60181641_.menu.SportInfoMenu;
import com.example.a60181641_.menu.StrechMenu;
import com.example.a60181641_.menu.WeightMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStrech = (Button) findViewById(R.id.btnStrech);
        btnStrech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StrechMenu.class);
                startActivity(intent);
            }
        });

        Button btnRunning = (Button) findViewById(R.id.btnRunning);
        btnRunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RunningMenu.class);
                startActivity(intent);
            }
        });

        Button btnWeight = (Button) findViewById(R.id.btnWeightPhoto);

        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightMenu.class);
                startActivity(intent);
            }
        });

        Button btnSportInfo = (Button) findViewById(R.id.btnSportInformation);

        btnSportInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SportInfoMenu.class);
                startActivity(intent);
            }
        });
        Button btnExit = findViewById(R.id.btnExit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                finishAndRemoveTask();
                System.exit(0);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//메뉴
        switch (item.getItemId()) {
            case R.id.callCenter:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("고객센터");
                dlg.setMessage("be_the_wings@kakao.com");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "확인을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
                break;
            case R.id.exit:
                moveTaskToBack(true);
                finishAndRemoveTask();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
