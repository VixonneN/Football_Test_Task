package com.vixonnen.footballtesttask.presentation.fixtures_screen.screen

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.vixonnen.footballtesttask.R
import com.vixonnen.footballtesttask.databinding.FragmentFixturesBinding
import com.vixonnen.footballtesttask.di.App
import com.vixonnen.footballtesttask.presentation.fixtures_screen.screen.recycler_view.FixturesAdapter
import com.vixonnen.footballtesttask.presentation.fixtures_screen.view_model.FixturesFragmentViewModel
import com.vixonnen.footballtesttask.presentation.league_screen.view_model.LeagueFragmentViewModel
import javax.inject.Inject

class FixturesFragment : Fragment() {

    private var _binding: FragmentFixturesBinding? = null
    private val mBinding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: FixturesFragmentViewModel

    private var leagueName = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFixturesBinding.inflate(layoutInflater, container, false)
        leagueName = requireArguments().getString("league_name") as String
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[FixturesFragmentViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        viewModel.getFixtures(leagueName)
        initializeRecyclerData()
    }

    private fun initializeRecyclerData(){
        mBinding.fixturesRv.apply {
            val fixturesAdapter = FixturesAdapter()
            viewModel.fixtures.observe(viewLifecycleOwner) {
                fixturesAdapter.fixturesList = it
            }
            adapter = fixturesAdapter
        }
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}