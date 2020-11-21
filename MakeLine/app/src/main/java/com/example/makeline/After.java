package com.example.makeline;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class After extends Activity {

    TextView text1, text2;

    CheckBox chkAgree;
    Button btnOK;
    ImageView imgMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.after);
        setTitle("메뉴 후기");

        // 위젯을 변수에 대입
        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);

        btnOK = (Button) findViewById(R.id.BtnOK);




    }

}