package org.martellina.bottomsheetexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    val menuState: LiveData<Int>
        get() = _menuState
    private val _menuState = MutableLiveData<Int>()

    fun setBottomMenuHeight(state: Int) {
        _menuState.value = state
    }
}
