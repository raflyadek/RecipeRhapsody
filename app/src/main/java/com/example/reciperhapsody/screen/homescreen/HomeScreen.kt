package com.example.reciperhapsody.screen.homescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reciperhapsody.R
import com.example.reciperhapsody.data.model.BottomBarItem

@Composable
fun RecipeHomeScreen(
    navController: NavController,
) {
    Scaffold(
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ){
            Banner()
            SearchBar(
                hint = "Mau masak apa?",
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "banner tagline",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    val focusManager = LocalFocusManager.current

    Box(modifier = modifier) {
        BasicTextField2(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            lineLimits = TextFieldLineLimits.Default,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
        )
        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
    ) {
        val navigationItems = listOf(
            BottomBarItem(
                tittle = "Home",
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                tittle = "Favorite",
                icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                tittle = "Profile",
                icon = Icons.Default.AccountCircle
            )
        )
        navigationItems.map {
            NavigationBarItem(
                selected = it.tittle == navigationItems[0].tittle,
                onClick = { /*TODO*/ },
                icon = { 
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.tittle
                    )
                },
                label = {
                    Text(text = it.tittle)
                }
            )
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    RecipeHomeScreen(navController = rememberNavController())
}