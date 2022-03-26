package com.example.convin.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.convin.R
import com.example.convin.databinding.ActivityMainBinding
import com.example.convin.main.adapter.MainAdapter
import com.example.convin.main.customList.CustomList.Companion.localList
import com.example.convin.main.model.CardData
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    private lateinit var mainAdapter: MainAdapter

    var logTag: String ="@MainActivity"

    private var cardData: CardData? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // clearing
        localList.clear()
        localList.add(0)

        //calling
        initTheme()
        initRecyclerView()
        fetchNewCard()
        initActions()

    }

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(this)
        binding.rvCards.setHasFixedSize(true)
        binding.rvCards.layoutManager = llm
        mainAdapter = MainAdapter(this)
        binding.rvCards.adapter = mainAdapter
    }

    private fun initActions() {

        binding.srlSwipeRefresh.setOnRefreshListener {
            binding.srlSwipeRefresh.isRefreshing = true
            fetchNewCard()
        }

    }

    private fun fetchNewCard(){
        //--------------------------------------------
        val size: Int = localList.size - 1

        var hh: Int = localList[localList.size - 1]

        var total:Int = hh + 1
        localList.add(total)
        Log.d(logTag, "fetchNewCard: " + total + "line no 78")

            cardData = CardData(total)
            mainAdapter.update(cardData!!)
            binding.srlSwipeRefresh.isRefreshing = false

    }

    private fun initTheme(){
        window.statusBarColor = resources.getColor(R.color.lightBlack)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }


}