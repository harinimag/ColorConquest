package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val player1 = findViewById<EditText>(R.id.player1)
        val player2 = findViewById<EditText>(R.id.player2)

        val startbutton = findViewById<Button>(R.id.startbutton)
        startbutton.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            startbutton.startAnimation(animationZoomIn)
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
            startbutton.startAnimation(animationZoomOut)
            if((player1.text.toString()=="")||(player2.text.toString()=="")){
                Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_SHORT).show()
            }
            else {
                val name1 = player1.text.toString()
                val name2 = player2.text.toString()
                val intent = Intent(applicationContext, MainActivity3::class.java)
                intent.putExtra("message_key1", name1)
                intent.putExtra("message_key2", name2)
                startActivity(intent)
            }
        }
    }
    override fun onBackPressed() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }
}
