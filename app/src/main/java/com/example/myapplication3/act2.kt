package com.example.myapplication3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication3.ui.theme.MyApplication3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TampilkanSemuaLayout(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}

// WRAPPER: Menampilkan semua layout dalam satu Scroll

@Composable
fun TampilkanSemuaLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ContohColumn()
        ContohRow()
        TataLetakColumnRow(modifier = Modifier)
        TataLetakRowColumn(modifier = Modifier)
        TataLetakBoxColumnRow(modifier = Modifier)
    }
}

// 1. CONTOH COLUMN

@Composable
fun ContohColumn() {
    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp)
    ) {
        Text("Hello")
        Text("Resya")
    }
}

// 2. CONTOH ROW

@Composable
fun ContohRow() {
    val kata = stringResource(id = R.string.kata)
    Row(
        modifier = Modifier
            .padding(top = 60.dp, start = 60.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Hello ")
        Text(text = kata)
    }
}

// 3. TATA LETAK COLUMN > ROW
@Composable
fun TataLetakColumnRow(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Baris 1
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Komponen1Baris1")
            Text(text = "Komponen2Baris1")
            Text(text = "Komponen3Baris1")
        }

        // Baris 2
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Komponen1Baris2")
            Text(text = "Komponen2Baris2")
            Text(text = "Komponen3Baris2")
        }
    }
}

// 4. TATA LETAK ROW > COLUMN
@Composable
fun TataLetakRowColumn(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Kolom 1
        Column {
            Text(text = "Komponen1Kolom1")
            Text(text = "Komponen2Kolom1")
            Text(text = "Komponen3Kolom1")
        }

        // Kolom 2
        Column {
            Text(text = "Komponen1Kolom2")
            Text(text = "Komponen2Kolom2")
        }
    }
}

// 5. TATA LETAK BOX > COLUMN > ROW
@Composable
fun TataLetakBoxColumnRow(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(height = 110.dp)
                .background(Color(0xFF008080)), // Teal via hex
            contentAlignment = Alignment.Center
        ) {
            Column {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Col1_Row1_Komponen1", color = Color.White)
                    Text(text = "Col1_Row1_Komponen2", color = Color.White)
                    Text(text = "Col1_Row1_Komponen3", color = Color.White)
                }
            }
        }
    }
}

// PREVIEW

@Preview(showBackground = true)
@Composable
fun PreviewSemuaLayout() {
    MyApplication3Theme {
        TampilkanSemuaLayout()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContohColumn() {
    MyApplication3Theme {
        ContohColumn()
    }
}

