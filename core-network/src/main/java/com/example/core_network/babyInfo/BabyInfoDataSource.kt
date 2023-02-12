package com.example.core_network.babyInfo

import com.example.core_model.Resource
import com.example.core_network.model.BabyInfoItem

interface BabyInfoDataSource {

    suspend fun fetchBabyInfo(): Resource<List<BabyInfoItem>>
}