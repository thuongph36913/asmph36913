package com.thuonght.asignmentapiph36913.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.thuonght.asignmentapiph36913.Fayvorite;
import com.thuonght.asignmentapiph36913.Login;
import com.thuonght.asignmentapiph36913.MainActivity;
import com.thuonght.asignmentapiph36913.R;
import com.thuonght.asignmentapiph36913.model.sanpham;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class sanphamadapter extends RecyclerView.Adapter<sanphamadapter.View> {

    private final Context context;
    private final ArrayList<sanpham> list;

    public sanphamadapter(Context context, ArrayList<sanpham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        android.view.View view = inflater.inflate(R.layout.recyview, parent, false);
        return new View(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View holder, int position) {
        sanpham sp = list.get(position);
        holder.txtTen.setText(list.get(position).getTen());
        Glide.with(context)
                .load(sp.getImg())
                .placeholder(R.drawable.orange)
                .into(holder.imgSp);
        holder.btnAdd.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(context, Fayvorite.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class View extends RecyclerView.ViewHolder {
        ImageView imgSp;
        TextView txtTen;

        Button btnAdd;
        public View(@NonNull android.view.View itemView) {
            super(itemView);
            imgSp = itemView.findViewById(R.id.imgSp);
            txtTen = itemView.findViewById(R.id.txtTen);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}
