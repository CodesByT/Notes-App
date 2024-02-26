package com.example.notesapp.model

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.notesapp.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val font1 = GoogleFont("Bebas Neue")
val font2 = GoogleFont("Lilita One")
val font3 = GoogleFont("Acme")

val fontFamily1 = FontFamily(
    Font(googleFont = font1, fontProvider = provider)
)
val fontFamily3 = FontFamily(
    Font(googleFont = font3, fontProvider = provider)
)
val fontFamily2= FontFamily(
    Font(googleFont = font2, fontProvider = provider)
)
