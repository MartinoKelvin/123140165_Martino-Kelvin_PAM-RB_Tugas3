package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource
import pertemuan3.composeapp.generated.resources.Res
import pertemuan3.composeapp.generated.resources.hero

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF9C9A89)),
            contentAlignment = Alignment.Center
        ) {
            ProfileCard()
        }
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProfileHeader(
                name = "Martino Kelvin",
                bio = "Informatics Student ITERA"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoItem("Email", "martino@email.com")
            InfoItem("Phone", "+62 8123456789")
            InfoItem("Location", "Lampung, Indonesia")

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {}) {
                Text("Follow")
            }
        }
    }
}

@Composable
fun ProfileHeader(name: String, bio: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(Res.drawable.hero),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Column(
            horizontalAlignment = Alignment.End
        ) {

            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = bio,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun InfoItem(label: String, value: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = label,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = value,
            color = Color.Gray
        )
    }
}