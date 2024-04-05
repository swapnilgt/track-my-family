package com.trackmyfamily

import android.util.Log
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
import timber.log.Timber

internal class MainViewModel: ViewModel() {

    private var uiState by mutableStateOf<MainActivityUIState>(MainActivityUIState.Loading)

    private val triggerLoginFlow = MutableSharedFlow<Boolean>(replay = 1)

    fun triggerLoginFlow() = triggerLoginFlow.asSharedFlow()

    fun getMyUiState(): MainActivityUIState = uiState


    fun init() {
        viewModelScope.launch {
            val user = Firebase.auth.currentUser
            user?.let {
                Timber.d("user details: %s", it.metadata)
                it.getIdToken(true).addOnCompleteListener{
                    Timber.d("Token is : %s", it.result.token)
                    Timber.d("Claim is : %s", it.result.claims)
                    Timber.d("provider is : %s", it.result.signInProvider)
                    Timber.d("second factor is : %s", it.result.signInSecondFactor)
                }
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