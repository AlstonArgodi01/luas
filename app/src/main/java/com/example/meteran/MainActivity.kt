package com.example.meteran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyField = false
            var isInvalidDouble = false

            if(inputLength.isEmpty()){
                isEmptyField = true
                edtLength.error = "tidak boleh kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyField = true
                edtWidth.error = "tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyField = true
                edtHeight.error = "tidak boleh kosong"
            }
            val length = toDouble(inputLength)
            val width = toDouble(inputWidth)
            val height = toDouble(inputHeight)

            if (length == null){
                isInvalidDouble = true
                edtLength.error="harus berupa nomer"
            }
            if (width == null){
                isInvalidDouble = true
                edtWidth.error="harus berupa nomer"
            }
            if (height == null){
                isInvalidDouble = true
                edtHeight.error="harus berupa nomer"
            }
            if (!isEmptyField && !isInvalidDouble){
                val volume = length as Double * width as Double * height as Double
                tvResult.text = volume.toString()
            }
        }
    }
    private fun toDouble(str:String):Double?{
        return try {
            str.toDouble()
        }catch (e: NumberFormatException){
            null
        }
    }
}
