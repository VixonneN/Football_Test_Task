package com.vixonnen.footballtesttask.presentation.league_screen.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vixonnen.footballtesttask.R
import com.vixonnen.footballtesttask.databinding.FragmentLeagueBinding

class LeagueFragment : Fragment() {

    private var _binding: FragmentLeagueBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLeagueBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    companion object {
        fun newInstance() =
            LeagueFragment()
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}