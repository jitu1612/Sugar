package com.news.sugar.views

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.news.sugar.api.NetworkCalls
import com.news.sugar.databinding.ActivityMainBinding
import com.news.sugar.models.Category
import com.news.sugar.models.CategoryPOJO
import com.news.sugar.models.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.R
import okhttp3.ResponseBody
import android.os.AsyncTask.execute
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.sugar.Adapters.Categories
import com.news.sugar.Adapters.CategoryViewHolder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.Observable

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    //private var adapter: RecylerViewAdapter? = null
    lateinit var binding: ActivityMainBinding
    public var allCategory = CategoryPOJO()
    public var lipsCategory = ArrayList<Products>()
    var faceCategory = ArrayList<Products>()
    var eyesCategory = ArrayList<Products>()
    var adapter: CategoryViewHolder? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.news.sugar.R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, com.news.sugar.R.layout.activity_main)
        setDialog(true)
        getCategory()
        //LipsTaskRX()
    }

    fun getCategory() {

        val retrofit = Retrofit.Builder()
            .baseUrl(NetworkCalls.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(NetworkCalls::class.java)

        var call = api.getData() as Call<CategoryPOJO>

        call.enqueue(object : Callback<CategoryPOJO> {
            override fun onResponse(call: Call<CategoryPOJO>, response: Response<CategoryPOJO>) {
                //Log.d("LogdgetTitle: ", response.body().toString())
                //Log.d("Logdresponse.code(): ", response.toString())
                if (response.code() == 200) {
                    //Log.d("Logdresponse.200)", "s")

                    allCategory = response.body() as CategoryPOJO

                    var list = allCategory.getCategory() as ArrayList<Category>
                    //Log.d("Logdresponse.200): ", allCategory.getCategory()?.size.toString())




                    getAllCatData(allCategory, lipsCategory, faceCategory, eyesCategory).execute()

                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    setDialog(false)
                }

            }

            override
            fun onFailure(call: Call<CategoryPOJO>, t: Throwable) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                //Log.d("LogdThrowable: ", t.toString())
                setDialog(false)
            }
        })

    }

    fun setDialog(show: Boolean){
        if (show){
            binding.loader.visibility= View.VISIBLE
        }else{

            binding.loader.visibility= View.GONE
        }
    }

    inner class getAllCatData(
        allCategory: CategoryPOJO,
        list: ArrayList<Products>,
        listFace: ArrayList<Products>,
        listEye: ArrayList<Products>
    ) : AsyncTask<Void, Void, Void>() {


        var allCategory = allCategory
        var list = list
        var listFace = listFace
        var listEye = listEye

        override fun onPreExecute() {
            super.onPreExecute()
            // ...
        }

        override fun doInBackground(vararg params: Void?): Void? {

            for (i in allCategory.getCategory()?.get(0)?.lips!!) {

                val api = NetworkCalls.retrofit.create(NetworkCalls::class.java)

                var call = api.getDetailedData("lips/" + i + ".json") as Call<Products>
                val res = call.execute() as Response<Products>
                val o = res.body() as Products
                list.add(o)
               // Log.d("logd", "doInBackground url " + call.request().url())
                //Log.d("logd", "doInBackground " + o.products?.size)
            }

            for (i in allCategory.getCategory()?.get(0)?.face!!) {

                val api = NetworkCalls.retrofit.create(NetworkCalls::class.java)

                var call = api.getDetailedData("face/" + i + ".json") as Call<Products>
                val res = call.execute() as Response<Products>
                val o = res.body() as Products
                listFace.add(o)
               // Log.d("logd", "doInBackground url " + call.request().url())
               // Log.d("logd", "doInBackground FaceTask " + o.products?.size)
            }

            for (i in allCategory.getCategory()?.get(0)?.eyes!!) {

                val api = NetworkCalls.retrofit.create(NetworkCalls::class.java)

                var call = api.getDetailedData("eyes/" + i + ".json") as Call<Products>
                val res = call.execute() as Response<Products>
                //Log.d("logd", "doInBackground url " + call.request().url())
                val o = res.body() as Products
                listEye.add(o)
                //Log.d("logd", "doInBackground EyesTask " + o.products?.size)
            }

            return null
        }


        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            /*Log.d("logd", "onPostExecutelist: " + list.size)
            Log.d("logd", "onPostExecutelistFace: " + listFace.size)
            Log.d("logd", "onPostExecutelistEye: " + listEye.size)
            Log.d("logd", "onPostExecute EyesTask: " + list.get(0).products?.get(0)?.title)
            Log.d("logd", "onPostExecute EyesTask: " + listFace.get(0).products?.get(0)?.title)
            Log.d("logd", "onPostExecute EyesTask: " + listEye.get(0).products?.get(0)?.title)*/


            val layoutManager = LinearLayoutManager(applicationContext);
            var a=ArrayList<Categories>()
            a.add(Categories("Lips",list))
            a.add(Categories("Face",listFace))
            a.add(Categories("Eyes",listEye))
            adapter = CategoryViewHolder(applicationContext,a);
            binding.recyclerview.adapter=adapter
            binding.recyclerview.setLayoutManager(layoutManager);
            //FaceTask(allCategory,list,listFace, listEye)

            setDialog(false)
        }
    }



    fun LipsTaskRX() {

        val retrofit = Retrofit.Builder()
            .baseUrl(NetworkCalls.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(NetworkCalls::class.java)
        Log.d("LogdLipsTaskRX: ", "LipsTaskRX")
        /*mCompositeDisposable?.add(retrofit.getDetailedData("lips/"+1+".json")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError))*/

        val okHttpClientBuilder = OkHttpClient.Builder();

        /*val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()*/

        val retrofit2 = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(NetworkCalls.Base_URL)
            .build().create(NetworkCalls::class.java)
        Log.d("LogdLipsTaskRX: ", "LipsTaskRX")
        mCompositeDisposable?.add(
            retrofit2.getData1()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        )


    }

    private fun handleResponse(androidList: CategoryPOJO) {

        Log.d("LogdhandleResponse: ", "fff")
        /*mAndroidArrayList = ArrayList(androidList)
        mAdapter = DataAdapter(mAndroidArrayList!!, this)

        rv_android_list.adapter = mAdapter*/
    }

    private fun handleError(error: Throwable) {
        Log.d("Logdhandleerror: ", "error")
        Log.d("LogdhandleError", error.localizedMessage)

        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    /*{
        "category": [
        {
            "lips": [
            "1",
            "2",
            "3",
            "4"
            ],
            "face": [
            "1",
            "2",
            "3",
            "4"
            ],
            "eyes": [
            "1",
            "2",
            "3",
            "4"
            ]
        }
        ]
    }*/
    override fun onDestroy() {
        super.onDestroy()

//Clear all your disposables//

        mCompositeDisposable?.clear()

    }
}
