package com.hinduverse.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hinduverse.myapplication.Activity.HomeActivity
import com.hinduverse.myapplication.ui.theme.MyApplicationTheme
import com.hinduverse.myapplication.ui.theme.Purple80
import com.hinduverse.myapplication.ui.theme.PurpleGrey80
import com.hinduverse.myapplication.ui.theme.grey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                LoginScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    val loginViewModel = LoginViewModel()
    var userName by remember { mutableStateOf("") }
    var password  by remember {
        mutableStateOf("")
    }
    var loginResult by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(grey)) {

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(150.dp)
                .offset(x = 10.dp))


        Box(modifier = Modifier.offset(x = 25.dp, y = (-50).dp)) {
            Image(painter = painterResource(id = R.drawable.login_page_img)
                , contentDescription = "login image",
                modifier = Modifier
                    .size(400.dp)
                    )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()

                .background(Purple80, shape = RoundedCornerShape(16.dp))
        ) {

        }


        TextField(
            value = userName,
            onValueChange = {  },
            label = { Text(text = "+91", color = Color.Black) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, start = 20.dp, end = 20.dp),

            colors = TextFieldDefaults.textFieldColors(
                containerColor = PurpleGrey80, // Background color of the TextField
                focusedIndicatorColor = Color.Transparent, // Hide the indicator (optional)
                unfocusedIndicatorColor = Color.Transparent // Hide the indicator (optional)
            ),
            shape = RoundedCornerShape(22.dp)
        )

        val context = LocalContext.current

        Button(onClick = { context.startActivity(Intent(context,HomeActivity::class.java)) },
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple80, shape = RoundedCornerShape(22.dp)),
            colors = ButtonDefaults.buttonColors(Purple80),
            ){
            Text(text = "Login", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Normal)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        LoginScreen()
    }
}