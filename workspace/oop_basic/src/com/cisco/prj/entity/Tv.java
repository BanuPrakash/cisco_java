package com.cisco.prj.entity;

public class Tv extends  Product{
    private String screenType;

    public Tv() {
    }

    public Tv(int id, String name, double price, String screenType) {
        super(id, name, price); // chain to Product constructor
        this.screenType = screenType;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }


    @Override
    public boolean isExpensive() {
        // proper logic
        return false;
    }

}
