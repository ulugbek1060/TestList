package com.example.remote

import com.example.remote.models.ProductsResponse
import retrofit2.http.GET

interface KattaBozorApi {
   @GET("/hh/test/api/v1/offers")
   suspend fun getOffers(): ProductsResponse
}