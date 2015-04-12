package com.sreedurgaestates.sde;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    List<DataModel> dataList;
    Context context;

    public CardAdapter(Context context,List<DataModel> dataList) {
        this.dataList = dataList;
        this.context = context;

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder myViewHolder, int i) {
        final DataModel dataModel = dataList.get(i);
        myViewHolder.mainImage.setImageDrawable(dataModel.getMainimage());


        myViewHolder.details_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WebPageActivity.class);
                i.putExtra("key", dataModel.getDetails());
                context.startActivity(i);

            }
        });
        myViewHolder.specs_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WebPageActivity.class);
                i.putExtra("key", dataModel.getSpecs());
                context.startActivity(i);

            }
        });
        myViewHolder.floorplan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WebPageActivity.class);
                i.putExtra("key", dataModel.getFloorplan());
                context.startActivity(i);

            }
        });
        myViewHolder.routemap_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WebPageActivity.class);
                i.putExtra("key", dataModel.getRoutemap());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}