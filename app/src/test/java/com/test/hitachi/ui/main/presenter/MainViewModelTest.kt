package com.test.hitachi.ui.main.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.hitachi.model.User
import com.test.hitachi.repository.GithubRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var repository: GithubRepository

    @Before
    fun setup() {
        mainViewModel = MainViewModel(repository)
    }

    @Test
    fun getUserList() {
        runTest {
            val userList = listOf(User("", "", ""))
            given(repository.getUserList()).willReturn(userList)
            mainViewModel.getUserList()
            verify(repository).getUserList()
            val result = mainViewModel.userList
            assertEquals(userList, result.value)
        }
    }
}