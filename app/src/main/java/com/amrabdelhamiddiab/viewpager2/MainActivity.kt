package com.amrabdelhamiddiab.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "MainActivity"
    }
    private lateinit var viewPager2 :ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(targetScreenDataList, ViewPagerAdapter.OnClickListener{
            photo -> Log.d(TAG, photo.toString() )
            Toast.makeText(this@MainActivity, "Clicked>>>>>>", Toast.LENGTH_SHORT).show()
        })
            /*Log.d(TAG, "clicked at $it")
            */

        viewPager2 = findViewById(R.id.view_pager)
        viewPager2.adapter = adapter
        val dotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        dotsIndicator.setViewPager2(viewPager2)
        viewPager2.clipToPadding = false
        viewPager2.setPadding(0, 0, 0, 0)
      ////////////////////////////////////////////////
        // You need to retain one page on each side
        // so that the next and previous items are visible
        viewPager2.offscreenPageLimit = 1
        // Add a PageTransformer that translates the next and previous items horizontally
        // towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources
            .getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.20f * abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        }
        viewPager2.setPageTransformer(pageTransformer)
            // The ItemDecoration gives the current (centered) item horizontal margin so that
            // it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewPager2.addItemDecoration(itemDecoration)
    }
}