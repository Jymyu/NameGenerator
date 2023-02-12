package com.example.namegenerator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_domain.FetchBabyNamesListUseCase
import com.example.core_model.BabyInfo
import com.example.core_model.BabyName
import com.example.core_model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BabyNameViewModel @Inject constructor(
    private val fetchBabyNamesListUseCase: FetchBabyNamesListUseCase
) : ViewModel(), BabyNameViewModelContract.ViewModel {

    private val _uiStateData = MediatorLiveData<BabyNameViewModelContract.State>()
    override val uiStateData: LiveData<BabyNameViewModelContract.State> = _uiStateData

    override fun invokeAction(action: BabyNameViewModelContract.Action) {
        when (action) {
            BabyNameViewModelContract.Action.FetchMaleName -> fetchBabyNamesList(MALE)
            BabyNameViewModelContract.Action.FetchFemaleName -> fetchBabyNamesList(FEMALE)
        }
    }

    private fun fetchBabyNamesList(gender: String) {
        viewModelScope.launch(Dispatchers.IO) {
            fetchBabyNamesListUseCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Error -> _uiStateData.postValue(
                        BabyNameViewModelContract.State.ErrorState(
                            resource.message
                        )
                    )
                    is Resource.Loading -> _uiStateData.postValue(BabyNameViewModelContract.State.LoadingState)
                    is Resource.Success -> resource.data?.let {
                        selectRandomName(it, gender)
                    }
                }
            }
        }
    }

    private fun selectRandomName(babyInfoList: List<BabyInfo>, gender: String) {
        val tempList = babyInfoList.toMutableList()
            .sortedByDescending { it.numberOfBabies }
            .toMutableList()
        tempList.removeAt(0)
        val babyName = BabyName(
            tempList.filter { it.gender == gender }
                .random().name.toString()
        )
        _uiStateData.postValue(BabyNameViewModelContract.State.SuccessState(babyName))

    }

    companion object {

        const val MALE = "MALE"
        const val FEMALE = "FEMALE"
    }


}