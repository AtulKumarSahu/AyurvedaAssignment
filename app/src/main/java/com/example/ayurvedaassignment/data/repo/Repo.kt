package com.example.ayurvedaassignment.data.repo

import com.example.ayurvedaassignment.data.database.CartDatabase
import com.example.ayurvedaassignment.data.tables.Cart
import kotlinx.coroutines.flow.Flow

class Repo(val database: CartDatabase) {

    suspend fun upsertCart(cart: Cart) {
         database.cartDao().upsertCart(cart)
    }
    suspend fun deleteCart(cart: Cart) {
        database.cartDao().deleteCart(cart)
    }
    fun getCart(): Flow<List<Cart>> {
        return database.cartDao().getCart()

    }

}