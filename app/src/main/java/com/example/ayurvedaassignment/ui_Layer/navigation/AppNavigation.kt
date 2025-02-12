package com.example.ayurvedaassignment.ui_Layer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ayurvedaassignment.ui_Layer.screens.CartScreen
import com.example.ayurvedaassignment.ui_Layer.screens.Product
import com.example.ayurvedaassignment.ui_Layer.screens.ProductScreen
import kotlinx.serialization.Serializable

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
   NavHost(navController = navController, startDestination = ProductScreen) {
       composable<ProductScreen> {
           ProductScreen(navController)
       }
       composable<CartScreen> {
           CartScreen()
       }
   }
}

@Serializable
object ProductScreen

@Serializable
object CartScreen