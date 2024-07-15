package com.prafull.netclanexplorer

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prafull.netclanexplorer.explorescreen.ui.ExploreScreen
import com.prafull.netclanexplorer.refine_screen.ui.RefineScreen
import com.prafull.netclanexplorer.ui.theme.selectedIconColor
import com.prafull.netclanexplorer.ui.theme.topAppBarColor
import com.prafull.netclanexplorer.ui.theme.unselectedIconColor

@SuppressLint("RestrictedApi")
@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val bottomAppBarItems = listOf<BottomAppBarItem>(
            BottomAppBarItem(
                    name = "Explore",
                    iconSelected = R.drawable.baseline_remove_red_eye_24,
                    iconUnSelected = R.drawable.outline_remove_red_eye_24,
                    route = Screens.Explore.name
            ),
            BottomAppBarItem(
                    name = "Refine",
                    iconSelected = R.drawable.baseline_checklist_24,
                    iconUnSelected = R.drawable.baseline_checklist_24,
                    route = Screens.Refine.name
            )
    )
    val currentBackStack by navController.currentBackStack.collectAsState()
    val currentDestination = currentBackStack.lastOrNull()?.destination?.route
    Scaffold(
            topBar = {
                ApplicationBar()
            },
            bottomBar = {
                NavigationBar(
                        modifier = Modifier.fillMaxWidth(),
                        containerColor = White
                ) {
                    bottomAppBarItems.forEach {
                        val selected = currentDestination == it.route
                        NavigationBarItem(
                                selected = false,
                                onClick = {
                                    if (!selected) {
                                        navController.navigateAndPopBackStack(it.route)
                                    }
                                },
                                icon = {
                                    Icon(
                                            painter = painterResource(id = if (selected) it.iconSelected else it.iconUnSelected),
                                            contentDescription = "Navigation bar icon",
                                            tint = if (selected) selectedIconColor else unselectedIconColor,
                                            modifier = Modifier.size(32.dp)
                                    )
                                },
                                label = { Text(it.name) }
                        )
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                        containerColor = topAppBarColor,
                        contentColor = White,
                        onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Button")
                }
            }
    ) { paddingValues ->
        NavHost(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                startDestination = Screens.Explore.name
        ) {
            composable(Screens.Explore.name) {
                ExploreScreen()
            }
            composable(Screens.Refine.name) {
                RefineScreen()
            }
        }
    }
}

@Immutable
data class BottomAppBarItem(
    val name: String,
    @DrawableRes val iconSelected: Int,
    @DrawableRes val iconUnSelected: Int,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationBar(modifier: Modifier = Modifier) {
    TopAppBar(
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                            painter = painterResource(id = R.drawable.baseline_subject_24),
                            contentDescription = "Menu Icon",
                            tint = White,
                            modifier = Modifier.size(32.dp)
                    )
                }
            },
            title = {
                Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Howdy James Bond !!", color = White, fontSize = 14.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                                painter = painterResource(id = R.drawable.baseline_location_on_24),
                                contentDescription = "Location icon",
                                tint = White,
                        )
                        Text(
                                text = "Dighi, Pune",
                                color = White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topAppBarColor
            ),
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                            painter = painterResource(id = R.drawable.baseline_notifications_none_24),
                            contentDescription = "Notification Icon",
                            tint = White,
                            modifier = Modifier.size(32.dp)
                    )
                }
            }
    )
}

enum class Screens {
    Explore, Refine
}