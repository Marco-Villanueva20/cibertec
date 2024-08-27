package pe.cibertec.ef.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.ef.R
import pe.cibertec.ef.model.Car

class CarAdapter(private val carList:List<Car>,private val clickListener:(Car) ->Unit):
    RecyclerView.Adapter<CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
       val layoutIntflater = LayoutInflater.from(parent.context)
        val vh = CarViewHolder(layoutIntflater.inflate(R.layout.item_cars,parent,false)){
            clickListener(carList[it])
        }
        return vh
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val itemCar = carList[position]
        holder.render(itemCar)
    }


}