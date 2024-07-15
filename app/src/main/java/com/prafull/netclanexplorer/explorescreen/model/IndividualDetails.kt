package com.prafull.netclanexplorer.explorescreen.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Purpose(val purpose: String, val icon: String)

data class IndividualDetails(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val place: String,
    val placeDistance: String,
    val purposes: List<Purpose>,
    val status: String,
    val profileScore: Int,
    var invited: Boolean = false,
    @DrawableRes val profileImage: Int = 0,
    val role: String
)
