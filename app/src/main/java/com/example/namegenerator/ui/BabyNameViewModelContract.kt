package com.example.namegenerator.ui

import androidx.lifecycle.LiveData
import com.example.core_model.BabyName

class BabyNameViewModelContract {

    interface ViewModel {
        val uiStateData: LiveData<State>
        fun invokeAction(action: Action)
    }

    sealed class Action {
        object FetchMaleName : Action()
        object FetchFemaleName : Action()
    }


    sealed class State {
        object LoadingState : State()
        data class SuccessState(val name: BabyName) : State()
        data class ErrorState(val errorMessage: String?) : State()
    }
}