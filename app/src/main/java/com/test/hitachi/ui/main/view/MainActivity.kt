package com.test.hitachi.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.hitachi.adapter.UserAdapter
import com.test.hitachi.databinding.ActivityMainBinding
import com.test.hitachi.ui.detail.view.UserDetailActivity
import com.test.hitachi.ui.main.presenter.MainViewModel
import com.test.hitachi.ui.search.view.SearchUserActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val userAdapter = UserAdapter {
        val intent = Intent(this@MainActivity, UserDetailActivity::class.java).apply {
            putExtra("username", it)
        }
        startActivity(intent)
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
            ivSearch.setOnClickListener {
                val intent = Intent(this@MainActivity, SearchUserActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initObserver() {
        viewModel.userList.observe(this) {
            userAdapter.submitList(it)
        }
    }
}