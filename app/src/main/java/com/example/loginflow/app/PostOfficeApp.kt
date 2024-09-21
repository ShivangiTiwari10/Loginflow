package com.example.loginflow.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.loginflow.R
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.screens.SignUpScreen

@Composable
fun PostOfficeApp(){
Surface(
    modifier = Modifier.fillMaxSize()
    ,
    color = Color.White

) {
    SignUpScreen()
}
}