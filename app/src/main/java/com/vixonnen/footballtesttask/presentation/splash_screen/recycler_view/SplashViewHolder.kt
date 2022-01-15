//package com.vixonnen.footballtesttask.presentation.splash_screen.recycler_view
//
//import androidx.recyclerview.widget.RecyclerView
//import com.vixonnen.footballtesttask.databinding.ItemFragmentSplashBinding
//import com.vixonnen.footballtesttask.domain.entity.country.CountriesResultEntity
//
//class SplashViewHolder(
//    private val binding: ItemFragmentSplashBinding,
//    private val onBtnClickListener: (CountriesResultEntity) -> Unit
//    ) :
//    RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(model: CountriesResultEntity) {
//        binding.itemBtnCountry.text = model.name
//        binding.itemBtnCountry.setOnClickListener {
//            onBtnClickListener(model)
//        }
//    }
//}