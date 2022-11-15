package com.example.cocktail_human_android.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat
import com.example.cocktail_human_android.R
import com.example.cocktail_human_android.ui.compose.button.BlendyButton
import com.example.cocktail_human_android.ui.compose.textfield.BlendyPasswordTextField
import com.example.cocktail_human_android.ui.compose.textfield.BlendyTextField
import com.example.cocktail_human_android.ui.theme.COCKTAIL_HUMAN_ANDROIDTheme
import com.example.cocktail_human_android.ui.theme.md_theme_dark_blurBoxColor
import com.example.cocktail_human_android.ui.theme.md_theme_light_blurBoxColor

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            COCKTAIL_HUMAN_ANDROIDTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val idTextState = remember { mutableStateOf("") }
    val passwordTextState = remember { mutableStateOf("") }
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_screen_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (logoImage, loginBox, blurBox, informationBox, blurImage) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .constrainAs(logoImage) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(loginBox.top)
                    }
            )
            //.
            Image(
                painter = painterResource(id = R.drawable.login_screen_background_blur),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(blurImage) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .height(275.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .constrainAs(blurBox) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(275.dp)
                    .alpha(0.4f)
                    .background(
                        if (isSystemInDarkTheme()) md_theme_dark_blurBoxColor else md_theme_light_blurBoxColor,
                        RoundedCornerShape(16.dp)
                    )
            )

            Column(
                modifier = Modifier
                    .constrainAs(loginBox) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(275.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BlendyTextField(
                    modifier = Modifier
                        .alpha(0.7f)
                        .padding(top = 24.dp, start = 15.dp, end = 15.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    value = idTextState.value,
                    onValueChange = { idTextState.value = it },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.login_student_number),
                            color = MaterialTheme.colors.onBackground
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background
                    ),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true
                )
                BlendyPasswordTextField(
                    modifier = Modifier
                        .alpha(0.7f)
                        .padding(top = 8.dp, start = 15.dp, end = 15.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    value = passwordTextState.value,
                    onValueChange = { passwordTextState.value = it },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.login_password),
                            color = MaterialTheme.colors.onBackground
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background
                    ),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true
                )
                BlendyButton(
                    modifier = Modifier
                        .padding(top = 24.dp, start = 15.dp, end = 15.dp)
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary
                    ),
                    shape = RoundedCornerShape(16.dp),
                    border = null,
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable {
                            /*TODO*/
                        }
                        .alpha(1f),
                    text = stringResource(id = R.string.login_find_password),
                    color = MaterialTheme.colors.onBackground
                )
            }
            Row(
                modifier = Modifier
                    .constrainAs(informationBox) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(loginBox.bottom)
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_circle_info),
                    contentDescription = null,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(top = 16.dp, start = 24.dp)
                        .size(16.dp)
                        .alpha(0.56f)
                )
                Text(
                    text = stringResource(id = R.string.login_app_information),
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 10.dp, end = 24.dp)
                        .alpha(0.56f)
                )
            }
        }
    }
}