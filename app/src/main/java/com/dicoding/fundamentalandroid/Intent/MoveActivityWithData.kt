package com.dicoding.fundamentalandroid.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dicoding.fundamentalandroid.R

class MoveActivityWithData : AppCompatActivity() {
    companion object {
        val EXTRA_NAME = "extra name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val name = intent.getStringExtra(EXTRA_NAME)
        val textHello = "hello my name is ${name}"

        val tvTextName: TextView = findViewById(R.id.tv_move_activity_with_data)
        tvTextName.text = textHello
    }
}