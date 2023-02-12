package com.example.core_domain

import com.example.core_data.BabyNamesListRepository
import com.example.core_model.BabyName
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchBabyNamesListUseCase @Inject constructor(private val repository: BabyNamesListRepository) {
    operator fun invoke() = repository.getBabyNamesList()
}
