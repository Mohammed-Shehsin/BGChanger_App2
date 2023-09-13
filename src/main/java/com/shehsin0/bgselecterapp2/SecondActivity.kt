package com.shehsin0.bgselecterapp2

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val radioGrp = findViewById<RadioGroup>(R.id.radioGroup)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        submitBtn.setOnClickListener {
            val selectedId: Int = radioGrp.checkedRadioButtonId
            var selectedColor = Color.WHITE

            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val selectedColorText = selectedRadioButton.text.toString()

                when (selectedColorText) {
                    "RED" -> selectedColor = Color.RED
                    "BLUE" -> selectedColor = Color.BLUE
                    "GREEN" -> selectedColor = Color.GREEN
                    "YELLOW" -> selectedColor = Color.YELLOW
                    "BLACK" -> selectedColor = Color.BLACK
                }
            }

            val intent = Intent()
            intent.putExtra("selectedColor", selectedColor)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}