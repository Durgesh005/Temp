package com.example.a15daystry.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a15daystry.Controller.RVSetup
import com.example.a15daystry.ViewModel.EntriesItem
import com.example.a15daystry.ViewModel.UserViewModel
import com.example.a15daystry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var Data = arrayListOf<EntriesItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.list.observe(this, Observer {
            Log.e("TAG", "onCreate============: ${it.size}")

            RvSetup(it as ArrayList<EntriesItem>)
        })


    }

    private fun RvSetup(Info: ArrayList<EntriesItem>) {
        var adapter = RVSetup(this, Info)
        var layoutManager = LinearLayoutManager(this)
        binding.RVView.layoutManager = layoutManager
        binding.RVView.adapter = adapter
    }
}