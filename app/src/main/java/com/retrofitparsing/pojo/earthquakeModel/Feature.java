package com.retrofitparsing.pojo.earthquakeModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Debopam Sikder on 8/6/2017.
 */

public class Feature {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("properties")
    @Expose
    public Properties properties;
    @SerializedName("geometry")
    @Expose
    public Geometry geometry;
    @SerializedName("id")
    @Expose
    public String id;
}
