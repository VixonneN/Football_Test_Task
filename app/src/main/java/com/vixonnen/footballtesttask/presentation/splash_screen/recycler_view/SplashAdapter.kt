//package com.vixonnen.footballtesttask.presentation.splash_screen.recycler_view
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.vixonnen.footballtesttask.databinding.ItemFragmentSplashBinding
//
//class SplashAdapter(
////    private val onBtnClickListener: (CountriesResultEntity) -> Unit
//) : RecyclerView.Adapter<SplashViewHolder>() {
//
////    var countryList = emptyList<CountriesResultEntity>()
//    set(value)  {
//        field = value
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SplashViewHolder {
//        val binding = ItemFragmentSplashBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return SplashViewHolder(binding, onBtnClickListener)
//    }
//
//    override fun onBindViewHolder(holder: SplashViewHolder, position: Int) {
//        holder.bind(countryList[position])
//    }
//
//    override fun getItemCount(): Int =
//        countryList.size
//}