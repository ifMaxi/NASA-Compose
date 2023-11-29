package com.maxidev.nasacompose.ui.screen

import android.content.Context
import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.maxidev.nasacompose.R
import com.maxidev.nasacompose.data.model.ApodModel
import com.maxidev.nasacompose.data.network.ApiResponse
import com.maxidev.nasacompose.ui.theme.NASAComposeTheme
import com.maxidev.nasacompose.ui.viewmodel.NasaViewModel

/**
 * In list:
 *
 * - OPTIONAL: Animated image
 * - TEST
 * - Final touches to the main screen
 */

@Composable
fun ApodScreen(
    //modifier: Modifier = Modifier,
    viewmodel: NasaViewModel = viewModel()
) {
    LaunchedEffect(true) {
        viewmodel.apod
    }

    ApodNetStatus(apiResponse = viewmodel.apod)
}

@Composable
private fun ApodNetStatus(apiResponse: ApiResponse) {
    when (apiResponse) {
        is ApiResponse.Loading -> ApodLoading()
        is ApiResponse.Success -> ApodScreenModel(apodModel = apiResponse.data as ApodModel)
        is ApiResponse.Error -> ApodConnectionError(errorText = R.string.connection_problems)
    }
}

@Composable
private fun ApodScreenModel(apodModel: ApodModel) {
    ApodScreenContent(
        image = apodModel.hdurl,
        title = apodModel.title,
        description = apodModel.explanation,
        date = apodModel.date
    )
}

@Composable
private fun ApodScreenContent(
    image: String,
    title: String,
    description: String,
    date: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 25.dp,
                start = 6.dp,
                bottom = 6.dp,
                end = 6.dp
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ApodTitleOfTheDay(title = title)
        ApodCard(
            image = image,
            description = description
        )
        ApodDateOfTheDay(date = date)
    }
}

@Composable
private fun ApodCard(
    image: String,
    description: String,
    elevation: CardElevation = CardDefaults.cardElevation(6.dp),
    scrollState: ScrollState = rememberScrollState()
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            .padding(10.dp),
        elevation = elevation,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState),
            content = {
                ApodImageOfTheDay(image = image)
                ApodExpandableButton(
                    onClick = { expanded = !expanded },
                    expanded = expanded,
                    info = R.string.info
                )
                if (expanded) {
                    ApodDescriptionOfTheDay(description = description)
                }
            }
        )
    }
}

@Composable
private fun ApodTitleOfTheDay(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon( // Replace Icon with NASA logo
            imageVector = Icons.Outlined.CalendarToday,
            contentDescription = null // Only illustrative
        )
    }
}

@Composable
private fun ApodImageOfTheDay(
    image: String,
    context: Context = LocalContext.current,
    cachePolicy: CachePolicy = CachePolicy.ENABLED,
    clipShape: Shape = RoundedCornerShape(5)
) {
    val imageRequest = ImageRequest.Builder(context)
        .data(image)
        .crossfade(true)
        .decoderFactory(GifDecoder.Factory())
        .memoryCachePolicy(cachePolicy)
        .diskCachePolicy(cachePolicy)
        .build()

    Box(
        modifier = Modifier
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = imageRequest,
            contentDescription = "Nasa: Image of the day",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(clipShape)
        )
    }
}

@Composable
private fun ApodDescriptionOfTheDay(
    description: String,
    textAlign: TextAlign = TextAlign.Justify
) {
    Column(
        modifier = Modifier
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = description,
            textAlign = textAlign
        )
    }
}

@Composable
private fun ApodDateOfTheDay(date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Date: $date"
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            imageVector = Icons.Outlined.CalendarMonth,
            contentDescription = null // Only illustrative
        )
    }
}

@Composable
private fun ApodExpandableButton(
    onClick: () -> Unit,
    expanded: Boolean,
    @StringRes info: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = info)
        )
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(onClick = onClick) {
            Icon(
                imageVector = if (expanded) Icons.Outlined.ExpandLess else Icons.Outlined.ExpandMore,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ApodConnectionError(
    @StringRes errorText: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Outlined.WifiOff,
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
        )
        Text(
            text = stringResource(id = errorText)
        )
    }
}

@Composable
private fun ApodLoading() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = {
            CircularProgressIndicator()
        }
    )
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class ThemePreviews

@ThemePreviews
@Composable
private fun ApodPreview() {
    NASAComposeTheme {
        Surface {
            Column(
                content = {
//                    ApodScreenContent(
//                        image = R.drawable.image_preview,
//                        title = R.string.app_name,
//                        description = R.string.lorem_ipsum,
//                        date = "2023/11/27"
//                    )
                    ApodLoading()
                    ApodConnectionError(errorText = R.string.connection_problems)
                }
            )
        }
    }
}