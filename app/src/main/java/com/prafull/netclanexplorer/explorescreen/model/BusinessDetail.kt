package com.prafull.netclanexplorer.explorescreen.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class BusinessDetail(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val place: String,
    val placeDistance: String,
    val status: String,
    val profileScore: Int,
    @DrawableRes val profileImage: Int = 0,
)
