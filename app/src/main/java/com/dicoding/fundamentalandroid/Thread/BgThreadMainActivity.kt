package com.dicoding.fundamentalandroid.Thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.dicoding.fundamentalandroid.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class BgThreadMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bg_thread)

        val btnStart: Button = findViewById(R.id.btn_start)
        val tvStatus: TextView = findViewById(R.id.tv_status)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

//        // using executor
//        btnStart.setOnClickListener {
//            executor.execute {
//                try {
//                    // simulate process compressing
//                    for (i in 1..10) {
//                        Thread.sleep(500)
//                        val percentage = i * 10
//                        handler.post {
//                            if (percentage == 100) {
//                                tvStatus.setText(R.string.task_completed)
//                            } else {
//                                tvStatus.text = String.format(getString(R.string.compressing), percentage)
//                            }
//                        }
//                    }
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//        }

        // using coroutines
        btnStart.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                // simulate process in background thread
                for (i in 1..10) {
                    delay(500)
                    val percentage = i * 10
                    withContext(Dispatchers.Main) {
                        //update ui in main thread
                        if (percentage == 100) {
                            tvStatus.setText(R.string.task_completed)
                        } else {
                            tvStatus.text = String.format(getString(R.string.compressing), percentage)
                        }
                    }
                }
            }
        }
    }
}