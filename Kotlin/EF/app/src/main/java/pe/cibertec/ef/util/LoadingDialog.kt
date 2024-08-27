package pe.cibertec.ef.util

import android.app.Activity
import android.app.AlertDialog
import pe.cibertec.ef.R

class LoadingDialog(private val myActivity:Activity) {
    private lateinit var dialog: AlertDialog
    fun startLoading(){
        val inflater = myActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.loading_layout, null)
        dialogView.alpha=0.99F

        val builder =AlertDialog.Builder(myActivity)
        builder.setView(dialogView)

        builder.setTitle("Cargando Datos")

        dialog=builder.create()

        dialog.show()


    }
    fun finishLoading(){
        dialog.dismiss()
    }



}