package pe.cibertec.cl2.proxy.interfaces

import pe.cibertec.cl2.model.Car
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CarService {

    @GET("cars")
    suspend fun getCars() :Response<List<Car>>

    @GET("car/{carId}")
    suspend fun getCarById(@Path("carId") carId:Int) :Response<Car>

    @POST("car")
    suspend fun saveCar(@Body car:Car):Response<Car>

    @DELETE("car/{carId}")
    suspend fun deleteCar(@Path("carId") carId:Int):Response<Int>

    @PATCH("car")
    suspend fun updateCar(@Body car:Car):Response<Car>



}