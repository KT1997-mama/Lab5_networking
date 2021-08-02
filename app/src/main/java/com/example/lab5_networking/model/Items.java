package com.example.lab5_networking.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {
    @SerializedName("_type")
    private String _type;

    @SerializedName("totalCount")
    private int totalCount;

    @SerializedName("value")
    private List<Value> valueList;

    public Items() {

    }

    public Items(String _type, int totalCount, List<Value> valueList) {
        this._type = _type;
        this.totalCount = totalCount;
        this.valueList = valueList;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Value> getValueList() {
        return valueList;
    }

    public void setValueList(List<Value> valueList) {
        this.valueList = valueList;
    }
}
