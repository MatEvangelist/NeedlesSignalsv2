package br.com.fiap.needlessignals.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.ui.theme.BgColor
import br.com.fiap.needlessignals.ui.theme.BluePrimary
import br.com.fiap.needlessignals.ui.theme.Primary
import br.com.fiap.needlessignals.ui.theme.TextColor
import br.com.fiap.needlessignals.ui.theme.componentShapes

@Composable
fun IconComponent(imageVector: ImageVector, contextDescription: String, modifier: Modifier = Modifier.size(30.dp)) {
    Icon(
        modifier = modifier,
        imageVector = imageVector,
        contentDescription = contextDescription
    )
}

@Composable
fun ButtonComponent(onClickCallback: () -> Unit, text: String, containerColor: Color = Color.Black) {
    Button(
        onClick = onClickCallback,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor)
    ) {
        Text(text = text, color = Color.White)
    }
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
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}
@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
//        color = colorResource(id = R.color.colorText)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    labelValue: String,
    icon: ImageVector,
    onTextSelected: (String) -> Unit,
    value: String,
    isError: Boolean
) {
    var textValue by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = value,
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        isError = isError,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        onValueChange = {
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(
    value: String = "",
    labelValue: String,
    icon: ImageVector,
    isError: Boolean,
    onTextSelected: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        onValueChange = {
            onTextSelected(it)
        },
        isError = isError,
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    confirmPassword: Boolean = false,
    labelValue: String,
    icon: ImageVector,
    onTextSelected: (String) -> Unit,
    value: String,
    isError: Boolean
) {
    val localFocusManager = LocalFocusManager.current

    var imeAction = ImeAction.Done

    if (confirmPassword) {
        imeAction = ImeAction.Next
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = imeAction),
        singleLine = true,
        maxLines = 1,
        isError = isError,
        keyboardActions = KeyboardActions{
            if (!confirmPassword) {
                localFocusManager.clearFocus()
            } else {
                localFocusManager.moveFocus(focusDirection = FocusDirection.Next)
            }
        },
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        onValueChange = {
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            var description = if(passwordVisible) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = description )
            }
        },
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String, onTextSelected: (String) -> Unit) {
    var checkedState by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkedState, onCheckedChange = {
            checkedState = !checkedState
        })
        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "Lembrar Senha?"

    val annotatedString = buildAnnotatedString {
        append(initialText)
    }

    ClickableText(text = annotatedString, onClick = {
            offsett ->
        annotatedString.getStringAnnotations(offsett, offsett)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{$span}")
                if ((span.item == initialText)) {
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun TermsClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "Registrando-se no nosso app você você esta aceitando nossos "
    val privacyPolicyText = "Termos e Politicas de privacidade"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
    }
    ClickableText(
        text = annotatedString,
        style = TextStyle(textAlign = TextAlign.Center, fontSize = 17.sp),
        onClick = { offsett ->
            annotatedString.getStringAnnotations(offsett, offsett)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{$span}")
                    if (span.item == privacyPolicyText) {
                        onTextSelected(span.item)
                    }
                }
        }
    )
}

@Composable
fun ClickableLoginTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = stringResource(R.string.forgetPassword)

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = BluePrimary)) {
            pushStringAnnotation(tag = initialText, annotation = initialText)
            append(initialText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        text = annotatedString,
        onClick = {
                offsett ->
            annotatedString.getStringAnnotations(offsett, offsett)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{$span}")
                    if (span.item == initialText) {
                        onTextSelected(span.item)
                    }
                }
        })
}

@Composable
fun CheckBoxTermosComponent(value: String, onCheckedChange: (Boolean) -> Unit, checked: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(76.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            }
        )
        ClickableTermosTextComponent(value = value, onTextSelected = {})
    }
}

@Composable
fun ClickableTermosTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = stringResource(R.string.agree_terms)

    val annotatedString = buildAnnotatedString {
        append(initialText)
    }

    ClickableText(text = annotatedString, onClick = {
            offsett ->
        annotatedString.getStringAnnotations(offsett, offsett)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTermosTextComponent", "{$span}")
                if ((span.item == initialText)) {
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun CheckBoxNewsletterComponent(value: String, onTextSelected: (String) -> Unit) {
    var checkedState by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkedState, onCheckedChange = {
            checkedState = !checkedState
        })
        ClickableNewsletterTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableNewsletterTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = stringResource(R.string.newsletter)

    val annotatedString = buildAnnotatedString {
        append(initialText)
    }

    ClickableText(text = annotatedString, onClick = {
            offsett ->
        annotatedString.getStringAnnotations(offsett, offsett)
            .firstOrNull()?.also { span ->
                Log.d("ClickableNewsletterTextComponent", "{$span}")
                if ((span.item == initialText)) {
                    onTextSelected(span.item)
                }
            }
    })
}