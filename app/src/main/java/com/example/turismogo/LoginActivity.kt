package com.example.turismogo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpUserButton: Button
    private lateinit var signUpCompanyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize the views
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        signInButton = findViewById(R.id.signInButton)
        signUpUserButton = findViewById(R.id.signUpUserButton)
        signUpCompanyButton = findViewById(R.id.signUpCompanyButton)

        // Set click listeners for the buttons
        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (validateInput(email, password)) {
                // Check if email and password match the hardcoded values
                if (email == "prueba@gmail.com" && password == "prueba") {
                    // Redirect to HomeActivity
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // Optional: to close LoginActivity
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        signUpUserButton.setOnClickListener {
            // Navigate to the User Sign Up activity
            val intent = Intent(this, SignUpUserActivity::class.java)
            startActivity(intent)
        }

        signUpCompanyButton.setOnClickListener {
            // Navigate to the Company Sign Up activity
            val intent = Intent(this, SignUpCompanyActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to validate input
    private fun validateInput(email: String, password: String): Boolean {
        return when {
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
