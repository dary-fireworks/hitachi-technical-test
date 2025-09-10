package com.test.hitachi.ui.search.view

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.hitachi.R
import com.test.hitachi.adapter.UserAdapter
import com.test.hitachi.databinding.ActivityUserSearchBinding
import com.test.hitachi.ui.detail.view.UserDetailActivity
import com.test.hitachi.ui.search.presenter.SearchUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchUserActivity: AppCompatActivity() {

    private lateinit var binding: ActivityUserSearchBinding

    private val viewModel: SearchUserViewModel by viewModels()

    private val userAdapter = UserAdapter {
        val intent = Intent(this@SearchUserActivity, UserDetailActivity::class.java).apply {
            putExtra("username", it)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObserver()
    }

    private fun initView() {
        binding.ivBack.setOnClickListener { finish() }

        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(this@SearchUserActivity)
            adapter = userAdapter
        }

        val etSearch = binding.svUser.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        etSearch.setTextColor(ContextCompat.getColor(this, R.color.black))
        binding.svUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    if(it.isNotEmpty()) {
                        viewModel.searchUser(it)
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun initObserver() {
        viewModel.searchUserList.observe(this) {
            userAdapter.submitList(it.users)
        }
    }

}