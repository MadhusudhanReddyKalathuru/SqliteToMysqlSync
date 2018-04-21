package com.msreddy.sqlitetomysqlsync.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by meghanthan on 4/21/2018.
 */

public class Base
{
    @SerializedName("stations")
    @Expose
    private String stations;

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }
}
