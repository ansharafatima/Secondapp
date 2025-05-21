package com.example.secondapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



                val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
                val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
                val loginButton = findViewById<Button>(R.id.loginButton)

                // Initialize SharedPreferences
                sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

                loginButton.setOnClickListener {
                    val username = usernameEditText.text.toString().trim()
                    val password = passwordEditText.text.toString().trim()

                    if (username.isNotEmpty() && password.isNotEmpty()) {
                        // Save user data in SharedPreferences
                        val editor = sharedPreferences.edit()
                        editor.putString("USERNAME", username)
                        editor.putString("PASSWORD", password)
                        editor.apply()

                        Toast.makeText(this, "Welcome, $username!", Toast.LENGTH_SHORT).show()

                        // Navigate to MainActivity
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Please enter username & password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

