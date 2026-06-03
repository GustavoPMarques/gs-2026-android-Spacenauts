package br.fiap.spacenauts.ui.screens.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.fiap.spacenauts.R
import br.fiap.spacenauts.ui.theme.SpacenautTheme

@Composable
fun IntroScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {}
) {
    var currentStep by remember { mutableStateOf(0) }

    Scaffold(

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onBackground)
                .padding(paddingValues)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painterResource(R.drawable.earth),
                contentDescription = "PNG da Terra",
                modifier = modifier.size(224.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))


            val texto = when (currentStep) {
                0 -> "Seja bem vindo ao Spacenauts"
                1 -> "Sobre o app"
                2 -> "Vamos começar?"
                else -> ""
            }

            Text(
                text = texto,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
            if (currentStep == 1) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Conectamos dados de satélites orbitais com inteligência climática para prever eventos extremos, monitorar ressacas, ondas de calor e desastres naturais com antecedência — protegendo comunidades em todo o Brasil.",
                    color = androidx.compose.ui.graphics.Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                if (currentStep > 0) {
                    OutlinedButton(onClick = { currentStep-- }) {
                        Text("Voltar")
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }

                Button(
                    onClick = {
                        if (currentStep < 2) {
                            currentStep++
                        } else {
                            onNavigateToHome()
                        }
                    }
                ) {
                    Text(if (currentStep < 2) "Avançar" else "Ir para Home")
                }
            }
        }
    }
}

@Preview
@Composable
private fun IntroScreenPrev() {
    SpacenautTheme {
        IntroScreen()
    }
}