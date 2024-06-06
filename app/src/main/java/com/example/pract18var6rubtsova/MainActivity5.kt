package com.example.pract18var6rubtsova

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity5 : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        login = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putString("login", intent.getStringExtra("login"))
        ed.putString("password", intent.getStringExtra("password"))
        ed.apply()


    }


    fun toreg(view: View) {
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }


    fun next(view: View) {
        if (login.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            val intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин или пароль")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()

        }
    }
}