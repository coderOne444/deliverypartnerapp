import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.deliverypartnerapp.utils.LocationTracker
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun DeliveryMapScreen() {
    // Define delivery location and route start point
    val deliveryLocation = LatLng(22.346010, 87.231972) // Replace with actual delivery location coordinates
    val deliveryRouteStart = LatLng(22.5678, 88.3476) // Replace with actual starting point coordinates

    // Camera position
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(deliveryLocation, 12f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        // Marker at the delivery location
        Marker(
            state = MarkerState(position = deliveryLocation),
            title = "Delivery Location"
        )

        // Marker at the starting point
        Marker(
            state = MarkerState(position = deliveryRouteStart),
            title = "Start Location"
        )

        // Draw a polyline for the delivery route
        Polyline(
            points = listOf(deliveryRouteStart, deliveryLocation),
            color = androidx.compose.ui.graphics.Color.Blue,
            width = 5f
        )
    }
}

@SuppressLint("MissingPermission")
@Composable
fun LiveLocationMapScreen(locationTracker: LocationTracker) {
    val userLocation = remember { mutableStateOf(LatLng(0.0, 0.0)) }
    val cameraPositionState = rememberCameraPositionState()

    locationTracker.startLocationUpdates { latitude, longitude ->
        userLocation.value = LatLng(latitude, longitude)
        cameraPositionState.move(CameraUpdateFactory.newLatLng(userLocation.value))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        // Marker for user's live location
        Marker(
            state = MarkerState(position = userLocation.value),
            title = "Your Location"
        )
    }
}
