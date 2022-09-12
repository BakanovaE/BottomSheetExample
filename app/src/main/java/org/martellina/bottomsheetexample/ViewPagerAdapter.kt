package org.martellina.bottomsheetexample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUMBER_OF_TABS = 2
private const val POSITION_FIRST = 0
private const val POSITION_SECOND = 1

class ViewPagerAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = NUMBER_OF_TABS

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            POSITION_FIRST -> FirstFragment()
            POSITION_SECOND -> SecondFragment()
            else -> FirstFragment()
        }
    }
}
