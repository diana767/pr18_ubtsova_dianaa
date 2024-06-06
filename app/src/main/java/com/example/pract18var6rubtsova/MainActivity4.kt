package com.example.pract18var6rubtsova

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity4 : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText
    private lateinit var info: TextView
    private lateinit var pref: SharedPreferences

  lateinit var builder: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        login = findViewById(R.id.ttt)
        pass = findViewById(R.id.tttt)
        info=findViewById(R.id.textView)

    }

    fun handler(v: View) {
        val builder = AlertDialog.Builder(this)
            .setCancelable(true)
            .setPositiveButton("Сохранить") { _, _ ->
                info.text="Numbers: ${login.text} Name ${pass.text}\n"
                Toast.makeText(
                    this, "Сохранено",
                    Toast.LENGTH_LONG
                ).show()

                pref = getPreferences(MODE_PRIVATE)
                val ed = pref.edit()
                ed.putString("Numbers", login.text.toString())
                ed.putString("Name", pass.text.toString())
                ed.apply()
            }
    builder.create()
    builder.show()


}


    }




