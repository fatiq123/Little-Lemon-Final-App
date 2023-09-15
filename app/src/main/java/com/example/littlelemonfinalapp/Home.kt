package com.example.littlelemonfinalapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Logo image in the center
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(top = 20.dp)
        )

        // Header with profile image (button to open Profile screen)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(8.dp)
        ) {
            // Profile image (clickable)
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null, // You can provide a description if needed
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.CenterEnd)
                    .clickable {
                        navController.navigate(DestinationImp.profile)
                    }
            )
        }
    }
}

@Preview
@Composable
fun PreviewHome() {
//    Home()
}