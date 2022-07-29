package com.sevban.profilewithsplasscreen.composables


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sevban.profilewithsplasscreen.R
import com.sevban.profilewithsplasscreen.model.Portfolio


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeadCardView(portfolioList: ArrayList<Portfolio>) {

    var showPortfolioState by remember { mutableStateOf(false)}


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        Card(modifier = Modifier.padding(16.dp), elevation = 6.dp) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                ProfilePicture(
                    image = R.drawable.ic_launcher_background,
                    modifier = Modifier
                        .size(250.dp)
                        .padding(32.dp)
                )
                ClassicText(
                    textSize = MaterialTheme.typography.h4,
                    name = "Sevban Bayır",
                    weight = FontWeight.Bold
                )
                ClassicText(
                    textSize = MaterialTheme.typography.h6,
                    name = "Native Android Developer",
                    weight = FontWeight.Light,
                    modifier = Modifier.alpha(0.4f)
                )
                ClassicText(
                    textSize = MaterialTheme.typography.subtitle2,
                    name = "@Hepsiburada",
                    weight = FontWeight.SemiBold,
                    Modifier
                        .alpha(0.8f)
                        .padding(bottom = 16.dp)
                )

                Divider()

                ClassicButton(onClick = { showPortfolioState = !showPortfolioState })

                AnimatedContent(targetState = showPortfolioState) { targetState ->
                    if (targetState){

                        Card(
                            Modifier
                                .padding(8.dp)
                                .border(
                                    BorderStroke(3.dp, color = Color.LightGray),
                                    shape = RoundedCornerShape(6.dp)
                                )
                        ) {

                            LazyColumn() {
                                items(portfolioList) {
                                    PortfolioRow(porfolioElement = it)
                                    Divider()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfilePicture(image: Int, modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = image),
        contentDescription = "Profile Picture",
        modifier = modifier
            .clip(shape = CircleShape)
    )
}

@Composable
fun ClassicText(
    textSize: TextStyle,
    name: String,
    weight: FontWeight,
    modifier: Modifier = Modifier
) {

    Text(
        text = name,
        fontSize = textSize.fontSize,
        fontWeight = weight,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun ClassicButton(onClick: () -> Unit, modifier: Modifier= Modifier) {
    Button(onClick = onClick, modifier = modifier.padding(10.dp)) {
        Text(text = "Show the Portfolio")
    }

}

@Composable
fun PortfolioRow(porfolioElement: Portfolio) {

    Surface(color = MaterialTheme.colors.background, contentColor = MaterialTheme.colors.onBackground) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            ProfilePicture(
                image = R.drawable.ic_launcher_background,
                modifier = Modifier
                    .padding(16.dp)
                    .size(48.dp)
            )

            Column(Modifier.fillMaxWidth()) {

                ClassicText(
                    textSize = MaterialTheme.typography.h6,
                    name = porfolioElement.projectHeader,
                    weight = FontWeight.Bold
                )

                ClassicText(
                    textSize = MaterialTheme.typography.subtitle1,
                    name = porfolioElement.note,
                    weight = FontWeight.Light,
                    modifier = Modifier.alpha(0.6f)
                )
            }
        }
    }
}