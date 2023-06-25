package com.example.nweavetask.ui

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Products
import com.example.domain.usecases.AllProductsFromDB
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
    private val allProductsFromDB: AllProductsFromDB,
    private val gson: Gson
) : ViewModel() {
    private val _products: MutableStateFlow<Products?> = MutableStateFlow(null)
    val products: StateFlow<Products?> = _products
    fun getProducts(context: Context) {
        viewModelScope.launch {

                if (isConnectingToInternet(context)) {
                    try {
                    _products.value = getAllProductsUseCase()
                    allProductsFromDB.insertProductsToLocal(_products.value!!.map {
                        responseToModel(it)
                    })
                } catch (e: Exception) {
                        Log.e("TAG", "getProducts: products faaileddd ${e.message}")
                        return@launch
                    }
                }else {
                    if (allProductsFromDB.tableSize() == 0) {
                        Toast.makeText(
                            context,
                            "Can't Load Products please check internet",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e("TAG", "getProducts: cant load", )
                        Log.e("TAG", "getProducts: cant load${allProductsFromDB.getProductsFromLocal()}", )
                    } else {
                            _products.value = mapProductModelListToProducts(allProductsFromDB.getProductsFromLocal())
                    }
                }
            }
        }

    fun getCurrentProduct(index: Int): String {
        return gson.toJson(products.value?.get(index) ?: "")
    }

    fun isConnectingToInternet(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting
    }

}