package com.example.core_data.di

import com.example.core_data.BabyNamesListRepository
import com.example.core_data.BabyNamesListRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindBabyNamesListRepository(babyNamesListRepository: BabyNamesListRepositoryImp): BabyNamesListRepository
}