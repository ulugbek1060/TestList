package com.example.data

import com.example.data.models.ProductEntity
import kotlinx.coroutines.flow.Flow

interface Repository {

   /**
   fetch offers without args any
   returns [OffersResponse]
    */
   fun getOffers(): Flow<List<ProductEntity>>
}