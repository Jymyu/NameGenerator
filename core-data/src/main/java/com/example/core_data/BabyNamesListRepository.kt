package com.example.core_data

import com.example.core_model.BabyInfo
import com.example.core_model.Resource
import kotlinx.coroutines.flow.Flow


interface BabyNamesListRepository {
    fun getBabyNamesList(): Flow<Resource<List<BabyInfo>>>
}