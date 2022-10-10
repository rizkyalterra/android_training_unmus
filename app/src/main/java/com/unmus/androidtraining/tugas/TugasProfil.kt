package com.unmus.androidtraining.tugas

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmus.androidtraining.ui.theme.AndroidTrainingTheme
import com.unmus.androidtraining.ui.theme.Red200

class TugasProfil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTrainingTheme{
                Surface(modifier = Modifier.fillMaxSize()) {
                    val user = User("Unmus", "Papua", 30)
                    MenampilkanPesan(user)
                }
            }
        }
    }
}

data class User(
    val name: String,
    val address: String,
    val umur: Int
)

@Composable
fun MenampilkanPesan(user: User){
    Column(
        modifier = Modifier.padding(all = 16.dp)
            .fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(painter =
        painterResource(id = com.unmus.androidtraining.R.drawable.univmusamus),
            contentDescription = "Uni musamus",
            modifier = Modifier
                // Set image size to 40 dp
                .size(60.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
            contentScale = ContentScale.Crop)
        Column(
            modifier = Modifier.padding(all = 16.dp)
                .fillMaxWidth(1f),
            horizontalAlignment = Alignment.Start

        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Nama", color = Color.Gray, modifier = Modifier.width(100.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp, modifier = Modifier.fillMaxWidth(1f)) {
                    Text(
                        text = user.name,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Alamat", color = Color.Gray, modifier = Modifier.width(100.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp, modifier = Modifier.fillMaxWidth(1f)) {
                    Text(
                        text = user.address,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Umur", color = Color.Gray, modifier = Modifier.width(100.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp, modifier = Modifier.fillMaxWidth(1f)) {
                    Text(
                        text = user.umur.toString(),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenampilkanPesan(){
    val user = User("Unmus", "Papua", 30)
    MenampilkanPesan(user)
}


@Composable
fun Conversation(users: List<User>) {
    LazyRow {
        items(users) { user ->
            MenampilkanPesan(user = user)
        }
    }
}