package com.sreedurgaestates.sde;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class CardViewHolder extends RecyclerView.ViewHolder {

    public ImageView mainImage;
    public ImageButton details_button;
    public ImageButton specs_button;
    public ImageButton floorplan_button;
    public ImageButton routemap_button;

    public CardViewHolder(View card) {
        super(card);

        mainImage = (ImageView)card.findViewById(R.id.main_image);
        details_button = (ImageButton) card.findViewById(R.id.details_button);
        specs_button = (ImageButton) card.findViewById(R.id.specs_button);
        floorplan_button = (ImageButton) card.findViewById(R.id.floorplan_button);
        routemap_button = (ImageButton) card.findViewById(R.id.routemap_button);




    }


}