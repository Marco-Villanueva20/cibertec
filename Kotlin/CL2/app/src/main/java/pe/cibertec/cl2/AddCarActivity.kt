package pe.cibertec.cl2

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.cibertec.cl2.model.Car
import pe.cibertec.cl2.proxy.interfaces.CarService
import pe.cibertec.cl2.proxy.retrofit.CarRetrofit

class AddCarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        var maxCarId =0
        val extras = intent.extras

        if(extras != null){
            maxCarId = extras.getInt("maxCarId")+1
        }

        val btnAddCar : Button = findViewById(R.id.btnSaveCar)
        val btnCancelCar : Button = findViewById(R.id.btnCancelCar)

        val txtIdCar : TextInputEditText = findViewById(R.id.txtIdCar)
        val txtMarcaCar : TextInputEditText = findViewById(R.id.txtMarcaCar)
        val txtModeloCar : TextInputEditText = findViewById(R.id.txtModeloCar)
        val txtAnioCar : TextInputEditText = findViewById(R.id.txtAnioCar)
        val txtAsientosCar : TextInputEditText = findViewById(R.id.txtAsientosCar)
        val txtColorCar : TextInputEditText = findViewById(R.id.txtColorCar)

        txtIdCar.append(""+maxCarId)

        btnAddCar.setOnClickListener{
            val carId = txtIdCar.text.toString().trim().toInt()
            val marca = txtMarcaCar.text.toString().trim()
            val modelo = txtModeloCar.text.toString().trim()
            val anioCreacion = txtAnioCar.text.toString().trim().toInt()
            val asientos = txtAsientosCar.text.toString().trim()
            val color = txtColorCar.text.toString().trim()

            val car = Car(carId, marca,modelo,anioCreacion,asientos,color)
            //CarProvider.carLis.add(car)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setMessage("¿Estás seguro que quieres agregar el nuevo carro ")
                .setCancelable(false).
                setPositiveButton("Si", DialogInterface.OnClickListener { dialogInterface, i ->

            CoroutineScope(Dispatchers.IO).launch {

                val retrofit = CarRetrofit.getRetrofit()
                    .create(CarService::class.java)
                    .saveCar(car)

                val data = retrofit.body()

                runOnUiThread {
                    Toast.makeText(this@AddCarActivity,
                        "Carro agregado correctamente", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@AddCarActivity,ListCarsActivity::class.java))

                }
            }
                }).setNegativeButton("No",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })
            alertDialog.create().show()
        }

        btnCancelCar.setOnClickListener{
            txtIdCar.setText("")
            txtMarcaCar.setText("")
            txtModeloCar.setText("")
            txtAnioCar.setText("")
            txtAsientosCar.setText("")
            txtColorCar.setText("")
        }
    }

}