package com.example.openviewmodeldemo

import android.util.Log

class MySampleViewModel : BaseViewModel() {
    fun onTopClicked() {
        // todo my logic
        super.navigate(123456)
    }

    fun onBackClicked() {
        // todo my logic
        super.goBack()
    }

    fun mock() {
        Log.d("AAAA", "I am mocked")
    }
}
