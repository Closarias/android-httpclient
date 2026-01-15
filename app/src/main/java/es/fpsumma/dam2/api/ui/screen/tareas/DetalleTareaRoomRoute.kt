package es.fpsumma.dam2.api.ui.screen.tareas

import DetalleTareaContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import es.fpsumma.dam2.api.model.Tarea
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@Composable
fun DetalleTareaRoomRoute(
    id: Int,
    navController: NavController,
    vm: TareasViewModel,
    modifier: Modifier
) {
    val tareaFlow = remember(id) { vm.getTarea(id) }
    val tarea by tareaFlow.collectAsStateWithLifecycle(initialValue = null)

    DetalleTareaContent(
        onBack = { navController.navigate(Routes.TAREA_LISTADO) },
        onSave = { titulo: String, descripcion: String ->
            vm.updateTarea(id, titulo, descripcion)
            navController.navigate(Routes.TAREA_LISTADO)
        },
        tarea = tarea,
        modifier = Modifier,
    )
}

 