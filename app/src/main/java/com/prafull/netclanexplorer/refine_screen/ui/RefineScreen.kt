package com.prafull.netclanexplorer.refine_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prafull.netclanexplorer.explorescreen.data.purposes
import com.prafull.netclanexplorer.ui.theme.cityAndRoleColor
import com.prafull.netclanexplorer.ui.theme.tabRowColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RefineScreen(refineViewModel: RefineViewModel = viewModel()) {
    val scrollState = rememberScrollState()

    Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AvailabilitySection()
        AddYourStatusSection()
        HyperLocalDistanceSection()
        SelectPurposeSection(refineViewModel = refineViewModel)
        SaveAndExploreButton()
    }
}

/*
*   Availability Section
* */
@Composable
fun AvailabilitySection() {
    var expanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val value = rememberSaveable {
        mutableStateOf("Available | Hey Let Us Connect")
    }
    Text(
            text = "Select Your Availability",
            color = tabRowColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
    )
    Column {
        OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value.value,
                onValueChange = {},
                enabled = false,
                colors = TextFieldDefaults.colors(
                        disabledContainerColor = Color.White,
                        disabledIndicatorColor = tabRowColor,
                        disabledTextColor = tabRowColor,
                        disabledTrailingIconColor = tabRowColor
                ),
                trailingIcon = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Drop Down"
                        )
                    }
                },
                shape = RoundedCornerShape(12.dp),
                textStyle = TextStyle(
                        fontSize = 14.sp
                )
        )
        DropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                expanded = expanded,
                onDismissRequest = { expanded = false },
                scrollState = scrollState
        ) {
            availabilities.forEach { availability ->
                DropdownMenuItem(
                        modifier = Modifier,
                        text = { Text(availability) },
                        onClick = {
                            value.value = availability
                            expanded = false
                        },
                )
            }
        }
    }
    LaunchedEffect(expanded) {
        if (expanded) {
            scrollState.scrollTo(scrollState.maxValue)
        }
    }
}

@Composable
fun AddYourStatusSection(modifier: Modifier = Modifier) {
    val value = rememberSaveable {
        mutableStateOf("Hi community! I am open to new connections")
    }
    Text(
            text = "Add Your Status", color = tabRowColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
    )
    OutlinedTextField(
            value = value.value, onValueChange = {
        value.value = it
    }, Modifier.fillMaxWidth(), colors = TextFieldDefaults.colors(
            focusedIndicatorColor = tabRowColor,
            unfocusedIndicatorColor = cityAndRoleColor,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
    ),
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle(
                    fontSize = 14.sp
            )
    )
}

@Composable
fun HyperLocalDistanceSection(modifier: Modifier = Modifier) {
    var sliderValue by remember { mutableFloatStateOf(55f) }
    Text(
            text = "Select Hyper local Distance",
            color = tabRowColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(20.dp))
    MovingBubbleSlider(
            value = sliderValue,
            onValueChange = { sliderValue = it }
    )
}

@Composable
fun MovingBubbleSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 1f..100f
) {
    Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
    ) {
        val sliderWidth = remember { mutableStateOf(0) }
        Slider(
                value = value,
                onValueChange = onValueChange,
                valueRange = valueRange,
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        sliderWidth.value = coordinates.size.width
                    }
                    .align(Alignment.BottomCenter),
                colors = SliderDefaults.colors(
                        activeTrackColor = tabRowColor,
                        thumbColor = tabRowColor,
                )
        )
        Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth()
                    .offset(y = (-30).dp)
        ) {
            Text(
                    text = value.toInt().toString(),
                    modifier = Modifier
                        .offset {
                            val position = (value / valueRange.endInclusive) * sliderWidth.value
                            IntOffset(position.toInt() - 12.dp.roundToPx(), 0)
                        }
                        .background(
                                color = tabRowColor,
                                shape = BubbleShape()
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
            )
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectPurposeSection(refineViewModel: RefineViewModel) {
    Text(
            text = "Select Purpose",
            color = tabRowColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
    )
    FlowRow {
        purposes.forEach {
            FilterChip(
                    colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = tabRowColor,
                            selectedLabelColor = Color.White,
                    ),
                    selected = refineViewModel.selected.contains(it.purpose),
                    onClick = {
                        if (refineViewModel.selected.contains(it.purpose)) {
                            refineViewModel.selected.remove(it.purpose)
                        } else {
                            refineViewModel.selected.add(it.purpose)
                        }
                    },
                    label = {
                        Text(
                                text = it.purpose,
                                color = if (refineViewModel.selected.contains(it.purpose)) Color.White else tabRowColor,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun SaveAndExploreButton(modifier: Modifier = Modifier) {
    Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
    ) {
        Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                        containerColor = tabRowColor,
                        contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
        ) {
            Text(text = "Save & Explore")
        }
    }
}


val availabilities = listOf(
        "Available | Hey Let Us Connect",
        "Away | Stay Discrete and watch",
        "Busy | Do not Disturb | Will Catch Up Later",
        "SOS | Emergency! Need Assistance! HELP"
)

class BubbleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val triangleHeight = 20.dp.value
        reset()
        moveTo(0f, 0f)
        lineTo(size.width, 0f)
        lineTo(size.width, size.height - triangleHeight)
        lineTo(size.width / 2 + triangleHeight, size.height - triangleHeight)
        lineTo(size.width / 2, size.height)
        lineTo(size.width / 2 - triangleHeight, size.height - triangleHeight)
        lineTo(0f, size.height - triangleHeight)
        close()
    })
}