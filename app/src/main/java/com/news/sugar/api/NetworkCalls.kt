package com.news.sugar.api

import io.reactivex.Observable
import com.news.sugar.models.CategoryPOJO
import com.news.sugar.models.Products
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


interface NetworkCalls {
    companion object {
        val Base_URL: String = "https://sugarcosmetics.s3.amazonaws.com/feeds/"

        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @GET("category.json")
    fun getData(): Call<CategoryPOJO>

     @GET("category.json")
        fun getData1(): Observable<CategoryPOJO>

    @GET
    fun getDetailedData(@Url url: String?): Call<Products>


    @GET
    fun getDetailedData1(@Url url: String?): Observable<Products>
}