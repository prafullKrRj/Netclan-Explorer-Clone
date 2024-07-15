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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafull.netclanexplorer.R
import com.prafull.netclanexplorer.explorescreen.data.individuals
import com.prafull.netclanexplorer.explorescreen.model.IndividualDetails
import com.prafull.netclanexplorer.ui.theme.cityAndRoleColor
import com.prafull.netclanexplorer.ui.theme.inviteButtonColor
import com.prafull.netclanexplorer.ui.theme.profileScoreColor
import com.prafull.netclanexplorer.ui.theme.profileScoreUnfilledColor
import com.prafull.netclanexplorer.ui.theme.tabRowColor

@Composable
fun IndividualCard(individual: IndividualDetails) {
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
                        NameAndInviteSection(
                                individual.name,
                                individual.invited,
                                Modifier.fillMaxWidth()
                        )
                        PlaceAndDistanceSectionIndividual(individual)
                        ProfileScoreSection(individual.profileScore)
                    }
                }
                LazyRow {
                    itemsIndexed(individual.purposes) { index, purpose ->
                        Text(
                                text = "${purpose.icon} ${purpose.purpose}",
                                color = cityAndRoleColor,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(8.dp)
                        )
                        if (index < individual.purposes.size - 1) {
                            Text(
                                    text = "|",
                                    color = cityAndRoleColor,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(4.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }
                Text(
                        text = individual.status,
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
fun PlaceAndDistanceSectionIndividual(individual: IndividualDetails) {
    Text(
            text = individual.place + " | " + individual.role,
            color = cityAndRoleColor,
            fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
            text = "Within ${individual.placeDistance}",
            color = cityAndRoleColor,
            fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun ProfileScoreSection(score: Int) {
    Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LinearProgressIndicator(
                modifier = Modifier
                    .weight(.45f)
                    .clip(RoundedCornerShape(10.dp)),
                progress = { score / 100f },
                color = profileScoreColor,
                trackColor = profileScoreUnfilledColor,
        )
        Text(
                text = "Profile Score ${score}%",
                color = profileScoreColor,
                fontSize = 16.sp,
                modifier = Modifier.weight(.55f)
        )
    }
}

@Composable
fun NameAndInviteSection(name: String, invited: Boolean, modifier: Modifier, showInvite: Boolean = true) {
    Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(top = 4.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
                text = name,
                color = tabRowColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
        )
        if (showInvite) {
            TextButton(modifier = Modifier, onClick = {
            }) {
                if (invited)
                    Text(
                            "INVITED",
                            fontWeight = FontWeight.SemiBold,
                            color = cityAndRoleColor
                    )
                else
                    Text(
                            "+ INVITE",
                            fontWeight = FontWeight.SemiBold,
                            color = inviteButtonColor
                    )
            }
        }
    }
}

@Preview
@Composable
fun IndividualCardPreview() {
    IndividualCard(
            individuals.first()
    )
}