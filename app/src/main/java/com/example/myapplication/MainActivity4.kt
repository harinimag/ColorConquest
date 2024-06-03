package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val allKeys = sharedPref.all.keys

        val tableLayout = findViewById<TableLayout>(R.id.tablelayout)

        for(key in allKeys){
            val value = sharedPref.getInt(key,1)
            val tableRow = TableRow(this)
            val layoutparams1 = TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,TableLayout.LayoutParams.WRAP_CONTENT)
            tableRow.layoutParams = layoutparams1
            tableRow.setBackgroundColor(ContextCompat.getColor(this,R.color.t1))

            val textView = TextView(this)
            val layoutparams2 = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,2f)
            textView.gravity = Gravity.CENTER
            textView.setTextColor(ContextCompat.getColor(this,R.color.black))
            textView.setTextSize(25f)
            textView.layoutParams=layoutparams2
            textView.text = key

            val textView2 = TextView(this)
            val layoutparams3 = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1f)
            textView2.gravity = Gravity.CENTER
            textView2.setTextColor(ContextCompat.getColor(this,R.color.black))
            textView2.setTextSize(32f)
            textView2.layoutParams=layoutparams3
            textView2.text = value.toString()

            tableRow.addView(textView)
            tableRow.addView(textView2)

            tableLayout.addView(tableRow)
        }

        val next = findViewById<ImageButton>(R.id.next)
        next.setOnClickListener{
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            next.startAnimation(animationZoomIn)
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
            next.startAnimation(animationZoomOut)
            val intent = Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        }
        val prev = findViewById<ImageButton>(R.id.prev)
        prev.setOnClickListener{
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            prev.startAnimation(animationZoomIn)
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
            prev.startAnimation(animationZoomOut)
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }
}