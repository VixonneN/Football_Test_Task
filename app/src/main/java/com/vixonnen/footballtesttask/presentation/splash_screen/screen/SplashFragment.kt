package com.vixonnen.footballtesttask.presentation.splash_screen.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
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
        viewModel.getLeagues()
        viewModel.getFixtures()
        showToasts()
        mBinding.btnToNext.setOnClickListener {
            navigation().navigate(R.id.action_splashFragment_to_leagueFragment)
        }
    }

    private fun showToasts() {
        viewModel.leagues.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.fixtures.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigation(): NavController =
        Navigation.findNavController(requireActivity(), R.id.fragment_container_view)
}