package com.example.remote.models

data class Offer(
   val attributes: List<Attribute>,
   val brand: String,
   val category: String,
   val id: Int,
   val image: Image,
   val merchant: String,
   val name: String
)