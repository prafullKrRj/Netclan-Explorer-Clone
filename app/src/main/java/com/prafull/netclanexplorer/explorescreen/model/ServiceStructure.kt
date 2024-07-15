package com.prafull.netclanexplorer.explorescreen.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class ServiceStructure(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val place: String,
    val placeDistance: String,
    val status: String,
    val description: String,
    val profileScore: Int,
    var invited: Boolean = false,
    @DrawableRes val profileImage: Int = 0,
    val role: String,
    val experience: String
)
