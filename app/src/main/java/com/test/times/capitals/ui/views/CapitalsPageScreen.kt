import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.test.times.capitals.model.listCities
import com.test.times.capitals.ui.CapitalsContract
import com.test.times.capitals.ui.views.CapitalsViewCities
import com.test.times.capitals.ui.views.CapitalsViewError
import com.test.times.core.mvi.SIDE_EFFECTS_KEY
import com.test.times.utils.theme.views.ViewLoading
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun CapitalsPageScreen(
    state: CapitalsContract.State,
    effectFlow: Flow<CapitalsContract.Effect>?,
    onEventSent: (event: CapitalsContract.Event) -> Unit,
    onNavigationRequested: (CapitalsContract.Effect.Navigation) -> Unit
) {
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is CapitalsContract.Effect.Navigation.Back -> {
                    onNavigationRequested(CapitalsContract.Effect.Navigation.Back)
                }

                is CapitalsContract.Effect.Navigation.ToTimePage -> {
                    onNavigationRequested(CapitalsContract.Effect.Navigation.ToTimePage)
                }
            }
        }?.collect()
    }
    when {
        state.isLoading -> ViewLoading()
        state.error != null -> CapitalsViewError(state)
        else -> CapitalsViewCities(cities = listCities) {
            onEventSent(CapitalsContract.Event.SaveTimeZoneAndNavigate(it.getTimeZone()))
        }
    }
}
