import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import es.fpsumma.dam2.api.viewmodel.TareasViewModel
import java.lang.reflect.Modifier

@Composable
fun NuevaTareaRoomRoute(
    navController: NavController,
    vm: TareasViewModel
){
    NuevaTareaContent(
        onBack = {navController.popBackStack()},
        onSave = {
            vm.addTarea(
                titulo = "",
                descripcion = ""
            )
            navController.navigate("TAREAS_LISTADO")
        }
    )
}