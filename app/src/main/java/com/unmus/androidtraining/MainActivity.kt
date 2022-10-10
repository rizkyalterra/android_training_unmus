package com.unmus.androidtraining

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmus.androidtraining.ui.theme.AndroidTrainingTheme

class MainActivity : ComponentActivity() {
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
    Row(
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Image(painter =
        painterResource(id = R.drawable.univmusamus),
            contentDescription = "Uni musamus",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        ,
        contentScale = ContentScale.Crop)
        Column() {
            Text(text = user.name)
            Text(text = user.address)
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