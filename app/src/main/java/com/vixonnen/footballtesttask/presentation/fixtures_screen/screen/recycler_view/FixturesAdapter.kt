package com.vixonnen.footballtesttask.presentation.fixtures_screen.screen.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vixonnen.footballtesttask.databinding.ItemFragmentFixturesBinding
import com.vixonnen.footballtesttask.domain.entity.fixtures.ResultFixturesEntity

class FixturesAdapter : RecyclerView.Adapter<FixturesViewHolder>() {

    var fixturesList = emptyList<ResultFixturesEntity>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        val binding =
            ItemFragmentFixturesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FixturesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        holder.bind(fixturesList[position])
    }

    override fun getItemCount(): Int =
        fixturesList.size
}