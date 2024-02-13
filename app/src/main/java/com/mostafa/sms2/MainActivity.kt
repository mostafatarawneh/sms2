package com.mostafa.sms2


import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.Intent
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

    private val SEND_SMS_PERMISSION_REQUEST_CODE = 1
    lateinit var et_column_name: EditText
    lateinit var iv_pick_file: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Add this line to inflate the layout
        et_column_name = findViewById(R.id.et_colmn_name)
        iv_pick_file = findViewById(R.id.imageViewSelect)


    }
}


