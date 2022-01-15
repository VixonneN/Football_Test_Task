package com.vixonnen.footballtesttask.presentation.league_screen.screen.recycler_view//package com.vixonnen.footballtesttask.presentation.splash_screen.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vixonnen.footballtesttask.databinding.ItemFragmentLeagueBinding
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity

class LeagueAdapter(
    private val onBtnClickListener: (ResultLeagueEntity) -> Unit
) : RecyclerView.Adapter<LeagueViewHolder>() {

    var countryList = emptyList<ResultLeagueEntity>()
    set(value)  {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val binding = ItemFragmentLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeagueViewHolder(binding, onBtnClickListener)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    override fun getItemCount(): Int =
        countryList.size
}