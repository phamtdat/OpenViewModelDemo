package com.example.openviewmodeldemo

class MyViewModel : BaseViewModel() {
    fun myNav() {
        navigate(12345678)
    }

    fun myGoBack() {
        goBack()
    }

    /**
     * I want to be able to do something like this to trigger the navigate method
     */
    fun onCLickMethodCalledFromXml() {
        // perform some actions and route after
        navigate(2323232)
    }
}