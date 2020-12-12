package com.example.openviewmodeldemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.openviewmodeldemo.databinding.FragmentMySampleBinding

class MySampleFragment : BaseFragment() {

    companion object {
        fun newInstance() = MySampleFragment()
    }

    private lateinit var mViewModel: MySampleViewModel
    private lateinit var binding: FragmentMySampleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        /**
         * [FragmentMySampleBinding] is auto-generated for layouts with the <layout> tag after you
         * build your app, no need to create custom Binding()
         */
        binding = DataBindingUtil.inflate<FragmentMySampleBinding>(
            inflater, R.layout.fragment_my_sample, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**
         * The issue is here. Here you call super, i.e. [BaseFragment.onViewCreated] where
         * [BaseFragment.observeNavigationCommands] is called inside. The problem is that
         * [BaseFragment.observeNavigationCommands] observes your [BaseFragment.viewModel],
         * not this fragment's [mViewModel]. Basically at this point, both [BaseFragment.viewModel]
         * and [mViewModel] is attached to this fragment, but
         * [BaseFragment.observeNavigationCommands] observes only the [BaseFragment.viewModel].
         * The best solution in this case is to make [BaseFragment.viewModel] override-able and
         * override it with your [mViewModel], otherwise you will have to specify the observer for
         * your [mViewModel] in here, because [BaseFragment] as super class cannot know about its
         * subclasses specifics.
         */
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MySampleViewModel::class.java)
        /** the easy fix though, is to assign [mViewModel] to [BaseFragment.viewModel] */
        viewModel = mViewModel
        /** but then you need to make [BaseFragment.observeNavigationCommands] protected and call
         * it again so it subscribes to the new instance of[BaseFragment.viewModel] */
        observeNavigationCommands()

        /** if you comment out lines 47, 49, 52, you reproduce the issue */

        /** I still think the more elegant way is by overriding the viewModel, see [MyFragment]
         * and newly added [MyBaseFragment]
         */

        binding.viewModel = mViewModel
    }
}
