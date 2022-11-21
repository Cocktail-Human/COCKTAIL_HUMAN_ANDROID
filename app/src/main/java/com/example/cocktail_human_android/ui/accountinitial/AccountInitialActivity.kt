package com.example.cocktail_human_android.ui.accountinitial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.cocktail_human_android.R
import com.example.cocktail_human_android.ui.compose.appbar.BlendyAppBar
import com.example.cocktail_human_android.ui.compose.button.BlendyButton
import com.example.cocktail_human_android.ui.compose.textfield.BlendyPasswordTextField
import com.example.cocktail_human_android.ui.compose.textfield.BlendyTextField
import com.example.cocktail_human_android.ui.theme.Black
import com.example.cocktail_human_android.ui.theme.BlendyTheme
import com.example.cocktail_human_android.ui.theme.White
import com.example.cocktail_human_android.ui.theme.md_theme_dark_hint
import com.example.cocktail_human_android.ui.theme.md_theme_dark_onButton
import com.example.cocktail_human_android.ui.theme.md_theme_light_hint
import com.example.cocktail_human_android.ui.theme.md_theme_light_onButton

class AccountInitialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlendyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InitialAccountSettingScreen()
                }
            }
        }
    }
}

@Composable
fun InitialAccountSettingScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (appbar, information, newPassword, checkPassword, passwordError, emailAddress, authSend, authNumber, auth, authError, completion) = createRefs()
        val newPasswordState = remember { mutableStateOf("") }
        val checkPasswordState = remember { mutableStateOf("") }
        val emailAddressState = remember { mutableStateOf("") }
        val authNumberState = remember { mutableStateOf("") }
        BlendyAppBar(
            modifier = Modifier
                .constrainAs(appbar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            title = stringResource(id = R.string.account_initial_title),
            contentColor = if (isSystemInDarkTheme()) White else Black
        )
        Text(
            modifier = Modifier
                .constrainAs(information) {
                    top.linkTo(appbar.bottom)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    width = Dimension.fillToConstraints
                },
            text = stringResource(id = R.string.account_initial_information),
            color = if (isSystemInDarkTheme()) md_theme_dark_hint else md_theme_light_hint
        )
        BlendyPasswordTextField(
            value = newPasswordState.value,
            onValueChange = { newPasswordState.value = it },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.account_initial_new_password)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                textColor = if (isSystemInDarkTheme()) md_theme_dark_hint else md_theme_light_hint
            ),
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            modifier = Modifier
                .constrainAs(newPassword) {
                    top.linkTo(information.bottom, 20.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
        BlendyPasswordTextField(
            value = checkPasswordState.value,
            onValueChange = { checkPasswordState.value = it },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.account_initial_check_password)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                textColor = if (isSystemInDarkTheme()) md_theme_dark_hint else md_theme_light_hint
            ),
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            modifier = Modifier
                .constrainAs(checkPassword) {
                    top.linkTo(newPassword.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
        )
        Text(
            text = stringResource(id = R.string.account_initial_password_not_correct),
            color = MaterialTheme.colors.error,
            maxLines = 1,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .constrainAs(passwordError) {
                    top.linkTo(checkPassword.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    width = Dimension.fillToConstraints
                }
        )
        BlendyTextField(
            value = emailAddressState.value,
            onValueChange = { emailAddressState.value = it },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.account_initial_email_address),
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                textColor = if (isSystemInDarkTheme()) md_theme_dark_hint else md_theme_light_hint
            ),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .constrainAs(emailAddress) {
                    top.linkTo(passwordError.bottom, margin = 8.dp)
                    end.linkTo(authSend.start, margin = 15.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
                .height(50.dp)
        )
        Box(
            modifier = Modifier
                .constrainAs(authSend) {
                    top.linkTo(passwordError.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 18.dp)
                }
                .width(102.dp)
                .height(50.dp)
        ) {
            BlendyButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(0.dp, MaterialTheme.colors.primary),
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.05f)
            )
            Text(
                text = stringResource(id = R.string.account_initial_auth_number_send),
                color = if (isSystemInDarkTheme()) md_theme_dark_onButton else md_theme_light_onButton,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )

        }
        BlendyTextField(
            value = authNumberState.value,
            onValueChange = { authNumberState.value = it },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.account_initial_auth_number),
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                textColor = if (isSystemInDarkTheme()) md_theme_dark_hint else md_theme_light_hint
            ),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .constrainAs(authNumber) {
                    top.linkTo(emailAddress.bottom, margin = 8.dp)
                    end.linkTo(auth.start, margin = 15.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
                .height(50.dp)
        )
        Box(
            modifier = Modifier
                .constrainAs(auth) {
                    top.linkTo(authSend.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 18.dp)
                }
                .width(102.dp)
                .height(50.dp)
        ) {
            BlendyButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(0.dp, MaterialTheme.colors.primary),
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.05f)
            )
            Text(
                text = stringResource(id = R.string.account_initial_auth),
                color = if (isSystemInDarkTheme()) md_theme_dark_onButton else md_theme_light_onButton,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Text(
            text = stringResource(id = R.string.account_initial_auth_number_not_correct),
            color = MaterialTheme.colors.error,
            maxLines = 1,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .constrainAs(authError) {
                    top.linkTo(authNumber.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    width = Dimension.fillToConstraints
                }
        )
        Box(
            modifier = Modifier
                .constrainAs(completion) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    width = Dimension.fillToConstraints
                }
                .height(50.dp)
        ) {
            BlendyButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(0.dp, MaterialTheme.colors.primary),
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.05f)
            )
            Text(
                text = stringResource(id = R.string.account_initial_completion),
                color = if (isSystemInDarkTheme()) md_theme_dark_onButton else md_theme_light_onButton,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun PreviewInitialAccountSettingScreen() {
    BlendyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            InitialAccountSettingScreen()
        }
    }
}