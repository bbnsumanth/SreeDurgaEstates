package com.sreedurgaestates.sde.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sreedurgaestates.sde.Adapters.CardAdapter;
import com.sreedurgaestates.sde.Data.DataModel;
import com.sreedurgaestates.sde.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bharat.sumanth on 4/11/2015.
 */
public class Tab2 extends Fragment {
    RecyclerView recyclerView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2,container,false);
        return v;
    }

    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        List<DataModel> tempList = new ArrayList<DataModel>();
       // String[] details = getResources().getStringArray(R.array.details);
        //String[] specs = getResources().getStringArray(R.array.specs);
       // String[] floorplan = getResources().getStringArray(R.array.floorplan);
        //String[] routemap = getResources().getStringArray(R.array.routemap);
        int[] mainimages = {R.drawable.cp1,R.drawable.cp2,R.drawable.cp3,R.drawable.cp4,R.drawable.cp5,R.drawable.cp6,R.drawable.cp7,R.drawable.cp8,R.drawable.cp9,R.drawable.cp10,R.drawable.cp11,R.drawable.cp12};

        int i= 0;
        while(i < mainimages.length){
            DataModel model = new DataModel();
            model.setDetails("No Details Available");
            model.setFloorplan("No Details Available");
            model.setSpecs("No Details Available");
            model.setRoutemap("No Details Available");
            model.setMainimage(getResources().getDrawable(mainimages[i]));
            tempList.add(model);
            i=i+1;
        }


        recyclerView = (RecyclerView) getActivity().findViewById(R.id.tab2card_recycler);
        recyclerView.setAdapter(new CardAdapter(getActivity(),tempList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
