package com.test.hitachi.ui.main.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.hitachi.model.User
import com.test.hitachi.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val _userList = MutableLiveData(emptyList<User>())
    val userList: LiveData<List<User>> = _userList

    fun getUserList() {
        viewModelScope.launch {
            _userList.value = repository.getUserList()
        }
    }

}