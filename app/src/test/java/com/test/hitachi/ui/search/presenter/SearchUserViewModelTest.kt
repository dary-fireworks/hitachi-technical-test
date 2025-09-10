package com.test.hitachi.ui.search.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.hitachi.model.SearchUser
import com.test.hitachi.model.User
import com.test.hitachi.repository.GithubRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class SearchUserViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var searchUserViewModel: SearchUserViewModel

    @Mock
    private lateinit var repository: GithubRepository

    @Before
    fun setup() {
        searchUserViewModel = SearchUserViewModel(repository)
    }

    @Test
    fun searchUser() {
        runTest {
            val userResult = SearchUser(
                "", false, listOf(
                    User("", "", "")
                )
            )
            given(repository.searchUser("")).willReturn(userResult)
            searchUserViewModel.searchUser("")
            verify(repository).searchUser("")
            val result = searchUserViewModel.searchUserList
            Assert.assertEquals(userResult, result.value)
        }
    }
}