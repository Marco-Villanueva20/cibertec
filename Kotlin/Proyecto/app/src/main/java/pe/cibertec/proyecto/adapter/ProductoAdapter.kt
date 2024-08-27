package pe.cibertec.proyecto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.proyecto.R
import pe.cibertec.proyecto.model.Producto

class ProductoAdapter(
    private val productoList: List<Producto>,
    private val clickListener: (Producto) -> Unit,
    private val onClickAdd:(Producto)-> Unit
) : RecyclerView.Adapter<ProductoViewHolder>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val vh = ProductoViewHolder(layoutInflater.inflate(R.layout.card_layout,parent,false)){
            clickListener(productoList[it])
        }
        return vh
    }

    override fun getItemCount(): Int = productoList.size

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val itemProducto = productoList[position]
        holder.render(itemProducto,onClickAdd)

    }
}