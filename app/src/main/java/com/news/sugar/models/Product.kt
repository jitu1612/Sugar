package com.news.sugar.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Product {

    @SerializedName("id")
    @Expose
    var id: Double? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("body_html")
    @Expose
    var bodyHtml: String? = null
    @SerializedName("vendor")
    @Expose
    var vendor: String? = null
    @SerializedName("product_type")
    @Expose
    var productType: String? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("handle")
    @Expose
    var handle: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("published_at")
    @Expose
    var publishedAt: String? = null
    @SerializedName("template_suffix")
    @Expose
    var templateSuffix: String? = null
    @SerializedName("tags")
    @Expose
    var tags: String? = null
    @SerializedName("published_scope")
    @Expose
    var publishedScope: String? = null
    @SerializedName("admin_graphql_api_id")
    @Expose
    var adminGraphqlApiId: String? = null
    @SerializedName("variants")
    @Expose
    var variants: List<Variant>? = null
    @SerializedName("options")
    @Expose
    var options: List<Option>? = null
    @SerializedName("images")
    @Expose
    var images: List<Image>? = null
    @SerializedName("image")
    @Expose
    var image: Image_? = null



}