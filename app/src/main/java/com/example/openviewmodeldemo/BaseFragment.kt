package com.example.openviewmodeldemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

open class BaseFragment: Fragment() {

    protected lateinit var viewModel: BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachViewModel()
        observeNavigationCommands()
    }

    protected open fun attachViewModel() {
        viewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
    }

    /**
     * Method that observes Navigation commands triggered by BaseViewHolder
     * This allows us to navigate from a viewHolder using the MVVM pattern
     */
    private fun observeNavigationCommands() {
        viewModel.navigationCommands.observe(viewLifecycleOwner, Observer {
            Log.d("AAAA", "received nav command $it")
            when (it) {
                is BaseViewModel.NavigationCommand.To ->
                    Log.d("AAAA", "to ${it.destinationId}")
                is BaseViewModel.NavigationCommand.Back ->
                    Log.d("AAAA", "back")
                is BaseViewModel.NavigationCommand.BackTo ->
                    Log.d("AAAA", "backTo")
                BaseViewModel.NavigationCommand.ToRoot ->
                    Log.d("AAAA", "toRoot")
            }
        })
    }
}
