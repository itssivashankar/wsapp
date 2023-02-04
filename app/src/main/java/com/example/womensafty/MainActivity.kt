package com.example.womensafty

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val callButton = findViewById<Button>(R.id.call_button)
        callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:8144668431")
            startActivity(intent)
        }
        val button = findViewById<Button>(R.id.sms_button)
        button.setOnClickListener {
                try {
                    val smsManager: SmsManager
                    if (Build.VERSION.SDK_INT >= 23) {
                        //if SDK is greater that or equal to 23 then
                        //this is how we will initialize the SmsManager
                        smsManager = this.getSystemService(SmsManager::class.java)
                    } else {
                        //if user's SDK is less than 23 then
                        //SmsManager will be initialized like this
                        smsManager = SmsManager.getDefault()
                    }

                    // on below line we are sending text message.
                    smsManager.sendTextMessage("9629430418", null, "Simple Check", null, null)

                    // on below line we are displaying a toast message for message send,
                    Toast.makeText(applicationContext, "Message Sent", Toast.LENGTH_LONG).show()

                } catch (e: Exception) {
                    println("sms_error " + e.message.toString())
                    Toast.makeText(
                        applicationContext,
                        "Please enter all the data.." + e.message.toString(),
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

            }
        }
    }