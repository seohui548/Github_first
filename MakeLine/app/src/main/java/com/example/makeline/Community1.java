package com.example.makeline;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Community1 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.community);
        setTitle("sns 보기");

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2) ;
        imageView2.setImageResource(R.drawable.bay) ;

    }

    }

