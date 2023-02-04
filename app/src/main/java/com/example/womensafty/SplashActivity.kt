package com.example.womensafty

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.SEND_SMS
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class SplashActivity : AppCompatActivity() {

    private val PERMISSION_CODE: Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)
        checkPermissionList()
    }
    private fun checkPermissionList() {
        if (ActivityCompat.checkSelfPermission(this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(CALL_PHONE, SEND_SMS), PERMISSION_CODE)
            openLoginActivity()
        }else{
            Handler().postDelayed({
                openLoginActivity()
            }, 3000)
        }
    }
    private fun openLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent)
        finish();
    }
}