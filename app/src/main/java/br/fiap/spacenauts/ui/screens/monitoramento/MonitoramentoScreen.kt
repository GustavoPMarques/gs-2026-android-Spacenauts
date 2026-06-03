package br.fiap.spacenauts.ui.screens.monitorar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import br.fiap.spacenauts.ui.components.RegiaoCard
import br.fiap.spacenauts.model.RegiaoSatelite
import br.fiap.spacenauts.data.getAllSatelites

import java.text.SimpleDateFormat
import java.util.Locale
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import br.fiap.spacenauts.R
import br.fiap.spacenauts.ui.components.SpacenautsBottomBar
import br.fiap.spacenauts.ui.theme.SpacenautTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonitorarScreen(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onAlertasClick: () -> Unit = {},
    onMonitorarClick: () -> Unit = {},
    onSatelitesClick: () -> Unit = {}
) {

    var satelitesState by remember { mutableStateOf(getAllSatelites()) }
    var regiaoSelecionada by remember { mutableStateOf(RegiaoSatelite.SP) }

    val formatter = SimpleDateFormat("HH:mm yy/MM/dd", Locale("pt", "BR"))

    val sateliteDaRegiao = satelitesState.filter { it.regiao == regiaoSelecionada }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Monitoramento",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {


            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(RegiaoSatelite.entries) { regiao ->
                    RegiaoCard(
                        regiao = regiao,
                        onClick = {
                            regiaoSelecionada = it
                            satelitesState = getAllSatelites()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            if (sateliteDaRegiao.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Nenhum satélite encontrado para essa região.",
                        color = Color.LightGray,
                        fontSize = 13.sp
                    )
                }
            } else {
                val satelite = sateliteDaRegiao[0]

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .border(
                            width = 1.dp,
                            color = Color(0xFF00FF00),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = "SATÉLITE ATIVO",
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 12.sp
                        )
                        Text(
                            text = satelite.nome,
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(text = "Região:", color = Color.LightGray, fontSize = 13.sp)
                            Text(
                                text = satelite.regiao.name,
                                color = Color.White,
                                fontSize = 13.sp
                            )
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "Última leitura:",
                                color = Color.LightGray,
                                fontSize = 13.sp
                            )
                            Text(
                                text = formatter.format(satelite.ultimaLeitura),
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 13.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.info),
                                contentDescription = "Informação",
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = "O que é isso?",
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )

                        }
                        Text(
                            text = "Esta tela permite monitorar em tempo real o status dos satélites ativos em cada região do Brasil. Caso um satélite não esteja funcionando corretamente, ele não aparecerá como ativo nesta tela.",
                            color = Color.LightGray,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MonitorarScreenPreview() {
    SpacenautTheme {
        MonitorarScreen()
    }
}