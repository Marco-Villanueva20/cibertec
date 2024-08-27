package pe.cibertec.proyecto.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Producto(
     val id: String?,
     val nombre: String?,
     val descripcion: String?,
     val precio: Double,
     var cantidad: Int,
     val marca: String?,
     val tipoAnimal: String?,
     val img:String?
) : Serializable, Parcelable{
     constructor(parcel: Parcel) : this(
          parcel.readString(),
          parcel.readString(),
          parcel.readString(),
          parcel.readDouble(),
          parcel.readInt(),
          parcel.readString(),
          parcel.readString(),
          parcel.readString()
     ) {
     }

     constructor() : this("","","",0.0,0,"","","")

     override fun writeToParcel(parcel: Parcel, flags: Int) {
          parcel.writeString(id)
          parcel.writeString(nombre)
          parcel.writeString(descripcion)
          parcel.writeDouble(precio)
          parcel.writeInt(cantidad)
          parcel.writeString(marca)
          parcel.writeString(tipoAnimal)
          parcel.writeString(img)
     }

     override fun describeContents(): Int {
          return 0
     }

     companion object CREATOR : Parcelable.Creator<Producto> {
          override fun createFromParcel(parcel: Parcel): Producto {
               return Producto(parcel)
          }

          override fun newArray(size: Int): Array<Producto?> {
               return arrayOfNulls(size)
          }
     }
}