package com.example.littlelemonfinalapp.panels

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemonfinalapp.R
import com.example.littlelemonfinalapp.database.Model
import com.example.littlelemonfinalapp.ui.theme.LittleLemonColor
import com.example.littlelemonfinalapp.viewmodels.MainViewModel

/*@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DishDetails(navController: NavController ,model: Model) {
    val context = LocalContext.current.applicationContext
//    val dish = requireNotNull(DishRepository.getDish(id = id))
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
    ) {
//        TopAppBar()   TODO top appbar here if needed
       *//* Image(
            painter = painterResource(id = model.image),
            contentDescription = "Dish Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )*//*
        GlideImage(
            model = model.image,
            contentDescription = "Menu Dish Image",
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )



        Text(text = model.title, fontSize = 26.sp, color = Color(0xFF495E57))
        Text(text = model.description, color = Color(0xFF495E57))
        Counter()
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Your ${model.title} order is received for $${model.price} dollars",
                    Toast.LENGTH_SHORT
                ).show()
            },
            shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4CE14),
                contentColor = Color(0xFF495E57)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(id = R.string.add_for) + " $${model.price}",
                textAlign = TextAlign.Center
            )
        }
    }
}*/




//

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DishDetails(navController: NavController, itemId: String, viewModel: MainViewModel) {
    // Retrieve the specific item's details using the itemId
    val modelData by viewModel.getAllDatabaseMenuItems().observeAsState()
    val item = modelData?.find { it.id == itemId.toInt() }

    // Check if the item is found
    if (item != null) {
        val context = LocalContext.current.applicationContext

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        ) {
            // Display the item details
            GlideImage(
                model = item.image,
                contentDescription = "Menu Dish Image",
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Text(text = item.title, fontSize = 26.sp, color = Color(0xFF495E57))
            Text(text = item.description, color = Color(0xFF495E57))
            Counter()
            Button(
                onClick = {
                    Toast.makeText(
                        context,
                        "Your ${item.title} order is received for $${item.price} dollars",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF4CE14),
                    contentColor = Color(0xFF495E57)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.add_for) + " $${item.price}",
                    textAlign = TextAlign.Center
                )
            }
        }
    } else {
        // Handle the case where the item with the specified ID is not found
        Text(text = "Item not found")
    }
}




@Composable
fun Counter() {
    var counter by remember {
        mutableIntStateOf(1)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(
            onClick = {
                counter--
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4CE14),
                contentColor = Color(0xFF495E57)
            )
        ) {
            Text(text = "−", style = MaterialTheme.typography.bodySmall)
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF495E57)
        )
        TextButton(
            onClick = {
                counter++
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4CE14),
                contentColor = Color(0xFF495E57)
            )
        ) {
            Text(text = "+", style = MaterialTheme.typography.bodySmall)
        }
    }
}
