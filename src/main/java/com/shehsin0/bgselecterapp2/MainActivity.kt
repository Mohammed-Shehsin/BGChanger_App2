package com.shehsin0.bgselecterapp2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private var resultText = Color.WHITE

    private val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult? ->

        if (result?.resultCode == Activity.RESULT_OK){
            resultText = result.data?.getIntExtra("selectedColor", Color.WHITE)!!
            val view = findViewById<View>(R.id.view)
            view.setBackgroundColor(resultText)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.button)


        btnNext.setOnClickListener {


            val intent = Intent(this,SecondActivity::class.java)

            resultContract.launch(intent)

        }
    }
}