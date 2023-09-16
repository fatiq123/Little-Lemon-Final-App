package com.example.littlelemonfinalapp.panels

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LowerPanel(navController: NavController, dishes: List<Dish> = listOf()) {
    Column {
        LazyRow {
            items(Categories) { category ->
                MenuCategory(category = category)
            }
        }
        Divider(
            modifier = Modifier.padding(8.dp),
            color = Color(0xFFF4CE14),
            thickness = 1.dp
        )
        LazyColumn {
            itemsIndexed(dishes) { _, dish ->
                MenuDish(dish = dish, navController = navController)
            }
        }
    }
}

@Composable
fun MenuDish(dish: Dish, navController: NavController? = null) {
    Card(
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.clickable {
            navController?.navigate(DishDetails.route + "/${dish.id}")
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = dish.name, fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF495E57)
                )
                Text(
                    text = dish.description,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(
                    text = "$" + dish.price,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = "",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = Color(0xFFF4CE14),
        thickness = 1.dp,
    )
}