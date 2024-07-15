package com.prafull.netclanexplorer.refine_screen.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class RefineViewModel : ViewModel() {

    val selected = mutableStateListOf<String>()
}