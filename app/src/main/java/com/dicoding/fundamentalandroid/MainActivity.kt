package com.dicoding.fundamentalandroid

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import com.dicoding.fundamentalandroid.CustomView.CustomViewMainActivity
import com.dicoding.fundamentalandroid.Debugging.DebuggingMainActivity
import com.dicoding.fundamentalandroid.Fragment.FragmentMainActivity
import com.dicoding.fundamentalandroid.Intent.IntentMainActivity
import com.dicoding.fundamentalandroid.ListView.ListViewMainActivity
import com.dicoding.fundamentalandroid.Navigation.MenuActivity
import com.dicoding.fundamentalandroid.Navigation.MenuFragment
import com.dicoding.fundamentalandroid.Service.ServiceMainActivity
import com.dicoding.fundamentalandroid.Thread.BgThreadMainActivity
import com.dicoding.fundamentalandroid.UnitTesting.UnitTestingMainActivity
import com.dicoding.fundamentalandroid.ViewPager.ViewPagerMainActivity
import com.dicoding.fundamentalandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        binding.btnIntentExercise.setOnClickListener(this)
//        val btnIntent: Button = findViewById(R.id.btn_intent_exercise)
//        btnIntent.setOnClickListener(this)

        val btnFragment: Button = findViewById(R.id.btn_fragment_exercise)
        btnFragment.setOnClickListener(this)

        val btnList: Button = findViewById(R.id.btn_listview_exercise)
        btnList.setOnClickListener(this)

        val btnDebug: Button = findViewById(R.id.btn_debugging_exercise)
        btnDebug.setOnClickListener(this)

        val btnUnitTest: Button = findViewById(R.id.btn_unittesting_exercise)
        btnUnitTest.setOnClickListener(this)

        val btnCustomView: Button = findViewById(R.id.btn_customview_exercise)
        btnCustomView.setOnClickListener(this)

        val btnViewPager: Button = findViewById(R.id.btn_viewpager_exercise)
        btnViewPager.setOnClickListener(this)

        val btnBgThread: Button = findViewById(R.id.btn_bgthread_exercise)
        btnBgThread.setOnClickListener(this)

        val btnService: Button = findViewById(R.id.btn_service_exercise)
        btnService.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_intent_exercise -> {
                val moveIntentExercise = Intent(this@MainActivity, IntentMainActivity::class.java)
                startActivity(moveIntentExercise)
            }
            R.id.btn_fragment_exercise -> {
                val moveFragmentExercise = Intent(this@MainActivity, FragmentMainActivity::class.java)
                startActivity(moveFragmentExercise)
            }
            R.id.btn_listview_exercise -> {
                val moveListViewExercise = Intent(this@MainActivity, ListViewMainActivity::class.java)
                startActivity(moveListViewExercise)
            }
            R.id.btn_debugging_exercise -> {
                val moveDebuggingExercise = Intent(this@MainActivity, DebuggingMainActivity::class.java)
                startActivity(moveDebuggingExercise)
            }
            R.id.btn_unittesting_exercise -> {
                val moveUnitTestExercise = Intent(this@MainActivity, UnitTestingMainActivity::class.java)
                startActivity(moveUnitTestExercise)
            }
            R.id.btn_customview_exercise -> {
                val moveCustomViewExercise = Intent(this@MainActivity, CustomViewMainActivity::class.java)
                startActivity(moveCustomViewExercise)
            }
            R.id.btn_viewpager_exercise -> {
                val moveViewPagerExercise = Intent(this@MainActivity, ViewPagerMainActivity::class.java)
                startActivity(moveViewPagerExercise)
            }
            R.id.btn_bgthread_exercise -> {
                val moveBgThreadExercise = Intent(this@MainActivity, BgThreadMainActivity::class.java)
                startActivity(moveBgThreadExercise)
            }
            R.id.btn_service_exercise -> {
                val moveServiceExercise = Intent(this@MainActivity, ServiceMainActivity::class.java)
                startActivity(moveServiceExercise)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.menu_1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MenuFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.menu_2 -> {
                val i = Intent(this@MainActivity, MenuActivity::class.java)
                startActivity(i)
                return true
            }
            else -> {
                return false
            }
        }
    }
}