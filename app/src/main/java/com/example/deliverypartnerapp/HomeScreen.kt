package com.example.deliverypartnerapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Order(val id: String, val customerName: String, val address: String)

@Composable
fun HomeScreen(navController: NavController) {
    val orders = listOf(
        Order("1", "John Doe", "123 Main St"),
        Order("2", "Jane Smith", "456 Elm St")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(orders) { order ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                onClick = { navController.navigate("order_details") }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Order ID: ${order.id}", style = MaterialTheme.typography.bodyLarge)
                    Text("Customer: ${order.customerName}", style = MaterialTheme.typography.bodyMedium)
                    Text("Address: ${order.address}", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
