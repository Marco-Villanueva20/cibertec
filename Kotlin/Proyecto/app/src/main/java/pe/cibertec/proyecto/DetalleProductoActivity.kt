package pe.cibertec.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.cibertec.proyecto.adapter.ProductoAdapter
import pe.cibertec.proyecto.model.Producto
import pe.cibertec.proyecto.util.DatabaseHelper
import pe.cibertec.proyecto.util.LoadingDialog

class DetalleProductoActivity : AppCompatActivity() {

    private lateinit var loading: LoadingDialog

    private lateinit var btnAddCarrito: Button
    private lateinit var btnAumentar: Button
    private lateinit var btnDisminuir: Button


    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var lblNombreProd: TextView
    private var id: String = ""
    private lateinit var lblPrecioProd: TextView
    private lateinit var etCantidad: EditText
    private lateinit var lblDescripcion: TextView
    private lateinit var ivProducto: ImageView
    private lateinit var etCantidadDetalle: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        initUIComponents()
        setupUIComponents()

        val extras = intent.extras
        if (extras != null) {
            id = extras.getString("id").toString()
            getProductoSQLite(id)

        }


    }

    private fun initUIComponents() {
        loading = LoadingDialog(this)
        // Inicializar vistas
        lblNombreProd = findViewById(R.id.tvDetalleProducto)
        lblPrecioProd = findViewById(R.id.tvPrecio)
        etCantidad = findViewById(R.id.etCantidadDetalle)
        lblDescripcion = findViewById(R.id.tvDetallesProducto)
        ivProducto = findViewById(R.id.ivImagenProducto)
        btnDisminuir = findViewById(R.id.btnDisminuirDetalle)
        btnAumentar = findViewById(R.id.btnAumentarDetalle)
        btnAddCarrito = findViewById(R.id.btnAddCarritoDetalle)
    }


    private fun setupUIComponents() {
        loading.startLoading()
        databaseHelper = DatabaseHelper(this)



    }


    private fun getProductoSQLite(id: String) {
        val producto = databaseHelper.getProducto(id)


        lblNombreProd.text = producto!!.nombre
        lblPrecioProd.text = producto.precio.toString()
        etCantidad.setText(producto.cantidad.toString())
        lblDescripcion.text = producto.descripcion
        val resourceId = this.resources.getIdentifier(producto.img, "drawable", this.packageName)
        if (resourceId != 0) {
            Glide.with(this).load(resourceId).into(ivProducto)
        } else {
            Glide.with(this).load(R.drawable.facebook).into(ivProducto)
        }
    }

}
