  package com.example.nweavetask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nweavetask.R
import dagger.hilt.android.AndroidEntryPoint
  @AndroidEntryPoint
class HostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }
}