package edu.wiu.ssamudrala.countdown

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.icu.lang.UCharacter.toString
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View.MeasureSpec.toString
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.TypedArrayUtils.getText
import java.util.*

class MainActivity : AppCompatActivity() {


    var number = 0;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveData()



        var number_textview: TextView = findViewById(R.id.number_textview)
        var input_view: EditText = findViewById(R.id.input_view)
        val button_view: Button = findViewById(R.id.button_view)
        val button_clear: Button = findViewById(R.id.button_clear)



        button_view.setOnClickListener() {

            val inval: Int = input_view.text.toString().toInt()

            number = number + inval

            number_textview.text = number.toString()


            val SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
            val editor = SharedPreferences.edit()
            editor.apply {
                putInt("INT_KEY", number)
            }.apply()

            }

        button_clear.setOnClickListener() {

            val SharedPreferences = getSharedPreferences("sharedPre", MODE_PRIVATE)
            val editor = SharedPreferences.edit()

            val savedInt = SharedPreferences.getInt("INT_KEY", 0)
            number = number - number

            number_textview.text = number.toString()
            number_textview.text = savedInt.toString()


        }


        }
    fun saveData(){

        var number_textview: TextView = findViewById(R.id.number_textview)
        var input_view: EditText = findViewById(R.id.input_view)
        val button_view: Button = findViewById(R.id.button_view)


        val SharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val savedInt = SharedPreferences.getInt("INT_KEY", 0)

        number_textview.text = savedInt.toString()

        number = savedInt


    }


}
