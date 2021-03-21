package com.example.backtest3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.setSelectedTabIndicatorColor(Color.BLACK)
        tab_layout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary))
        tab_layout.tabTextColors = ContextCompat.getColorStateList(this,android.R.color.white)
        tab_layout.tabMode = TabLayout.MODE_FIXED
        //tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        tab_layout.isInlineLabel = true

        val numberOfTabs = 3
        val adapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numberOfTabs)
        tabs_viewpager.adapter = adapter

        tabs_viewpager.isUserInputEnabled =false //Set the Viewpager Adapter


        TabLayoutMediator(tab_layout, tabs_viewpager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Menu"
                    tab.setIcon(R.drawable.music)
                }
                1 -> {
                    tab.text = "Pay"
                    tab.setIcon(R.drawable.movie)
                }
                2 -> {
                    tab.text = "Book"
                    tab.setIcon(R.drawable.book)
                }
            }
            // Change color of the icons
            tab.icon?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                Color.WHITE,
                BlendModeCompat.SRC_ATOP)
        }.attach()
    }
}
