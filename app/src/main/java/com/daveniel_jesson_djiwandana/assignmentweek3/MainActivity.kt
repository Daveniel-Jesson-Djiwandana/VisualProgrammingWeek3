package com.daveniel_jesson_djiwandana.assignmentweek3

import com.daveniel_jesson_djiwandana.assignmentweek3.soal1.Soal1View
import com.daveniel_jesson_djiwandana.assignmentweek3.soal2.Soal2View
import com.daveniel_jesson_djiwandana.assignmentweek3.soal3.Soal3View
import com.daveniel_jesson_djiwandana.assignmentweek3.soal4.Soal4View
import com.daveniel_jesson_djiwandana.assignmentweek3.bonusSoal1.SoalBonus1View
import com.daveniel_jesson_djiwandana.assignmentweek3.bonusSoal2.SoalBonus2View
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daveniel_jesson_djiwandana.assignmentweek3.ui.theme.AssignmentWeek3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentWeek3Theme {
                Soal3View()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AssignmentWeek3Theme {
        Greeting("Android")
    }
}