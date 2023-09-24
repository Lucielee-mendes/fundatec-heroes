package com.example.fundatecheroes.profile.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fundatecheroes.R
import com.google.android.material.snackbar.Snackbar


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val buttonCreate = findViewById<Button>(R.id.buttonCreate)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)


        buttonCreate.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()


            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                showSnackbar("Todos os campos devem ser preenchidos")
                return@setOnClickListener
            }


            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            if (!email.matches(emailPattern.toRegex())) {
                showSnackbar("Email inválido")
                return@setOnClickListener
            }


            if (password.length < 8) {
                showSnackbar("A senha deve ter pelo menos 8 caracteres")
                return@setOnClickListener
            }

            showSnackbar("Perfil criado com sucesso")
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }
}
