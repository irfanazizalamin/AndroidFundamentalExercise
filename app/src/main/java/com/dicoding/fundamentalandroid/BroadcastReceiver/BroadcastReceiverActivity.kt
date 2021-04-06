package com.dicoding.fundamentalandroid.BroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.dicoding.fundamentalandroid.R
import com.dicoding.fundamentalandroid.databinding.ActivityBroadcastReceiverBinding
import com.dicoding.fundamentalandroid.databinding.ActivityMainBinding
import java.util.jar.Manifest

class BroadcastReceiverActivity : AppCompatActivity() {

    companion object {
        const val ACTION_DOWNLOAD_STATUS = "download_status"
        private const val SMS_REQUEST_CODE = 101
    }

    private lateinit var downloadReceiver: BroadcastReceiver
    private var binding: ActivityBroadcastReceiverBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.btnPermission?.setOnClickListener {
            Toast.makeText(this, "hai clicked", Toast.LENGTH_SHORT).show()
            PermissionManager.check(this, android.Manifest.permission.RECEIVE_SMS, SMS_REQUEST_CODE)
        }

        // download receiver scope
        downloadReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d(DownloadService.TAG, "Download Selesai")
                Toast.makeText(context, "Download Selesai", Toast.LENGTH_SHORT).show()
            }
        }

        val downloadIntentFilter = IntentFilter(ACTION_DOWNLOAD_STATUS)
        registerReceiver(downloadReceiver, downloadIntentFilter)

        binding?.btnDownload?.setOnClickListener {
            val downloadServiceIntent = Intent(this, DownloadService::class.java)
            startService(downloadServiceIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(downloadReceiver)
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