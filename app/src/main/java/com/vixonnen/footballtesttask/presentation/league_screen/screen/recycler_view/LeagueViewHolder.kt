package com.vixonnen.footballtesttask.presentation.league_screen.screen.recycler_view//package com.vixonnen.footballtesttask.presentation.splash_screen.recycler_view

import androidx.recyclerview.widget.RecyclerView
import com.vixonnen.footballtesttask.databinding.ItemFragmentLeagueBinding
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity

class LeagueViewHolder(
    private val binding: ItemFragmentLeagueBinding,
    private val onBtnClickListener: (ResultLeagueEntity) -> Unit
    ) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ResultLeagueEntity) {

    }
}