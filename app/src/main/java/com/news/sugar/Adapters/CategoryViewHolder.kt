package com.news.sugar.Adapters;

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.news.sugar.views.FullActivity
import android.animation.ValueAnimator
import com.news.sugar.R
import android.view.animation.AccelerateDecelerateInterpolator
import android.animation.AnimatorSet
import android.animation.ValueAnimator.ofInt
import android.animation.AnimatorListenerAdapter
import android.view.animation.AccelerateInterpolator
//import android.R
import android.animation.Animator
import com.google.gson.Gson


class CategoryViewHolder (val context: Context, var newsList: ArrayList<Categories>) : RecyclerView.Adapter<CategoryViewHolder.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_category,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //holder.setIsRecyclable(true)
        holder.tvtitle.text = newsList.get(position).name
        holder.tvproduct1.text = newsList.get(position).products.get(0).products?.get(0)?.title
        holder.tvpro2.text = newsList.get(position).products.get(1).products?.get(0)?.title
        holder.tvproduct3.text = newsList.get(position).products.get(2).products?.get(0)?.title
        holder.tvpro4.text = newsList.get(position).products.get(3).products?.get(0)?.title


        Log.d("logd",newsList.get(position).name)
        Log.d("logd",newsList.get(position).name +" "+position)
        Log.d("logd",newsList.get(position).products.get(2).products?.get(0)?.title)

        holder.firstLinear.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val height = holder.firstLinear.measuredHeight
        holder.linearDown.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val height1 = holder.linearDown.measuredHeight


        val params: ViewGroup.LayoutParams = holder.linear.layoutParams
            //params.width = 100
            params.height = height
            holder.linear.layoutParams = params

        holder.ivdown.setOnClickListener {
            Log.d("lol","kokk")
            /*val params: ViewGroup.LayoutParams = holder.linear.layoutParams
            //params.width = 100
            params.height = 1000
            holder.linear.layoutParams = params*/

            /*holder.linear.setLayoutParams(
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            )*/
            if (position>0){
                holder.linear.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                val targetHeight = holder.linear.measuredHeight
                var o=height1/2
                slideView(holder.linear,holder.linear.height,targetHeight+o)
            }else{
                holder.linear.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                val targetHeight = holder.linear.measuredHeight
                slideView(holder.linear,holder.linear.height,targetHeight)
            }



        }

        Glide.with(context).load(newsList.get(position).products.get(0).products?.get(0)?.images?.get(1)?.src)
            .apply(RequestOptions().centerCrop())
            .into(holder.ivpro1)
        Glide.with(context).load(newsList.get(position).products.get(1).products?.get(0)?.images?.get(1)?.src)
            .apply(RequestOptions().centerCrop())
            .into(holder.ivpro2)
        Glide.with(context).load(newsList.get(position).products.get(2).products?.get(0)?.images?.get(1)?.src)
            .apply(RequestOptions().centerCrop())
            .into(holder.ivpro3)
        Glide.with(context).load(newsList.get(position).products.get(3).products?.get(0)?.images?.get(1)?.src)
            .apply(RequestOptions().centerCrop())
            .into(holder.ivpro4)



        holder.ivpro1.setOnClickListener {
            var gson =  Gson();
            val i = Intent(context, FullActivity::class.java)
            i.putExtra("obj", gson.toJson(newsList.get(position)))
            i.putExtra("position", 0)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
        holder.ivpro2.setOnClickListener {
            var gson =  Gson();
            val i = Intent(context, FullActivity::class.java)
            i.putExtra("obj", gson.toJson(newsList.get(position)))
            i.putExtra("position", 1);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
        holder.ivpro3.setOnClickListener {
            var gson =  Gson();
            val i = Intent(context, FullActivity::class.java)
            i.putExtra("obj", gson.toJson(newsList.get(position)))
            i.putExtra("position", 2);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
        holder.ivpro4.setOnClickListener {
            var gson =  Gson();
            val i = Intent(context, FullActivity::class.java)
            i.putExtra("obj", gson.toJson(newsList.get(position)))
            i.putExtra("position", 3);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvtitle: TextView = itemView!!.findViewById(R.id.tvtitle)
        val tvproduct1: TextView = itemView!!.findViewById(R.id.tvproduct1)
        val tvpro2: TextView = itemView!!.findViewById(R.id.tvpro2)
        val tvproduct3: TextView = itemView!!.findViewById(R.id.tvproduct3)
        val tvpro4: TextView = itemView!!.findViewById(R.id.tvpro4)
        val linear: LinearLayout = itemView!!.findViewById(R.id.linear)
        val firstLinear: LinearLayout = itemView!!.findViewById(R.id.firstLinear)
        val linearDown: LinearLayout = itemView!!.findViewById(R.id.linearDown)
        val ivpro1: ImageView = itemView!!.findViewById(R.id.ivpro1)
        val ivpro2: ImageView = itemView!!.findViewById(R.id.ivpro2)
        val ivpro3: ImageView = itemView!!.findViewById(R.id.ivpro3)
        val ivpro4: ImageView = itemView!!.findViewById(R.id.ivpro4)
        val ivdown: ImageView = itemView!!.findViewById(R.id.ivdown)

    }

    fun slideView( view :View,
     currentHeight: Int,
     newHeight: Int) {

        var slideAnimator = ValueAnimator
                .ofInt(currentHeight, newHeight)
            .setDuration(500)

        /* We use an update listener which listens to each tick
         * and manually updates the height of the view  */

        slideAnimator.addUpdateListener { animation ->
            var value = animation.getAnimatedValue()


            view.getLayoutParams().height = value as Int
            view.requestLayout()
        }
        /*  We use an animationSet to play the animation  */

        val animationSet = AnimatorSet()
        animationSet.setInterpolator( AccelerateDecelerateInterpolator())
        animationSet.play(slideAnimator)
        animationSet.start()
    }

    fun expand(view: View) {
        view.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val targetHeight = view.measuredHeight

        // Set initial height to 0 and show the view
        view.layoutParams.height = view.height
        view.visibility = View.VISIBLE

        Log.d("logd","Initial: "+view.layoutParams.height)
        Log.d("logd","Initial1: "+view.height)
        Log.d("logd","targetHeight: "+targetHeight)

        val anim = ValueAnimator.ofInt(view.measuredHeight, targetHeight)
        anim.interpolator = AccelerateInterpolator()
        anim.duration = 1000
        anim.addUpdateListener { animation ->
            val layoutParams = view.layoutParams
            layoutParams.height = (targetHeight * animation.animatedFraction).toInt()
            view.layoutParams = layoutParams
            Log.d("logd","addListener: "+view.height)
        }
        anim.addListener(object : AnimatorListenerAdapter() {
            override
            fun onAnimationEnd(animation: Animator) {
                // At the end of animation, set the height to wrap content
                // This fix is for long views that are not shown on screen
                val layoutParams = view.layoutParams
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                Log.d("logd","addListener: "+layoutParams.height)
                Log.d("logd","addListener: "+view.height)
            }
        })
        anim.start()
    }

}



