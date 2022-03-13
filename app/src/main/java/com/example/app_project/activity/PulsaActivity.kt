package com.example.app_project.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app_project.MainActivity
import com.example.app_project.adapter.PulsaAdapter
import com.example.app_project.databinding.ActivityPulsaBinding
import com.example.app_project.model.Pulsa

class PulsaActivity : AppCompatActivity() {

    var bundle : Bundle? = null
    private val binding by lazy { ActivityPulsaBinding.inflate(layoutInflater) }

    private lateinit var  pulsaAdapter: PulsaAdapter
    private val listPulsa = GridLayoutManager(this, 2)
    private var addPulsaList: MutableList<Pulsa> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bundle = intent.extras

        binding.menuTitle.text = bundle?.getString("menu_title")

        this.supportActionBar?.title = bundle?.getString("menu_title")

        binding.btnCancel.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        binding.btnBuy.setOnClickListener {
            val i = Intent(this, FinishActivity::class.java)
            startActivity(i)
        }

        initPulsa()
    }

    private fun initPulsa() {
        binding.rvPulsa.layoutManager = listPulsa
        pulsaAdapter = PulsaAdapter(this)
        binding.rvPulsa.adapter = pulsaAdapter

        addPulsaList.add(Pulsa("6.500"))
        addPulsaList.add(Pulsa("11.500"))
        addPulsaList.add(Pulsa("21.500"))
        addPulsaList.add(Pulsa("31.500"))
        addPulsaList.add(Pulsa("51.500"))
        addPulsaList.add(Pulsa("101.500"))

        pulsaAdapter.setPulsa(addPulsaList)
    }

}