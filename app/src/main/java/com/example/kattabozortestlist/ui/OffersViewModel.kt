package com.example.kattabozortestlist.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Repository
import com.example.data.models.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OffersViewModel @Inject constructor(
   private val offersRepository: Repository
) : ViewModel() {
   private val _offers = MutableLiveData<List<ProductEntity>>(listOf())
   val offers: LiveData<List<ProductEntity>> = _offers

   private val TAG = this.javaClass.simpleName;

   init {
      viewModelScope.launch {
         offersRepository.getOffers()
            .catch {
               Log.d(TAG, "Error: $it")
            }
            .collectLatest { list ->
               _offers.value = list
            }

      }
   }
}