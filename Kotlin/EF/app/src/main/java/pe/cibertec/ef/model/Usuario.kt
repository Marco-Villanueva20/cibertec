package pe.cibertec.ef.model

import java.io.Serializable

class Usuario (
    val id:Int,
    val user:String,
    val password:String
    ): Serializable {
    constructor():this(0,"","")}

