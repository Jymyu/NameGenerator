package com.example.core_data

import com.example.core_model.BabyInfo
import com.example.core_model.Resource
import com.example.core_network.babyInfo.BabyInfoDataSource
import com.example.core_network.model.asBabyInfoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BabyNamesListRepositoryImp @Inject constructor(private val babyInfoDataSource: BabyInfoDataSource) :
    BabyNamesListRepository {


    override fun getBabyNamesList(): Flow<Resource<List<BabyInfo>>> = flow {
        emit(Resource.Loading())
        val remoteResponse = babyInfoDataSource.fetchBabyInfo()
        val responseData = remoteResponse.data?.map { babyInfoItem ->
            babyInfoItem.asBabyInfoModel()
        }
        responseData?.let {
            emit(Resource.Success(responseData))
        }
    }
}