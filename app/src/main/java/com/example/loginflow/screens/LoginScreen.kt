package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.ClikableLoginTextComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextField
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordTextFieldComponent
import com.example.loginflow.components.underLinedTextComponent

@Composable
fun LoginScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp)
    ) {

        Column {
            NormalTextComponent(stringResource(id = R.string.top_txt))


            HeadingTextComponent(stringResource(id = R.string.welcome))

            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                "Email",
                painterResource = painterResource(id = R.drawable.baseline_mail_outline_24)
            )


            PasswordTextFieldComponent(
                "Password",
                painterResource = painterResource(id = R.drawable.lock)
            )

            Spacer(modifier = Modifier.height(40.dp))
            underLinedTextComponent(stringResource(id = R.string.forgotPassword))

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            ClikableLoginTextComponent(TryintoLogin = false,onTextSelected ={} )

        }


    }
}

@Preview
@Composable
fun defaultPrev() {
    LoginScreen()
}