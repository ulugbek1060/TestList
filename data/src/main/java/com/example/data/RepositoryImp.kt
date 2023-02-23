package com.example.data

import com.example.data.models.ProductEntity
import com.example.remote.KattaBozorApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImp @Inject constructor(
   private val kattaBozorApi: KattaBozorApi
) : Repository {

   override fun getOffers(): Flow<List<ProductEntity>> = flow {

      val result = kattaBozorApi
         .getOffers()
         .offers
         .map { ProductEntity.map(it) }

      emit(result)

   }.flowOn(Dispatchers.IO)

}