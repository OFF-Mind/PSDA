package com.alexvolkov.test

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alexvolkov.test.domain.TileOpenHandler
import com.alexvolkov.test.samplescreen.SampleScreen
import com.alexvolkov.test.samplescreen.presentation.SampleViewModel
import com.alexvolkov.test.samplescreen.presentation.SampleViewModelEvents
import com.alexvolkov.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                val vm = SampleViewModel(TileOpenHandler())

                SampleScreen(vm) { event ->
                    when (event) {
                        is SampleViewModelEvents.OpenVideo -> {
                            // navigate to video screen
                        }

                        is SampleViewModelEvents.ShowError -> {
                            Toast.makeText(this, "Error: ${event.errorId}", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
}
