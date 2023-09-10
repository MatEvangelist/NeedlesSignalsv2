package br.com.fiap.needlessignals.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
fun MyTextField(value: String = "", labelValue: String, icon: ImageVector) {
    var textValue by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = textValue,
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        onValueChange = {
            textValue = it
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(value: String = "", labelValue: String, icon: ImageVector) {
    var emailValue by remember {
        mutableStateOf("")
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = emailValue,
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        onValueChange = {
            emailValue = it
            if (emailValue.length > 0) emailError = false
        },
        isError = emailError,
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        }
    )
    if (emailError) {
        Text(
            text = "E-mail é obrigatório!",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Red,
            textAlign = TextAlign.End
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(value: String = "", labelValue: String, icon: ImageVector) {
    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = password,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        onValueChange = {
            password = it
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
fun CheckBoxTermosComponent(value: String, onTextSelected: (String) -> Unit) {
    var checkedState by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(76.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkedState, onCheckedChange = {
            checkedState = !checkedState
        })
        ClickableTermosTextComponent(value = value, onTextSelected)
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