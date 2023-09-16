package com.example.littlelemonfinalapp.panels

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemonfinalapp.DestinationImp
import com.example.littlelemonfinalapp.MainActivity
import com.example.littlelemonfinalapp.R
import com.example.littlelemonfinalapp.ui.theme.LittleLemonColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(navHostController: NavHostController) {
    
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var registrationMessage by remember {
        mutableStateOf<String?>(null)
    }

    val context = LocalContext.current

    val scrollState = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(state = scrollState)
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


    /*    val snackBarHostState = remember {
            SnackbarHostState()
        }
        val scope = rememberCoroutineScope()*/
        Button(
            onClick = {
                if (validateInputFields(firstName, lastName, email)) {
                    // Save user data in SharedPreferences
                    storeUserData(firstName, lastName, email, context = context)
                    registrationMessage = "Registration successful!"

                    /*scope.launch {
                        delay(5000L)
                        snackBarHostState.showSnackbar(message = registrationMessage!!, duration = SnackbarDuration.Long)
                    }*/

                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()

                    // Set the onboarding completed flag
                    (context as? MainActivity)?.setOnboardingCompletedFlag()

                    navHostController.navigate(DestinationImp.home)
                } else {
                    registrationMessage = "Registration unsuccessful. Please enter all data."

                    /*scope.launch {
                        delay(5000L)
                        snackBarHostState.showSnackbar(message = registrationMessage!!, duration = SnackbarDuration.Long)
                    }*/
                    Toast.makeText(context, "Registration unsuccessful. Please enter all data.", Toast.LENGTH_SHORT).show()

                }
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

        /*// Display the Snackbar when registrationMessage is not null
        registrationMessage?.let { message ->
            RegistrationSnackbar(message = message) {
                // Reset the registrationMessage when Snackbar is dismissed
                registrationMessage = null
            }
        }*/
    }

}


// Function to validate input fields
private fun validateInputFields(firstName: String, lastName: String, email: String): Boolean {
    return firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()
}


// Define constants for the SharedPreferences keys
private const val FIRST_NAME_KEY = "first_name"
private const val LAST_NAME_KEY = "last_name"
private const val EMAIL_KEY = "email"

// Function to save user data in SharedPreferences
fun storeUserData(firstName: String, lastName: String, email: String, context: Context) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedPreferences.edit()

    editor.putString(FIRST_NAME_KEY, firstName)
    editor.putString(LAST_NAME_KEY, lastName)
    editor.putString(EMAIL_KEY, email)

    editor.apply()
}




@Composable
fun RegistrationSnackbar(
    message: String?,
    onDismiss: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    SnackbarHost(
        hostState = snackbarHostState,
//        modifier = Modifier.fillMaxWidth()
    ) {
        message?.let {
            Snackbar(
                action = {
                    TextButton(onClick = {
                        snackbarHostState.currentSnackbarData?.dismiss()
                        onDismiss()
                    }) {
                        Text("Dismiss")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp) // Add padding to separate the message and dismiss action
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp), // Add end padding to separate message and dismiss
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = it)
                    Spacer(modifier = Modifier.width(8.dp)) // Add spacer to separate message and dismiss
                }
            }
        }
    }

    LaunchedEffect(message) {
        message?.let {
            snackbarHostState.showSnackbar(message)
        }
    }
}




@Preview(showSystemUi = true)
@Composable
fun PreviewOnboarding() {
//    Onboarding()
}