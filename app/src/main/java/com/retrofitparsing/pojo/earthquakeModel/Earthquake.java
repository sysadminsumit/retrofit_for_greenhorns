package com.retrofitparsing.pojo.earthquakeModel;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Debopam Sikder on 8/6/2017.
 */

public class Earthquake  {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;
    @SerializedName("features")
    @Expose
    public ArrayList<Feature> features = new ArrayList<>();
    @SerializedName("bbox")
    @Expose
    public List<Float> bbox = null;
    public ArrayList<Feature> ret_feat(){
        return features;
    }
}
