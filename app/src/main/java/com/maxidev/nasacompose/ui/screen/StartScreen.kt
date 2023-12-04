package com.maxidev.nasacompose.ui.screen

/* Created by Pelizzoni Maximiliano on 23/11/2023 */

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.maxidev.nasacompose.R

// Welcome screen to the app.
// Shows an animated image of Lottie.
@Composable
fun StartScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText(text = R.string.welcome)

        Spacer(modifier = Modifier.height(50.dp))

        NasaLottieAnimation()

        Spacer(modifier = Modifier.height(20.dp))

        DiscoverText(text = R.string.discover_cosmos)

        Spacer(modifier = Modifier.height(50.dp))

        InfoExpertsText(info = R.string.info_experts)
    }
}

@Composable
private fun WelcomeText(@StringRes text: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun NasaLottieAnimation() {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.nasa_word_animation)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Box {
        LottieAnimation(
            composition = composition,
            progress = { progress }
        )
    }
}

@Composable
private fun DiscoverText(@StringRes text: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun InfoExpertsText(@StringRes info: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = info),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}