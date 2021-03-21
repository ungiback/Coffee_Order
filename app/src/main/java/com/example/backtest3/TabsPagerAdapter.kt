package com.example.backtest3

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter(fm : FragmentManager, lifecycle: Lifecycle, private var numberOfTabs : Int) : FragmentStateAdapter(fm, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return MenuFragment()
            }
            1 -> {
                return PayFragment()
            }
            else -> {
                val bundle = Bundle()
                bundle.putString("fragmentName","Books Fragment")
                val booksFragment = DemoFragment()
                booksFragment.arguments = bundle
                return booksFragment
            }
        }
    }
    override fun getItemCount(): Int {
        return numberOfTabs
    }
}