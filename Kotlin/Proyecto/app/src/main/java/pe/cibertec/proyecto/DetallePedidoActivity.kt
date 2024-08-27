package pe.cibertec.proyecto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.proyecto.adapter.ProductoAdapter
import pe.cibertec.proyecto.model.Producto
import pe.cibertec.proyecto.util.LoadingDialog

class DetallePedidoActivity : AppCompatActivity() {
    private var listaCarrito: ArrayList<Producto> = arrayListOf()
    private lateinit var recyclerViewCarrito: RecyclerView
    private lateinit var loading: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pedido)
        //initRecyclerView()

        val extras = intent.extras
        if (extras != null) {
            listaCarrito = intent.getParcelableArrayListExtra("carrito") ?: arrayListOf()
        }

        //setupRecyclerView()
    }

//    private fun initRecyclerView() {
//        loading = LoadingDialog(this)
//        recyclerViewCarrito = findViewById(R.id.rvCamion)
//        val manager = LinearLayoutManager(this)
//        recyclerViewCarrito.layoutManager = manager
//    }
//
//    private fun setupRecyclerView() {
//        recyclerViewCarrito.adapter = ProductoAdapter(
//            productoList = listaCarrito,
//            clickListener = {  },
//            onClickAdd = {
//        )
//
//        loading.finishLoading()
//    }


}
