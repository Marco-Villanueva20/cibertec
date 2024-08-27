package pe.cibertec.dami.recyclerapplication.proxy.interfaces

import pe.cibertec.dami.recyclerapplication.model.Docente
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DocenteService {

    @GET("docentes")
    // http://10.0.2.2:8080/docente/v1/docentes
    suspend fun getDocentes(): Response<List<Docente>>

    @GET("docente/{docenteId}")
    // http://10.0.2.2:8080/docente/v1/docente/1
    suspend fun getDocente(@Path("docenteId") docenteId: Int): Response<Docente>

    @POST("docente")
    // http://10.0.2.2:8080/docente/v1/docente
    suspend fun saveDocente(@Body docente: Docente): Response<Docente>

    @DELETE("docente/{docenteId}")
    // http://10.0.2.2:8080/docente/v1/docente/1
    suspend fun deleteDocente(@Path("docenteId") docenteId: Int): Response<Int>


    @PATCH("docente")
    // http://10.0.2.2:8080/docente/v1/docente
    suspend fun updateDocente(@Body docente: Docente): Response<Docente>


}