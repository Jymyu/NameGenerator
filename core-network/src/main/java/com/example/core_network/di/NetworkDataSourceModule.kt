package com.example.core_network.di

import com.example.core_network.babyInfo.BabyInfoDataSource
import com.example.core_network.babyInfo.BabyInfoDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NetworkDataSourceModule {

    @Binds
    abstract fun bindBabyInfoDataSource(babyInfoDataSource: BabyInfoDataSourceImp): BabyInfoDataSource
}