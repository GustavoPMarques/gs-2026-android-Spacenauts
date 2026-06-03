package br.fiap.spacenauts.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.fiap.spacenauts.ui.screens.alertas.AlertasScreen
import br.fiap.spacenauts.ui.screens.home.HomeScreen
import br.fiap.spacenauts.ui.screens.infoSatelite.InfoSateliteScreen
import br.fiap.spacenauts.ui.screens.intro.IntroScreen
import br.fiap.spacenauts.ui.screens.monitorar.MonitorarScreen
import br.fiap.spacenauts.ui.screens.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ) {

        composable<SplashRoute> {
            SplashScreen(
                onNavigateToIntro = {
                    navController.navigate(IntroRoute) {
                        popUpTo<SplashRoute> {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<IntroRoute> {
            IntroScreen(
                onNavigateToHome = {
                    navController.navigate(HomeRoute) {
                        popUpTo<IntroRoute> {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<HomeRoute> {
            HomeScreen(
                onHomeClick = { navController.navigate(HomeRoute) },
                onAlertasClick = { navController.navigate(AlertasRoute) },
                onMonitorarClick = { navController.navigate(MonitorarRoute) },
                onSatelitesClick = { navController.navigate(InfoSateliteRoute) }
            )
        }

        composable<AlertasRoute> {
            AlertasScreen(
                onHomeClick = { navController.navigate(HomeRoute) },
                onAlertasClick = { navController.navigate(AlertasRoute) },
                onMonitorarClick = { navController.navigate(MonitorarRoute) },
                onSatelitesClick = { navController.navigate(InfoSateliteRoute) }
            )
        }

        composable<MonitorarRoute> {
            MonitorarScreen(
                onHomeClick = { navController.navigate(HomeRoute) },
                onAlertasClick = { navController.navigate(AlertasRoute) },
                onMonitorarClick = { navController.navigate(MonitorarRoute) },
                onSatelitesClick = { navController.navigate(InfoSateliteRoute) }
            )
        }

        composable<InfoSateliteRoute> {
            InfoSateliteScreen(
                onHomeClick = { navController.navigate(HomeRoute) },
                onAlertasClick = { navController.navigate(AlertasRoute) },
                onMonitorarClick = { navController.navigate(MonitorarRoute) },
                onSatelitesClick = { navController.navigate(InfoSateliteRoute) }
            )
        }
    }
}