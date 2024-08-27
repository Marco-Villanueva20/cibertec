package pe.cibertec.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    BASIC
}

class PerfilActivity : AppCompatActivity() {

    private lateinit var lblemail: TextView
    private lateinit var lblProvedor: TextView
    private lateinit var btnCerrarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        lblemail = findViewById(R.id.lblUsuarioLogeado)
        lblProvedor = findViewById(R.id.lblProvedor)
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)

        //setup
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")

        val provedor: String? = bundle?.getString("provedor")


        setup(email ?: "", provedor ?: "")
    }

    private fun setup(email: String, provedor: String) {
        title = "Bienvenido a mi proyecto"
        lblemail.text = email
        lblProvedor.text = provedor
        cerrarSesion()
    }

    private fun cerrarSesion() {
        btnCerrarSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@PerfilActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}