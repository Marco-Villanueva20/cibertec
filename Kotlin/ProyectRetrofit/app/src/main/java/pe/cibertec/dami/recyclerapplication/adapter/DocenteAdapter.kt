package pe.cibertec.dami.recyclerapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.dami.recyclerapplication.R
import pe.cibertec.dami.recyclerapplication.model.Docente

class DocenteAdapter(
    private val docenteList: List<Docente>,
    private val clickListener: (Docente) -> Unit
) :
    RecyclerView.Adapter<DocenteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocenteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val vh = DocenteViewHolder(layoutInflater.inflate(R.layout.layout_docente, parent, false)) {
            clickListener(docenteList[it])
        }
        return vh
    }

    override fun onBindViewHolder(holder: DocenteViewHolder, position: Int) {
        val itemDocente = docenteList[position]
        holder.render(itemDocente)
    }

    override fun getItemCount(): Int = docenteList.size

}