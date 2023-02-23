package com.example.data.source

import com.example.data.source.models.ProductsResponse
import retrofit2.http.GET

interface KattaBozorApi {
   @GET("/hh/test/api/v1/offers")
   suspend fun getOffers(): ProductsResponse
}