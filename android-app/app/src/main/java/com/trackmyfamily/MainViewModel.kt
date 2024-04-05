package com.trackmyfamily

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.replay
import kotlinx.coroutines.launch

internal class MainViewModel: ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return super.create(modelClass)
            }
        }
    }

    private var uiState by mutableStateOf<MainActivityUIState>(MainActivityUIState.Loading)

    private val triggerLoginFlow = MutableSharedFlow<Boolean>(replay = 1)

    fun triggerLoginFlow() = triggerLoginFlow.asSharedFlow()

    fun getMyUiState(): MainActivityUIState = uiState


    fun init() {
        viewModelScope.launch {
            val user = Firebase.auth.currentUser
            user?.let {
                uiState = MainActivityUIState.LoggedIn
            } ?: kotlin.run {
                uiState = MainActivityUIState.TriggerLogin
                triggerLoginFlow.emit(true)
            }
        }
    }

    fun loginFailed() {
        uiState = MainActivityUIState.LoginFailed
    }
}