package com.daveniel_jesson_djiwandana.assignmentweek3.soal3

import com.daveniel_jesson_djiwandana.assignmentweek3.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class halamanApa {WELCOME, HITUNG, GAME, DONE}
enum class mode {TEXT, COLOR}
@Composable
fun Soal3View(){
    var pageState by remember {mutableStateOf(halamanApa.WELCOME)}
    var countDown by remember {mutableStateOf("")}
    when(pageState) {
        halamanApa.WELCOME -> {
            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
                Text("Welcome\ntp\nColor Word Matching")
                Button(
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    )
                    ) {
            
                }
            }
        }
        halamanApa.HITUNG -> {

        }
        halamanApa.GAME -> {

        }
        halamanApa.DONE -> {

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal3Preview(){
    Soal3View()
}