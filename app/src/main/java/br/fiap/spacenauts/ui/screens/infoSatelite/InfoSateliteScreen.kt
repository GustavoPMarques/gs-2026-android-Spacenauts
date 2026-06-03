package br.fiap.spacenauts.ui.screens.infoSatelite


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import br.fiap.spacenauts.model.Satelite
import br.fiap.spacenauts.data.getAllSatelites
import br.fiap.spacenauts.ui.components.SpacenautsBottomBar

import br.fiap.spacenauts.ui.theme.SpacenautTheme

@Composable
fun InfoSateliteScreen(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onAlertasClick: () -> Unit = {},
    onMonitorarClick: () -> Unit = {},
    onSatelitesClick: () -> Unit = {}
) {

    var searchTextState by remember { mutableStateOf("") }
    var satelitesState by remember { mutableStateOf(getAllSatelites()) }

    val listaFiltrada = satelitesState.filter {
        it.nome.startsWith(prefix = searchTextState, ignoreCase = true)
    }

    Scaffold(
        bottomBar = {
            SpacenautsBottomBar(
                onHomeClick = onHomeClick,
                onAlertasClick = onAlertasClick,
                onMonitorarClick = onMonitorarClick,
                onSatelitesClick = onSatelitesClick
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.onBackground)
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {


            OutlinedTextField(
                value = searchTextState,
                onValueChange = { searchTextState = it },
                label = { Text("Nome do satélite") },
                modifier = Modifier.fillMaxWidth(),
                colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                    focusedTextColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.primary
                )
            )

            Spacer(modifier = Modifier.height(16.dp))


            if (searchTextState.isNotEmpty() && listaFiltrada.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Verifique se escreveu corretamente",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(listaFiltrada) { satelite ->
                        SateliteInfoCard(satelite = satelite)
                    }
                }
            }
        }
    }
}

@Composable
fun SateliteInfoCard(satelite: Satelite) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = satelite.nome,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Região: ${satelite.regiao.name}",
                color = Color.LightGray,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = satelite.descricao,
                color = Color.White,
                fontSize = 13.sp
            )
        }
    }
}

@Preview
@Composable
private fun InfoSateliteScreenPreview() {
    SpacenautTheme {
        InfoSateliteScreen()
    }
}