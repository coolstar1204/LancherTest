package com.cool.star.timerlancher

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val callBack:IUnityCallBack= object:IUnityCallBack {
        override fun onTimeRunFinish() {
            Log.d("TimerLancher","---onTimeRunFinish--")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        TimerLauncher.printDebugLog(true);
        fab.setOnClickListener { view ->
            TimerLauncher.startDelayLaunch(this,"cn.kuwo.boom",10);
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                TimerLauncher.regularTimeRun(this,2, callBack)
                true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}
