package com.example.core_network.model

import com.example.core_model.BabyInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BabyInfoItem(
    @SerializedName("year_of_birth")
    @Expose
    val yearOfBirth: Int? = null,
    @SerializedName("year_of_birth")
    @Expose
    val gender: String? = null,
    @SerializedName("year_of_birth")
    @Expose
    val ethnicity: String? = null,
    @SerializedName("year_of_birth")
    @Expose
    val name: String? = null,
    @SerializedName("year_of_birth")
    @Expose
    val numberOfBabies: Int? = null,
    @SerializedName("year_of_birth")
    @Expose
    val nameRank: Int? = null,
)

fun BabyInfoItem.asBabyInfoModel() = BabyInfo(
    yearOfBirth,
    gender,
    ethnicity,
    name,
    numberOfBabies,
    nameRank
)
