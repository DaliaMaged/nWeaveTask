package com.example.nweavetask.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.entities.ProductResponse
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    gson: Gson,
    stateHandle: SavedStateHandle
) : ViewModel() {
    private val _product : MutableStateFlow<ProductResponse?> = MutableStateFlow(null)
    val product : StateFlow<ProductResponse?> = _product

    init {
         val str=stateHandle.get<String>("product")
        _product.value=gson.fromJson(str,ProductResponse::class.java)
    }
}
