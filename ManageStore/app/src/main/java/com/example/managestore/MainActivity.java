package com.example.managestore;

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


        Button btnStore = (Button) findViewById(R.id.btnStore);
        //Button btnMenuTable = (Button) findViewById(R.id.btnMenuTable);
        Button btnResult = (Button) findViewById(R.id.btnResult);

        btnStore.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        StartLineActivity.class);
                startActivity(intent);
            }
        });


        btnResult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),
                        MainPostActivity.class);
                startActivity(intent);
            }
        });


    }
}
