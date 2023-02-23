package com.example.kattabozortestlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.example.data.models.ProductEntity
import com.example.kattabozortestlist.databinding.ProductItemBinding


class ProductAdapter :
   ListAdapter<ProductEntity, ProductAdapter.ProductViewHolder>(DiffCallback()) {

   class ProductViewHolder(
      private val binding: ProductItemBinding
   ) : RecyclerView.ViewHolder(binding.root) {
      fun onBind(item: ProductEntity) {
         var requestOptions = RequestOptions()
         requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(20))
         Glide.with(itemView.context)
            .load(item.imageUrl)
            .transition(withCrossFade())
            .apply(requestOptions)
            .into(binding.imageView)

         binding.tvName.text = item.name
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
      ProductViewHolder(
         ProductItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
         )
      )

   override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
      val item = getItem(position)
      holder.onBind(item)
   }
}

class DiffCallback : DiffUtil.ItemCallback<ProductEntity>() {

   override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity) =
      oldItem.id == newItem.id

   override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity) =
      oldItem == newItem

}