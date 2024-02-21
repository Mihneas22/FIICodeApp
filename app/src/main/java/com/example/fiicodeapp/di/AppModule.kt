package com.example.fiicodeapp.di

import com.example.fiicodeapp.features.data.repository.ApiRepository
import com.example.fiicodeapp.features.data.repository.AuthRepository
import com.example.fiicodeapp.features.data.repository.ProductsRepository
import com.example.fiicodeapp.features.domain.models.User
import com.example.fiicodeapp.features.domain.repository.AuthRepositoryIMPL
import com.example.fiicodeapp.features.domain.repository.ProductRepositoryIMPL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
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

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val api: ApiRepository = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiRepository.BASE_URL)
        .client(client)
        .build()
        .create(ApiRepository::class.java)

    @Provides
    fun provideProductsRepository(): ProductsRepository = ProductRepositoryIMPL(
        api = api
    )
}
