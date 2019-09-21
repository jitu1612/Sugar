package com.news.sugar.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryPOJO {

    @SerializedName("category")
    @Expose
    private var category: List<Category>? = null

    fun getCategory(): List<Category>? {
        return category
    }

    fun setCategory(category: List<Category>) {
        this.category = category
    }



}