package com.dicoding.fundamentalandroid.Intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.fundamentalandroid.R

class IntentMainActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_main)

        supportActionBar?.title = "Intent Exercise"

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityWithData: Button = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivityWithData.setOnClickListener(this)

        val btnMoveActivityWithObject: Button = findViewById(R.id.btn_move_activity_with_object)
        btnMoveActivityWithObject.setOnClickListener(this)

        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        val btnMoveActivityWithResult: Button = findViewById(R.id.btn_move_activity_for_result)
        btnMoveActivityWithResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@IntentMainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data -> {
                val moveIntent = Intent(this@IntentMainActivity, MoveActivityWithData::class.java)
                moveIntent.putExtra(MoveActivityWithData.EXTRA_NAME, "Irfan Aziz Al Amin")
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_object -> {
                val person = Person("Irfan", 21, "irfanazizalamin@gmail.com", "Boyolali")

                val moveIntent = Intent(this@IntentMainActivity, MoveActivityWithObject::class.java)
                moveIntent.putExtra(MoveActivityWithObject.EXTRA_PERSON, person)
                startActivity(moveIntent)

            }
            R.id.btn_dial_number -> {
//                val dialNumberIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:085702694127"))
//                startActivity(dialNumberIntent)
                val intent = Intent(Intent.ACTION_MAIN)
                intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings")
                startActivity(intent)
            }
            R.id.btn_move_activity_for_result -> {
                val moveForResultIntent = Intent(this@IntentMainActivity, MoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}