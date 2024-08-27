package pe.cibertec.ef

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import pe.cibertec.ef.model.Car

class DetailsCarActivity : AppCompatActivity() {

    private lateinit var btnEdit: FloatingActionButton
    private lateinit var btnDelete: FloatingActionButton
    private lateinit var txtMarcaCar: TextInputEditText
    private lateinit var txtModeloCar: TextInputEditText
    private lateinit var txtAnioCar: TextInputEditText
    private lateinit var txtAsientosCar: TextInputEditText
    private lateinit var txtColorCar: TextInputEditText
    private lateinit var btnGuardar: Button
    private lateinit var btnCancelar: Button
    private lateinit var lyActions: LinearLayout
    private lateinit var dbFirebase: DatabaseReference
    private lateinit var txtImagenUrl: TextInputEditText


    private var cardId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_car)
        initIdCar()
        initUIComponents()
        getCarFirebase()
        setupUIComponents()

    }

    private fun initIdCar() {
        val extras = intent.extras
        if (extras != null) {
            cardId = extras.getInt("carId")
        }
    }

    private fun getCarFirebase() {
        dbFirebase.child(cardId.toString()).get().addOnSuccessListener { dataSnapshot ->
            val car = dataSnapshot.getValue(Car::class.java)
            car?.let { displayCarDetails(it) }

        }.addOnFailureListener {
            // Manejar error al obtener el carro desde Firebase
        }
    }

    private fun displayCarDetails(car: Car) {
        txtMarcaCar.setText(car.marca)
        txtModeloCar.setText(car.modelo)
        txtAnioCar.setText(car.anioCreacion.toString())
        txtColorCar.setText(car.color)
        txtAsientosCar.setText(car.asientos.toString())
        txtImagenUrl.setText(car.img)
    }

    private fun setupUIComponents() {
        btnEdit.setOnClickListener {
            txtMarcaCar.isEnabled = true
            txtModeloCar.isEnabled = true
            txtAnioCar.isEnabled = true
            txtColorCar.isEnabled = true
            txtAsientosCar.isEnabled = true
            txtImagenUrl.isEnabled=true
            lyActions.visibility = View.VISIBLE
        }

        btnCancelar.setOnClickListener {
            txtMarcaCar.isEnabled = false
            txtModeloCar.isEnabled = false
            txtAnioCar.isEnabled = false
            txtColorCar.isEnabled = false
            txtAsientosCar.isEnabled = false
            txtImagenUrl.isEnabled = false
            lyActions.visibility = View.INVISIBLE
        }

        btnDelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("¿Estás seguro que quieres eliminar el carro con ID $cardId?")
                .setPositiveButton("Sí") { dialog, _ ->
                    deleteCarFirebase()
                    dialog.dismiss()
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
        btnGuardar.setOnClickListener {
            val updatedCar = Car(
                cardId,
                txtMarcaCar.text.toString().trim(),
                txtModeloCar.text.toString().trim(),
                txtAnioCar.text.toString().trim().toInt(),
                txtAsientosCar.text.toString().trim().toInt(),
                txtColorCar.text.toString().trim()
                ,txtImagenUrl.text.toString().trim()
            )

            AlertDialog.Builder(this)
                .setMessage("¿Estás seguro que quieres actualizar el carro con ID $cardId?")
                .setPositiveButton("Sí") { dialog, _ ->
                    updateCarFirebase(updatedCar)
                    dialog.dismiss()
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun updateCarFirebase(updatedCar: Car) {

        dbFirebase.child(cardId.toString()).setValue(updatedCar)
            .addOnSuccessListener {
                confirmUpdate()
            }
            .addOnFailureListener { e ->
                msjFirebaseError("actualizar",e)
            }
    }

    private fun confirmUpdate() {
        Toast.makeText(this, "Carro actualizado correctamente", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ListCarsActivity::class.java)
        startActivity(intent)
    }

    private fun deleteCarFirebase() {
        dbFirebase.child(cardId.toString()).removeValue()
            .addOnSuccessListener {
                confirmDelete()
            }
            .addOnFailureListener {e ->
                msjFirebaseError("eliminar",e)
            }
    }

    private fun confirmDelete() {
        Toast.makeText(this, "Carro eliminado correctamente", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ListCarsActivity::class.java)
        startActivity(intent)
    }

    private fun initUIComponents() {
        txtImagenUrl = findViewById(R.id.txtImagenCarroDet)
        btnEdit = findViewById(R.id.btnEditDt)
        btnDelete = findViewById(R.id.btnDeleteDt)
        txtMarcaCar = findViewById(R.id.txtMarcaCarDt)
        txtModeloCar = findViewById(R.id.txtModeloCarDt)
        txtAnioCar = findViewById(R.id.txtAnioCarDt)
        txtAsientosCar = findViewById(R.id.txtAsientosCarDt)
        txtColorCar = findViewById(R.id.txtColorCarDt)
        lyActions = findViewById(R.id.lyActionsCarDt)

        btnGuardar = findViewById(R.id.btnSaveCarDt)
        btnCancelar = findViewById(R.id.btnCancelCarDt)

        dbFirebase = FirebaseDatabase.getInstance().getReference("Cars")
    }
    private fun msjFirebaseError(action: String, e: Exception) {
        Toast.makeText(
            this@DetailsCarActivity,
            "Error al $action el carro: ${e.message}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
