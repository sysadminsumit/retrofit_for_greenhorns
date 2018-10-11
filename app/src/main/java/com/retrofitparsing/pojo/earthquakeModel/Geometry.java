package com.retrofitparsing.pojo.earthquakeModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Debopam Sikder on 8/6/2017.
 */

public class Geometry {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("coordinates")
    @Expose
    public List<Float> coordinates = null;
}
