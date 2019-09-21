package com.news.sugar.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Category {

    @SerializedName("lips")
    @Expose
    var lips: List<String>? = null
    @SerializedName("face")
    @Expose
    var face: List<String>? = null
    @SerializedName("eyes")
    @Expose
    var eyes: List<String>? = null



}