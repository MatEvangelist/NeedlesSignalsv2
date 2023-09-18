package br.com.fiap.needlessignals.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness1
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.needlessignals.R
import br.com.fiap.needlessignals.data.DummyAtivosDataSource
import br.com.fiap.needlessignals.data.model.Ativos

@Composable
fun AtivoCard(
    ativo: Ativos,
) {
    Column {
        Card(
            modifier = Modifier.run {
                fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable(onClick = {})
            },
            elevation = CardDefaults.cardElevation(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp, 40.dp),
                        imageVector = Icons.Outlined.StarBorder,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.CenterStart
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        modifier = Modifier
                            .size(30.dp, 30.dp),
                        painter = painterResource(id = R.drawable.eurusd),
                        contentDescription = "",
                        alignment = Alignment.CenterStart
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = ativo.name,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                        )

                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(15.dp),
                        imageVector = Icons.Filled.Brightness1,
                        contentDescription = "",
                        tint = if (ativo.isBuy) Color.Green else Color.Red
                    )
                    Icon(
                        modifier = Modifier
                            .size(15.dp),
                        imageVector = Icons.Filled.Brightness1,
                        contentDescription = "",
                        tint = if (ativo.isBuy) Color.Green else Color.Red
                    )
                    Icon(
                        modifier = Modifier
                            .size(15.dp),
                        imageVector = Icons.Filled.Brightness1,
                        contentDescription = "",
                        tint = if (ativo.isBuy) Color.Green else Color.Red
                    )
                }
            }
        }
        Text(
            modifier = Modifier.align(Alignment.End).padding(end=16.dp).offset(y = (-7).dp),
            text = "Comprar com precaução"
        )
    }

    @Composable
    fun GenderTag(gender: String, modifier: Modifier) {
        val color = if (gender == "Male") {
            Color.Blue
        } else {
            Color.Red
        }
        Box(
            modifier = modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(12.dp))
                .background(color.copy(.2f))
        ) {
            Text(
                text = gender,
                modifier = Modifier.padding(12.dp, 4.dp, 12.dp, 6.dp),
                style = MaterialTheme.typography.labelSmall,
                color = color
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevPetInfoItem() {
    val ativoItems = DummyAtivosDataSource.ativosList.random()
    AtivoCard(ativoItems)
}

