package com.example.littlelemonfinalapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonfinalapp.ui.theme.LittleLemonColor

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

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .requiredHeight(100.dp)
                .requiredWidth(450.dp)
                .background(color = LittleLemonColor.green)
        ) {
            Text(
                text = "Let's get to know you",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier.fillMaxWidth(1f)) {
            Text(
                text = "Personal information",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .padding(start = 25.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = firstName,
            onValueChange = {
                firstName = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            label = { Text(text = "First name") },
            placeholder = { Text(text = "john") },
            shape = RoundedCornerShape(size = 10.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                containerColor = Color(0xFFE5EAF0),
                placeholderColor = Color.Transparent
            ),

            )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it
            },
            label = { Text(text = "Last name") },
            placeholder = { Text(text = "doe") },
            shape = RoundedCornerShape(size = 10.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                containerColor = Color(0xFFE5EAF0),
                placeholderColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "johndoe@gmail.com") },
            shape = RoundedCornerShape(size = 10.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                containerColor = Color(0xFFE5EAF0),
                placeholderColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),

            )

        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                // TODO add functionality here
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = LittleLemonColor.yellow
            )
        ) {
            Text(
                text = "Register",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboarding() {
    Onboarding()
}