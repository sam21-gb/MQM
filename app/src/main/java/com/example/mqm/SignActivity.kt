package com.example.mqm

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_sign.*
import org.w3c.dom.Text

class SignActivity:  AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        val name = findViewById<EditText>(R.id.name) as EditText
        val email = findViewById<EditText>(R.id.email) as EditText
        val number = findViewById<EditText>(R.id.number) as EditText
        val password = findViewById<EditText>(R.id.password) as EditText
        val password2 = findViewById<EditText>(R.id.age) as EditText
        val kin = findViewById<EditText>(R.id.kin) as EditText
        val gender = findViewById<RadioGroup>(R.id.gender) as RadioGroup
        val submit = findViewById<Button>(R.id.submitButton) as Button




        submitButton.setOnClickListener ( View.OnClickListener {
            if (TextUtils.isEmpty(name.text.toString())) {
                name.setError("Enter name")
                return@OnClickListener
            }
            if (TextUtils.isEmpty(email.text.toString())) {
                email.setError("Enter Email")
                return@OnClickListener
            }
            if (TextUtils.isEmpty(number.text.toString())) {
                number.setError("Enter number")
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password.text.toString())) {
                password.setError("Enter password")
                return@OnClickListener
            }
            if (TextUtils.isEmpty(age.text.toString())) {
                password2.setError("should not be Empty")
                return@OnClickListener
            }
            if (TextUtils.isEmpty(kin.text.toString())) {
                kin.setError("Choose next of kin")
                return@OnClickListener
            }

            val intent = Intent(this@SignActivity, DataActivity::class.java)

            val bundle = Bundle()

            bundle.putString("name", name.getText().toString())
            bundle.putString("email", email.getText().toString())
            bundle.putString("number", number.getText().toString())
            bundle.putString("password", password.getText().toString())
            bundle.putString("age", age.getText().toString())
            bundle.putString("kin", kin.getText().toString())

            val gend = gender.getCheckedRadioButtonId()

            if (gend == -1) {
                Toast.makeText(this@SignActivity, "Select gender", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            } else {
                val radioButton = findViewById<RadioButton>(gend)
                val gendValue = radioButton.text.toString()
                bundle.putString("gender", gendValue)
            }
            intent.putExtras(bundle)

            startActivity(intent)
        })
        }
    }
