package com.example.namegenerator.ui

import androidx.lifecycle.LiveData

class BabyNameViewModelContract {

    interface ViewModel{
        val uiStateData: LiveData<State>

    }

    sealed class State {
        object LoadingState : State()
        data class SuccessState(val name: BabyName): State()
        data class ErrorState(val errorMessage: String) : State()
    }
}