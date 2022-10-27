package com.practica1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.sqrt

class GetB : Fragment() {
    private lateinit var buttonResult: Button
    private lateinit var textResult: TextView
    private lateinit var inputC: EditText
    private lateinit var inputA: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_get_b, container, false)

        textResult = view.findViewById<TextView>(R.id.result)
        buttonResult = view.findViewById<Button>(R.id.getB)
        buttonResult.setOnClickListener{
            inputC = view.findViewById<EditText>(R.id.editTextNumber2)
            inputA = view.findViewById<EditText>(R.id.editTextNumber3)

            if(inputC.text.isEmpty()){
                inputC.error = getString(R.string.ErrorGet) + " c"
            }
            else if(inputA.text.isEmpty()){
                inputA.error = getString(R.string.ErrorGet) + " a"
            }
            else if(inputC.text.toString().toDouble() < inputA.text.toString().toDouble()){
                inputA.error = "c " + getString(R.string.ErrorOrder) + " a"
            }
            else{
                val c: Double = inputC.text.toString().toDouble()
                val a: Double = inputA.text.toString().toDouble()

                val result: Double = sqrt(c * c - a * a)
                val decFormat = DecimalFormat("#.###")
                decFormat.roundingMode = RoundingMode.DOWN
                val finalResult  = decFormat.format(result).toString()

                var intent = Intent(this.context, MainActivity3::class.java).apply{
                    putExtra("catA", a.toString())
                    putExtra("catB", finalResult)
                    putExtra("Hipo", c.toString())
                }

                startActivity(intent)
            }
        }

        return view
    }
}