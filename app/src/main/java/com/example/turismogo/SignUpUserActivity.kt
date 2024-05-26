package com.example.turismogo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpUserActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var documentTypeSpinner: Spinner
    private lateinit var documentNumberEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_user)

        // Initialize the views
        nameEditText = findViewById(R.id.name)
        documentTypeSpinner = findViewById(R.id.documentType)
        documentNumberEditText = findViewById(R.id.documentNumber)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        registerButton = findViewById(R.id.registerButton)
        cancelButton = findViewById(R.id.cancelButton)

        // Set click listeners for the buttons
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val documentType = documentTypeSpinner.selectedItem.toString()
            val documentNumber = documentNumberEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateInput(name, documentType, documentNumber, email, password)) {
                // Handle registration logic
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                // Navigate to the next screen or perform any required action
            }
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }

    // Function to validate input
    private fun validateInput(name: String, documentType: String, documentNumber: String, email: String, password: String): Boolean {
        return when {
            name.isEmpty() -> {
                nameEditText.error = "Please enter your name"
                nameEditText.requestFocus()
                false
            }
            documentType.isEmpty() -> {
                Toast.makeText(this, "Please select a document type", Toast.LENGTH_SHORT).show()
                false
            }
            documentNumber.isEmpty() -> {
                documentNumberEditText.error = "Please enter your document number"
                documentNumberEditText.requestFocus()
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
