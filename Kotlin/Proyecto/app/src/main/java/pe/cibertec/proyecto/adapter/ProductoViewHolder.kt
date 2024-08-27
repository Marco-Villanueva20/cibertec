package pe.cibertec.proyecto.adapter

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.cibertec.proyecto.PrincipalActivity
import pe.cibertec.proyecto.R
import pe.cibertec.proyecto.model.Producto

class ProductoViewHolder(view: View, position: (Int) -> Unit) : RecyclerView.ViewHolder(view) {

    private val lblNombreProd: TextView = view.findViewById(R.id.tvNombreProducto)
    private val lblPrecioProd: TextView = view.findViewById(R.id.tvPrecioProducto)
    private val lblCantidad: TextView = view.findViewById(R.id.etCantidad)
    private val lblDescripcion : TextView = view.findViewById(R.id.tvNombreProducto)
    private val btnAddCarrito :Button= view.findViewById(R.id.btnAddCarrito)
    private val btnAumentar :Button = view.findViewById(R.id.btnAumentar)
    private val btnDisminuir :Button = view.findViewById(R.id.btnDisminuir)
    private val ivProducto: ImageView = view.findViewById(R.id.ivProducto)
    //

    init {
        itemView.setOnClickListener {
            position(adapterPosition)
        }
    }

    fun render(producto: Producto, onClickAdd: (Producto) -> Unit) {
        val resourceId = itemView.context.resources.getIdentifier(producto.img, "drawable", itemView.context.packageName)
        if (resourceId != 0) {
            Glide.with(itemView.context).load(resourceId).into(ivProducto)
        } else {
            Glide.with(itemView.context).load(R.drawable.facebook).into(ivProducto)
        }

        lblNombreProd.text = producto.nombre
        lblDescripcion.text = producto.descripcion
        lblPrecioProd.text = producto.precio.toString()
        //lblCantidad.text = producto.cantidad.toString()


        btnAddCarrito.setOnClickListener{
            onClickAdd(producto)
//            PrincipalActivity.carrito.add(producto)
            btnAumentar.isEnabled=false
            btnDisminuir.isEnabled=false
            btnAddCarrito.isEnabled=false

        }

        btnAumentar.setOnClickListener{
            var num : Int =  lblCantidad.text.toString().toInt()
            num++
            lblCantidad.text = num.toString()
        }
        btnDisminuir.setOnClickListener{
            var num : Int =  lblCantidad.text.toString().toInt()
            if (num > 1){
                num--
                lblCantidad.text = num.toString()
            }
        }

    }

}