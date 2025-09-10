package com.test.hitachi.ui.detail.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.test.hitachi.databinding.ActivityUserDetailBinding
import com.test.hitachi.model.UserDetail
import com.test.hitachi.ui.detail.presenter.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    private val viewModel: UserDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObserver()
        viewModel.getUserDetail(intent?.getStringExtra("username").orEmpty())
    }

    private fun initView() {
        binding.ivBack.setOnClickListener { finish() }
    }

    private fun initObserver() {
        viewModel.userDetail.observe(this) {
            successGetUserDetail(it)
        }
    }

    private fun successGetUserDetail(user: UserDetail) {
        binding.apply {
            Glide.with(this@UserDetailActivity)
                .load(user.avatar)
                .centerCrop()
                .into(ivUser)
            tvUsername.text = user.username
            tvName.text = user.name
            tvEmail.text = user.email
            tvBio.text = user.bio
        }
    }

}