package org.martellina.bottomsheetexample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator
import org.martellina.bottomsheetexample.databinding.ViewPagerFragmentBinding

class ViewPagerFragment: Fragment() {

    private lateinit var binding: ViewPagerFragmentBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var menuBehavior: BottomSheetBehavior<View>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = ViewPagerFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
        setUpBehaviour()
        observeMenuHeight()
        setUpMenuActions()
    }

    private fun setUpViewPager() {
        with(binding) {
            viewPager.adapter =
                ViewPagerAdapter(childFragmentManager, lifecycle)
            TabLayoutMediator(
                tabLayout,
                viewPager
            ) { tab, position ->
                viewPager.setCurrentItem(tab.position, true)
                tab.text = resources.getStringArray(R.array.tab_layout_tabs_title_list)[position]
            }.attach()
            tabLayout.makeSelectedTabTitleBold()
            tabLayout.getTabAt(0)?.select()
        }
    }

    private fun setUpBehaviour() {
        menuBehavior = BottomSheetBehavior.from(binding.bottomSheet.root)
        menuBehavior.halfExpandedRatio = 0.38f
    }

    private fun observeMenuHeight() {
        sharedViewModel.menuState.observe(viewLifecycleOwner) { state ->
            when(state) {
                BottomSheetBehavior.STATE_HALF_EXPANDED -> menuBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
                BottomSheetBehavior.STATE_COLLAPSED -> menuBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }

    @SuppressLint("SwitchIntDef")
    private fun setUpMenuActions() {
        binding.bottomSheet.topButton.setOnClickListener {
            when (menuBehavior.state) {
                BottomSheetBehavior.STATE_COLLAPSED -> menuBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
                BottomSheetBehavior.STATE_HALF_EXPANDED -> menuBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                BottomSheetBehavior.STATE_EXPANDED -> menuBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            }
        }
    }
}
