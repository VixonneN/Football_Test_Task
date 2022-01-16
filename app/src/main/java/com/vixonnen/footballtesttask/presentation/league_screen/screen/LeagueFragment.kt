package com.vixonnen.footballtesttask.presentation.league_screen.screen

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
import com.vixonnen.footballtesttask.databinding.FragmentLeagueBinding
import com.vixonnen.footballtesttask.di.App
import com.vixonnen.footballtesttask.presentation.league_screen.screen.recycler_view.LeagueAdapter
import com.vixonnen.footballtesttask.presentation.league_screen.view_model.LeagueFragmentViewModel
import javax.inject.Inject

class LeagueFragment : Fragment() {

    private var _binding: FragmentLeagueBinding? = null
    private val mBinding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: LeagueFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLeagueBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[LeagueFragmentViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        viewModel.getLeagues()
        initializeRecyclerView()
        checkException()
    }

    private fun initializeRecyclerView() {
        mBinding.choiceLeagueRv.apply {
            val leagueAdapter = LeagueAdapter(
                onBtnClickListener = { league ->
                    val bundle = Bundle()
                    bundle.putString("league_name", league.league_name)
                    navigation().navigate(R.id.action_leagueFragment_to_fixturesFragment, bundle)
                }
            )
            viewModel.leagues.observe(viewLifecycleOwner) {
                leagueAdapter.countryList = it
            }
            adapter = leagueAdapter
        }
    }

    private fun checkException() {
        viewModel.exception.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigation(): NavController =
        Navigation.findNavController(requireActivity(), R.id.fragment_container_view)

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}