package pe.cibertec.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.proyecto.adapter.ProductoAdapter
import pe.cibertec.proyecto.model.Producto
import pe.cibertec.proyecto.util.DatabaseHelper
import pe.cibertec.proyecto.util.LoadingDialog


class PrincipalActivity : AppCompatActivity() {
    companion object {
        lateinit var carrito: MutableCollection<Producto>
    }
    private var maxProductoId = ""
 //   lateinit var carrito: MutableCollection<Producto>


    private lateinit var loading: LoadingDialog

    private lateinit var btnAddCarrito: Button
    private lateinit var btnAumentar: Button
    private lateinit var btnDisminuir: Button
    private lateinit var btnPerfil: Button
    private lateinit var btnPedido: Button


    private lateinit var etCantidad: EditText
    private lateinit var recyclerViewProducto: RecyclerView
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        initUIComponents()
        initRecyclerView()
        setupUIComponents()
        loadData()
    }


    private fun initUIComponents() {
        carrito = mutableListOf()
        btnPedido = findViewById(R.id.btnPedido)
        btnPerfil = findViewById(R.id.btnPerfil)
        loading = LoadingDialog(this)
    }

    private fun initRecyclerView() {
        recyclerViewProducto = findViewById(R.id.rvListaProductos)
        val manager = LinearLayoutManager(this)
        recyclerViewProducto.layoutManager = manager
    }


    private fun setupUIComponents() {
        loading.startLoading()
        databaseHelper = DatabaseHelper(this)
        var email: String = ""
        var provedor: String = ""

        val extras = intent.extras
        if (extras != null) {
            email = intent.getStringExtra("email").toString()
            provedor = intent.getStringExtra("provedor").toString()
        }

        btnPerfil.setOnClickListener {
            val intent = Intent(this@PrincipalActivity, PerfilActivity::class.java).apply {
                putExtra("email", email)
                putExtra("provedor", provedor)
            }
            startActivity(intent)
        }
        btnPedido.setOnClickListener {
            val intent = Intent(this@PrincipalActivity, DetallePedidoActivity::class.java).apply {
                carrito = intent.getParcelableArrayListExtra("carrito") ?: arrayListOf()
            }
            startActivity(intent)
        }

    }

    private fun loadData() {
        loadDataSQLite()
    }


    private fun loadDataSQLite() {
        // maxProductoId = databaseHelper.getAllProductos()!!.maxOf { it.id }
        //insertDataSQLite()
        val listaProducto: List<Producto> = databaseHelper.getAllProductos()
        recyclerViewProducto.adapter = ProductoAdapter(productoList = listaProducto,
            clickListener = { producto -> goToProductoDetalle(producto) },
            onClickAdd = { producto -> onAddCarrito(producto) })
        loading.finishLoading()
    }

    private fun onAddCarrito(producto: Producto) {
        carrito.add(producto)
    }

    private fun insertDataSQLite() {
        val productoList = listOf(
            Producto(
                "1",
                "Juguete de material resistente en forma de hueso",
                "Este juguete para perros está hecho de un material resistente y tiene forma de hueso. Ideal para perros que aman masticar.",
                10.0,
                5,
                "MarcaJuguetes",
                "Perro",
                "jugueteperro"
            ), Producto(
                "2",
                "Colchón descanso estampado para perros",
                "Un cómodo colchón estampado para perros. Perfecto para un buen descanso después de un día de juegos.",
                20.0,
                10,
                "MarcaDescanso",
                "Perro",
                "almohada"
            ), Producto(
                "3",
                "Arena aglomerante a base de bentonita",
                "Arena aglomerante para gatos a base de bentonita de alta calidad. No contiene aditivos ni químicos.",
                30.0,
                15,
                "MarcaArena",
                "Gato",
                "arena"
            )
        )


        productoList.forEach { producto ->
            databaseHelper.insertProducto(producto)
        }
    }

    private fun goToProductoDetalle(producto: Producto) {
        val intent = Intent(this@PrincipalActivity, DetalleProductoActivity::class.java).apply {
            putExtra("id", producto.id)
        }
        startActivity(intent)
    }


}