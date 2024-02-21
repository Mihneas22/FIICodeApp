package com.example.fiicodeapp.di

import com.example.fiicodeapp.features.data.repository.AuthRepository
import com.example.fiicodeapp.features.domain.models.User
import com.example.fiicodeapp.features.domain.repository.AuthRepositoryIMPL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryIMPL(
        realm = Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    User::class
                )
            )
        )
    )
}
