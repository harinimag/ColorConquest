package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        val one = findViewById<TextView>(R.id.one)
        val intent = intent
        val str1 = intent.getStringExtra("message_key1")
        one.setText(str1)
        val two = findViewById<TextView>(R.id.two)
        val str2 = intent.getStringExtra("message_key2")
        two.setText(str2)
        /*val mark1 = findViewById<TextView>(R.id.mark1)
        mark1.setText("0")
        val mark2 = findViewById<TextView>(R.id.mark2)
        mark2.setText("0")*/
        val reset = findViewById<ImageButton>(R.id.reset)
        reset.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
            reset.startAnimation(animationZoomIn)
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
            reset.startAnimation(animationZoomOut)
            count = 0
            for(id in Blue){
                Blue.remove(id)
                val b = findViewById<Button>(id)
                b.text = ""
                b.setBackgroundColor(ContextCompat.getColor(this,R.color.cornsilk))
            }
            for(id in Tomato){
                Tomato.remove(id)
                val b = findViewById<Button>(id)
                b.text = ""
                b.isPressed = false
                b.setBackgroundColor(ContextCompat.getColor(this,R.color.cornsilk))
            }
        }
    }



    var count = 0
    var Blue = mutableListOf<Int>()
    val Tomato = mutableListOf<Int>()
    /*var point1 = 0
    var point2 = 0*/

    fun tomexpand(mButton: Button) {
        if (mButton.id !in setOf(R.id.B15, R.id.B25, R.id.B35, R.id.B45, R.id.B55)) {
            var B1 = mButton.id + 1
            val b1 = findViewById<Button>(B1)
            b1.setBackgroundColor(ContextCompat.getColor(this, R.color.tomato))
            increasetomato(b1)
            if (B1 !in Tomato && b1.text != "") {
                Tomato.add(B1)
            }
        }
        if (mButton.id !in setOf(R.id.B11, R.id.B21, R.id.B31, R.id.B41, R.id.B51)) {
            var B2 = mButton.id - 1
            val b2 = findViewById<Button>(B2)
            b2.setBackgroundColor(ContextCompat.getColor(this, R.color.tomato))
            increasetomato(b2)
            if (B2 !in Tomato && b2.text != "") {
                Tomato.add(B2)
            }
        }
        if (mButton.id !in setOf(R.id.B51, R.id.B52, R.id.B53, R.id.B54, R.id.B55)) {
            var B3 = mButton.id + 5
            val b3 = findViewById<Button>(B3)
            b3.setBackgroundColor(ContextCompat.getColor(this, R.color.tomato))
            increasetomato(b3)
            if (B3 !in Tomato && b3.text != "") {
                Tomato.add(B3)
            }
        }
        if (mButton.id !in setOf(R.id.B11, R.id.B12, R.id.B13, R.id.B14, R.id.B15)) {
            var B4 = mButton.id - 5
            val b4 = findViewById<Button>(B4)
            b4.setBackgroundColor(ContextCompat.getColor(this, R.color.tomato))
            increasetomato(b4)
            if (B4 !in Tomato && b4.text != "") {
                Tomato.add(B4)
            }
        }
        mButton.text = ""
        mButton.setBackgroundColor(ContextCompat.getColor(this, R.color.cornsilk))
        while (Tomato.contains(mButton.id)) {
            Tomato.remove(mButton.id)
        }
    }

    fun bluexpand(mButton: Button) {
        if (mButton.id !in setOf(R.id.B15, R.id.B25, R.id.B35, R.id.B45, R.id.B55)) {
            var B1 = mButton.id + 1
            val b1 = findViewById<Button>(B1)
            b1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            increaseblue(b1)
            if (B1 !in Blue && b1.text != "") {
                Blue.add(B1)
            }
        }
        if (mButton.id !in setOf(R.id.B11, R.id.B21, R.id.B31, R.id.B41, R.id.B51)) {
            var B2 = mButton.id - 1
            val b2 = findViewById<Button>(B2)
            b2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            increaseblue(b2)
            if (B2 !in Blue && b2.text != "") {
                Blue.add(B2)
            }
        }
        if (mButton.id !in setOf(R.id.B51, R.id.B52, R.id.B53, R.id.B54, R.id.B55)) {
            var B3 = mButton.id + 5
            val b3 = findViewById<Button>(B3)
            b3.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            increaseblue(b3)
            if (B3 !in Blue && b3.text != "") {
                Blue.add(B3)
            }
        }
        if (mButton.id !in setOf(R.id.B11, R.id.B12, R.id.B13, R.id.B14, R.id.B15)) {
            var B4 = mButton.id - 5
            val b4 = findViewById<Button>(B4)
            b4.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            increaseblue(b4)
            if (B4 !in Blue && b4.text != "") {
                Blue.add(B4)
            }
        }
        mButton.text = ""
        mButton.setBackgroundColor(ContextCompat.getColor(this, R.color.cornsilk))
        while (Blue.contains(mButton.id)) {
            Blue.remove(mButton.id)
        }
    }

    fun increaseblue(butt: Button) {
        if (butt.text == "3" && butt.id in Blue) {
            bluexpand(butt)
        } else if (butt.text == "2" && butt.id in Blue) {
            butt.text = "3"
        } else if (butt.text == "1" && butt.id in Blue) {
            butt.text = "2"
        } else if (butt.text == "") {
            butt.text = "1"
        } else if (butt.id in Tomato) {
            butt.text = "1"
            while (Tomato.contains(butt.id)) {
                Tomato.remove(butt.id)
            }
        }
    }

    fun increasetomato(butt: Button) {
        if (butt.text == "3" && butt.id in Tomato) {
            tomexpand(butt)
        } else if (butt.text == "2" && butt.id in Tomato) {
            butt.text = "3"
        } else if (butt.text == "1" && butt.id in Tomato) {
            butt.text = "2"
        } else if (butt.text == "") {
            butt.text = "1"
        } else if (butt.id in Blue) {
            butt.text = "1"
            while (Blue.contains(butt.id)) {
                Blue.remove(butt.id)
            }
        }
    }


    fun onClick(view: View) {
        val mButton = view as Button
        mButton.setTextColor(Color.WHITE)
        val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        mButton.startAnimation(animationZoomIn)
        val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        mButton.startAnimation(animationZoomOut)
        val sharedPref = getSharedPreferences("my_prefs", MODE_PRIVATE)
        val editor = sharedPref.edit()
        if ((count % 2 == 0 && mButton.id in Blue) || (count % 2 != 0 && mButton.id in Tomato) || (count>1 && mButton.id !in Tomato && mButton.id !in Blue)) {
            Toast.makeText(this, "invalid click", Toast.LENGTH_SHORT).show()
        } else {
            var i = 0
            count++
            if (mButton.text == "3") {
                mButton.text = "4"
                i = 1
            } else if (mButton.text == "2") {
                mButton.text = "3"
                i = 1
            } else if (mButton.text == "1") {
                mButton.text = "2"
                i = 1
            }
            if (count % 2 == 0) {
                val myColor = ContextCompat.getColor(this, R.color.blue)
                mButton.setBackgroundColor(myColor)
                if (mButton.text == "4") {
                    i = 1
                    bluexpand(mButton)
                }
                val mycolor2 = ContextCompat.getColor(this, R.color.tomato)
                val myLayout = findViewById<ConstraintLayout>(R.id.main3)
                myLayout.setBackgroundColor(mycolor2)
            } else {
                val myColor = ContextCompat.getColor(this, R.color.tomato)
                mButton.setBackgroundColor(myColor)
                if (mButton.text == "4") {
                    i = 1
                    tomexpand(mButton)
                }
                val mycolor2 = ContextCompat.getColor(this, R.color.blue)
                val myLayout = findViewById<ConstraintLayout>(R.id.main3)
                myLayout.setBackgroundColor(mycolor2)
            }
            if (i == 0) {
                mButton.text = "3"
                if (count % 2 == 0) {
                    Blue.add(mButton.id)
                } else {
                    Tomato.add(mButton.id)
                }
            }
        }
/*
        val mark1 = findViewById<TextView>(R.id.mark1)
        val mark2 = findViewById<TextView>(R.id.mark2)
        if (Blue.size!=0) {
            for (id1 in Blue) {
                var p1 = findViewById<Button>(id1)
                point1 = point1 + p1.text.toString().toInt()
            }
            mark1.setText(point1)
        }
        else{
            mark1.setText("0")
        }
        if (Tomato.size!=0) {
            for (id2 in Tomato) {
                var p2 = findViewById<Button>(id2)
                point2 = point2 + p2.text.toString().toInt()
            }
            mark2.setText(point2)
        }
        else{
            mark2.setText("0")
        }
*/
        val intent = intent
        val str1 = intent.getStringExtra("message_key1")
        val str2 = intent.getStringExtra("message_key2")

        if (count > 1 && Blue.size == 0) {
            val builder = AlertDialog.Builder(this, R.style.AlertDialogCustom).create()
            val view = layoutInflater.inflate(R.layout.winner, null)
            builder.setView(view)
            builder.setCanceledOnTouchOutside(false)
            val winner = view.findViewById<TextView>(R.id.winner)
            winner.setText(str1)
            val play = view.findViewById<ImageButton>(R.id.startbutton)
            play.setOnClickListener {
                val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
                play.startAnimation(animationZoomIn)
                val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
                play.startAnimation(animationZoomOut)
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
            if (sharedPref.contains(str1.toString())){
                    val value = sharedPref.getInt(str1.toString(),1)
                    editor.putInt(str1.toString(),value+1)
            }
            else{
                editor.putInt(str1.toString(),1)
            }
            editor.apply()
            val back = view.findViewById<ImageButton>(R.id.back)
            back.setOnClickListener {
                val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
                back.startAnimation(animationZoomIn)
                val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
                back.startAnimation(animationZoomOut)
                val intent = Intent(applicationContext,MainActivity4::class.java)
                startActivity(intent)
            }
            builder.show()
        } else if (count > 1 && Tomato.size == 0) {
            val builder = AlertDialog.Builder(this, R.style.AlertDialogCustom).create()
            val view = layoutInflater.inflate(R.layout.winner, null)
            builder.setView(view)
            builder.setCanceledOnTouchOutside(false)
            val winner = view.findViewById<TextView>(R.id.winner)
            winner.setText(str2)
            val play = view.findViewById<ImageButton>(R.id.startbutton)
            play.setOnClickListener {
                val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
                play.startAnimation(animationZoomIn)
                val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
                play.startAnimation(animationZoomOut)
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
            if (sharedPref.contains(str2.toString())){
                val value = sharedPref.getInt(str2.toString(),1)
                editor.putInt(str2.toString(),value+1)
            }
            else{
                editor.putInt(str2.toString(),1)
            }
            editor.apply()
            val back = view.findViewById<ImageButton>(R.id.back)
            back.setOnClickListener {
                val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.scale_up)
                back.startAnimation(animationZoomIn)
                val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.scale_down)
                back.startAnimation(animationZoomOut)
                val intent = Intent(applicationContext,MainActivity4::class.java)
                startActivity(intent)
            }
            builder.show()
        }
    }}