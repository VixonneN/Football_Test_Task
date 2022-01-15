package com.vixonnen.footballtesttask.presentation.splash_screen.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vixonnen.footballtesttask.R
import com.vixonnen.footballtesttask.databinding.FragmentSplashBinding
import com.vixonnen.footballtesttask.di.App
import com.vixonnen.footballtesttask.presentation.splash_screen.view_model.SplashFragmentViewModel
import javax.inject.Inject

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val mBinding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: SplashFragmentViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[SplashFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.getFixtures()
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}