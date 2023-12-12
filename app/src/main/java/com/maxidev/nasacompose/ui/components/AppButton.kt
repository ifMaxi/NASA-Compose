package com.maxidev.nasacompose.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    @StringRes text: Int,
    onClick: () -> Unit,
    iconSpacing: Dp = ButtonDefaults.IconSpacing
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        elevation = ButtonDefaults.buttonElevation(6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(iconSpacing))
        Text(
            text = stringResource(id = text)
        )
    }
}