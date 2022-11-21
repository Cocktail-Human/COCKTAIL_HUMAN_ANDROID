package com.example.cocktail_human_android.ui.compose.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cocktail_human_android.ui.theme.Black
import com.example.cocktail_human_android.ui.theme.BlendyTheme
import com.example.cocktail_human_android.ui.theme.Shapes
import com.example.cocktail_human_android.ui.theme.White

@Composable
fun BlendyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = Shapes.small,
    border: BorderStroke? = BorderStroke(1.dp, Black),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = White,
        contentColor = Black
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}

@Preview
@Composable
fun PreviewBlendyButton() {
    BlendyTheme {
        BlendyButton(onClick = { /*TODO*/ }) {
            Text("로그인")
        }
    }
}