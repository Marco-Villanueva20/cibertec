package pe.cibertec.dami.recyclerapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.cibertec.dami.recyclerapplication.model.Docente
import pe.cibertec.dami.recyclerapplication.proxy.interfaces.DocenteService
import pe.cibertec.dami.recyclerapplication.proxy.retrofit.DocenteRetrofit
import pe.cibertec.dami.recyclerapplication.util.DatabaseHelper
import pe.cibertec.dami.recyclerapplication.util.LoadingDialog
import java.util.Arrays

class AddDocenteActivity : AppCompatActivity() {

    private lateinit var loading: LoadingDialog
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var dbFirebase : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_docente)


        loading = LoadingDialog(this) //        loading.startLoading()
        databaseHelper = DatabaseHelper(this)
        dbFirebase = FirebaseDatabase.getInstance().getReference("Docentes")


        var maxDocenteId = 0

        val extras = intent.extras
        if (extras != null) {
            maxDocenteId = extras.getInt("maxDocenteId") + 1
        }

        var indexTipoDocente = -1
        val btnAddDocente: Button = findViewById(R.id.btnAddDocente)
        val btnCancelDocente: Button = findViewById(R.id.btnCancelDocente)
        val txtNombreDocente: TextInputEditText = findViewById(R.id.txtNombreDocente)
        val txtApellidoDocente: TextInputEditText = findViewById(R.id.txtApellidoDocente)
        val spnTipoDocente: Spinner = findViewById(R.id.spnTipoDocente)
        val tipoDocente =
            ArrayList<String>(Arrays.asList(*resources.getStringArray(R.array.spnTipoDocente)))
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipoDocente)
        spnTipoDocente.adapter = arrayAdapter

        spnTipoDocente.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                indexTipoDocente = p2 // 0 = nulo, 1 = parcial, 2 = completo
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }



        btnAddDocente.setOnClickListener {

            val nombreDocente = txtNombreDocente.text.toString().trim()
            val apellidoDocente = txtApellidoDocente.text.toString().trim()

            //saveDocenteProvider(docente)
            //saveDocenteRetrofit(docente)
            /*
            saveDocenteSQLite(
                Docente(
                    id = "",
                    docenteId=maxDocenteId,
                    nombre = nombreDocente,
                    apellido = apellidoDocente,
                    tipoDocente = indexTipoDocente,
                    foto = "https://loremflickr.com/320/240?lock=15"
            ))*/
            saveDocenteFirebase(
                Docente(
                    docenteId=maxDocenteId,
                    nombre = nombreDocente,
                    apellido = apellidoDocente,
                    tipoDocente = indexTipoDocente,
                    foto = "https://loremflickr.com/320/240?lock=15"
                )
            )
        }

        btnCancelDocente.setOnClickListener {
            txtNombreDocente.setText("")
            txtApellidoDocente.setText("")
            spnTipoDocente.adapter = arrayAdapter
        }

    }

    private fun saveDocenteSQLite(docente:Docente){
        databaseHelper.insertDocente(docente)
        startActivity(Intent(this@AddDocenteActivity,ListaDocenteActivity::class.java))

    }

    private fun saveDocenteFirebase(docente: Docente){
        val objectId = dbFirebase.push().key!!
        dbFirebase.child(objectId).setValue(docente)
            .addOnCompleteListener{
                Toast.makeText(this,"Docente agregado correctamente",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@AddDocenteActivity,ListaDocenteActivity::class.java))
            }

    }


    private fun saveDocenteProvider(docente:Docente){
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit =
                DocenteRetrofit.getRetrofit().create(DocenteService::class.java)
                    .saveDocente(docente)
            val data = retrofit.body()
            runOnUiThread {
                //mensaje
                Toast.makeText(this@AddDocenteActivity, docente.toString(), Toast.LENGTH_LONG).show()

                startActivity(Intent(this@AddDocenteActivity, ListaDocenteActivity::class.java))
            }

        }
    }
    fun saveDocenteRetrofit(docente: Docente) {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit =
                DocenteRetrofit.getRetrofit().create(DocenteService::class.java)
                    .saveDocente(docente)
            val data = retrofit.body()
            runOnUiThread {
                startActivity(Intent(this@AddDocenteActivity, ListaDocenteActivity::class.java))
            }
        }
    }

}