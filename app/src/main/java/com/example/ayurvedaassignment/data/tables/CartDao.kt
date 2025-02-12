package com.example.ayurvedaassignment.data.tables

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao{

    @Upsert
    suspend fun upsertCart(cart: Cart)

    @Delete
    suspend fun deleteCart(cart: Cart)

    @Query("SELECT * FROM cart_table")
    fun getCart(): Flow<List<Cart>>



}