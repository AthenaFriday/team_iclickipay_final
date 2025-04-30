package com.athenafriday.screens.authentication.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.athenafriday.iclickipay.R
import com.athenafriday.iclickipay.signup.reusableComposable.ConfirmButton
import com.athenafriday.iclickipay.signup.reusableComposable.LoadImage
import com.athenafriday.iclickipay.signup.reusableComposable.Title
import com.athenafriday.iclickipay.ui.theme.IclickIpayTheme
import com.athenafriday.screens.authentication.login.viewmodel.LoginScreenViewModel
import com.athenafriday.navigation.Destinations

@Composable
fun SignupScreen(modifier: Modifier = Modifier, onSignupSuccess: () -> Unit) {
    val viewModel: LoginScreenViewModel = viewModel()
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Title(modifier.fillMaxWidth(), title = "Complete the form")
        LoadImage(modifier.padding(20.dp), R.drawable.sign_up)

        TextFieldColumn( // ✅ Corrected name
            email = email,
            onEmailChange = { email = it },
            password = password,
            onPasswordChange = { password = it }
        )

        Spacer(modifier = Modifier.weight(1f))

        ConfirmButton(modifier.padding(bottom = 30.dp)) {
            viewModel.signUpWithEmail(
                email = email,
                password = password,
                context = context,
                onSuccess = {
                    println("✅ Signup successful. Navigating to dashboard.")
                    onSignupSuccess()
                }
            )
        }
    }
}

@Composable
fun TextFieldColumn( // ✅ Renamed from Colomn
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
    ) {
        GenderDropdown()
        GenericTextField("First Name")
        GenericTextField("Last Name")
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            modifier = Modifier.fillMaxWidth().height(65.dp),
            label = { Text("Email") }
        )
        GenericTextField("Phone Number")
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier.fillMaxWidth().height(65.dp),
            label = { Text("Password") }
        )
    }
}

@Composable
fun GenderDropdown(modifier: Modifier = Modifier) {
    var mExpanded by remember { mutableStateOf(false) }
    val genders = listOf("Male", "Female", "Other", "Don't wish to answer")
    var mSelectedText by remember { mutableStateOf("") }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    OutlinedTextField(
        value = mSelectedText,
        onValueChange = { mSelectedText = it },
        modifier = modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                mTextFieldSize = coordinates.size.toSize()
            },
        label = { Text("Select Gender") },
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = if (mExpanded) "Collapse dropdown" else "Expand dropdown",
                modifier = Modifier.clickable { mExpanded = !mExpanded }
            )
        }
    )

    DropdownMenu(
        expanded = mExpanded,
        onDismissRequest = { mExpanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
    ) {
        genders.forEach { label ->
            DropdownMenuItem(
                text = { Text(text = label) },
                onClick = {
                    mSelectedText = label
                    mExpanded = false
                }
            )
        }
    }
}

@Composable
fun GenericTextField(label: String = "Default Label") {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        modifier = Modifier.fillMaxWidth().height(65.dp),
        label = { Text(label) },
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    IclickIpayTheme {
        Title(modifier = Modifier, title = "Complete the form")
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    val navController = rememberNavController()

    SignupScreen(onSignupSuccess = {
        navController.navigate(Destinations.DASHBOARD) {
            popUpTo(Destinations.SIGNUP) { inclusive = true }
        }
    })
}
