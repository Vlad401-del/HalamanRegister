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
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import android.widget.Toast
import androidx.compose.material3.Divider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.halamanregister.ui.theme.HalamanRegisterTheme
import kotlin.math.tan

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
                    RegisterPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Darryl M. Immanuel Panggabean",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            // textAlign = TextAlign.Center
        )
        Text(
            text = "245150400111056",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        Text(
            text = "Halo, Selamat Datang",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
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

        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Email")},
            modifier = Modifier.fillMaxWidth()
        )

        var tanggalLahir by remember { mutableStateOf("Pilih tanggal lahir") }
        var showDialog by remember { mutableStateOf(false) }

        Button(onClick = {showDialog = true}, modifier = Modifier.fillMaxWidth()) {
            Text(text = tanggalLahir)
        }

        if (showDialog) {
            val datePickerState = rememberDatePickerState()
            DatePickerDialog(
                onDismissRequest = {showDialog = false},
                confirmButton = {
                    Button(onClick = {
                        datePickerState.selectedDateMillis?.let {
                            val selectedDate = java.util.Calendar.getInstance().apply{
                                timeInMillis = it
                            }
                            val day = selectedDate.get(java.util.Calendar.DAY_OF_MONTH)
                            val month = selectedDate.get(java.util.Calendar.MONTH)
                            val year = selectedDate.get(java.util.Calendar.YEAR)
                            tanggalLahir = "$day/${month + 1}/$year"
                        }
                        showDialog = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    Button(onClick = {showDialog = false}) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

//        val context = LocalContext.current
//        Button(onClick = {
//            Toast.makeText(
//                context,
//                "Data diterima: Nama = $nama, NIM = $nim, Tanggal Lahir = $tanggalLahir",
//                Toast.LENGTH_LONG
//            ).show()
//        }, modifier = Modifier.fillMaxWidth()
//            ) { Text("Daftar") }
    }
}