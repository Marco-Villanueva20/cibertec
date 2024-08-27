package pe.cibertec.ef

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.cibertec.ef.model.Usuario
import pe.cibertec.ef.util.UsuarioDatabaseHelper

class LoginActivity : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnAcceder: Button
    private lateinit var btnRegistrar: Button
    private lateinit var usuarioDatabaseHelper: UsuarioDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        initUIComponents()
        setupUIComponents()

    }

    private fun setupUIComponents() {
        btnAcceder.setOnClickListener {
            val email = txtEmail.text.toString()
            val password = txtPassword.text.toString()

            // Verificar la autenticación del usuario
            val usuario = usuarioDatabaseHelper.getUsuarioByUserAndPassword(email, password)

            if (usuario != null) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                goToListCars()
            } else {

                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegistrar.setOnClickListener {
            val email = txtEmail.text.toString()
            val password = txtPassword.text.toString()

            if (isValidEmail(email) && password.isNotEmpty()) {
                val usuario = Usuario(id = 0, user = email, password = password)
                val id = usuarioDatabaseHelper.insertUsuario(usuario)
                if (id != -1L) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    goToListCars()
                } else {
                    Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, ingrese un correo electrónico válido @gmail o @hotmail y contraseña", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun initUIComponents() {
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)
        btnAcceder = findViewById(R.id.btnAcceder)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        usuarioDatabaseHelper = UsuarioDatabaseHelper(this)
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9._%+-]+@(hotmail|gmail)\\.com$"
        return email.matches(emailRegex.toRegex())
    }


    private fun goToListCars() {
        val intent = Intent(this@LoginActivity,ListCarsActivity::class.java).apply{
            putExtra("email",txtEmail.text.toString())
        }
        startActivity(intent)
    }

}
