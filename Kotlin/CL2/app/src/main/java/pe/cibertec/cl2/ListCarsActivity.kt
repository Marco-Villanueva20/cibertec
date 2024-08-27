package pe.cibertec.cl2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.cibertec.cl2.adapter.CarAdapter
import pe.cibertec.cl2.proxy.interfaces.CarService
import pe.cibertec.cl2.proxy.retrofit.CarRetrofit
import pe.cibertec.cl2.util.LoadingDialog

class ListCarsActivity : AppCompatActivity() {

    private var maxCarId=0
    private lateinit var loading:LoadingDialog
    private lateinit var btnAddCar:FloatingActionButton
    private lateinit var recyclerViewCar: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cars)

        loading = LoadingDialog(this)
        loading.startLoading()

        recyclerViewCar = findViewById(R.id.recyclerCar)
        btnAddCar = findViewById(R.id.btnAddCar)

        setUpComponent()
        loadData()

    }

    private fun setUpComponent(){
        //        recyclerViewCar.adapter=CarAdapter(CarProvider.carLis)
        recyclerViewCar.layoutManager = LinearLayoutManager(this)
        btnAddCar.setOnClickListener{
            val viajar = Intent(this@ListCarsActivity, AddCarActivity::class.java)
            viajar.putExtra("maxCarId", maxCarId)
            startActivity(viajar)
            //finish()  elimina y cierra o llama al onDestroy
        }
    }

    private fun  loadData(){
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = CarRetrofit.getRetrofit()
                .create(CarService::class.java)
                .getCars()

            val data = retrofit.body()

            runOnUiThread {
                if (retrofit.isSuccessful){
                    recyclerViewCar.adapter=CarAdapter(data!!) {
                        val carId = it.carId
                        val intent = Intent(this@ListCarsActivity,DetailsCarActivity::class.java).apply {
                            putExtra("carId",it.carId)
                        }
                        startActivity(intent)
                    }
                    maxCarId = data!!.maxOf { it.carId }
                    loading.finishLoading()

                }
            }
        }
    }

}