package com.amrabdelhamiddiab.viewpager2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amrabdelhamiddiab.viewpager2.MainActivity.Companion.TAG
import com.google.android.material.progressindicator.LinearProgressIndicator

class ViewPagerAdapter(
    private val targetList: List<TargetScreenData>,
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
        val targetObject = targetList[position]
        holder.bind(targetObject.imageRes, targetObject.stringRes)
    }

    override fun getItemCount(): Int {
        return targetList.size
    }

    inner class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivSliderImage = itemView.findViewById<ImageView>(R.id.imageView)
        private val tvDescription = itemView.findViewById<TextView>(R.id.text_view_description)
        private val progressIndicator =
            itemView.findViewById<LinearProgressIndicator>(R.id.progress_bar)
        private val currentRatio = itemView.findViewById<TextView>(R.id.text_view_current_max_value)
        private val status = itemView.findViewById<TextView>(R.id.tv_status)

        fun bind(image: Int, itemString: Int) {
            ivSliderImage.setImageResource(image)
            tvDescription.setText(itemString)
            progressIndicator.progress = 60
            progressIndicator.max = 100
            currentRatio.text = "20/80"
            status.text = "You can edit the target"


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