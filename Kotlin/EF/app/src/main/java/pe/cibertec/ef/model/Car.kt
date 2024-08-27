package pe.cibertec.ef.model

import java.io.Serializable

data class Car (val carId:Int,
                val marca:String,
                val modelo:String,
                val anioCreacion:Int,
                val asientos:Int,
                val color:String,
                val img:String,
    ): Serializable{
constructor():this(0,"","",0,0,"","")
    }