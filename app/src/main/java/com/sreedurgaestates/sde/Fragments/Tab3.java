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
public class Tab3 extends Fragment {
    RecyclerView recyclerView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_3,container,false);
        return v;
    }

    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        List<DataModel> tempList = new ArrayList<DataModel>();

        int[] mainimages = {R.drawable.fp1,R.drawable.fp2,R.drawable.fp3,R.drawable.fp4};
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


        recyclerView = (RecyclerView) getActivity().findViewById(R.id.tab3card_recycler);
        recyclerView.setAdapter(new CardAdapter(getActivity(),tempList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
