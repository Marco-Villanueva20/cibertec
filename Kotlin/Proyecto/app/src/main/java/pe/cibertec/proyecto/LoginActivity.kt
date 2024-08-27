package pe.cibertec.proyecto

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    private lateinit var btnRegistrar: Button
    private lateinit var btnAcceder: Button
    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUIComponents()

        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnAcceder = findViewById(R.id.btnAcceder)
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)

        setup()
    }

//    override fun onStart() {
//        super.onStart()
//        val currentUser = auth.currentUser
//        updateUI(currentUser)
//    }

//    private fun updateUI(currentUser: FirebaseUser?) {
//        customToken?.let {
//            auth.signInWithCustomToken(it)
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d(TAG, "signInWithCustomToken:success")
//                        val user = auth.currentUser
//                        updateUI(user)
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.w(TAG, "signInWithCustomToken:failure", task.exception)
//                        Toast.makeText(
//                            baseContext,
//                            "Authentication failed.",
//                            Toast.LENGTH_SHORT,
//                        ).show()
//                        updateUI(null)
//                    }
//                }
//        }
//    }

    private fun initUIComponents() {
        val auth = Firebase.auth

    }

    private fun setup() {
        title = "Autenticación"

        btnRegistrar.setOnClickListener {
            if (txtEmail.text.isNotEmpty() && txtPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    txtEmail.text.toString(),
                    txtPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showPrincipal(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }
        }

        btnAcceder.setOnClickListener {
            if (txtEmail.text.isNotEmpty() && txtPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    txtEmail.text.toString(),
                    txtPassword.text.toString()
                )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showPrincipal(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }

        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showPrincipal(email: String, provedor: ProviderType) {
        val principalIntent = Intent(this@LoginActivity, PrincipalActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provedor", provedor.toString())
        }
        startActivity(principalIntent)
    }


}