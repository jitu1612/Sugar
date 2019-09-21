package com.news.sugar.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Image {

    @SerializedName("id")
    @Expose
    var id: Double? = null
    @SerializedName("product_id")
    @Expose
    var productId: Double? = null
    @SerializedName("position")
    @Expose
    var position: Double? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("alt")
    @Expose
    var alt: Any? = null
    @SerializedName("width")
    @Expose
    var width: Double? = null
    @SerializedName("height")
    @Expose
    var height: Double? = null
    @SerializedName("src")
    @Expose
    var src: String? = null
    @SerializedName("variant_ids")
    @Expose
    var variantIds: List<Any>? = null
    @SerializedName("admin_graphql_api_id")
    @Expose
    var adminGraphqlApiId: String? = null

}