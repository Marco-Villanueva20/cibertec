package pe.cibertec.dami.recyclerapplication

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.cibertec.dami.recyclerapplication.model.Docente
import pe.cibertec.dami.recyclerapplication.proxy.interfaces.DocenteService
import pe.cibertec.dami.recyclerapplication.proxy.retrofit.DocenteRetrofit
import pe.cibertec.dami.recyclerapplication.util.DatabaseHelper
import java.util.Arrays

class DetailDocenteActivity : AppCompatActivity() {

    private lateinit var btnEdit: FloatingActionButton
    private lateinit var btnDelete: FloatingActionButton
    private lateinit var txtNombre: TextInputEditText
    private lateinit var txtApellido: TextInputEditText
    private lateinit var spnTipoDocente: Spinner
    private lateinit var btnGuardar: Button
    private lateinit var btnCancelar: Button
    private lateinit var lyActions: LinearLayout

    private lateinit var databaseHelper: DatabaseHelper

    private var docenteId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_docente)
        btnEdit = findViewById(R.id.btnEdit)
        btnDelete = findViewById(R.id.btnDelete)
        txtNombre = findViewById(R.id.txtNombreDocenteDt)
        txtApellido = findViewById(R.id.txtApellidoDocenteDt)
        spnTipoDocente = findViewById(R.id.spnTipoDocenteDt)
        btnGuardar = findViewById(R.id.btnSaveDocente)
        btnCancelar = findViewById(R.id.btnClearDocente)
        lyActions = findViewById(R.id.lyActionsDt)
        databaseHelper = DatabaseHelper(this)
        var indexTipoDocente = -1

        val tipoDocente =
            ArrayList<String>(Arrays.asList(*resources.getStringArray(R.array.spnTipoDocente)))
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tipoDocente)
        spnTipoDocente.adapter = arrayAdapter

        spnTipoDocente.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                indexTipoDocente = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        btnEdit.setOnClickListener {
            txtNombre.isEnabled = true
            txtApellido.isEnabled = true
            spnTipoDocente.isEnabled = true
            lyActions.visibility = View.VISIBLE
        }

        btnCancelar.setOnClickListener {
            txtNombre.setText("")
            txtApellido.setText("")
            txtNombre.isEnabled = false
            txtApellido.isEnabled = false
            spnTipoDocente.isEnabled = false
            lyActions.visibility = View.INVISIBLE
        }

        val extras = intent.extras
        if (extras != null) {
            docenteId = extras.getInt("docenteId")
//           getDocenteRetrofit()
            getDocenteSQLite()

            btnDelete.setOnClickListener {

                val alertDialog = AlertDialog.Builder(this)

                alertDialog.setMessage("¿Estás seguro que quieres eliminar el docente con ID ${docenteId}?")
                    .setCancelable(false)
                    .setPositiveButton(
                        "Si",
                        DialogInterface.OnClickListener { dialogInterface, i ->
                            //deleteDocenteRetrofit()
                            deleteDocenteSQLite()
                        }

                    )
                    .setNegativeButton("No",
                        DialogInterface.OnClickListener { dialogInterface, i ->
                            dialogInterface.cancel()
                        })
                alertDialog.create().show()
            }
        }

        btnGuardar.setOnClickListener {

            val docente = Docente(
                docenteId = docenteId,
                apellido = txtApellido.text.toString().trim(),
                nombre = txtNombre.text.toString().trim(),
                tipoDocente = indexTipoDocente,
                foto = "https://loremflickr.com/320/240?lock=454"
            )

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setMessage("¿Estás seguro que quieres actualizar al docente ${docente.nombre} ${docente.apellido}?")
                .setCancelable(false)
                .setPositiveButton(
                    "Si",
                    DialogInterface.OnClickListener {dialogInterface, i ->
    //                  updateDocenteRetrofit()
                        updateDocenteSQLite(docente)
                    }
                )
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })
            alertDialog.create().show()
        }

    }

    private fun updateDocenteSQLite(docente: Docente) {
        databaseHelper.updateDocente(docente)
        confirmUpdate()
    }


    private fun confirmUpdate() {
        val intent =
            Intent(
                this@DetailDocenteActivity,
                ListaDocenteActivity::class.java
            )
        Toast.makeText(
            this@DetailDocenteActivity,
            "Docente actualizado correctamente",
            Toast.LENGTH_SHORT
        ).show()
        startActivity(intent)
    }


    private fun updateDocenteRetrofit(docente: Docente) {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit =
                DocenteRetrofit.getRetrofit().create(DocenteService::class.java)
                    .saveDocente(docente)
            val data = retrofit.body()
            runOnUiThread {
                confirmUpdate()
            }
        }
    }


    private fun getDocenteSQLite() {
        val docente = databaseHelper.getDocente(docenteId)
        txtApellido.setText(docente!!.apellido)
        txtNombre.setText(docente.nombre)
        spnTipoDocente.setSelection(docente.tipoDocente)
    }

    private fun getDocenteRetrofit(){
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit =
                DocenteRetrofit.getRetrofit().create(DocenteService::class.java)
                    .getDocente(docenteId)
            val data = retrofit.body()
            runOnUiThread {
//                    Toast.makeText(this@DetailDocenteActivity, "${data!!}", Toast.LENGTH_LONG).show()
                if (retrofit.isSuccessful) {
                    txtApellido.setText(data!!.apellido)
                    txtNombre.setText(data.nombre)
                    spnTipoDocente.setSelection(data.tipoDocente)
                }
            }
        }
    }
    private fun deleteDocenteRetrofit(){
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit =
                DocenteRetrofit.getRetrofit().create(DocenteService::class.java)
                    .deleteDocente(docenteId)
            val data = retrofit.body()
            runOnUiThread{
                confirmDelete()
            }
        }
    }


    private fun deleteDocenteSQLite() {
        databaseHelper.deleteDocente(docenteId)
        confirmDelete()
    }


    private fun confirmDelete(){
        val intent =
            Intent(
                this@DetailDocenteActivity,
                ListaDocenteActivity::class.java
            )
        Toast.makeText(
            this@DetailDocenteActivity,
            "Docente eliminado correctamente",
            Toast.LENGTH_SHORT
        ).show()
        startActivity(intent)
    }
}
