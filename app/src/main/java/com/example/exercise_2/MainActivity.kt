package com.example.exercise_2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calc = findViewById<Button>(R.id.buttonCalculate)
        val reset = findViewById<Button>(R.id.buttonReset)

        calc.setOnClickListener(View.OnClickListener {
            var bmi = editTextWeight.text.toString().toDouble() / Math.pow((editTextHeight.text.toString().toDouble()/100), 2.0)
            if (bmi<18.5){
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.under))
                textViewBMI.setText("BMI is below :"+bmi.toInt())
            }
            else if(bmi < 25){
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.normal))
                textViewBMI.setText("BMI is normal :"+bmi.toInt())
            }
            else{
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.over))
                textViewBMI.setText("BMI is more than :"+bmi.toInt())
            }
        })

        reset.setOnClickListener(View.OnClickListener {
            editTextHeight.text.clear()
            editTextWeight.text.clear()
            textViewBMI.setText("BMI :")
            imageViewProfile.setImageDrawable(getDrawable(R.drawable.empty))
        })
    }
}
