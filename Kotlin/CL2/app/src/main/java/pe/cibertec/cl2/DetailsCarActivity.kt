package pe.cibertec.cl2

import android.content.DialogInterface
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.cibertec.cl2.model.Car
import pe.cibertec.cl2.proxy.interfaces.CarService
import pe.cibertec.cl2.proxy.retrofit.CarRetrofit

class DetailsCarActivity : AppCompatActivity() {
    private lateinit var  btnEdit:FloatingActionButton

    private var carId = 0

    private lateinit var txtIdCar : TextInputEditText
    private lateinit var txtMarcaCar : TextInputEditText
    private lateinit var txtModeloCar : TextInputEditText
    private lateinit var txtAnioCar : TextInputEditText
    private lateinit var txtAsientosCar : TextInputEditText
    private lateinit var txtColorCar : TextInputEditText

    private lateinit var btnGuardar : Button
    private lateinit var btnCancelar : Button
    private lateinit var btnDelete : FloatingActionButton
    private lateinit var lyActions:LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_car)

        btnEdit = findViewById(R.id.btnEditDt)
        btnDelete = findViewById(R.id.btnDeleteDt)
        txtIdCar = findViewById(R.id.txtIdCarDt)
        txtMarcaCar = findViewById(R.id.txtMarcaCarDt)
        txtModeloCar = findViewById(R.id.txtModeloCarDt)
        txtAnioCar = findViewById(R.id.txtAnioCarDt)
        txtAsientosCar = findViewById(R.id.txtAsientosCarDt)
        txtColorCar = findViewById(R.id.txtColorCarDt)
        lyActions = findViewById(R.id.lyActionsCarDt)

        btnGuardar = findViewById(R.id.btnSaveCarDt)
        btnCancelar = findViewById(R.id.btnCancelCarDt)

        btnEdit.setOnClickListener{
            txtMarcaCar.setText("")
            txtModeloCar.setText("")
            txtAnioCar.setText("")
            txtAsientosCar.setText("")
            txtColorCar.setText("")

            txtMarcaCar.isEnabled = true
            txtModeloCar.isEnabled = true
            txtAnioCar.isEnabled = true
            txtAsientosCar.isEnabled = true
            txtColorCar.isEnabled = true

           lyActions.visibility= View.VISIBLE
        }



        btnCancelar.setOnClickListener{
            txtMarcaCar.setText("")
            txtModeloCar.setText("")
            txtAnioCar.setText("")
            txtAsientosCar.setText("")
            txtColorCar.setText("")

            txtMarcaCar.isEnabled = false
            txtModeloCar.isEnabled = false
            txtAnioCar.isEnabled = false
            txtAsientosCar.isEnabled = false
            txtColorCar.isEnabled = false

            lyActions.visibility= View.INVISIBLE
        }
        val extras = intent.extras
        if (extras != null){

            carId = extras.getInt("carId")

            CoroutineScope(Dispatchers.IO).launch {

                val retrofit = CarRetrofit.getRetrofit()
                    .create(CarService::class.java)
                    .getCarById(carId)

                val data = retrofit.body()

                runOnUiThread {
                    if (retrofit.isSuccessful) {
                        txtIdCar.setText(data!!.carId.toString())
                        txtModeloCar.setText(data!!.modelo)
                        txtMarcaCar.setText(data!!.marca)
                        txtAnioCar.setText(data!!.anioCreacion.toString())
                        txtAsientosCar.setText(data!!.asientos)
                        txtColorCar.setText(data!!.color)
                    }

                    }
                }
            btnDelete.setOnClickListener{

                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setMessage("¿Estás seguro que quieres eliminar el carro con ID ${carId}")
                    .setCancelable(false).
                        setPositiveButton("Si",DialogInterface.OnClickListener { dialogInterface, i ->
                            CoroutineScope(Dispatchers.IO).launch {

                                val retrofit = CarRetrofit.getRetrofit()
                                    .create(CarService::class.java)
                                    .deleteCar(carId)

                                val data = retrofit.body()

                                runOnUiThread {
                                    val intent = Intent(this@DetailsCarActivity,ListCarsActivity::class.java)
                                    Toast.makeText(
                                        this@DetailsCarActivity,
                                        "Carro eliminado correctamente",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    startActivity(intent)
                                }
                            }
                        }).setNegativeButton("No",
                        DialogInterface.OnClickListener { dialogInterface, i ->
                            dialogInterface.cancel()
                        })
                alertDialog.create().show()
            }
            }
        btnGuardar.setOnClickListener{

    val car = Car(carId = carId, marca = txtMarcaCar.text.toString().trim(),modelo=txtModeloCar.text.toString().trim(),
        anioCreacion = txtAnioCar.text.toString().trim().toInt(),asientos=txtAsientosCar.text.toString().trim(),color=txtColorCar.text.toString().trim())

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setMessage("¿Estás seguro que quieres actualizar el carro con ID ${carId}")
                .setCancelable(false).
                setPositiveButton("Si",DialogInterface.OnClickListener { dialogInterface, i ->
                    CoroutineScope(Dispatchers.IO).launch {

                        val retrofit = CarRetrofit.getRetrofit()
                            .create(CarService::class.java)
                            .updateCar(car)

                        val data = retrofit.body()

                        runOnUiThread {
                            val intent = Intent(this@DetailsCarActivity,ListCarsActivity::class.java)
                            Toast.makeText(
                                this@DetailsCarActivity,
                                "Carro actualizado correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(intent)
                        }
                    }
                }).setNegativeButton("No",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })
            alertDialog.create().show()
        }
        }


    }
