package com.practica1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class GetC : Fragment() {
    private lateinit var buttonResult: Button
    private lateinit var textResult: TextView
    private lateinit var inputA: EditText
    private lateinit var inputB: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_get_c, container, false)

        textResult = view.findViewById<TextView>(R.id.result)
        buttonResult = view.findViewById<Button>(R.id.getC)
        buttonResult.setOnClickListener{
            inputA = view.findViewById<EditText>(R.id.editTextNumber2)
            inputB = view.findViewById<EditText>(R.id.editTextNumber3)

            if(inputA.text.isEmpty()){
                inputA.error = getString(R.string.ErrorGet) + " a"
            }
            else if(inputB.text.isEmpty()){
                inputB.error = getString(R.string.ErrorGet) + " b"
            }else{
                val a: Double = inputA.text.toString().toDouble()
                val b: Double = inputB.text.toString().toDouble()

                val result: Double = sqrt(a * a + b * b)
                textResult.setText(getString(R.string.ResultString) + result.toString())

                inputA.text.clear()
                inputB.text.clear()
            }
        }

        return view
    }
}