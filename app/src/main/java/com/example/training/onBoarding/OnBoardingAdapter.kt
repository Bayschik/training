package com.example.training.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.training.databinding.ItemOnboardingBinding

class OnBoardingAdapter(val onClick:()->Unit):Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf(
        OnBoarding(
            "Have a good time",
            "You should take the time to help those \n who need you",
        ),
        OnBoarding(
            "Cherishing love",
            "It is no longer possible for \n you to cherish love",
        ),
        OnBoarding(
            "Have a breakup?",
            "We have the correction for you \n don't worry \n Maybe someone is waiting for you!",
        ),
        OnBoarding(
            "It's fun and many more!",
            "",
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
       return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding:ItemOnboardingBinding):ViewHolder(binding.root){
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            binding.tvSkip.isVisible = adapterPosition != list.lastIndex
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.btnStart.setOnClickListener {onClick()}
            binding.tvSkip.setOnClickListener {onClick()}
        }

    }
}