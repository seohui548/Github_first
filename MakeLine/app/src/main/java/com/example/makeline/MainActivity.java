package com.example.makeline;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLine = (Button) findViewById(R.id.btnLine);
        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        //Button btnAfter = (Button) findViewById(R.id.btnAfter);
        Button btnYouway = (Button) findViewById(R.id.btnYouway);
       // Button btnComunity = (Button) findViewById(R.id.btnComunity);
        Button btnMyPage = (Button) findViewById(R.id.btnMyPage);

        btnLine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        StartLineActivity.class);
                startActivity(intent);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        MainRank.class);
                startActivity(intent);
            }
        });


//        btnAfter.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),
//                        After.class);
//                startActivity(intent);
//            }
//        });

        btnYouway.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        Map.class);
                startActivity(intent);
            }
        });

        btnMyPage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        MainEventActivity.class);
                startActivity(intent);
            }
        });
    }
}