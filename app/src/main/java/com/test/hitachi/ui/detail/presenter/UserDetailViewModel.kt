package com.test.hitachi.ui.detail.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.hitachi.model.UserDetail
import com.test.hitachi.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private var repository: GithubRepository
): ViewModel() {

    private val _userDetail = MutableLiveData<UserDetail>()
    val userDetail: LiveData<UserDetail> = _userDetail

    fun getUserDetail(username: String) {
        viewModelScope.launch {
            _userDetail.value = repository.getUserDetail(username)
        }
    }

}