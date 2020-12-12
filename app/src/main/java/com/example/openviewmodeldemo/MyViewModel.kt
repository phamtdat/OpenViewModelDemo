package com.example.openviewmodeldemo

class MyViewModel : BaseViewModel() {
    fun myNav() {
        navigate(12345678)
    }

    fun myGoBack() {
        goBack()
    }
}