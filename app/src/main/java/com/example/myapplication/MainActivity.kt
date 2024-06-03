package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val playbutton = findViewById<Button>(R.id.playbutton)
        playbutton.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            playbutton.startAnimation(animationZoomIn)
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
            playbutton.startAnimation(animationZoomOut)
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        val scoreboard = findViewById<Button>(R.id.scoreboard)
        scoreboard.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            scoreboard.startAnimation(animationZoomIn)
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
            scoreboard.startAnimation(animationZoomOut)
            val intent = Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }
        val help = findViewById<Button>(R.id.help)
        help.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            help.startAnimation(animationZoomIn)
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
            help.startAnimation(animationZoomOut)
            val builder = AlertDialog.Builder(this, R.style.AlertDialogCustom).create()
            val view = layoutInflater.inflate(R.layout.rules, null)
            builder.setView(view)
            val close = view.findViewById<ImageButton>(R.id.close)
            close.setOnClickListener {
                builder.cancel()
            }
            builder.show()
        }
        }
    }