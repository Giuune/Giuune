package com.project.giunnae.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.project.giunnae.Res
import com.project.giunnae.common.util.NotoSans.fontMedium
import com.project.giunnae.common.util.NotoSans.medium
import com.project.giunnae.nanum_square_round_bold
import com.project.giunnae.nanum_square_round_extrabold
import com.project.giunnae.nanum_square_round_light
import com.project.giunnae.nanum_square_round_regular
import com.project.giunnae.noto_sans_bold
import com.project.giunnae.noto_sans_extrabold
import com.project.giunnae.noto_sans_light
import com.project.giunnae.noto_sans_medium
import com.project.giunnae.noto_sans_regular
import org.jetbrains.compose.resources.FontResource

object NotoSans {
    var light: FontResource = Res.font.noto_sans_light
    var regular: FontResource = Res.font.noto_sans_regular
    var medium: FontResource = Res.font.noto_sans_medium
    var bold: FontResource = Res.font.noto_sans_bold
    var extraBold: FontResource = Res.font.noto_sans_extrabold

    var fontLight: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.Light
    }
    var fontRegular: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.Normal
    }
    var fontMedium: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.Medium
    }
    var fontBold: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.Bold
    }
    var fontExtraBold: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.ExtraBold
    }

    @Composable
    fun initFont() {
        fontLight = org.jetbrains.compose.resources.Font(light, FontWeight.Light)
        fontRegular = org.jetbrains.compose.resources.Font(regular, FontWeight.Normal)
        fontMedium = org.jetbrains.compose.resources.Font(medium, FontWeight.Medium)
        fontBold = org.jetbrains.compose.resources.Font(bold, FontWeight.Bold)
        fontExtraBold = org.jetbrains.compose.resources.Font(extraBold, FontWeight.ExtraBold)
    }
}

object NanumRound {
    var light: FontResource = Res.font.nanum_square_round_light
    var regular: FontResource = Res.font.nanum_square_round_regular
    var bold: FontResource = Res.font.nanum_square_round_bold
    var extraBold: FontResource = Res.font.nanum_square_round_extrabold

    var fontLight: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.Light
    }
    var fontRegular: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.Normal
    }
    var fontBold: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.Bold
    }
    var fontExtraBold: Font = object : Font {
        override val style: FontStyle = FontStyle.Normal
        override val weight: FontWeight = FontWeight.ExtraBold
    }

    @Composable
    fun initFont() {
        fontLight = org.jetbrains.compose.resources.Font(light, FontWeight.Light)
        fontRegular = org.jetbrains.compose.resources.Font(regular, FontWeight.Normal)
        fontBold = org.jetbrains.compose.resources.Font(bold, FontWeight.Bold)
        fontExtraBold = org.jetbrains.compose.resources.Font(extraBold, FontWeight.ExtraBold)
    }
}

fun GPFont(spec: FontResource): Font {
    return when(spec) {
        NanumRound.light -> NanumRound.fontLight
        NanumRound.regular -> NanumRound.fontRegular
        NanumRound.bold -> NanumRound.fontBold
        NanumRound.extraBold -> NanumRound.fontExtraBold
        else -> NanumRound.fontRegular
    }
}

sealed class GPFontFamily() {
    companion object {
        val Light = FontFamily(NanumRound.fontLight)
        val Regular = FontFamily(NanumRound.fontRegular)
        val Medium = FontFamily(NanumRound.fontRegular)
        val Bold = FontFamily(NanumRound.fontBold)
        val ExtraBold = FontFamily(NanumRound.fontExtraBold)
    }
}