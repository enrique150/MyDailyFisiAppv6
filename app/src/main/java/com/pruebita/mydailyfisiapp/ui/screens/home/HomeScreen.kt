package com.pruebita.mydailyfisiapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pruebita.mydailyfisiapp.ui.navigation.AppScreens
import com.pruebita.mydailyfisiapp.ui.theme.poppins

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 15.dp, end = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "¡Hola, Miguel!",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                letterSpacing = 0.78.sp,
            )

        )
        Text(
            text = "Hay un evento en la facultad esta mañana ",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                letterSpacing = 0.48.sp,
            )
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(122.dp)
                .background(
                    color = Color(0xFF495ECA),
                    shape = RoundedCornerShape(size = 20.dp)
                )

        ) {
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column(
                    modifier = Modifier.weight(0.7f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Hackathon",
                            style = TextStyle(
                                fontSize = 28.sp,
                                lineHeight = 34.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                letterSpacing = 0.8.sp,
                            )
                        )
                        Text(
                            text = "Vol 2",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 16.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.Light,
                                color = Color.White,
                            )
                        )
                    }
                    Row(){
                        Text(
                            text = "El día de hoy se presentaran 5 grupos en el Auditorio.",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 19.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.Light,
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                }
                Column(
                    modifier = Modifier.weight(0.3f)
                ) {
                    ElevatedButton(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF495EC9),
                            disabledContainerColor = Color(0xFFB3B6C4)

                        ), contentPadding = PaddingValues(),
                        enabled = true
                    ) {
                        Text(text = "Ver mas", fontSize = 13.sp, fontFamily = poppins)
                    }

                }




            }

        }
        Spacer(modifier = Modifier.padding(8.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ){
            Row(){
                Text(
                    text = "4 Clases Pendientes",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                )
            }


        }

    }
}