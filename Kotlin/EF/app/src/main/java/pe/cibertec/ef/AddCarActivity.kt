package pe.cibertec.ef

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.cibertec.ef.model.Car

class AddCarActivity : AppCompatActivity() {

    private lateinit var btnAddCar: Button
    private lateinit var btnCancelCar: Button
    private lateinit var txtMarcaCar: TextInputEditText
    private lateinit var txtModeloCar: TextInputEditText
    private lateinit var txtAnioCar: TextInputEditText
    private lateinit var txtAsientosCar: TextInputEditText
    private lateinit var txtColorCar: TextInputEditText
    private lateinit var ivImagenCar: TextInputEditText
    private var maxCarId: Int = 0
    private lateinit var s : ScrollView

    private lateinit var dbFirebase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        dbFirebase = FirebaseDatabase.getInstance().getReference("Cars")

        initUIComponents()
        setupUIComponents()
    }

    private fun initUIComponents() {
        val extras = intent.extras
        if (extras != null){
            maxCarId = extras.getInt("maxCarId")
        }
        btnAddCar = findViewById(R.id.btnSaveCar)
        btnCancelCar = findViewById(R.id.btnCancelCar)


        txtMarcaCar = findViewById(R.id.txtMarcaCar)
        txtModeloCar = findViewById(R.id.txtModeloCar)
        txtAnioCar = findViewById(R.id.txtAnioCar)
        txtAsientosCar = findViewById(R.id.txtAsientosCar)
        txtColorCar = findViewById(R.id.txtColorCar)
        ivImagenCar = findViewById(R.id.txtImagenCarroAdd)
    }

    private fun setupUIComponents() {
        btnAddCar.setOnClickListener {
            val marca = txtMarcaCar.text.toString().trim()
            val modelo = txtModeloCar.text.toString().trim()
            val anioCreacion = txtAnioCar.text.toString().trim().toInt()
            val asientos = txtAsientosCar.text.toString().trim().toInt()
            val color = txtColorCar.text.toString().trim()
            val img = ivImagenCar.text.toString().trim()

            val car = Car(maxCarId, marca, modelo, anioCreacion, asientos, color, img)
            saveCarFirebase(car)
        }

        btnCancelCar.setOnClickListener {
            txtMarcaCar.setText("")
            txtModeloCar.setText("")
            txtAnioCar.setText("")
            txtAsientosCar.setText("")
            txtColorCar.setText("")
            ivImagenCar.setText("")
        }
    }

    private fun saveCarFirebase(car: Car) {
        dbFirebase.child(car.carId.toString()).setValue(car)
            .addOnSuccessListener {
                Toast.makeText(this, "Carro agregado correctamente", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@AddCarActivity, ListCarsActivity::class.java))
            }
            .addOnFailureListener { e ->
                msjFirebaseError("guardar",e)
            }
    }

    private fun msjFirebaseError(mensaje: String, e: Exception) {
        Toast.makeText(
            this@AddCarActivity,
            "Error al $mensaje el carro: ${e.message}",
            Toast.LENGTH_SHORT
        ).show()
    }

}
