package com.example.core_network.api

import com.example.core_network.model.BabyInfoItem
import retrofit2.http.GET

interface NetworkApi {

    @GET("")
    suspend fun fetchListOfBabyInfoItem(): List<BabyInfoItem>
}