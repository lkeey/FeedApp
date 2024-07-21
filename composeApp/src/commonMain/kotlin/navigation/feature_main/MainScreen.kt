package navigation.feature_main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import features.feature_feed.FeedScreen
import feedapp.composeapp.generated.resources.Res
import feedapp.composeapp.generated.resources.bottom_home
import feedapp.composeapp.generated.resources.bottom_inbox
import feedapp.composeapp.generated.resources.bottom_library
import feedapp.composeapp.generated.resources.bottom_post
import feedapp.composeapp.generated.resources.bottom_subscriptions
import navigation.AppScreens
import navigation.LocalNavHost
import org.jetbrains.compose.resources.stringResource
import theme.Theme

enum class MainScreens(val route: String) {
    Home("home"), Subscriptions("subscriptions"), Post("post"), Inbox("inbox"), Library("library")
}

@Composable
fun MainScreen(

) {
    val outerNavController = LocalNavHost.current
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()
    val bottomNavigationHeight = 75.dp

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            modifier = Modifier
                .padding(bottom = bottomNavigationHeight)
                .fillMaxHeight(),
            startDestination = MainScreens.Home.route
        ) {
            composable(MainScreens.Home.route) {
                FeedScreen()
            }
            composable(MainScreens.Subscriptions.route) {
                Text("Subscriptions", color = Color.White, fontSize = 50.sp)
            }
            composable(MainScreens.Inbox.route) {
                Text("Inbox", color = Color.White, fontSize = 50.sp)
            }
            composable(MainScreens.Library.route) {
                Text("Library", color = Color.White, fontSize = 50.sp)
            }
        }

        BottomNavigation (
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(bottomNavigationHeight),
            backgroundColor = Theme.colors.secondaryBackground
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->

                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route} == true

                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = when (screen) {
                                MainScreens.Home -> Icons.Filled.Home
                                MainScreens.Subscriptions -> Icons.Filled.Check
                                MainScreens.Post -> Icons.Filled.Create
                                MainScreens.Inbox -> Icons.Filled.Email
                                MainScreens.Library -> Icons.Filled.AccountBox
                            },
                            contentDescription = screen.route,
                            tint = Theme.colors.tintColor
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(when (screen) {
                                MainScreens.Home -> Res.string.bottom_home
                                MainScreens.Subscriptions -> Res.string.bottom_subscriptions
                                MainScreens.Post -> Res.string.bottom_post
                                MainScreens.Inbox -> Res.string.bottom_inbox
                                MainScreens.Library -> Res.string.bottom_library
                            }),
                            color = if (isSelected) Theme.colors.primaryText else Theme.colors.tintColor
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        if (screen == MainScreens.Post) {
                            outerNavController.navigate(AppScreens.CreatePost.title)
                        } else {
                            navController.navigate(screen.route){

                                popUpTo(navController.graph.findStartDestination().displayName) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}
