package com.example.enabled_buttononfill

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTextUsername = findViewById(R.id.edit_text_username)
        editTextPassword = findViewById(R.id.edit_text_password)
        buttonConfirm = findViewById(R.id.button_confirm)

        editTextUsername!!.addTextChangedListener(loginTextWatcher)
        editTextPassword!!.addTextChangedListener(loginTextWatcher)


    }
    private var editTextUsername: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonConfirm: Button? = null

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = editTextUsername!!.text.toString().trim { it <= ' ' }
            val passwordInput = editTextPassword!!.text.toString().trim { it <= ' ' }

            buttonConfirm!!.isEnabled = !usernameInput.isEmpty() && !passwordInput.isEmpty()
        }

        override fun afterTextChanged(s: Editable) {

        }
    }

}
