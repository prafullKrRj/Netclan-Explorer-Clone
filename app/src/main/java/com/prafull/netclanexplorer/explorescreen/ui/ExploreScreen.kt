package com.prafull.netclanexplorer.explorescreen.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prafull.netclanexplorer.explorescreen.data.businesses
import com.prafull.netclanexplorer.explorescreen.data.individuals
import com.prafull.netclanexplorer.explorescreen.data.services
import com.prafull.netclanexplorer.ui.theme.tabRowColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize()) {

        val tabTitles = listOf("Personal", "Services", "Businesses")
        val pagerState = rememberPagerState(pageCount = { tabTitles.size })
        val scope = rememberCoroutineScope()

        Column {
            TabRow(
                    selectedTabIndex = pagerState.currentPage,
                    containerColor = tabRowColor,
                    contentColor = Color.White
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                            text = { Text(title) },
                            selected = pagerState.currentPage == index,
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                    )
                }
            }

            HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> PersonalScreen()
                    1 -> ServicesScreen()
                    2 -> BusinessesScreen()
                }
            }
        }

    }
}

@Composable
fun BusinessesScreen() {
    LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(businesses, key = {
            it.id
        }) { businessDetail ->
            BusinessCard(businessDetail)
        }
    }
}

@Composable
fun ServicesScreen() {
    LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(services, key = {
            it.id
        }) { service ->
            ServicesCard(service)
        }
    }
}

@Composable
fun PersonalScreen(modifier: Modifier = Modifier) {
    LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(individuals, key = {
            it.id
        }) { individual ->
            IndividualCard(individual)
        }
    }
}