package pe.cibertec.ef

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import pe.cibertec.ef.adapter.CarAdapter
import pe.cibertec.ef.model.Car
import pe.cibertec.ef.util.LoadingDialog

class ListCarsActivity : AppCompatActivity() {

    private lateinit var loading: LoadingDialog
    private lateinit var btnAddCar: FloatingActionButton
    private lateinit var recyclerViewCar: RecyclerView
    private lateinit var dbFirebase: DatabaseReference
    private var maxCarId : Int = 0
    private var email : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cars)

        loading = LoadingDialog(this)
        loading.startLoading()

        recyclerViewCar = findViewById(R.id.recyclerCar)

        val extras = intent.extras
        if (extras != null) {
             email= extras.getString("email").toString()
        }

        btnAddCar = findViewById(R.id.btnAddCar)

        if (email.contains("@gmail.com")) {
            btnAddCar.visibility = View.VISIBLE // Para hacer visible el botón
        }
        if (email.contains("@hotmail.com")) {
            btnAddCar.visibility = View.INVISIBLE // Para hacer invisible el botón
        }
        setupComponents()

        loadDataFirebase()
    }

    private fun setupComponents() {
        recyclerViewCar.layoutManager = LinearLayoutManager(this)

        dbFirebase = FirebaseDatabase.getInstance().getReference("Cars")

    }


    private fun loadDataFirebase() {
        dbFirebase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val arrayCars = mutableListOf<Car>()
                if(snapshot.exists()){
                    for(carSnap in snapshot.children){
                        val car = carSnap.getValue(Car::class.java)
                        arrayCars.add(car!!)
                    }
                     maxCarId= arrayCars!!.maxOf { it.carId }
                    recyclerViewCar.adapter = CarAdapter(arrayCars) { goToCarDetail(it)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
        loading.finishLoading()
        btnAddCar.setOnClickListener {
            val intent = Intent(this@ListCarsActivity, AddCarActivity::class.java)
            intent.putExtra("maxCarId", maxCarId+1)
            startActivity(intent)
        }
    }

    private fun goToCarDetail(car: Car) {
        val intent = Intent(this@ListCarsActivity, DetailsCarActivity::class.java).apply {
            putExtra("carId", car.carId)
        }
        startActivity(intent)
    }
}
