package pe.cibertec.dami.recyclerapplication.model

import java.io.Serializable

data class Docente(
    val docenteId: Int,
    val nombre: String,
    val apellido: String,
    val tipoDocente: Int,
    val foto: String
) : Serializable {
    constructor() : this(0, "", "", 0, "")
}