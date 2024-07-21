package features.feature_login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.textfield.FTextField
import features.feature_login.models.LoginEvent
import features.feature_login.models.LoginViewState
import feedapp.composeapp.generated.resources.Res
import feedapp.composeapp.generated.resources.login_email
import feedapp.composeapp.generated.resources.login_forgot
import feedapp.composeapp.generated.resources.login_intro
import feedapp.composeapp.generated.resources.login_login
import feedapp.composeapp.generated.resources.login_password
import feedapp.composeapp.generated.resources.login_register
import feedapp.composeapp.generated.resources.login_signup
import feedapp.composeapp.generated.resources.login_welcome_back
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme
import theme.Theme

@Composable
internal fun LoginView (
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {

    Column {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .fillMaxWidth().height(48.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_login),
                color = Theme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp)
                .fillMaxWidth().height(28.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_welcome_back),
                color = Theme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_intro),
                color = Theme.colors.primaryText,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal, fontSize = 16.sp
            )
        }

        FTextField(
            text = viewState.emailValue,
            hint = stringResource(Res.string.login_email),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.EmailChanged(it))
        }

        FTextField(
            text = viewState.passwordValue,
            hint = stringResource(Res.string.login_password),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier.size(width = 156.dp, height = 40.dp)
                .clickable {

                }
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_forgot),
                    color = Theme.colors.primaryText
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier.size(width = 84.dp, height = 40.dp)
                    .clickable {
                        eventHandler.invoke(LoginEvent.LoginClicked)
                    }
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_login),
                    color = Theme.colors.primaryText
                )
            }
        }

        Row {
            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 16.dp),
                text = stringResource(Res.string.login_register),
                color = Theme.colors.tintColor,
                fontWeight = FontWeight.Light
            )

            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, end = 16.dp)
                    .clickable {
                        eventHandler.invoke(LoginEvent.SignUpClicked)
                    },
                text = stringResource(Res.string.login_signup),
                color = Theme.colors.tintColor,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview
@Composable
internal fun LoginView_Preview() {
    AppTheme {
        LoginView(
            viewState = LoginViewState(
                emailValue = "l.key14@mail.ru",
                passwordValue = "123456"
            ),
            eventHandler = {

            }
        )
    }
}
