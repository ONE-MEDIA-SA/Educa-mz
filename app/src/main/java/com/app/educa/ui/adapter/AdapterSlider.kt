package com.app.educa.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.app.educa.R
import com.bumptech.glide.Glide

class AdapterSlider (var list: List<String>, var ctx: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    lateinit var context:Context

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(ctx)

        var view = layoutInflater.inflate(R.layout.img_item,container,false)
        val img = view.findViewById<ImageView>(R.id.simpleimg)

        Glide
            .with(view.context)
            .load(list[position])
            .into(img)

        container.addView(view,0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}