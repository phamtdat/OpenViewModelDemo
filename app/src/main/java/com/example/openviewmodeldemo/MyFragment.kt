package com.example.openviewmodeldemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.openviewmodeldemo.databinding.FragmentMyBinding

class MyFragment : MyBaseFragment() {
    private lateinit var binding: FragmentMyBinding

    // if you mind casting, use a convenient getter to return casted type
    private val myViewModel: MyViewModel?
    get() { return viewModel as? MyViewModel }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentMyBinding>(
            inflater, R.layout.fragment_my, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = myViewModel
    }

    override fun attachViewModel() {
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    }
}