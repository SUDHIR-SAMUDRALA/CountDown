package edu.wiu.ssamudrala.countdown

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.icu.lang.UCharacter.toString
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.MeasureSpec.toString
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getText

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var number_textview: TextView = findViewById(R.id.number_textview)
        var input_view: EditText = findViewById(R.id.input_view)
        val button_view: Button = findViewById(R.id.button_view)


        var number = 0;

        button_view.setOnClickListener() {



            val inval: Int = input_view.text.toString().toInt()

            number = number + inval

            number_textview.text = number.toString()


            val SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
            val editor = SharedPreferences.edit()
            editor.apply {
                putInt("INT KEY", number)
            }.apply()

            val savedInt = SharedPreferences.getInt("INT KEY", 0)
            number_textview.text = number.toString()

            }

        }


}
