package com.vixonnen.footballtesttask.presentation.one_signal_screen.view_model

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class OneSignalFragmentViewModel @Inject constructor(

) : ViewModel() {

    fun check(checkValue: String?): String {
        return checkValue ?: ""
    }
}