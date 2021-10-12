package com.amrabdelhamiddiab.viewpager2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.amrabdelhamiddiab.viewpager2.MainActivity.Companion.TAG

class ViewPagerAdapter(
    private val imagesList: List<Int>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val image = imagesList[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

   inner class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivSliderImage = itemView.findViewById<ImageView>(R.id.imageView)
        fun bind(image: Int) {
            ivSliderImage.setImageResource(image)
            ivSliderImage.setOnClickListener {
                Log.d(TAG, "Click!") // WORKS!!!
                onClickListener.onClick(image)
            }
        }

    }
    class OnClickListener(val clickListener: (imageResource: Int) -> Unit) {
        fun onClick(imageResource: Int) = clickListener(imageResource)
    }
}