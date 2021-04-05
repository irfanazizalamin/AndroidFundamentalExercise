package com.dicoding.fundamentalandroid.BroadcastReceiver

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.dicoding.fundamentalandroid.R
import com.dicoding.fundamentalandroid.databinding.ActivityBroadcastReceiverBinding
import com.dicoding.fundamentalandroid.databinding.ActivityMainBinding
import java.util.jar.Manifest

class BroadcastReceiverActivity : AppCompatActivity() {

    companion object {
        private const val SMS_REQUEST_CODE = 101
    }

    private var binding: ActivityBroadcastReceiverBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.btnPermission?.setOnClickListener {
            when (it.id) {
                R.id.btn_permission -> {
                    Toast.makeText(this, "hai clicked", Toast.LENGTH_SHORT).show()
                    PermissionManager.check(this, android.Manifest.permission.RECEIVE_SMS, SMS_REQUEST_CODE)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode === SMS_REQUEST_CODE) {
            when {
                grantResults[0] == PackageManager.PERMISSION_GRANTED ->
                    Toast.makeText(
                        this,
                        "Sms receiver permission diterima",
                        Toast.LENGTH_SHORT
                    ).show()

                else -> Toast.makeText(
                    this,
                    "Sms receiver permission ditolak",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}