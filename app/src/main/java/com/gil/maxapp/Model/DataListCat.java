package com.gil.maxapp.Model;

import com.google.gson.annotations.SerializedName;

public class DataListCat {
@SerializedName("CTitle")
    private String CTitle;

@SerializedName("CatId")
    private int CatId;

    public String getCTitle() {
        return CTitle;
    }

    public void setCTitle(String CTitle) {
        this.CTitle = CTitle;
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }
}
