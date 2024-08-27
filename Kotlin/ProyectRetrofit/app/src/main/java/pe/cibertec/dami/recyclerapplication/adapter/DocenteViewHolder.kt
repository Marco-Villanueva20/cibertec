package pe.cibertec.dami.recyclerapplication.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.cibertec.dami.recyclerapplication.R
import pe.cibertec.dami.recyclerapplication.model.Docente

class DocenteViewHolder(view: View, position: (Int) -> Unit) : RecyclerView.ViewHolder(view) {

    val lblId: TextView = view.findViewById(R.id.lblId)
    val lblNombre: TextView = view.findViewById(R.id.lblNombreDocente)
    val lblApellido: TextView = view.findViewById(R.id.lblApellidoDocente)
    val lblTipoDocente: TextView = view.findViewById(R.id.lblTipoDocente)
    val imgDocente: ImageView = view.findViewById(R.id.imgDocente)
    val nombreCompleto: TextView = view.findViewById(R.id.nombreCompleto)

    init {
        itemView.setOnClickListener {
            position(adapterPosition)
        }
    }

    fun render(docente: Docente) {

        Glide.with(itemView.context).load(docente.foto).into(imgDocente)

        lblId.text = docente.docenteId.toString()
        lblNombre.text = docente.nombre
        lblApellido.text = docente.apellido
        nombreCompleto.text = "${docente.nombre} ${docente.apellido}: ${docente.docenteId}"

        // 1 = Tiempo Completo y 2 = Tiempo Parcial
        var tipoDocente = ""
        when (docente.tipoDocente) {
            1 -> {
                tipoDocente = "Tiempo Completo"
            }

            2 -> {
                tipoDocente = "Tiempo Parcial"
            }
        }
        lblTipoDocente.text = tipoDocente
    }

}