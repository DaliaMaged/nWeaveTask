package com.example.nweavetask.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Products
import com.example.domain.usecases.GetAllProductsUseCase
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsScreenViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val gson: Gson
    ) : ViewModel() {
    private val _products : MutableStateFlow <Products?> = MutableStateFlow(null)
    val products : StateFlow<Products?> = _products
        fun getProducts(){
            viewModelScope.launch {
                try {
                    _products.value=getAllProductsUseCase()
                }catch (e:Exception){
                    Log.e("TAG", "getProducts: products faaileddd ${e.message}", )
                    return@launch
                }
            }
        }
    fun getCurrentProduct(index:Int):String{
        return gson.toJson(products.value?.get(index) ?: "")
    }
}