package com.example.nweavetask.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.ProductResponse
import com.example.domain.usecases.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsScreenViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
    ) : ViewModel() {
    private val _products : MutableStateFlow<ProductResponse?> = MutableStateFlow(null)
    val products : StateFlow<ProductResponse?> = _products
        fun getProducts(){
            viewModelScope.launch {
                try {
                    getAllProductsUseCase()
                }catch (e:Exception){
                    Log.e("TAG", "getProducts: products faaileddd ${e.message}", )
                }
                
            }
        }
}