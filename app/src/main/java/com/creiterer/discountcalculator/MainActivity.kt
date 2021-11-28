package com.creiterer.discountcalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcDiscountButton: Button = findViewById(R.id.calcButton)

        calcDiscountButton.setOnClickListener {
            val originalPriceInput: EditText = findViewById(R.id.originalPriceInput)
            val reducedPriceInput: EditText = findViewById(R.id.reducedPriceInput)
            val discountResultView: TextView = findViewById(R.id.discountResultView)

            val originalPriceText = originalPriceInput.text.toString()
            if (originalPriceText.isEmpty()) {
                originalPriceInput.setError("please enter original price")
                discountResultView.text = ""
                return@setOnClickListener
            }

            val reducedPriceText = reducedPriceInput.text.toString()
            if (reducedPriceText.isEmpty()) {
                reducedPriceInput.setError("please enter reduced price")
                discountResultView.text = ""
                return@setOnClickListener
            }

            val discount = (1 - reducedPriceText.toDouble() / originalPriceText.toDouble()) * 100
            discountResultView.text = String.format("%.2f %%", discount)

            when {
                discount < 20.0 -> {
                    discountResultView.setTextColor(Color.RED)
                }
                discount < 30.0 -> {
                    discountResultView.setTextColor(Color.rgb(250, 132, 14))
                }
                discount < 40.0 -> {
                    discountResultView.setTextColor(Color.rgb(154, 205, 50))
                }
                else -> {
                    discountResultView.setTextColor(Color.GREEN)
                }
            }
        }
    }
}