package com.example.dronamanagercompanion.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.dronamanagercompanion.models.Player
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun calculateAgeAsString(dobString: String): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val dob: Date = dateFormat.parse(dobString) ?: throw IllegalArgumentException("Invalid date format")

    val calDOB = Calendar.getInstance()
    calDOB.time = dob

    val calNow = Calendar.getInstance()

    var age = calNow.get(Calendar.YEAR) - calDOB.get(Calendar.YEAR)

    if (calNow.get(Calendar.DAY_OF_YEAR) < calDOB.get(Calendar.DAY_OF_YEAR)) {
        age--
    }

    return "$age years" ;
}
@Composable
fun PlayerDetailScreen(
    player : Player ,
    modifier : Modifier = Modifier
)
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp))
    {
        Card(
            modifier = modifier.fillMaxWidth().fillMaxHeight(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        )
        {
            Box(modifier = Modifier.fillMaxWidth()
                .height(70.dp)
                .padding(10.dp)
            )

            {
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(player.countryImage)
                        .crossfade(true)
                        .build() ,
                    contentDescription = player.name,
                    placeholder = painterResource(id = R.drawable.loading_logo) ,
                    contentScale = ContentScale.Inside ,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
            Box(modifier = Modifier.fillMaxWidth()
                .height(250.dp)
            )
            {
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(player.playerImage)
                        .crossfade(true)
                        .build() ,
                    contentDescription = player.name,
                    placeholder = painterResource(id = R.drawable.default_player) ,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.7f)
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
//                .background(Color.Blue)
                .padding(20.dp,0.dp),
                contentAlignment = Alignment.TopStart
            ){
                Text(text = "Full  Name :  "+player.name,
                    style = TextStyle(color = Color.Black, fontSize = 20.sp,
                        fontFamily = FontFamily.Default)
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
//                .background(Color.Yellow)
                .padding(20.dp,0.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Text(text = "Age  :  "+ calculateAgeAsString(player.dob) ,
                    style = TextStyle(color = Color.Black, fontSize = 20.sp,
                        fontFamily = FontFamily.Default))
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
//                .background(Color.Yellow)
                .padding(20.dp,0.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Text(text = "Role  :  "+player.role,
                    style = TextStyle(color = Color.Black, fontSize = 20.sp,
                        fontFamily = FontFamily.Default))
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
//                .background(Color.Yellow)
                .padding(20.dp,0.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Text(text = "Batting  Style  :  "+player.battingStyle,
                    style = TextStyle(color = Color.Black, fontSize = 20.sp,
                        fontFamily = FontFamily.Default))
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
//                .background(Color.Yellow)
                .padding(20.dp,0.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Text(text = "Bowling  Style  :  "+player.bowlingStyle,
                    style = TextStyle(color = Color.Black, fontSize = 20.sp,
                        fontFamily = FontFamily.Default))
            }



        }
    }
}