package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.CheckboxComponent
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextField
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordTextFieldComponent
import com.example.loginflow.navigation.PostOfficeAppRouter
import com.example.loginflow.navigation.Screen

@Composable
fun SignUpScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .background(Color.White),

        ) {
        Column {
            NormalTextComponent(value = stringResource(id = R.string.top_txt))

            HeadingTextComponent(value = stringResource(id = R.string.heading))

            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                "First Name",
                painterResource = painterResource(id = R.drawable.baseline_person_outline_24)
            )
            MyTextField("Last Name", painterResource(id = R.drawable.baseline_person_outline_24))
            MyTextField(
                "Email",
                painterResource = painterResource(id = R.drawable.baseline_mail_outline_24)
            )

            PasswordTextFieldComponent(
                "Password",
                painterResource = painterResource(id = R.drawable.lock)
            )

            CheckboxComponent(value = stringResource(id = R.string.description), onTextSelected = {

                PostOfficeAppRouter.navigateTo(Screen.termAndConditionScren)

            })

            ButtonComponent(value = stringResource(id = R.string.register))

            NormalTextComponent(value = stringResource(id = R.string.last_text))
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}