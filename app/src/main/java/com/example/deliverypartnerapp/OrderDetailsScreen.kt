package com.example.deliverypartnerapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun OrderDetailsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Order Details", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Order ID: 1")
        Text("Customer Name: John Doe")
        Text("Address: 123 Main St")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* TODO: Update order status */ }) {
            Text("Mark as Picked Up")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { /* TODO: Update order status */ }) {
            Text("Mark as Delivered")
        }
    }
}
