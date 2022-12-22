package com.evilstan.composetestapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evilstan.composetestapp.ui.theme.ComposeTestAppTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(messageList)
                }
            }
        }
    }
}

data class Message(val author: String, val body: String, val profilePicture: Int?)

val messageList = listOf(
    Message("John Doe", "Lorem Iasd,;lfegvelv,eovwovwveogmdfpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem Iasd,;lfegvelv,eovwovwveogmdfpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem Iasd,;lfegvelv,eovwovwveogmdfpsum", R.drawable.john_doe),
    Message("John Doe", "LoremmknfgnmktrpHTYRF THRTBR   hbtr bomtr Ipsum", R.drawable.john_doe),
    Message("John Doe", "Loremhthbtntntnntrrmrn yrn rynytt Ipsum", R.drawable.john_doe),
    Message("John Doe", "Loremhthbtntntnntrrmrn yrn rynytt Ipsum", R.drawable.john_doe),
    Message("John Doe", "Loremhthbtntntnntrrmrn yrn rynytt Ipsum", R.drawable.john_doe),
    Message("John Doe", "Lorem btyngfdui.iu.umyt nr thhtr hei.uirtnfgIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem btyngfdui.iu.umyt nr thhtr hei.uirtnfgIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem btyngfdui.iu.umyt nr thhtr hei.uirtnfgIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem btyngfdui.iu.umyt nr thhtr hei.uirtnfgIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem btyngfdui.iu.umyt nr thhtr hei.uirtnfgIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem ntjik.huihui.jkiuhreh rereg re ugrntIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem ntjik.huihui.jkiuhreh rereg re ugrntIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem ntjik.huihui.jkiuhreh rereg re ugrntIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem ntrntrnnberhdhjt gre reg rnmhytmhIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem ntrntrnnberhdhjt gre reg rnmhytmhIpsum", R.drawable.john_doe),
    Message("John Doe", "Lorem ntrntrnnberhdhjt gre reg rnmhytmhIpsum", R.drawable.john_doe),
    Message(
        "John Doe",
        "Lorem jyu,k.iukiu.luyhreg rgrgr gr  rrrj,iykh,ih.i.Ipsum",
        R.drawable.john_doe
    )
)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn() {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(
                id = msg.profilePicture ?: R.drawable.ic_launcher_foreground
            ), contentDescription = "userPicture", modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode")
@Composable
fun DefaultPreview() {
    ComposeTestAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Conversation(messageList)
        }
    }
}