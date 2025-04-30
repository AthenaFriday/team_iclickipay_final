package com.athenafriday.iclickipay.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch



open class LoginScreenViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onSuccess()
                    } else {
                        onError(task.exception?.message ?: "Login failed")
                    }
                }
        }
    }

    fun signUpWithEmail(email: String, password: String, context: Context) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Signup successful
                    Toast.makeText(context, "Signup successful!", Toast.LENGTH_SHORT).show()
                } else {
                    // Signup failed
                    Toast.makeText(context, "Signup failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

}