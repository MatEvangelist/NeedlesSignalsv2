package br.com.fiap.needlessignals.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.needlessignals.components.ButtonComponent
import br.com.fiap.needlessignals.components.IconComponent
import br.com.fiap.needlessignals.ui.theme.BgColor

data class BottonNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val items = listOf(
        BottonNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star,
            hasNews = false
        ),
        BottonNavigationItem(
            title = "Chat",
            selectedIcon = Icons.Filled.Menu,
            unselectedIcon = Icons.Outlined.Menu,
            hasNews = false,
            badgeCount = 35
        ),
        BottonNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {

            },
            bottomBar = {
                NavigationBar() {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                // navController.navigate(item.title)
                            },
                            alwaysShowLabel = false,
                            icon = {
                                BadgedBox(badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }
                                }) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            })
                    }
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BgColor)
            ) {
                Spacer(modifier = Modifier.height(45.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .background(Color.White)
                        .height(64.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Sinais", fontSize = 32.sp)
                    Spacer(modifier = Modifier.width(115.dp))
                    IconComponent(
                        imageVector = Icons.Outlined.FilterAlt,
                        contextDescription = "Filtro"
                    )
                    Spacer(modifier = Modifier.width(18.dp))

                    IconComponent(
                        imageVector = Icons.Outlined.Search,
                        contextDescription = "Search"
                    )
                    Spacer(modifier = Modifier.width(18.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "M1", fontSize = 25.sp)
                        IconComponent(
                            imageVector = Icons.Outlined.ArrowDropDown,
                            contextDescription = "Filtro",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                LazyRow(
                    modifier = Modifier.padding(16.dp)
                ) {
                    item {
                        ButtonComponent(
                            onClickCallback = { /*TODO*/ },
                            text = "Forex",
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        ButtonComponent(
                            onClickCallback = { /*TODO*/ },
                            text = "Criptomoedas"
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        ButtonComponent(
                            onClickCallback = { /*TODO*/ },
                            text = "Index Future"
                        )
                    }
                }

                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    item(40) {
                        for (i in 1..100) {
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                                .height(70.dp),

                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(16.dp)
                        ) {
                            Text(text = "Card do maneiro $i")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        }

                    }
                }

            }
        }
    }
}