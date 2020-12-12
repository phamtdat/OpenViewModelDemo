package com.example.openviewmodeldemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class MySampleFragment: BaseFragment() {

    companion object {
        fun newInstance() = MySampleFragment()
    }

    private lateinit var mViewModel: MyViewModel
    private lateinit var binding: Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        /* binding = Binding() DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)*/
        /*binding.lifecycleOwner = viewLifecycleOwner*/

        // I am working with dataBinding so I have to do things like this so the code at least makes sense. lol sorry
        binding = Binding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.otpView.setOtpCompletionListener { otp ->
            Timber.e("TAG verification code => $otp")
        }*/

        // here I have to pass my viewModel to the binding object for my xml to consume
        // How can I do this without having to overrride your "attachViewModel()" method
        // and type casting.
        //
        // Unless I have a misunderstanding of how Inheritance works

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        binding.vm = viewModel
    }

}


class Binding {
    var vm: BaseViewModel? = null
    var root: View? = null
}