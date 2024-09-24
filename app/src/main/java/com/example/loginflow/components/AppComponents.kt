package com.example.loginflow.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.R
import com.example.loginflow.componentShape
import com.example.loginflow.ui.theme.Primary
import com.example.loginflow.ui.theme.Secondary
import com.example.loginflow.ui.theme.TextColor

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),

        style = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center

        ),
        color = colorResource(id = R.color.colorText),

        )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),

        style = TextStyle(
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center

        ),
        color = colorResource(id = R.color.colorText),

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, painterResource: Painter) {
    var textValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textValue,
        onValueChange = { textValue = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            focusedTextColor = TextColor
        ),
        singleLine = true,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clip(componentShape.small),

        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = ""
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(labelValue: String, painterResource: Painter) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    val controller = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = password,
        onValueChange = { value -> password = value },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            focusedTextColor = TextColor
        ),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clip(componentShape.small),

        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardActions = KeyboardActions(onDone = { controller?.hide() }),
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = ""
            )
        },
        trailingIcon = {

            val imageIcon = if (passwordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible) {
                "hide password"
            } else {
                "show password"
            }
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = imageIcon, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()

    )
}

@Composable
fun CheckboxComponent(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf<Boolean>(false)
        }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value != checkedState.value })
        ClikableTextComponent(value = value, onTextSelected)

    }

}


@Composable
fun ClikableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialTxt = "By continuing you accept"
    val privasyPolicyTxt = "Privacy Policy"

    val andTxt = " and "
    val termandConditiontxt = "Term of use"


    val annotatedString = buildAnnotatedString {
        append(initialTxt)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privasyPolicyTxt, annotation = privasyPolicyTxt)
            append(privasyPolicyTxt)
        }
        append(andTxt)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termandConditiontxt, annotation = termandConditiontxt)
            append(termandConditiontxt)

        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
            Log.d("ClickableTextComponent", "{$span}")


            if (span.item == termandConditiontxt || span.item == privasyPolicyTxt) {

                onTextSelected(span.item)
            }
        }

    })

}

@Composable
fun ButtonComponent(value: String) {


    Button(
        onClick = { /*TODO*/ }, modifier = Modifier

            .fillMaxWidth()
            .heightIn(48.dp),

        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier

                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value, fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}


@Composable
fun DividerTextComponent() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            thickness = 1.dp,
            color = colorResource(id = R.color.colorGrey)
        )
        Text(modifier = Modifier.padding(8.dp), text = "or", fontSize = 18.sp, color = TextColor)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            thickness = 1.dp,
            color = colorResource(id = R.color.colorGrey)
        )
    }
}


@Composable
fun ClikableLoginTextComponent(onTextSelected: (String) -> Unit) {
    val initialtxt = "Already have an Account?"
    val login = "Login"

    val annotatedString = buildAnnotatedString {
        append(initialtxt)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = login, annotation = login)
            append(login)
        }

    }

    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),

        style = TextStyle(
            fontSize = 21.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center

        ),
        text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->


                if (span.item == login) {

                    onTextSelected(span.item)
                }
            }

        })
}