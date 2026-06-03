package br.fiap.spacenauts.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.fiap.spacenauts.R
import br.fiap.spacenauts.ui.theme.SpacenautTheme

import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToIntro: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        delay(4000)
        onNavigateToIntro()
    }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.onBackground),
            contentAlignment = Alignment.Center
        ) {
            Column(
            modifier = modifier.
                fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "SPACENAUTS",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 42.sp,
                )
                Spacer(
                    modifier = modifier.height(32.dp)
                )
                Image(
                    painterResource(R.drawable.satelite),
                    contentDescription = "Icone de satelite PNG",
                    modifier = modifier.size(128.dp)
                )
            }

        }
    }
}

@Preview
@Composable
private fun SplashScreenPrev() {
    SpacenautTheme {
        SplashScreen()
    }
}