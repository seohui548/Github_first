package com.example.managestore;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Inputlist extends AppCompatActivity {
    TextView wdate;
    int mYear, mMonth, mDay;
    EditText subject, content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_list);
        setTitle("새 줄서기");
        findViewById(R.id.btnDelete).setVisibility(View.GONE);
        subject=(EditText)findViewById(R.id.subject);
        content=(EditText)findViewById(R.id.content);
        //helper = new DiaryDB(this);
        GregorianCalendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH) + 1;
        mDay = cal.get(Calendar.DAY_OF_MONTH);
        wdate = (TextView)findViewById(R.id.wdate);
        wdate.setText(String.format("%04d/%02d/%02d", mYear, mMonth, mDay));
    }
    public void mClick(View v) {
        switch (v.getId()) {
            case R.id.bntCal:
                new DatePickerDialog(this, mDate, mYear, mMonth - 1, mDay).show();
                break;
            case R.id.btnSave:
                String strWdate = wdate.getText().toString();
                String strSubject = subject.getText().toString();
                String strContent = content.getText().toString();
                String sql = "'insert into diary(wdate, subject, content) values(";
                sql = sql + "" + strWdate + "',";
                sql = sql + "" + strSubject + "',";
                sql = sql + "" + strContent + "')";
                //db.execSQL(sql);
                Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainList.class);
                startActivity(intent);
                break;
            case R.id.btnCancel:
                finish();


        }

    }
    DatePickerDialog.OnDateSetListener mDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            mYear = year;
            mMonth = month + 1;
            mDay = day;
            wdate.setText(String.format("%04d/%02d/%02d", mYear, mMonth, mDay));
        }
    };
}
