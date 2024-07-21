package common.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme
import theme.Theme


@Composable
fun FTextField(
    text: String,
    hint: String = "",
    enabled: Boolean = true,
    onTextChanged: (String) -> Unit
) {
    TextField(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 12.dp)
            .fillMaxWidth().height(56.dp),
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        placeholder = { Text(text = hint, color = Theme.colors.tintColor, fontSize = 14.sp) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Theme.colors.secondaryBackground,
            focusedContainerColor = Theme.colors.secondaryBackground,
            disabledContainerColor = Theme.colors.secondaryBackground
                .copy(alpha = 0.3f),
            focusedTextColor = Theme.colors.tintColor,
            unfocusedTextColor = Theme.colors.tintColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        textStyle = TextStyle(fontSize = 14.sp),
        value = text,
        onValueChange = onTextChanged
    )
}

@Composable
@Preview
fun FTextField_Preview() {
    AppTheme {
        FTextField(
            text = "Some Value",
            hint = "Email",
        ) {

        }
    }
}

@Composable
@Preview
fun FTextField_Disabled_Preview() {
    AppTheme {
        FTextField(
            text = "Some Value",
            hint = "Email",
            enabled = false
        ) {

        }
    }
}