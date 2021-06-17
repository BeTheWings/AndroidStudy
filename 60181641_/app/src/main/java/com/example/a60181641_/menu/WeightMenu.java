package com.example.a60181641_.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a60181641_.R;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

public class WeightMenu extends Activity {
    private Button imgBtn, ConfirmBtn;
    private EditText goalText;
    private ImageView imageView;
    private static final int REQUEST_IMAGE_1 = 1;
    private String imagePath1 = "";
    Boolean check = true;
    private Drawable getDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_menu);
        imageView = findViewById(R.id.weightImage);
        imgBtn = findViewById(R.id.getImage);
        ConfirmBtn = findViewById(R.id.confirm);
        goalText = findViewById(R.id.goalText);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Get Album"), REQUEST_IMAGE_1);
            }
        });
        ConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WeightMenu2.class);

                //이미지뷰의 그림을 가져오기
                if (getDrawable != null) {

                    BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable;
                    Bitmap imageBit = bitmapDrawable.getBitmap();
                    //byte단위로 imag를 bit로 변경하여 전송한다.
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    //이미지의 크기를 조율한다 왜냐하면 이미지가 100mb를 넘으면 intent를 통해 전달할 수 없기 때문이다.
                    float scale = (float) (1024 / (float) imageBit.getWidth());
                    int image_w = (int) (imageBit.getWidth() * scale);
                    int image_h = (int) (imageBit.getHeight() * scale);
                    imageBit = Bitmap.createScaledBitmap(imageBit, image_w, image_h, true);
                    imageBit.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    //iamge라는 이름과 함께 byte를 전달한다. 해당기능은 이미지를 가지고온 경우에만 작동을 한다.
                    intent.putExtra("image", byteArray);

                } else {
                    Toast.makeText(getApplicationContext(), "체중계 이미지가 없습니다.", Toast.LENGTH_SHORT).show();
                }

                //text를 다음 화면으로 전송한다.
                              intent.putExtra("context", goalText.getText().toString());

                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                // 결과가 OK 였다면
                // 이미지를 요청했는대
                case REQUEST_IMAGE_1:
                    imagePath1 = setImageAndSaveImageReturnPath(imageView, data);
                    break;
            }
        }
    }

    private String setImageAndSaveImageReturnPath(ImageView v, Intent data) {
        try {
            // URI 가져오기
            Uri selectedImageUri = data.getData();
            // 선택한 이미지에서 비트맵 생성
            InputStream in = getApplicationContext().getContentResolver().openInputStream(selectedImageUri);
            Bitmap img = BitmapFactory.decodeStream(in);
            in.close();
            String path = getString(R.string.app_name);
            String fileName = "/" + System.currentTimeMillis() + ".png";
            String externalPath = getExternalPath(path);
            String address = externalPath + fileName;
            BufferedOutputStream out = null;
            File dirFile = new File(externalPath);
            if (!dirFile.isDirectory()) {
                dirFile.mkdirs();
            }
            // drawable로 변환
            getDrawable = new BitmapDrawable(img);

            // 이미지 표시
            v.setBackground(getDrawable);

            check = false;
            return address;
        } catch (Exception e) {
            e.printStackTrace();
            return "null";
        }
    }

    public String getExternalPath(String forlderName) {
//그림의 위치를 가지고온다.
        String sdPath = "";
        String ext = Environment.getExternalStorageState();
        if (ext.equals(Environment.MEDIA_MOUNTED)) {
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + forlderName;
        } else {
            sdPath = getFilesDir() + "/" + forlderName;
        }
        return sdPath;
    }
}
