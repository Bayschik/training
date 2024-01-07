package com.example.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.training.databinding.FragmentMainBinding
import com.example.training.view.App
import com.example.training.view.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() = with(binding) {
        btnCalculate.setOnClickListener {
            viewModel.getLiveLoveData(etFirst.text.toString(), etSecond.text.toString())
                .observe(viewLifecycleOwner) {
                    tvResult.text = it.percentage
                    App.db.getDao().insert(it)
                }
        }
        btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }
}
