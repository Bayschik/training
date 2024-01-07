package com.example.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.training.databinding.FragmentHistoryBinding
import com.example.training.view.App

class HistoryFragment : Fragment() {
    private lateinit var binding:FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = App.db.getDao().getAll()

        list.forEach {_->
            binding.tvHistory.text = list.toString()
                .replace("[", "").replace("]", "").replace(",", "")
        }
    }

}