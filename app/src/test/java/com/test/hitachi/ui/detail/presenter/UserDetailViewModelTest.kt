package com.test.hitachi.ui.detail.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.test.hitachi.model.UserDetail
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
class UserDetailViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var userDetailViewModel: UserDetailViewModel

    @Mock
    private lateinit var repository: GithubRepository

    @Before
    fun setup() {
        userDetailViewModel = UserDetailViewModel(repository)
    }

    @Test
    fun getUserDetail() {
        runTest {
            val expected = UserDetail("", "", "", "", "", "")
            given(repository.getUserDetail("")).willReturn(expected)
            userDetailViewModel.getUserDetail("")
            verify(repository).getUserDetail("")
            val result = userDetailViewModel.userDetail
            Assert.assertEquals(expected, result.value)
        }
    }
}