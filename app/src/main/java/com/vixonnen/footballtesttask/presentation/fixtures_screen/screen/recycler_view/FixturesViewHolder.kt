package com.vixonnen.footballtesttask.presentation.fixtures_screen.screen.recycler_view

import androidx.recyclerview.widget.RecyclerView
import com.vixonnen.footballtesttask.R
import com.vixonnen.footballtesttask.databinding.ItemFragmentFixturesBinding
import com.vixonnen.footballtesttask.di.glide.GlideApp
import com.vixonnen.footballtesttask.domain.entity.fixtures.ResultFixturesEntity

class FixturesViewHolder(
    private val binding: ItemFragmentFixturesBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ResultFixturesEntity) {
        binding.firstTeamNameTv.text = model.event_home_team
        binding.secondTeamNameTv.text = model.event_away_team
        binding.scopeTv.text = model.event_final_result

        GlideApp.with(binding.root)
            .load(model.home_team_logo)
            .placeholder(R.drawable.ic_baseline_pause_circle_outline_24)
            .into(binding.firstTeamIv)

        GlideApp.with(binding.root)
            .load(model.away_team_logo)
            .placeholder(R.drawable.ic_baseline_pause_circle_outline_24)
            .into(binding.secondTeamIv)
    }
}