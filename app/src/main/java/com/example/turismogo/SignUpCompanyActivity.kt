package com.example.turismogo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpCompanyActivity : AppCompatActivity() {

    private lateinit var rucEditText: EditText
    private lateinit var companyNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_company)

        // Initialize the views
        rucEditText = findViewById(R.id.ruc)
        companyNameEditText = findViewById(R.id.companyName)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        registerButton = findViewById(R.id.registerButton)
        cancelButton = findViewById(R.id.cancelButton)

        // Set click listeners for the buttons
        registerButton.setOnClickListener {
            val ruc = rucEditText.text.toString()
            val companyName = companyNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateInput(ruc, companyName, email, password)) {
                // Handle registration logic
                Toast.makeText(this, "Company registration successful", Toast.LENGTH_SHORT).show()
                // Navigate to the next screen or perform any required action
            }
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }

    // Function to validate input
    private fun validateInput(ruc: String, companyName: String, email: String, password: String): Boolean {
        return when {
            ruc.isEmpty() -> {
                rucEditText.error = "Please enter Ruc"
                rucEditText.requestFocus()
                false
            }
            companyName.isEmpty() -> {
                companyNameEditText.error = "Please enter company name"
                companyNameEditText.requestFocus()
                false
            }
            email.isEmpty() -> {
                emailEditText.error = "Please enter your email"
                emailEditText.requestFocus()
                false
            }
            password.isEmpty() -> {
                passwordEditText.error = "Please enter your password"
                passwordEditText.requestFocus()
                false
            }
            else -> true
        }
    }
}
