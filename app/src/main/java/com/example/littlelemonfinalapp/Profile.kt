package com.example.littlelemonfinalapp

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.littlelemonfinalapp.database.Database
import com.example.littlelemonfinalapp.network.Menu
import com.example.littlelemonfinalapp.ui.theme.LittleLemonColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController) {

    val userData = getUserData(LocalContext.current)
    val context = LocalContext.current

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

        Spacer(modifier = Modifier.height(30.dp))
        // Display user registration information using non-editable text fields
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = TextFieldValue(userData.firstName),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 10.dp),
                enabled = false // Set it to false to make it non-editable
            )

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = TextFieldValue(userData.lastName),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 10.dp),
                enabled = false
            )

            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = TextFieldValue(userData.email),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 10.dp),
                enabled = false
            )

            Spacer(modifier = Modifier.height(80.dp))


            Button(
                onClick = {
                    // Clear user data from SharedPreferences
                    clearUserData(context = context)

                    // Navigate to the Onboarding screen
                    navController.navigate(DestinationImp.onBoarding)
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
                    text = "Log Out", textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }


    }
}

/* to show the data entered by user in fields using shared preferences*/
data class UserData(val firstName: String, val lastName: String, val email: String)

fun getUserData(context: Context): UserData {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("first_name", "") ?: ""
    val lastName = sharedPreferences.getString("last_name", "") ?: ""
    val email = sharedPreferences.getString("email", "") ?: ""

    return UserData(firstName, lastName, email)
}


fun clearUserData(context: Context) {
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedPreferences.edit()

    // Clear all data by calling clear()
    editor.clear()

    // Apply the changes
    editor.apply()
}





@Preview
@Composable
fun PreviewProfile() {
//    Profile()
}