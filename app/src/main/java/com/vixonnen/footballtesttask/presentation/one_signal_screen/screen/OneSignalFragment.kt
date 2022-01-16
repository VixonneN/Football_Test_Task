package com.vixonnen.footballtesttask.presentation.one_signal_screen.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.lifecycle.ViewModelProvider
import com.vixonnen.footballtesttask.R
import com.vixonnen.footballtesttask.databinding.FragmentOneSignalBinding
import com.vixonnen.footballtesttask.di.App
import com.vixonnen.footballtesttask.presentation.league_screen.view_model.LeagueFragmentViewModel
import com.vixonnen.footballtesttask.presentation.one_signal_screen.view_model.OneSignalFragmentViewModel
import javax.inject.Inject

class OneSignalFragment : Fragment() {

    private var url: String? = "https://www.google.ru"

    private var _binding: FragmentOneSignalBinding? = null
    private val mBinding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: OneSignalFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOneSignalBinding.inflate(layoutInflater, container, false)
//        viewModel.check(requireArguments().getString("url"))
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[OneSignalFragmentViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        setupWebView()
    }

    private fun setupWebView() {
        mBinding.webView.settings.setSupportZoom(true)
        mBinding.webView.settings.loadsImagesAutomatically
        mBinding.webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        if (url != null) {
            mBinding.webView.loadUrl(url!!)
        }
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}