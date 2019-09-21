package com.news.sugar.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.news.sugar.Adapters.Categories
import com.news.sugar.databinding.ActivityFullBinding
import com.news.sugar.databinding.ActivityMainBinding
import android.R
import android.os.Build
import android.text.Html
import androidx.viewpager.widget.ViewPager
import com.news.sugar.Adapters.ViewPagerAdapter
import com.google.gson.Gson
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3
import java.lang.Exception


class FullActivity : AppCompatActivity() {


    lateinit var binding: ActivityFullBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.news.sugar.R.layout.activity_full)

        binding = DataBindingUtil.setContentView(this, com.news.sugar.R.layout.activity_full)

        val intent = intent

        if (intent.hasExtra("obj")) {


            try {

                val gson = Gson()
                val strObj = getIntent().getStringExtra("obj")
                val position = getIntent().getIntExtra("position",0)
                val cat = gson.fromJson<Categories>(strObj, Categories::class.java)
                //binding.tvcontent.text = cat.products.get(0).products?.get(0)
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    binding.tvcontent.setText(
                        Html.fromHtml(
                            cat.products.get(position).products?.get(0)?.bodyHtml,
                            Html.FROM_HTML_MODE_LEGACY
                        )
                    )
                } else {
                    binding.tvcontent.setText(Html.fromHtml(cat.products.get(position).products?.get(0)?.bodyHtml))
                }
                binding.tvtitle.text= cat.products.get(position).products?.get(0)?.title
                binding.tvprice.text= "Price: Rs. "+cat.products.get(position).products?.get(0)?.variants?.get(0)?.price
                //val cat=intent.getSerializableExtra("obj")as Categories
                Log.d("logd", "obj " + cat.name)
                var list = ArrayList<String>()
                var size = cat.products.get(position).products?.get(0)?.images?.size
                for (i in 0 until size!!) {
                    list.add(cat.products.get(position).products?.get(0)?.images?.get(i)?.src.toString())
                }

                val adapter = ViewPagerAdapter(applicationContext, list)
                binding.viewpager.setAdapter(adapter)
                binding.indicator.setViewPager(binding.viewpager)

                adapter.registerDataSetObserver(binding.indicator.getDataSetObserver());

            } catch (e: Exception) {
                e.toString()
            }

        }

    }
}
