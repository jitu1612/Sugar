package com.news.sugar.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Option {

    @SerializedName("id")
    @Expose
    var id: Double? = null
    @SerializedName("product_id")
    @Expose
    var productId: Double? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("position")
    @Expose
    var position: Double? = null
    @SerializedName("values")
    @Expose
    var values: List<String>? = null

}