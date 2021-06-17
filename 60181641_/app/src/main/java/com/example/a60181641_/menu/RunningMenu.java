package com.example.a60181641_.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a60181641_.R;

import java.sql.Time;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class RunningMenu extends Activity {
    Button btn1;
    Button btn2;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioGroup radioGroup;
    View running_dialog, plank_dialog;
    TextView main_Text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running_menu);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.btnRunning);
        radioButton2 = findViewById(R.id.btnPlank);

        btn1 = findViewById(R.id.StartBtn);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.btnPlank:
                        AlertDialog dlg = new AlertDialog.Builder(RunningMenu.this).setTitle("플랭크").setNegativeButton(android.R.string.no, null).create();
                        main_Text = findViewById(R.id.mainText);
                        dlg.setOnShowListener(new DialogInterface.OnShowListener() {
                            //MaxCount
                            private static final int time = 180000;

                            @Override
                            public void onShow(final DialogInterface dialog) {

                                final Button defaultButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
                                final CharSequence negativeButtonText = defaultButton.getText();
                                //몇초마다 시간을 흐르게 할것인가?
                                new CountDownTimer(time, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        defaultButton.setText(String.format(Locale.getDefault(), "%s (%d)", negativeButtonText, TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) + 1));
                                    }

                                    @Override
                                    public void onFinish() {
                                        if (((AlertDialog) dialog).isShowing()) {
                                            dialog.dismiss();
                                            main_Text.setText("플랭크 종료");
                                        }
                                    }
                                }.start();
                            }
                        });
                        plank_dialog = View.inflate(RunningMenu.this, R.layout.plank_dialog, null);
                        dlg.setView(plank_dialog);
                        dlg.show();
                        break;
                    case R.id.btnRunning:
                        AlertDialog DialogForRunning = new AlertDialog.Builder(RunningMenu.this).setTitle("달리기").setNegativeButton(android.R.string.no, null).create();
                        main_Text = findViewById(R.id.mainText);
                        DialogForRunning.setOnShowListener(new DialogInterface.OnShowListener() {
                            private static final int time = 1200000;

                            @Override
                            public void onShow(final DialogInterface dialog) {

                                final Button defaultButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
                                final CharSequence negativeButtonText = defaultButton.getText();
                                new CountDownTimer(time, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        defaultButton.setText(String.format(Locale.getDefault(), "%s (%d)", negativeButtonText, TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) + 1));
                                    }

                                    @Override
                                    public void onFinish() {
                                        if (((AlertDialog) dialog).isShowing()) {
                                            dialog.dismiss();
                                            main_Text.setText("완료");
                                        }
                                    }
                                }.start();
                            }
                        });
                        running_dialog = View.inflate(RunningMenu.this, R.layout.running_dialog, null);
                        DialogForRunning.setView(running_dialog);
                        DialogForRunning.show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "운동 선택 후 버튼을 눌러주세요", Toast.LENGTH_SHORT).show();
                        break;
                }

            }


        });

        btn2 =

                findViewById(R.id.ExitBtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
