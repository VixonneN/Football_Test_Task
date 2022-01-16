package com.vixonnen.footballtesttask.presentation.league_screen.screen.recycler_view//package com.vixonnen.footballtesttask.presentation.splash_screen.recycler_view

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vixonnen.footballtesttask.databinding.ItemFragmentLeagueBinding
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity

class LeagueViewHolder(
    private val binding: ItemFragmentLeagueBinding,
    private val onBtnClickListener: (ResultLeagueEntity) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ResultLeagueEntity) {
        binding.tvLeague.text = model.league_name
        Glide.with(binding.root)
            .load(model.league_logo)
            .into(binding.imageLeague)
        binding.itemLeagueContainer.setOnClickListener {
            onBtnClickListener(model)
        }
    }
}