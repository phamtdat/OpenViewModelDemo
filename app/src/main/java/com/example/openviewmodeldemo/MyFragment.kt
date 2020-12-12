package com.example.openviewmodeldemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_my.view.*

class MyFragment : BaseFragment() {

    // Why cant I do something like  this? (Line 24)
    //
    // Why do I need to use the viewModel instance created in the BaseFragment?
    // isnt extending it enough?
    //
    // Type casting every time I need to call a fun that only exists in MyViewModel can
    // be cumbersome
    //
    // The reason i am trying to achieve this is because I am using the MVVM architecture
    // in my application and want to able to route directly from the viewModel
    //
    // Please take a loook at MySampleFragment to see an example
    private lateinit var mViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun attachViewModel() {
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btn_to?.setOnClickListener {
            (viewModel as? MyViewModel)?.myNav()
        }
        view.btn_back?.setOnClickListener {
            (viewModel as? MyViewModel)?.myGoBack()
        }
    }
}