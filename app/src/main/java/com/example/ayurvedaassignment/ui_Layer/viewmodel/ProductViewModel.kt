package com.example.ayurvedaassignment.ui_Layer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayurvedaassignment.data.repo.Repo
import com.example.ayurvedaassignment.data.tables.Cart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(val repo: Repo):ViewModel() {

    private val _cartList= MutableStateFlow<List<Cart>>(emptyList())
    val cartList=_cartList.asStateFlow()

    init {
        viewModelScope.launch {
            repo.getCart().collect{
                _cartList.value=it
            }
        }
            }



//   private _cartList= MutableStateFlow<List<Cart>>(emptyList())
//    val cartList=_cartList.asStateFlow()
//
//
//    init {
//        viewModelScope.launch {
//            repo.getCart().collect{
//                _cartList.value=it
//            }
//        }
//    }




    fun addToCart(name:String,price:Double,quantity:Int,image:Int){
        viewModelScope.launch {
            repo.upsertCart(Cart(name = name, price = price, quantity = quantity, image = image))

        }
    }
}