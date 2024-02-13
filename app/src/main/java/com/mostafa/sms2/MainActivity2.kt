package com.mostafa.sms2
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.Manifest
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity2 : Activity() {
    val SEND_SMS_PERMISSION_REQUEST_CODE =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        requestSendSmsPermission()
        val phoneNumberEditText: EditText = findViewById(R.id.editTextPhoneNumber)
        val messageEditText: EditText = findViewById(R.id.editTextMessage)
        val sendButton: Button = findViewById(R.id.buttonSend)
        sendButton.setOnClickListener {
            val phoneNumberInput = phoneNumberEditText.text.toString()
            val messageInput = messageEditText.text.toString()

            if (phoneNumberInput.isNotEmpty() && messageInput.isNotEmpty()) {
                val phoneNumbers = phoneNumberInput.split(",").map { it.trim() }
                sendSms(phoneNumbers, messageInput)
            } else {
                showToast("Please enter valid phone number(s) and message.")
            }
        }
    }

    private fun sendSms(phoneNumbers: List<String>, message: String) {
        val smsManager = SmsManager.getDefault()

        for (phoneNumber in phoneNumbers) {
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            showToast("SMS sent to $phoneNumber")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun requestSendSmsPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.SEND_SMS),
                SEND_SMS_PERMISSION_REQUEST_CODE
            )
        } else {
            // Permission already granted, proceed with sending SMS or other logic
            // You can call your file picker code here
            // For example: startActivityForResult(createFilePickerIntent(), PICK_FILE_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == SEND_SMS_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                TODO("Here you can use the app from code or it self")
                var lnumPhone  = listOf<String>("","")
                sendSms(lnumPhone,"this is message")
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(
                    this,
                    "Permission denied. SMS functionality will not work.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


}
