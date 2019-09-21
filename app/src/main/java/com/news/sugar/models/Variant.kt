package com.news.sugar.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Variant {

    @SerializedName("id")
    @Expose
    var id: Double? = null
    @SerializedName("product_id")
    @Expose
    var productId: Double? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("price")
    @Expose
    var price: String? = null
    @SerializedName("sku")
    @Expose
    var sku: String? = null
    @SerializedName("position")
    @Expose
    var position: Double? = null
    @SerializedName("inventory_policy")
    @Expose
    var inventoryPolicy: String? = null
    @SerializedName("compare_at_price")
    @Expose
    var compareAtPrice: Any? = null
    @SerializedName("fulfillment_service")
    @Expose
    var fulfillmentService: String? = null
    @SerializedName("inventory_management")
    @Expose
    var inventoryManagement: String? = null
    @SerializedName("option1")
    @Expose
    var option1: String? = null
    @SerializedName("option2")
    @Expose
    var option2: Any? = null
    @SerializedName("option3")
    @Expose
    var option3: Any? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("taxable")
    @Expose
    var taxable: Boolean? = null
    @SerializedName("barcode")
    @Expose
    var barcode: String? = null
    @SerializedName("grams")
    @Expose
    var grams: Double? = null
    @SerializedName("image_id")
    @Expose
    var imageId: Any? = null
    @SerializedName("weight")
    @Expose
    var weight: Double? = null
    @SerializedName("weight_unit")
    @Expose
    var weightUnit: String? = null
    @SerializedName("inventory_item_id")
    @Expose
    var inventoryItemId: Double? = null
    @SerializedName("inventory_quantity")
    @Expose
    var inventoryQuantity: Double? = null
    @SerializedName("old_inventory_quantity")
    @Expose
    var oldInventoryQuantity: Double? = null
    @SerializedName("requires_shipping")
    @Expose
    var requiresShipping: Boolean? = null
    @SerializedName("admin_graphql_api_id")
    @Expose
    var adminGraphqlApiId: String? = null

}