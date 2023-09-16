package com.example.littlelemonfinalapp.panels

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.room.Room
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemonfinalapp.DestinationImp
import com.example.littlelemonfinalapp.R
import com.example.littlelemonfinalapp.database.Database
import com.example.littlelemonfinalapp.database.Model
import com.example.littlelemonfinalapp.ui.theme.LittleLemonColor
import com.example.littlelemonfinalapp.viewmodels.MainViewModel

/*
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
*/


//

/*@Composable
fun MenuItems(menu: List<Model>?) {
    Column {
        menu?.forEach { menu ->
            MenuItem(menu = menu)
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(menu: Model) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = menu.title,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "$${menu.price}",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = menu.description,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        val url =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
        GlideImage(
            model = menu.image,
            contentScale = ContentScale.Crop,
            contentDescription = "Menu Images"
        )

    }
}


@Composable
fun MenuScreen() {

    val context = LocalContext.current
    val database by lazy {
        Room.databaseBuilder(
            context,
            Database::class.java,
            "app_database"
        ).build()
    }

    val databaseMenuItems by database.appDao().getAllData()
        .observeAsState()    // to retrieve data from database


    MenuItems(menu = databaseMenuItems)
}*/


//

@Composable
fun HomeScreen(navController: NavController) {

    val viewModel: MainViewModel = viewModel()
    val databaseMenuItems = viewModel.getAllDatabaseMenuItems().observeAsState(emptyList()).value
    val searchPhrase = remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        viewModel.fetchMenuDataIfNeeded()
    }



    Column() {
        Header(navController)
        UpperPanel() {
            searchPhrase.value = it
        }
        LowerPanel(
            databaseMenuItems = databaseMenuItems,
            search = searchPhrase,
            /*navController = navController*/
        )
    }


}

@Composable
fun Header(navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(50.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth(0.65f)
        )

        Box(modifier = Modifier
            .size(50.dp)
            .clickable {
                navController.navigate(DestinationImp.profile)
            }
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile Icon",
                tint = LittleLemonColor.green,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 2.dp)
                    .clip(CircleShape),
            )
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpperPanel(search: (parameter: String) -> Unit) {
    val searchPhrase = remember {
        mutableStateOf("")
    }

    Log.d("AAAAA", "UpperPanel: ${searchPhrase.value}")
    Column(
        modifier = Modifier
            .background(LittleLemonColor.green)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = "Little Lemon",
            style = MaterialTheme.typography.headlineLarge,
            color = LittleLemonColor.yellow,
//            fontFamily = FontFamily(Font(R.font.markazi_text))
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "New York",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
//            fontFamily = FontFamily(Font(R.font.markazi_text))
            fontFamily = FontFamily.Serif
        )

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with  a modern twist. Turkish, Italian, Indian and chinese recipes are our speciality.",
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 15.dp, bottom = 10.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = FontFamily(Font(R.font.karla))
            )
            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Hero Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        Spacer(modifier = Modifier.size(10.dp))
        OutlinedTextField(
            value = searchPhrase.value,
            onValueChange = {
                searchPhrase.value = it
                search(searchPhrase.value)
            },
            placeholder = {
                Text(text = "Enter Search Phrase")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            modifier = Modifier.fillMaxWidth()
        )

    }

}

@Composable
fun LowerPanel(
    databaseMenuItems: List<Model>,
    search: MutableState<String>,
    /*navController: NavController,*/
) {
    val categories = databaseMenuItems.map {
        it.category.replaceFirstChar { character ->
            character.uppercase()
        }
    }.toSet()


    val selectedCategory = remember {
        mutableStateOf("")
    }


    val items = if (search.value == "") {
        databaseMenuItems

    } else {
        databaseMenuItems.filter {
            it.title.contains(search.value, ignoreCase = true)

        }


    }


    val filteredItems = if (selectedCategory.value == "" || selectedCategory.value == "all") {
        items
    } else {
        items.filter {
            it.category.contains(selectedCategory.value, ignoreCase = true)
        }
    }


    Column {
        MenuCategories(categories) {
            selectedCategory.value = it
        }
        Spacer(modifier = Modifier.size(2.dp))
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (item in filteredItems) {
                MenuItem(item = item/*, navController = navController*/)
            }
        }

    }
}


@Composable
fun MenuCategories(categories: Set<String>, categoryLambda: (sel: String) -> Unit) {
    val cat = remember {
        mutableStateOf("")
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
            Text(
                text = "ORDER FOR DELIVERY",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                CategoryButton(category = "All") {
                    cat.value = it.lowercase()
                    categoryLambda(it.lowercase())
                }

                for (category in categories) {
                    CategoryButton(category = category) {
                        cat.value = it
                        categoryLambda(it)
                    }

                }

            }
        }
    }
}

@Composable
fun CategoryButton(category: String, selectedCategory: (sel: String) -> Unit) {
    val isClicked = remember {
        mutableStateOf(false)
    }
    Button(
        onClick = {
            isClicked.value = !isClicked.value
            selectedCategory(category)

        },
        colors = ButtonDefaults.buttonColors(
            contentColor = LittleLemonColor.green,
            containerColor = LittleLemonColor.cloud
        )
    ) {
        Text(text = category, fontFamily = FontFamily.Serif)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(item: Model, /*navController: NavController*/) {

    val itemDescription = if (item.description.length > 100) {
        item.description.substring(0, 100) + ". . ."
    } else {
        item.description
    }

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .clickable {
                // TODO when user clicks on specific card
//                navController.navigate(DestinationImp.detail + "/${item.id}")
            }) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier.fillMaxWidth(0.7f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = itemDescription,
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = "$ ${item.price}",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )

            }

            GlideImage(
                model = item.image,
                contentDescription = "",
                Modifier.size(100.dp, 100.dp),
                contentScale = ContentScale.Crop
            )
        }
    }

}