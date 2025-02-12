package com.example.ayurvedaassignment.data.tables

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class Cart(
    @PrimaryKey(autoGenerate = true)val id:Int?=null,
    val name:String,
    val price:Double,
    val quantity:Int,
    val image:Int
)