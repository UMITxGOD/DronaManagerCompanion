package com.example.dronamanagercompanion.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.dronamanagercompanion.R

@Composable
fun PlayerCardView(
    playerImage : String ,
    title : String,
    description : String,
    county:String ,
    modifier: Modifier = Modifier ,
    onClick : (name:String)->Unit ,

)
{
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxWidth(0.5f)
        .padding(2.dp))
    {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )

        ) {
            Box(modifier = Modifier.height(200.dp))
            {
                    AsyncImage(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(playerImage)
                            .crossfade(true)
                            .build() ,
                        contentDescription = title,
                        placeholder = painterResource(id = R.drawable.default_player) ,
                        contentScale = ContentScale.Crop ,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight(0.5f)
                    )

                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 10.dp)
                    .clickable { onClick(title) },
                    contentAlignment = Alignment.TopStart
                ){
                    Text(text = title,
                        style = TextStyle(color = Color.Black, fontSize = 13.sp,
                            fontFamily = FontFamily.Serif)
                    )

                }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 41.dp)
                    .clickable { onClick(title) },
                    contentAlignment = Alignment.TopStart
                ){
                    Text(text = "$county || $description",
                        style = TextStyle(color = Color.Black, fontSize = 11.sp)
                    )

                }
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(20.dp, 85.dp)
                    .clickable {
                        val shareIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT , title)
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(shareIntent, null))
                    }
                ){
                    Image(
                        painter = painterResource(id = R.drawable.share),
                        contentDescription =null,
                        contentScale = ContentScale.None,

                    )
                }

            }

        }

    }
}
