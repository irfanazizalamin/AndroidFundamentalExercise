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
import com.dicoding.fundamentalandroid.API.ApiMainActivity
import com.dicoding.fundamentalandroid.AlarmManager.AlarmManagerMainActivity
import com.dicoding.fundamentalandroid.BroadcastReceiver.BroadcastReceiverActivity
import com.dicoding.fundamentalandroid.CustomView.CustomViewMainActivity
import com.dicoding.fundamentalandroid.Debugging.DebuggingMainActivity
import com.dicoding.fundamentalandroid.Fragment.FragmentMainActivity
import com.dicoding.fundamentalandroid.Intent.IntentMainActivity
import com.dicoding.fundamentalandroid.JobScheduler.JobSchedulerMainActivity
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

        val btnBcReceiver: Button = findViewById(R.id.btn_broadcastreceiver_exercise)
        btnBcReceiver.setOnClickListener(this)

        val btnAlarmManager: Button = findViewById(R.id.btn_alarmmanager_exercise)
        btnAlarmManager.setOnClickListener(this)

        val btnApi: Button = findViewById(R.id.btn_api_exercise)
        btnApi.setOnClickListener(this)

        val btnJobScheduler: Button = findViewById(R.id.btn_jobscheduler_exercise)
        btnJobScheduler.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent: Intent? = null

        when(v?.id) {
            R.id.btn_intent_exercise -> {
                intent = Intent(this@MainActivity, IntentMainActivity::class.java)
            }
            R.id.btn_fragment_exercise -> {
                intent = Intent(this@MainActivity, FragmentMainActivity::class.java)
            }
            R.id.btn_listview_exercise -> {
                intent = Intent(this@MainActivity, ListViewMainActivity::class.java)
            }
            R.id.btn_debugging_exercise -> {
                intent = Intent(this@MainActivity, DebuggingMainActivity::class.java)
            }
            R.id.btn_unittesting_exercise -> {
                intent = Intent(this@MainActivity, UnitTestingMainActivity::class.java)
            }
            R.id.btn_customview_exercise -> {
                intent = Intent(this@MainActivity, CustomViewMainActivity::class.java)
            }
            R.id.btn_viewpager_exercise -> {
                intent = Intent(this@MainActivity, ViewPagerMainActivity::class.java)
            }
            R.id.btn_bgthread_exercise -> {
                intent = Intent(this@MainActivity, BgThreadMainActivity::class.java)
            }
            R.id.btn_service_exercise -> {
                intent = Intent(this@MainActivity, ServiceMainActivity::class.java)
            }
            R.id.btn_broadcastreceiver_exercise -> {
                intent = Intent(this@MainActivity, BroadcastReceiverActivity::class.java)
            }
            R.id.btn_alarmmanager_exercise -> {
                intent = Intent(this@MainActivity, AlarmManagerMainActivity::class.java)
            }
            R.id.btn_api_exercise -> {
                intent = Intent(this@MainActivity, ApiMainActivity::class.java)
            }
            R.id.btn_jobscheduler_exercise -> {
                intent = Intent(this@MainActivity, JobSchedulerMainActivity::class.java)
            }
        }
        startActivity(intent)
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