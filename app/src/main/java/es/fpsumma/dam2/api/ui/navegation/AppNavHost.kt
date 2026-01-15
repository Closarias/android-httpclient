package es.fpsumma.dam2.api.ui.navegation

import ListadoTareasRemoteRoute
import ListadoTareasRoomRoute
import NuevaTareaRoomRoute
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import es.fpsumma.dam2.api.ui.screen.tareas.DetalleTareaRoomRoute
import es.fpsumma.dam2.api.viewmodel.TareasViewModel
import es.fpsumma.dam2.api.viewmodel.TareasRemoteViewModel

@Composable
fun AppNavHost(navController: NavHostController, tareasViewModel: TareasViewModel, tareasRemoteViewModel: TareasRemoteViewModel) {
    NavHost(navController = navController, startDestination = Routes.TAREA_LISTADO_API) {
        composable(Routes.TAREA_LISTADO) { ListadoTareasRoomRoute(navController, tareasViewModel) }
        composable(Routes.TAREA_LISTADO_API) { ListadoTareasRemoteRoute(navController, tareasRemoteViewModel) }
        composable(Routes.TAREA_ADD) { NuevaTareaRoomRoute(
            navController, tareasViewModel,
            modifier = Modifier
        ) }
        composable(
            route = Routes.TAREA_VIEW,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStage ->
            DetalleTareaRoomRoute(
                id = backStage.arguments?.getInt("id") ?: 0,
                navController,
                tareasViewModel,
                modifier = Modifier
            )
        }
    }
}