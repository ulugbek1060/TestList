package com.example.data.models

import com.example.remote.models.Offer

data class ProductEntity(
   val attributes: List<AttributeItem>,
   val brand: String,
   val category: String,
   val id: Int,
   val imageUrl: String,
   val merchant: String,
   val name: String
) {
   companion object {
      fun map(offer: com.example.remote.models.Offer): ProductEntity {
         return ProductEntity(
            attributes = offer.attributes.map { AttributeItem(name = it.name, value = it.value) },
            brand = offer.brand,
            category = offer.category,
            id = offer.id,
            imageUrl = offer.image.url,
            merchant = offer.merchant,
            name = offer.name
         )
      }
   }
}