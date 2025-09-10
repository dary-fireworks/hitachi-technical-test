package com.test.hitachi.ui.main.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.hitachi.adapter.UserAdapter
import com.test.hitachi.databinding.ActivityMainBinding
import com.test.hitachi.ui.main.presenter.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val userAdapter = UserAdapter {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObserver()
        viewModel.getUserList()
    }

    private fun initView() {
        binding.apply {
            rvUsers.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = userAdapter
            }
        }
    }

    private fun initObserver() {
        viewModel.userList.observe(this) {
            userAdapter.submitList(it)
        }
    }
}