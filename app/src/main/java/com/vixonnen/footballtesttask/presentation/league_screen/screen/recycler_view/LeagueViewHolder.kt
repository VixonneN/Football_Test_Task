package com.vixonnen.footballtesttask.presentation.league_screen.screen.recycler_view//package com.vixonnen.footballtesttask.presentation.splash_screen.recycler_view

import androidx.recyclerview.widget.RecyclerView
import com.vixonnen.footballtesttask.R
import com.vixonnen.footballtesttask.databinding.ItemFragmentLeagueBinding
import com.vixonnen.footballtesttask.di.glide.GlideApp
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity

class LeagueViewHolder(
    private val binding: ItemFragmentLeagueBinding,
    private val onBtnClickListener: (ResultLeagueEntity) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ResultLeagueEntity) {
        binding.tvLeague.text = model.league_name
        GlideApp.with(binding.root)
            .load(model.league_logo)
            .placeholder(R.drawable.ic_baseline_pause_circle_outline_24)
            .into(binding.imageLeague)
        binding.itemLeagueContainer.setOnClickListener {
            onBtnClickListener(model)
        }
    }
}