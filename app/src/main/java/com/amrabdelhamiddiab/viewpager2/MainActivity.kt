package com.amrabdelhamiddiab.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "MainActivity"
    }
    private lateinit var viewPager2 :ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageList = listOf(
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3
        )
        val adapter = ViewPagerAdapter(imageList, ViewPagerAdapter.OnClickListener{
            photo -> Log.d(TAG, photo.toString() )
            Toast.makeText(this@MainActivity, "Clicked>>>>>>", Toast.LENGTH_SHORT).show()
        })
            /*Log.d(TAG, "clicked at $it")
            */

        viewPager2 = findViewById(R.id.view_pager)
        viewPager2.adapter = adapter
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        dotsIndicator.setViewPager2(viewPager2)
        viewPager2.clipToPadding = false
        viewPager2.setPadding(0, 0, 0, 0)
      //  viewPager2.requestTransform()
    }
}