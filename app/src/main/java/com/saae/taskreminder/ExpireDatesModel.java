package com.saae.taskreminder;

/**
 * Created by Saae on 6/18/2017.
 */

public class ExpireDatesModel {

    public int date;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String data;

    @Override
    public String toString() {
        return data;
    }
}
