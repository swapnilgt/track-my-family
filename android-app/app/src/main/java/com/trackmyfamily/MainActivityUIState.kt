package com.trackmyfamily

internal sealed class MainActivityUIState {

    object Loading: MainActivityUIState()

    object LoggedIn: MainActivityUIState()

    object TriggerLogin: MainActivityUIState()

    object LoginFailed: MainActivityUIState()
}