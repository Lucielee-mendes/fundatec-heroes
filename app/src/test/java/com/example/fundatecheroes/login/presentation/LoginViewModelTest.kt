/*
package com.example.fundatecheroes.login.presentation

import com.example.fundatecheroes.CoroutinesRule
import com.example.fundatecheroes.login.domain.LoginUseCase
import com.example.fundatecheroes.login.presentation.model.LoginViewState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.any
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import io.mockk.mockk
import io.mockk.coEvery
import io.mockk.coVerify



@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = CoroutinesRule()

    private val loginUseCase = mockk<LoginUseCase>()
    private val viewModel = LoginViewModel(loginUseCase)

    @Test
    fun validateViewState_returnShowEmailError() = runTest {
        prepareScenario(isSuccess = false)
        viewModel.validacaoPreenchimento(null, null)
        coVerify(exactly = 0) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowEmailError)
    }

    @Test
    fun validateViewState_returnShowPasswordError() = runTest {
        prepareScenario(isSuccess = false)
        viewModel.validacaoPreenchimento("email@gmail.com", null)
        coVerify(exactly = 0) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowPasswordError)
    }

    @Test
    fun validateViewState_returnShowErrorMessage() = runTest {
        prepareScenario(isSuccess = false)
        viewModel.validacaoPreenchimento("email@gmail.com", "passworddassadas")
        coVerify(exactly = 1) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowErrorMessage)
    }

    @Test
    fun validateViewState_returnShowHomeScreen() = runTest {
        prepareScenario(isSuccess = true)
        viewModel.validacaoPreenchimento("email@gmail.com", "passworddassadas")
        coVerify(exactly = 1) { loginUseCase.login(any(), any()) }
        assertEquals(viewModel.state.value, LoginViewState.ShowHomeScreen)
    }

    private fun prepareScenario(
        isSuccess: Boolean
    ) {
        coEvery {
            loginUseCase.login(any(), any())
        } returns isSuccess
    }
}*/
