package br.fiap.spacenauts.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.fiap.spacenauts.R
import br.fiap.spacenauts.ui.theme.SpacenautTheme

@Composable
fun SpacenautsBottomBar(
    onHomeClick: () -> Unit = {},
    onAlertasClick: () -> Unit = {},
    onMonitorarClick: () -> Unit = {},
    onSatelitesClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onHomeClick) {
                Icon(
                    painter = painterResource(R.drawable.home),
                    contentDescription = "Home",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
            }
            Text(
                text = "Home",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onAlertasClick) {
                Icon(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = "Alertas",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
            }
            Text(
                text = "Alertas",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onMonitorarClick) {
                Icon(
                    painter = painterResource(R.drawable.monitor),
                    contentDescription = "Monitorar",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
            }
            Text(
                text = "Monitorar",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onSatelitesClick) {
                Icon(
                    painter = painterResource(R.drawable.info),
                    contentDescription = "Satélites",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(28.dp)
                )
            }
            Text(
                text = "Satélites",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
private fun SpacenautsBottomBarPreview() {
    SpacenautTheme {
        SpacenautsBottomBar()
    }
}