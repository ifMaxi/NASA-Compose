package com.maxidev.nasacompose.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    CenterAlignedTopAppBar(
        modifier = modifier.shadow(20.dp),
        title = {
            Text(text = stringResource(id = title))
        },
        scrollBehavior = scrollBehavior
    )
}
