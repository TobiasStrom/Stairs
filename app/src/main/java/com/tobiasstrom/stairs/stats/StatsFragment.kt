package com.tobiasstrom.stairs.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tobiasstrom.stairs.databinding.FragmentStatsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatsFragment : Fragment() {
    private val viewModel: StatsViewModel by viewModel()

    lateinit var binding: FragmentStatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}
