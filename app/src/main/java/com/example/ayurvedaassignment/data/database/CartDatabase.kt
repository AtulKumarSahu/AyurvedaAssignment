package com.example.ayurvedaassignment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ayurvedaassignment.data.tables.Cart
import com.example.ayurvedaassignment.data.tables.CartDao


@Database(entities = arrayOf(Cart::class), version = 2, exportSchema = false )
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}