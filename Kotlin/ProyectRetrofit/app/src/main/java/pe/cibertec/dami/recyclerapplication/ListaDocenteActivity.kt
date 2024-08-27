    package pe.cibertec.dami.recyclerapplication

    import android.content.Intent
    import android.os.Bundle
    import android.util.Log
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.google.android.material.floatingactionbutton.FloatingActionButton
    import com.google.firebase.database.DataSnapshot
    import com.google.firebase.database.DatabaseError
    import com.google.firebase.database.DatabaseReference
    import com.google.firebase.database.FirebaseDatabase
    import com.google.firebase.database.ValueEventListener
    import kotlinx.coroutines.CoroutineScope
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.launch
    import pe.cibertec.dami.recyclerapplication.adapter.DocenteAdapter
    import pe.cibertec.dami.recyclerapplication.model.Docente
    import pe.cibertec.dami.recyclerapplication.proxy.interfaces.DocenteService
    import pe.cibertec.dami.recyclerapplication.proxy.retrofit.DocenteRetrofit
    import pe.cibertec.dami.recyclerapplication.util.DatabaseHelper
    import pe.cibertec.dami.recyclerapplication.util.LoadingDialog

    class ListaDocenteActivity : AppCompatActivity() {

        private var maxDocenteId = 0
        private lateinit var loading: LoadingDialog
        private lateinit var btnAddDocente: FloatingActionButton
        private lateinit var recyclerViewDocente: RecyclerView

        private lateinit var databaseHelper: DatabaseHelper
        private lateinit var dbFirebase : DatabaseReference

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_lista_docente)

            loading = LoadingDialog(this)
            loading.startLoading()

            recyclerViewDocente = findViewById(R.id.recyclerDocentes)
            btnAddDocente = findViewById(R.id.btnAddDocente)
            // initUIComponents()
            setupUIComponents()
           // loadData()
            loadDataSQLite()
        }

        private fun initUIComponents() {
        }

        private fun setupUIComponents() {
            recyclerViewDocente.layoutManager = LinearLayoutManager(this)

            btnAddDocente.setOnClickListener {
                val intent = Intent(this, AddDocenteActivity::class.java)
                intent.putExtra("maxDocenteId", maxDocenteId)
                startActivity(intent)
            }
            databaseHelper = DatabaseHelper(this)
            dbFirebase = FirebaseDatabase.getInstance().getReference("Docentes")

        }
        private fun loadData() {

            //loadDataRetrofit()
            //loadDataSQLite()
        }



        private fun goToDocenteDetail(docente : Docente){
            val intent =
                Intent(
                    this@ListaDocenteActivity,
                    DetailDocenteActivity::class.java
                ).apply {
                    putExtra("docenteId", docente.docenteId)
                }
            startActivity(intent)
        }

        private fun loadDataSQLite(){
            maxDocenteId = databaseHelper.getAllDocentes()!!.maxOf { it.docenteId }
           recyclerViewDocente.adapter=DocenteAdapter(databaseHelper.getAllDocentes()){
                goToDocenteDetail(it)
           }
            loading.finishLoading()
        }



    }