package com.example.app_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_project.adapter.HistoryAdapter
import com.example.app_project.databinding.FragmentHistoryBinding
import com.example.app_project.model.History

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private lateinit var historyAdapter: HistoryAdapter
    private val listHistory = LinearLayoutManager(activity)
    private val addHistoryList: MutableList<History> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHistory()
    }

    private fun initHistory() {
        binding.rvHistory.layoutManager = listHistory
        historyAdapter = HistoryAdapter(requireActivity())
        binding.rvHistory.adapter = historyAdapter

        // 0 berhasil 1 pending 2 gangguan 3 gagal
        addHistoryList.add(History(1920, "Pulsa Telkomsel 10000", 62812603134782, 11500, 1500, 0))
        addHistoryList.add(History(1921, "Pulsa Telkomsel 100000", 62812603134782, 101500, 1500, 1))
        addHistoryList.add(History(1922, "Pulsa XL 5000", 62812603134782, 6500, 1500, 0))
        addHistoryList.add(History(1923, "Pulsa XL - Axis 35000", 62812603134782, 36500, 1500, 2))
        addHistoryList.add(History(1924, "Pulsa Telkomsel 200000", 62812603134782, 201500, 1500, 3))
        addHistoryList.add(History(1925, "Pulsa Smartfren 5000", 62812603134782, 6500, 1500, 1))
        addHistoryList.add(History(1926, "Pulsa XL - AXIS 20000", 62812603134782, 21500, 1500, 0))
        addHistoryList.add(History(1927, "Pulsa Indosat 300000", 62812603134782, 301500, 1500, 0))
        addHistoryList.add(History(1928, "Pulsa Byu 40000", 62812603134782, 41500, 1500, 2))
        addHistoryList.add(History(1929, "Pulsa Byu 50000", 62812603134782, 51500, 1500, 0))
        addHistoryList.add(History(1930, "Pulsa Smartfren 45000", 62812603134782, 46500, 1500, 0))
        addHistoryList.add(History(1921, "Pulsa XL 25000", 62812603134782, 26500, 1500, 0))
        addHistoryList.add(History(1922, "Pulsa Telkomsel 35000", 62812603134782, 36500, 1500, 1))

        historyAdapter.setHistory(addHistoryList)
    }
}