package com.example.ayurvedaassignment.ui_Layer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ayurvedaassignment.R
import com.example.ayurvedaassignment.data.tables.Cart
import com.example.ayurvedaassignment.ui_Layer.viewmodel.ProductViewModel

@Composable
fun CartScreen(viewmodel: ProductViewModel = hiltViewModel()) {


     Column(
         modifier = Modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         val cartList= viewmodel.cartList.collectAsState()

         LazyColumn {
             items(cartList.value){
                 cartCard(cartList = it)

             }
         }

     }

}

@Composable
fun cartCard(
    cartList: Cart
) {
    var quntity by remember { mutableStateOf(1) }

    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))

        ) {
            Card(
                modifier = Modifier.weight(2f),
            ) {
                Image(
                    painterResource(id = cartList.image),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(2.dp)
                        .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(3f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {

                Text(text = cartList.name)
                Text(text = "₹:${cartList.price*quntity}")
                Text(text = "Quantity:${quntity}")






                Row(
                    modifier = Modifier
                        .background(color = Color.Blue, shape = RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))

                ) {
                    IconButton(
                        onClick = {
                            if (quntity >= 2) {
                                quntity--
                            }
                        },
                        modifier = Modifier
                            .background(color = Color.Red)
                            .weight(1f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_horizontal_rule_24),
                            contentDescription = "add"
                        )
                    }
                    Text(
                        text = "${quntity}", modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    IconButton(
                        onClick = { quntity++ },
                        modifier = Modifier
                            .background(color = Color.Green)
                            .weight(1f)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "add")
                    }
                }

            }
        }


    }


}