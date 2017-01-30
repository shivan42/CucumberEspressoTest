package com.shivan.cucumbertest

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            if (input.text.isNotEmpty()) {
                try {
                    val intNum = input.text.toString().toInt()
                    Snackbar.make(view, "Вы ввели $intNum", Snackbar.LENGTH_LONG).show()
                } catch (e: Exception) {
                    Snackbar.make(view, "Ошибка! Введите число", Snackbar.LENGTH_LONG).show()
                }
            } else {
                Snackbar.make(view, "Ошибка! Введите число", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
