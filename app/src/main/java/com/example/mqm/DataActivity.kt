package com.example.mqm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val bundle = intent.extras

        val name = findViewById<TextView>(R.id.nameValue) as TextView
        val email = findViewById<TextView>(R.id.emailValue) as TextView
        val number = findViewById<TextView>(R.id.numberValue) as TextView
        val age = findViewById<TextView>(R.id.ageValue) as TextView
        val kin = findViewById<TextView>(R.id.kinValue) as TextView
        val gender = findViewById<TextView>(R.id.genderValue) as TextView

        name.setText(bundle!!.getCharSequence("name"))
        email.setText(bundle!!.getCharSequence("email"))
        number.setText(bundle!!.getCharSequence("number"))
        kin.setText(bundle!!.getCharSequence("kin"))
        gender.setText(bundle!!.getCharSequence("gender"))

        val back = findViewById<Button>(R.id.signOut) as Button
        back.setOnClickListener (View.OnClickListener {
            val intent = Intent(this@DataActivity,SignActivity::class.java)
            startActivity(intent)
        })
    }
}
