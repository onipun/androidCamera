package com.example.shaufyq.schoollab1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadedActivity extends AppCompatActivity {


    ImageView iv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaded);

        iv = findViewById(R.id.imgVwProfile);
        Intent intent = getIntent();
        String strmsg = intent.getStringExtra("name");
        tv1 = findViewById(R.id.textView2);
        tv1.setText("welcome to new activity wahai "+ strmsg);
    }

    public void fnTakePicture(View vw){

        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText(tv1.getText().toString() + ".. This is your picture " );
                    }
                });
            }
        };
        Thread thr = new Thread(run);
        thr.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);
    }
}
