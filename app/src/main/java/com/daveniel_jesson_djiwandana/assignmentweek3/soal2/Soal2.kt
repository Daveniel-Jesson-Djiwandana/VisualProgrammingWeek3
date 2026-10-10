package com.daveniel_jesson_djiwandana.assignmentweek3.soal2


import com.daveniel_jesson_djiwandana.assignmentweek3.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun Soal2View(){
    val helper = remember { MutableInteractionSource() }
    val buttonPress by helper.collectIsPressedAsState()

    var cat = R.drawable.catclose
    if (buttonPress) {
        cat = R.drawable.catopen
    } else {
        R.drawable.catclose
    }
    var sound = "Purr~"
    if (buttonPress) {
        sound = "Meow!"
    } else {
        sound = "Purr~"
    }
    var coins by rememberSaveable { mutableStateOf(0) }
    var value by rememberSaveable { mutableStateOf(1) }
    var valueSelanjutnya = (value * 1.5).roundToInt()
    var cost by rememberSaveable { mutableStateOf(10) }
    val coinsToUpgrade = maxOf(0, cost - coins)
    val canUpgrade = coins >= cost
    var coinAmount = ""
    if (canUpgrade) {
        coinAmount = "Pay for $cost coins"
    } else {
        coinAmount = "Find $coinsToUpgrade more coins"
    }
    Box(){
        Image(
            painter = painterResource(R.drawable.wallpapersoal2),"", Modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )
        Column() {
            Row(Modifier
                .padding(40.dp)
                .padding(top = 30.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Card(
                    modifier = Modifier
                        .width(170.dp)
                        .height(170.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.3f)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Your Coins",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )

                        Text(
                            "$coins",
                            Modifier.padding(5.dp),
                            color = Color(0xFF00FF88),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "${value} coins per tap",
                            color = Color.White
                            ,fontWeight = FontWeight.Bold,
                            fontSize = 20.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Tap the cat",Modifier.padding(12.dp), fontSize = 25.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    Image(
                        painter = painterResource(cat),
                        contentDescription = "Tap the Cat",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(180.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable(
                                interactionSource = helper,
                                indication = null,
                                onClick = {coins += value }
                            )
                    )
                    Text(sound,Modifier.padding(12.dp), fontSize = 20.sp, color = Color.White)
                }
            }
            Row(Modifier
                .padding(40.dp)
                .padding(top = 10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Card(
                    modifier = Modifier
                        .width(400.dp)
                        .height(170.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Give me your coin",
                            Modifier.padding(5.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                        )

                        Text(
                            text = "Next upgrade: +$valueSelanjutnya coins per tap",
                            fontSize = 16.sp
                        )

                        Button(
                            onClick = {
                                coins -= cost
                                cost *= 2
                                value = valueSelanjutnya
                            },
                            enabled = canUpgrade,
                            modifier = Modifier.width(320.dp).height(60.dp).padding(5.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF089C14)
                            )

                        ) {Text(coinAmount, fontSize = 16.sp, fontWeight = FontWeight.Bold) }
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2Preview(){
    Soal2View()
}

