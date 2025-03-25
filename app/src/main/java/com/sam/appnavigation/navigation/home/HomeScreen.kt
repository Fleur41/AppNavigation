package com.sam.appnavigation.navigation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sam.appnavigation.navigation.NavDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onDetailClick:() -> Unit
) {
    var text by remember {mutableStateOf("")}
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "HomeScreen") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home screen")

//            TextField(
//                text = text,
//                onValueChange = { text = text}
//            )
            Button(
                onClick = {
                    onDetailClick()
                }
            ) {
                Text(text = "Go to Detail Screen")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(modifier: Modifier = Modifier) {
    HomeScreen(onDetailClick = {})
}
