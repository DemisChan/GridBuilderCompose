package com.example.gridbuildercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridbuildercompose.data.DataSource
import com.example.gridbuildercompose.model.CourseTopic
import com.example.gridbuildercompose.ui.theme.GridBuilderComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridBuilderComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicApp()
                }
            }
        }
    }
}


@Composable
fun TopicApp() {
    TopicGrid(topicGrid = DataSource.topics)
}


@Composable
fun TopicGrid(topicGrid: List<CourseTopic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topicGrid) { topic ->
            GridItem(courseTopic = topic)
        }
    }

}

@Composable
fun GridItem(courseTopic: CourseTopic, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = Color.LightGray)

    ) {
        Image(
            painter = painterResource(id = courseTopic.imageRes),
            contentDescription = stringResource(id = courseTopic.topicName),
            modifier = Modifier
                .size(68.dp)
        )
        Box {
            Column {
                Text(
                    text = stringResource(id = courseTopic.topicName),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = "Grains",
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = courseTopic.count.toString(),
                        modifier = Modifier
                            .padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun GridItemPreview() {
    GridItem(
        courseTopic = CourseTopic(R.string.architecture, 100, R.drawable.architecture)
    )
}

@Preview(showBackground = true)
@Composable
fun GridPreview() {
    TopicGrid(topicGrid = DataSource.topics)
}