package com.example.data

import com.example.data.models.ProductEntity
import kotlinx.coroutines.flow.Flow

interface Repository {

   /**
   fetch offers without any args
   returns [ProductEntity] as List
    */
   fun getOffers(): Flow<List<ProductEntity>>
}