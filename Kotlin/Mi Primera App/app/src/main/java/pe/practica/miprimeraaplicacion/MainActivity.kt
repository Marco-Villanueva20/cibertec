package pe.practica.miprimeraaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val atributo1 = "a" //inmutable //redundante val atributo1 : String = "a" //inmutable

        var atributo2  = 1 //mutable
        atributo2 = 9

        var parrafo = "Mi linea 1 \n"
        parrafo += "Mi linea 2 \n"
        parrafo += "Mi linea 3"

        val parrafobloque = """
           Mi linea de bloque 1
           Mi linea de bloque 2
           Mi linea de bloque 3
        """//String literal

        fun mostrar(parametro: Any){
            println(parametro)
        }
        mostrar(parrafo)
        mostrar(parrafobloque)
        mostrar(atributo1)

        var minumero =0
        while (minumero<100){
            println("Mi numero es ${minumero}")//String Tamplates
            minumero+=2
        }
        fun sumaConLambda(a: Int, b: Int, operacion: (Int, Int) -> Int): Int = operacion(a, b)
        println(sumaConLambda(8,4){ x, y -> x + y })
        val docente = Docente("Marco","Villanueva")

        mostrar(docente)
        //object Destructuring
        val (id,nombre,apellido)=docente
        mostrar(id)
        mostrar(nombre)
        mostrar(apellido)

        val arrayInt = arrayListOf<Int>(1,3,3,4,5)
        val arrarDocente = arrayListOf<Docente>(
            Docente(1,"Marco","Villanueva"),
            Docente(2,"Roxana","Villanueva"),
            Docente(3,"Carmen","Soto")
        )
        for ( docente in arrarDocente){
            mostrar(docente)
        }
        arrarDocente.forEach{println(it)}

        for (i in 1 .. 50){
            mostrar(i)
        }

    //println(parrafo)
        //println(parrafobloque)
        //println(atributo1)
    }

    data class Docente(
        val id : Int,
        var nombre: String,
        var apellido: String
    ){
        constructor(nombre: String,apellido: String):this(1,nombre,apellido)
    }
}