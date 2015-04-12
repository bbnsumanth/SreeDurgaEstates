package com.sreedurgaestates.sde;

import android.graphics.drawable.Drawable;

public class DataModel {
    private long id;
    private Drawable mainimage;
    private String details;
    private String specs;
    private String floorplan;
    private String routemap;

    public Drawable getMainimage() {
        return mainimage;
    }

    public String getDetails() {
        return details;
    }

    public String getSpecs() {
        return specs;
    }

    public String getFloorplan() {
        return floorplan;
    }

    public String getRoutemap() {
        return routemap;
    }

    public long getId() {
        return id;
    }


    public void setMainimage(Drawable mainimage) {
        this.mainimage = mainimage;
    }


    public void setDetails(String details) {
        this.details = details;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public void setFloorplan(String floorplan) {
        this.floorplan = floorplan;
    }

    public void setRoutemap(String routemap) {
        this.routemap = routemap;
    }

    public void setId(Long id) {
        this.id = id;
    }
}