package com.prafull.netclanexplorer.explorescreen.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafull.netclanexplorer.R
import com.prafull.netclanexplorer.explorescreen.model.ServiceStructure
import com.prafull.netclanexplorer.ui.theme.cityAndRoleColor
import com.prafull.netclanexplorer.ui.theme.topAppBarColor

@Composable
fun ServicesCard(service: ServiceStructure) {
    Box(
            modifier = Modifier.fillMaxWidth()
    ) {
        Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
        ) {
            Spacer(modifier = Modifier.weight(.15f))
            OutlinedCard(
                    modifier = Modifier
                        .weight(.85f)
                        .fillMaxHeight(),
                    colors = CardDefaults.outlinedCardColors(containerColor = White),
                    border = BorderStroke(1.dp, White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                    shape = RoundedCornerShape(15)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(.15f))
                    Column(modifier = Modifier.weight(.85f)) {
                        NameAndInviteSection(service.name, service.invited, Modifier.fillMaxWidth())
                        PlaceAndDistanceService(service.place, service.placeDistance)
                        ProfileScoreSection(service.profileScore)
                        CallAndAddSection()
                    }
                }
                Text(
                        text = service.role + " | " + service.experience + " of experience",
                        color = cityAndRoleColor,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp, start = 16.dp, end = 8.dp)
                )
                Text(
                        text = service.status,
                        color = cityAndRoleColor,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp, start = 16.dp, end = 8.dp)
                )
                Text(
                        text = service.description,
                        color = cityAndRoleColor,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp, start = 16.dp, end = 8.dp)
                )

            }
        }
        Image(
                painter = painterResource(id = R.drawable.test),
                contentDescription = "user image",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                alpha = 1f,
                contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun CallAndAddSection(showLocation: Boolean = false) {
    Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        FilledIconButton(
                modifier = Modifier.size(32.dp),
                colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = topAppBarColor, contentColor = White
        ), shape = CircleShape, onClick = { /*TODO*/ }) {
            Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.baseline_call_24),
                    contentDescription = "Call"
            )
        }
        FilledIconButton(
                modifier = Modifier.size(32.dp),
                colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = topAppBarColor, contentColor = White
        ), shape = CircleShape, onClick = { /*TODO*/ }) {
            Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.baseline_person_add_alt_1_24),
                    contentDescription = "Call"
            )
        }
        if (showLocation) {
            FilledIconButton(
                    modifier = Modifier.size(32.dp),
                    colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = topAppBarColor, contentColor = White
            ), shape = CircleShape, onClick = { /*TODO*/ }) {
                Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.baseline_location_on_24),
                        contentDescription = "Location"
                )
            }
        }
    }
}

@Composable
fun PlaceAndDistanceService(place: String, distance: String) {
    Text(
            text = "$place, within$distance",
            color = cityAndRoleColor,
            fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(4.dp))
}