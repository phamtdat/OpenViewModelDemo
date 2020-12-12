package com.example.openviewmodeldemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    val navigationCommands = MutableLiveData<NavigationCommand>()

    /**
     * Navigate to a specific fragment using Id
     */
    fun navigate(id: Int) {
        Log.d("AAAA","trigger navigation event $id")
        // navigationCommands.postValue(NavigationCommand.To(id))
        navigationCommands.value = NavigationCommand.To(id)
    }

    /**
     * Pop backStack
     */
    fun goBack() {
        navigationCommands.value = NavigationCommand.Back
    }

    sealed class NavigationCommand {
        data class To(val destinationId: Int) : NavigationCommand()
        data class BackTo(val destinationId: Int) : NavigationCommand()
        object Back : NavigationCommand()
        object ToRoot : NavigationCommand()
    }
}
