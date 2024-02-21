package com.example.fiicodeapp.features.domain.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.fiicodeapp.features.data.repository.ApiRepository
import com.example.fiicodeapp.features.data.repository.ProductsRepository
import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models_test.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductRepositoryIMPL @Inject constructor(
    private val api: ApiRepository
): ProductsRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getProductsList(): Flow<Resource<List<Product>>> {
        return flow {
            val productsFromApi = try {
                api.getProductsList()
            }catch (ex: IOException){
                ex.printStackTrace()
                emit(Resource.Failure(ex))
                return@flow
            }catch (ex: HttpException){
                ex.printStackTrace()
                emit(Resource.Failure(ex))
                return@flow
            }catch (ex: Exception){
                ex.printStackTrace()
                emit(Resource.Failure(ex))
                return@flow
            }

            emit(Resource.Succes(productsFromApi.products))
        }
    }
}