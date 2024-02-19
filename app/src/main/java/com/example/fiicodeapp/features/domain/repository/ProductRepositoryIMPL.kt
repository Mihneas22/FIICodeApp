package com.example.fiicodeapp.features.domain.repository

import com.example.fiicodeapp.features.data.repository.ApiRepository
import com.example.fiicodeapp.features.data.repository.ProductRepository
import com.example.fiicodeapp.features.data.util.Resource
import com.example.fiicodeapp.features.domain.models.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductRepositoryIMPL @Inject constructor(
    private val api: ApiRepository
): ProductRepository {
    override suspend fun getProductList(): Flow<Resource<List<Product>>> {
        return flow {
            val productsFromApi = try {
                api.getFoods()
            }catch (ex: IOException){
                ex.printStackTrace()
                emit(Resource.Failure(ex))
                return@flow
            }catch (ex: Exception){
                ex.printStackTrace()
                emit(Resource.Failure(ex))
                return@flow
            }
            Resource.Succes(productsFromApi.products)
        }
    }
}