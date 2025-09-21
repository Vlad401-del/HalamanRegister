package com.example.halamanregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.halamanregister.ui.theme.HalamanRegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HalamanRegisterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    //kalkulator nanti
                    RegisterPage()
                }
            }
        }
    }
}

@Composable
fun RegisterPage() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Halo",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        var nama by remember { mutableStateOf("") }

        OutlinedTextField(
            value =  nama,
            onValueChange = {nama = it}, //menyimpan teks baru it ke memori saat user mengetik
            label = {Text("Nama Lengkap")}, //label
            modifier = Modifier.fillMaxWidth()
        )

        var nim by remember { mutableStateOf("") }

        OutlinedTextField(
            value = nim,
            onValueChange = {nim = it},
            label = {Text("NIM")},
            modifier = Modifier.fillMaxWidth()
        )
    }
}