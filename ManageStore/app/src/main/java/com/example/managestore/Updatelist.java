package com.example.managestore;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Updatelist extends Activity {
    TextView wdate;
    Cursor cursor;
    EditText subject, content;
    int id;
    int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_list);
        wdate = (TextView) findViewById(R.id.wdate);
        subject = (EditText) findViewById(R.id.subject);
        content = (EditText) findViewById(R.id.content);
        //helper=new DiaryDB(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        while (cursor.moveToNext()) {
            wdate.setText(cursor.getString(1));
            subject.setText(cursor.getString(2));
            content.setText(cursor.getString(3));
        }
    }
    public void mClick(View v) {
        switch(v.getId()){
            case R.id.bntCal:
                String date = wdate.getText().toString();
                mYear = Integer.parseInt(date.substring(0,4));
                mMonth = Integer.parseInt(date.substring(5,7));
                mDay = Integer.parseInt(date.substring(8,10));
                new DatePickerDialog(this, mDate, mYear, mMonth - 1, mDay).show();
                break;
            case R.id.btnSave:
                String strWdate =wdate.getText().toString();
                String strSubject=subject.getText().toString();
                String strContent=content.getText().toString();
                String sql = "update diary set";
                sql = sql + "wdate='" +strWdate + "',";
                sql = sql + "subject='" + strSubject + "',";
                sql = sql + "content='" + strContent + "' ";
                sql = sql + "where _id=" + id;
                Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainList.class);
                startActivity(intent);
                break;
            case R.id.btnDelete:
                AlertDialog.Builder box = new AlertDialog.Builder(this);
                box.setMessage("삭제하시겠습니까?");
                box.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        String sql="delete from diary where _id=" + id;
                        Toast.makeText(Updatelist.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Updatelist.this, MainList.class);
                        startActivity(intent);
                    }
                });
                box.setNegativeButton("아니오", null);
                box.show();
                break;
            case R.id.btnCancel:
                finish();
        }
    }
    DatePickerDialog.OnDateSetListener mDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            mYear=year;
            mMonth=month;
            mDay=day;
            wdate.setText(String.format("%04d/%02d/%02d", mYear, mMonth, mDay));
        }
    };
}
