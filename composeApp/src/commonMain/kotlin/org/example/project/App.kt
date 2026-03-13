package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import pertemuan3.composeapp.generated.resources.Res
import pertemuan3.composeapp.generated.resources.hero
import pertemuan3.composeapp.generated.resources.kelinci
import pertemuan3.composeapp.generated.resources.sapi
import pertemuan3.composeapp.generated.resources.ayam


@Composable
@Preview
fun App() {

    val products = listOf(
        Product(
            "Kelinci",
            "Rp 100.000",
            "Kelinci hias yang lucu dan ramah, cocok dipelihara di rumah.",
            Res.drawable.kelinci
        ),
        Product(
            "Ayam",
            "Rp 80.000",
            "Ayam kampung sehat yang cocok untuk diternakkan atau dikonsumsi.",
            Res.drawable.ayam
        ),
        Product(
            "Sapi",
            "Rp 7.500.000",
            "Sapi berkualitas tinggi untuk peternakan dan produksi daging.",
            Res.drawable.sapi
        )
    )

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF9C9A89))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            ProfileCard()

            products.forEach {
                ProductItem(it)
            }

        }

    }
}

@Composable
fun ProfileCard() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column {

            ProfileHeader()

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                InfoItem(Icons.Default.Email, "martino@email.com")

                InfoItem(Icons.Default.Phone, "+62 8123456789")

                InfoItem(Icons.Default.LocationOn, "Lampung, Indonesia")

            }

        }

    }

}

@Composable
fun ProfileHeader() {

    var isFollowing by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4A4F57))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.hero),
                contentDescription = "Profile Photo",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Martinokelvin_",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

        }

        Button(
            onClick = {
                isFollowing = !isFollowing
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowing) Color.Gray else Color(0xFF0095F6)
            )
        ){
            Text(
                if (isFollowing) "Unfollow" else "Follow"
            )
        }

    }

}

@Composable
fun InfoItem(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.DarkGray
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            fontSize = 16.sp
        )

    }

}