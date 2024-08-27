package pe.cibertec.cl2.adapter

import pe.cibertec.cl2.model.Car

class CarProvider {
 companion object{
     val carLis = mutableListOf(
         Car(1,"Toyota","Yaris",2015,"5","Blue"),
         Car(2,"Mazda","CX3",2019,"7","Red")
     )
 }
}