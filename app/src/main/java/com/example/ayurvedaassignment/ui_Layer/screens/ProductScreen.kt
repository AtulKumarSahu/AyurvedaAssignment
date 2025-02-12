package com.example.ayurvedaassignment.ui_Layer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ayurvedaassignment.R
import com.example.ayurvedaassignment.ui_Layer.navigation.CartScreen
import com.example.ayurvedaassignment.ui_Layer.viewmodel.ProductViewModel
import kotlinx.serialization.Serializable

@Composable
fun ProductScreen(navController: NavController,viewModel: ProductViewModel= hiltViewModel()) {
    val cartList= viewModel.cartList.collectAsState()

    val productList = listOf(

        Product("Product 3", 30.0, R.drawable.ic_launcher_background),
        Product("Product 4", 40.0, R.drawable.ic_launcher_background),
        Product("Product 5", 50.0, R.drawable.ic_launcher_background),
        Product("Product 6", 60.0, R.drawable.ic_launcher_background),
        Product("Product 7", 70.0, R.drawable.ic_launcher_background),
        Product("Product 8", 80.0, R.drawable.ic_launcher_background),
        Product("Product 9", 90.0, R.drawable.ic_launcher_background),
        Product("Product 10", 100.0, R.drawable.ic_launcher_background),
        Product("Product 11", 110.0, R.drawable.ic_launcher_background),
        Product("Product 12", 120.0, R.drawable.ic_launcher_background),
        Product("Product 13", 130.0, R.drawable.ic_launcher_background),
        Product("Product 14", 140.0, R.drawable.ic_launcher_background),
        Product("Product 15", 150.0, R.drawable.ic_launcher_background),
        Product("Product 16", 160.0, R.drawable.ic_launcher_background),
        Product("Product 17", 170.0, R.drawable.ic_launcher_background),
        Product("Product 18", 180.0, R.drawable.ic_launcher_background),
        Product("Product 19", 190.0, R.drawable.ic_launcher_background),
        Product("Product 20", 200.0, R.drawable.ic_launcher_background),
        )
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Product Screen",
                fontSize = 20.sp
            )
            Box(
                modifier = Modifier.padding(2.dp)
            ) {
                IconButton(onClick = {navController.navigate(CartScreen) }) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Cart",
                        modifier = Modifier
                            .size(30.dp)
                            .background(shape = CircleShape, color = Color.White)
                    )
                }
                Text(
                    text = if(cartList.value.size==0){""}else{"${cartList.value.size}"},
                    color = Color.Red,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .offset(x = 30.dp, y = (-2).dp)
                )
            }
        }

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(productList){
                productCard(product = it,viewModel = viewModel)
            }
        }

    }
}

    @Composable
    fun productCard(
        product: Product,
        viewModel: ProductViewModel
    ) {
        Card(onClick = {},
            modifier = Modifier.padding(2.dp)) {
            Column(
                modifier = Modifier.fillMaxSize().padding(8.dp),
            ) {
            Image(imageVector = ImageVector.vectorResource(id = product.image), contentDescription = product.name
            , modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop)
            Text(text = product.name,fontWeight = FontWeight.W400, fontSize = 15.sp)
            Text(text = "₹:${product.price}",fontWeight = FontWeight.W600, fontSize = 15.sp)

                Button(onClick = {
                    viewModel.addToCart(product.name,product.price,1,product.image)
                }) {
                    Text(text = "Add to Cart")
                }
        }
        }

    }
//@Preview(showBackground = true)
//@Composable
//fun ProductScreenPreview() {
//    ProductScreen()
//}

@Serializable
data class Product(
    val name: String,
    val price: Double,
    val image: Int
)