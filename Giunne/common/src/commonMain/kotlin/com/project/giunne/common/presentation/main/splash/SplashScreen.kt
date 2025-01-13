package com.project.giunne.common.presentation.main.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
//            AsyncImage(
//                modifier = Modifier.size(300.dp),
//                model = "https://picsum.photos/200/300",
//                contentDescription = null
//            )
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Splash"
            )
        }
    }
}