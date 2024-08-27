package pe.cibertec.ef.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.cibertec.ef.R
import pe.cibertec.ef.model.Car

class CarViewHolder(view: View, position :(Int)->Unit) : RecyclerView.ViewHolder(view){

    val lblMarca: TextView = view.findViewById(R.id.lblMarca)
    val lblModelo: TextView = view.findViewById(R.id.lblModelo)
    val ivImagenCarro : ImageView=view.findViewById(R.id.ivImagenCarro)

    init {
        itemView.setOnClickListener{
            position(adapterPosition)
        }
    }

    fun render(car : Car){
        Glide.with(itemView.context).load(car.img).into(ivImagenCarro)
        lblMarca.text = car.marca
        lblModelo.text = car.modelo
    }
}