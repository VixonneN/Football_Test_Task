package com.vixonnen.footballtesttask.presentation.fixtures_screen.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vixonnen.footballtesttask.R
import com.vixonnen.footballtesttask.databinding.FragmentFixturesBinding

class FixturesFragment : Fragment() {

    private var _binding: FragmentFixturesBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFixturesBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    companion object {
        fun newInstance() = FixturesFragment()
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}