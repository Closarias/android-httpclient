import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import es.fpsumma.dam2.api.data.local.entity.TareaEntity
import es.fpsumma.dam2.api.model.Tarea
import es.fpsumma.dam2.api.viewmodel.TareasViewModel

@Composable
fun DetalleTareaRoomRoute(
    id: Int,
    navController: NavController,
    vm: TareasViewModel
){
    val tareaEntity = vm.getTarea(id).collectAsState(initial = null).value

    DetalleTareaContent(
        tarea = tareaEntity?.let {
            Tarea(
                it.id,
                it.titulo,
                it.descripcion
            )
        },
        onBack = { navController.popBackStack() },
        onSave = {
            vm.updateTarea(
                id = id,
                titulo = "",
                descripcion = ""
            )
            navController.popBackStack()
        }
    )
}