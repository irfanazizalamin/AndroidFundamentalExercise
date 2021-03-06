package com.dicoding.fundamentalandroid.Debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.fundamentalandroid.R
import kotlinx.android.synthetic.main.activity_debugging_main.*
import java.lang.StringBuilder

class DebuggingMainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvText: TextView
    private lateinit var btnSetValue: Button
    private lateinit var imgPreview: ImageView

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debugging_main)

        tvText = findViewById(R.id.tv_text)
        btnSetValue = findViewById(R.id.btn_set_value)
        btnSetValue.setOnClickListener(this)

        names.add("Narenda Wicaksono")
        names.add("Kevin")
        names.add("Yoza")

        imgPreview = findViewById(R.id.img_preview)
//        imgPreview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ahmad_dahlan))
        Glide.with(this)
            .load(R.drawable.ahmad_dahlan)
            .apply { RequestOptions().override(150,20) }
            .into(imgPreview)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_set_value) {
            Log.d("Debugging Main Activity", names.toString())
            val name = StringBuilder()
            for (i in 0..2) {
                name.append(names[i]).append("\n")
            }
            tvText.text = name.toString()
        }
    }
}