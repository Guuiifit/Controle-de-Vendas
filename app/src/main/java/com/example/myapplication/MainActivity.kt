package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val editTexts = ArrayList<EditText>()
    private val textViews = ArrayList<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextIds = intArrayOf(
            R.id.quant_produto, R.id.quant_produto2, R.id.quant_produto3, R.id.quant_produto4,
            R.id.quant_produto5, R.id.quant_produto6, R.id.quant_produto7, R.id.quant_produto8
        )

        for (i in 0..7) {
            val editText = findViewById<EditText>(editTextIds[i])
            val textView = findViewById<TextView>(editTextIds[i])
            editTexts.add(editText)
            textViews.add(textView)

            setupButtonClicks(i)
        }
    }

    private fun setupButtonClicks(index: Int) {
        val subtrairButton = findViewById<Button>(resources.getIdentifier("btn${index + 1}_menos", "id", packageName))
        val adicionarButton = findViewById<Button>(resources.getIdentifier("btn${index + 1}_mais", "id", packageName))

        subtrairButton.setOnClickListener {
            val valorDigitado = editTexts[index].text.toString().toIntOrNull() ?: 0
            val novoValor = valorDigitado - 1
            textViews[index].text = "Novo valor: $novoValor"
            editTexts[index].setText(novoValor.toString())
        }

        adicionarButton.setOnClickListener {
            val valorDigitado = editTexts[index].text.toString().toIntOrNull() ?: 0
            val novoValor = valorDigitado + 1
            textViews[index].text = "Novo valor: $novoValor"
            editTexts[index].setText(novoValor.toString())
        }
    }
}