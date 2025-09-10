package com.test.hitachi.ui.search.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.hitachi.model.SearchUser
import com.test.hitachi.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchUserViewModel @Inject constructor(
    private val repository: GithubRepository
): ViewModel() {

    private val _searchUserList = MutableLiveData<SearchUser>()
    val searchUserList: LiveData<SearchUser> = _searchUserList

    fun searchUser(query: String) {
        viewModelScope.launch {
            _searchUserList.value = repository.searchUser(query)
        }
    }

}