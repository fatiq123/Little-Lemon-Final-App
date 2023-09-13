package com.example.littlelemonfinalapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding() {
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Let's get to know you.", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Personal information.", textAlign = TextAlign.Start, fontWeight = FontWeight.Bold, )

        TextField(
            value = firstName,
            onValueChange = {
                firstName = it
            },
            label = { Text(text = "First name") },
            placeholder = { Text(text = "john") },
        )
        TextField(
            value = lastName,
            onValueChange = {
                lastName = it
            },
            label = { Text(text = "Last name") },
            placeholder = { Text(text = "doe") },
        )
        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "johndoe@gmail.com") },
        )

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            shape = RoundedCornerShape(size = 5.dp)
        ) {
            Text(
                text = "Register",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Black
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboarding() {
    Onboarding()
}