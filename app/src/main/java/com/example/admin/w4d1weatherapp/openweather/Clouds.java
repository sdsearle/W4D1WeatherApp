
package com.example.admin.w4d1weatherapp.openweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    @Expose
    private Float all;

    public Float getAll() {
        return all;
    }

    public void setAll(Float all) {
        this.all = all;
    }

}
