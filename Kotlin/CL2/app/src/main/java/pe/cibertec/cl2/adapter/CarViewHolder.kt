package pe.cibertec.cl2.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.cl2.R
import pe.cibertec.cl2.model.Car

class CarViewHolder(view: View, position :(Int)->Unit) : RecyclerView.ViewHolder(view){

    val lblMarca: TextView = view.findViewById(R.id.lblMarca)
    val lblModelo: TextView = view.findViewById(R.id.lblModelo)

    init {
        itemView.setOnClickListener{
            position(adapterPosition)
        }
    }

    fun render(car : Car){
        lblMarca.text = car.marca
        lblModelo.text = car.modelo
    }
}