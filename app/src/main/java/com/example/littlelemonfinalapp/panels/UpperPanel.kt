package com.example.littlelemonfinalapp.panels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.littlelemonfinalapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpperPanel(navController: NavController) {

    var search by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF495E57))
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    )
    {
        Text(
            text = stringResource(id = R.string.title),
            fontFamily = FontFamily(Font(R.font.markazi_text)),
            fontSize = 52.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF4CE14)
        )
        Text(
            text = stringResource(id = R.string.location),
            fontSize = 38.sp,
            fontFamily = FontFamily(Font(R.font.markazi_text)),
            color = Color(0xFFEDEFEE)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                fontFamily = FontFamily(Font(R.font.karla)),
                color = Color(0xFFEDEFEE),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(0.6f)
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier.clip(
                    RoundedCornerShape(10.dp)
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = search,
            onValueChange = {
                search = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
                .clickable {
                    // TODO here for search phrase
                },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "App Logo")
            },
            placeholder = { Text(text = "Enter search phrase") },
            colors = TextFieldDefaults.textFieldColors(),
            shape = RoundedCornerShape(size = 8.dp),

            )
    }

}