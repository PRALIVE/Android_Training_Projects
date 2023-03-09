package com.example.launchmodesproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("checkinglaunchmodes","onCreate is invoked on Activity1")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchnextactivity(view: View) {
        startActivity(Intent(this,MainActivity2::class.java))
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("checkinglaunchmodes","onNewIntent is invoked on Activity1")
    }

    fun launchsameactivity(view: View) {
        startActivity(Intent(this,MainActivity::class.java))
        Snackbar.make(view,"Same Activity launched",Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checkinglaunchmodes","onDestroy is invoked on Activity1")
    }

    fun onClickDialog(view: View) {
        val customDialog = MyCustomDialog()
        customDialog.isCancelable = false
        customDialog.show(supportFragmentManager,"MyCustomFragment")
    }
}