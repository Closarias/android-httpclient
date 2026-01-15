import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import es.fpsumma.dam2.api.ui.navegation.Routes
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@Composable
fun NuevaTareaRoomRoute(
    navController: NavController,
    vm: TareasViewModel,
    modifier: Modifier
){
    val state by vm.state.collectAsState()

    NuevaTareaContent(
        state = state,
                onBack = { navController.navigate(Routes.TAREA_LISTADO) },
        onSave = { titulo: String, descripcion: String ->
            vm.addTarea(titulo, descripcion)
            navController.navigate(Routes.TAREA_LISTADO)
        },
        modifier = Modifier
    )
}