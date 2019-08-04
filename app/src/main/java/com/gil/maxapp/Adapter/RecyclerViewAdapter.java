package com.gil.maxapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gil.maxapp.Model.DataListObject;
import com.gil.maxapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private ArrayList<DataListObject> myList;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<DataListObject> myList, Context context) {
        this.myList = myList;
        mContext = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_view, viewGroup, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {

        DataListObject currentObject = myList.get(position);

        String text = currentObject.getTitle();
        if (text != null) {
            myHolder.textview_item.setText(text);
        }
        String textStitle = currentObject.getSTitle();
        if (textStitle != null) {
            myHolder.textview_sTitlle.setText(textStitle);
        }

        String imageUrl = currentObject.getImag();
        if (imageUrl != null) {
            Picasso.with(mContext).load(imageUrl).into(myHolder.imageView_item);
        }

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        ImageView imageView_item;
        TextView textview_item;
        TextView textview_sTitlle;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView_item = itemView.findViewById(R.id.imageView_item);
            textview_item = itemView.findViewById(R.id.textview_item);
            textview_sTitlle = itemView.findViewById(R.id.textview_sTitlle);

        }
    }
}
