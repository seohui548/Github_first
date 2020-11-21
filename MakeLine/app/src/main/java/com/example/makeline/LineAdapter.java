package com.example.makeline;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.MyViewHolder>{

    Context context;
    ArrayList<MyLine> myLine;


    public LineAdapter(Context c, ArrayList<MyLine> p) {
        context = c;;
        myLine = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoes.setText(myLine.get(i).getTitledoes());
        myViewHolder.descdoes.setText(myLine.get(i).getDescdoes());
        myViewHolder.datedoes.setText(myLine.get(i).getDatedoes());

        final String getTitleDoes = myLine.get(i).getTitledoes();
        final String getDescDoes = myLine.get(i).getDescdoes();
        final String getDateDoes = myLine.get(i).getDatedoes();
        final String getKeyDoes = myLine.get(i).getKeydoes();

        myViewHolder.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context, MainPostActivity.class);
                aa.putExtra("titledoes", getTitleDoes);
                aa.putExtra("descdoes", getDescDoes);
                aa.putExtra("datedoes", getDateDoes);
                aa.putExtra("keydoes", getKeyDoes);
                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myLine.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titledoes, descdoes, datedoes, keydoes;

        Button btnEnter;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
            btnEnter = (Button) itemView.findViewById(R.id.btnEnter);
        }


    }

}