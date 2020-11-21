package com.example.managestore;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;


public class ResultStore extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultstore);
        setTitle("예약 현황 보기");
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1) ;
        imageView1.setImageResource(R.drawable.menuresult1) ;
        /*
        Button btnResult = (Button) findViewById(R.id.btnResult);



        btnResult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
            }
        });
        */
    }
}
