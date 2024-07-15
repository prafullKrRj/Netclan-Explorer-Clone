package com.prafull.netclanexplorer.explorescreen.data

import com.prafull.netclanexplorer.explorescreen.model.IndividualDetails
import com.prafull.netclanexplorer.explorescreen.model.Purpose

val purposes = listOf(
        Purpose("Coffee", "☕"), Purpose("Business", "💼"), Purpose("Hobbies", "🎨"),
        Purpose("Friendship", "🤝"), Purpose("Movies", "🎬"), Purpose("Dining", "🍽️"),
        Purpose("Dating", "❤️"), Purpose("Matrimony", "💍")
)
val statuses = listOf(
        "Hi Community! I am open to new connections.",
        "Currently busy with work, open to connections soon.",
        "Exploring new opportunities, feel free to reach out.",
        "Available for collaborations and networking.",
        "On a break, will connect later."
)
val individuals: List<IndividualDetails> = listOf(
        IndividualDetails(
                name = "John Doe",
                place = "New York",
                placeDistance = "10 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 85,
                role = "Student"
        ),
        IndividualDetails(
                name = "Jane Smith",
                place = "Los Angeles",
                placeDistance = "20 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 75,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Alice Johnson",
                place = "Chicago",
                placeDistance = "30 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 90,
                role = "Student"
        ),
        IndividualDetails(
                name = "Bob Brown",
                place = "Houston",
                placeDistance = "40 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 60,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Charlie Davis",
                place = "Phoenix",
                placeDistance = "50 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 70,
                role = "Student"
        ),
        IndividualDetails(
                name = "David Wilson",
                place = "Philadelphia",
                placeDistance = "15 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 88,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Eva Moore",
                place = "San Antonio",
                placeDistance = "25 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 78,
                role = "Student"
        ),
        IndividualDetails(
                name = "Frank Harris",
                place = "San Diego",
                placeDistance = "35 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 82,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Grace Clark",
                place = "Dallas",
                placeDistance = "45 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 65,
                role = "Student"
        ),
        IndividualDetails(
                name = "Hank Lewis",
                place = "San Jose",
                placeDistance = "55 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 95,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Ivy Walker",
                place = "Austin",
                placeDistance = "12 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 77,
                role = "Student"
        ),
        IndividualDetails(
                name = "Jack King",
                place = "Jacksonville",
                placeDistance = "22 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 89,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Kara Lee",
                place = "Fort Worth",
                placeDistance = "32 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 91,
                role = "Student"
        ),
        IndividualDetails(
                name = "Liam Hall",
                place = "Columbus",
                placeDistance = "42 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 67,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Mia Young",
                place = "Charlotte",
                placeDistance = "52 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 74,
                role = "Student"
        ),
        IndividualDetails(
                name = "Noah Allen",
                place = "San Francisco",
                placeDistance = "18 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 83,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Olivia Scott",
                place = "Indianapolis",
                placeDistance = "28 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 68,
                role = "Student"
        ),
        IndividualDetails(
                name = "Paul Adams",
                place = "Seattle",
                placeDistance = "38 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 92,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Quinn Baker",
                place = "Denver",
                placeDistance = "48 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 64,
                role = "Student"
        ),
        IndividualDetails(
                name = "Ruby Mitchell",
                place = "Washington",
                placeDistance = "58 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 86,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Sam Carter",
                place = "Boston",
                placeDistance = "11 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 76,
                role = "Student"
        ),
        IndividualDetails(
                name = "Tina Turner",
                place = "El Paso",
                placeDistance = "21 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 81,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Uma Phillips",
                place = "Nashville",
                placeDistance = "31 km",
                purposes = purposes.shuffled().take(4),
                status = statuses.random(),
                profileScore = 73,
                role = "Student"
        ),
        IndividualDetails(
                name = "Vince Campbell",
                place = "Detroit",
                placeDistance = "41 km",
                purposes = purposes.shuffled().take(5),
                status = statuses.random(),
                profileScore = 79,
                role = "Professional"
        ),
        IndividualDetails(
                name = "Wendy Parker",
                place = "Portland",
                placeDistance = "51 km",
                purposes = purposes.shuffled().take(3),
                status = statuses.random(),
                profileScore = 84,
                role = "Student"
        )
)
