package com.practica1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigInteger
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.round
import kotlin.math.sqrt

class GetA : Fragment() {
    private lateinit var buttonResult: Button
    private lateinit var textResult: TextView
    private lateinit var inputC: EditText
    private lateinit var inputB: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_get_a, container, false)
        textResult = view.findViewById<TextView>(R.id.result)
        buttonResult = view.findViewById<Button>(R.id.getA)
        buttonResult.setOnClickListener{
            inputC = view.findViewById<EditText>(R.id.editTextNumber2)
            inputB = view.findViewById<EditText>(R.id.editTextNumber3)

            if(inputC.text.isEmpty()){
                inputC.error = getString(R.string.ErrorGet) + " c"
            }
            else if(inputB.text.isEmpty()){
                inputB.error = getString(R.string.ErrorGet) + " b"
            }
            else if(inputC.text.toString().toDouble() < inputB.text.toString().toDouble()){
                inputB.error = "c " + getString(R.string.ErrorOrder) + " b"
            }
            else{
                val c = inputC.text.toString().toDouble()
                val b = inputB.text.toString().toDouble()

                val result = round(sqrt(c * c - b * b))
                val decFormat = DecimalFormat("#.###")
                decFormat.roundingMode = RoundingMode.DOWN
                val finalResult  = decFormat.format(result).toString()
                textResult.setText(getString(R.string.ResultString) + finalResult)

                inputC.text.clear()
                inputB.text.clear()
            }
        }

        return view
    }
}