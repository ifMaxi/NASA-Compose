package com.maxidev.nasacompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.maxidev.nasacompose.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val montserratName = GoogleFont("Montserrat")
val exo2Name = GoogleFont("Exo 2")

val montserratFamily = FontFamily(
    Font(googleFont = montserratName, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = montserratName, fontProvider = provider, weight = FontWeight.Medium)
)

val exo2Family = FontFamily(
    Font(googleFont = exo2Name, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = exo2Name, fontProvider = provider, weight = FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = exo2Family,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)