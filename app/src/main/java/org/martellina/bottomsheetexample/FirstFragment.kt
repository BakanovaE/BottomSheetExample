package org.martellina.bottomsheetexample

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior

class FirstFragment : Fragment(R.layout.first_fragment) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onResume() {
        super.onResume()
        sharedViewModel.setBottomMenuHeight(BottomSheetBehavior.STATE_HALF_EXPANDED)
    }
}
