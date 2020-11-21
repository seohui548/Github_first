package com.example.managestore;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainList extends AppCompatActivity {
    //DiaryDB helper;
    Cursor cursor;
    MyAdapter adapter;
    LayoutInflater inflater;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        setTitle("예약 가능 리스트");
        inflater =(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        //helper=new DiaryDB(this);
        //db = helper.getWritableDatabase();
        //cursor=db.rawQuery("select * from diary", null);
        //adapter=new MyAdapter(this, cursor);
        list=(ListView)findViewById(R.id.list);
        //list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainList.this, Updatelist.class);
                intent.putExtra("id", cursor.getInt(0));
                        startActivity(intent);

            }
        });
        registerForContextMenu(list);

    }

    public void mClick(View v){
        Intent intent = new Intent(this, Inputlist.class);
        startActivity(intent);
    }
    class MyAdapter extends CursorAdapter {
        public MyAdapter(Context context, Cursor c){
            super(context, c);
        }
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView wdate =(TextView)view.findViewById(R.id.wdate);
            wdate.setText(cursor.getString(1));
            TextView subject=(TextView)view.findViewById(R.id.subject);
            subject.setText(cursor.getString(2));
        }
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return inflater.inflate(R.layout.item, parent,false);
        }
//        @Override
//        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//            menu.setHeaderTitle("정렬방식");
//            menu.add(0,1,0, "최신글");
//            menu.add(0,2,0, "과거글");
//            super.onCreateContextMenu(menu, v, menuInfo);
//        }

    }
}
