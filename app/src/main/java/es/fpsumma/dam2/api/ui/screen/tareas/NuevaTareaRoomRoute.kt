import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import es.fpsumma.dam2.api.viewmodel.TareasViewModel
import java.lang.reflect.Modifier

@Composable
fun NuevaTareaRoomRoute(
    navController: NavController,
    vm: TareasViewModel,
    modifier: Modifier
){
    NuevaTareaContent(
        onBack = {navController.popBackStack()},
        onSave = {vm.addTarea(titulo = "", descripcion = "") in navController.navigate("TAREAS_LISTADO")}
    )
}