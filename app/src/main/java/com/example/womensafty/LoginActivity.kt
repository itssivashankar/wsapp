package com.example.womensafty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val layout = findViewById<TextInputLayout>(R.id.emailTextField)
        val ins = findViewById<TextInputEditText>(R.id.emailInput)
        ins.setOnClickListener {
            println("jjk "+it);
        }
        val button = findViewById<Button>(R.id.loginButton)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent)
            finish()
        }
    }
}