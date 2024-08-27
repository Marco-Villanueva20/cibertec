package pe.empresa.ejerciciolayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LinearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear)
//no dp si sp
        val lblTitulo = findViewById<TextView>(R.id.lblTitulo) //val lblTitulo: TextView = findViewById<TextView>(R.id.lblTitulo) as TextView
        lblTitulo.setText("Mi primera Aplicacion")

    }
}