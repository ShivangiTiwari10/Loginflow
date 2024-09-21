package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.R
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextField
import com.example.loginflow.components.NormalTextComponent

@Composable
fun SignUpScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .background(Color.White)
        ,

        ) {
        Column {
            NormalTextComponent(value = stringResource(id = R.string.top_txt))

            HeadingTextComponent(value = stringResource(id = R.string.heading))

            MyTextField("First Name ")

            Row(modifier = Modifier.padding(10.dp)) {
                Checkbox(checked = false, onCheckedChange = null)
                Text(text = stringResource(id = R.string.description), fontSize = 15.sp)
            }

            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(10.dp)

            ) {
                colorResource(id = R.color.colorSecondary)
                Text("Register")
            }

            NormalTextComponent(value = stringResource(id = R.string.last_text))
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}