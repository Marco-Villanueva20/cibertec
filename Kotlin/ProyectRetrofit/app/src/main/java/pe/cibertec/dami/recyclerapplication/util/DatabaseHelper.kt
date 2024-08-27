package pe.cibertec.dami.recyclerapplication.util

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import pe.cibertec.dami.recyclerapplication.model.Docente

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "cibertec.db"
        private const val DATABASE_VERSION = 3
        private const val TABLE_DOCENTE = "tb_docente"
        private const val DOCENTE_ID = "id"
        private const val DOCENTE_NOMBRE = "nombre"
        private const val DOCENTE_APELLIDO = "apellido"
        private const val DOCENTE_TIPO = "tipo_docente"
        private const val DOCENTE_FOTO = "foto"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableProduct =
            ("CREATE TABLE $TABLE_DOCENTE " +
                    "(  $DOCENTE_ID INTEGER PRIMARY KEY,"
                    +" $DOCENTE_NOMBRE TEXT," +
                    " $DOCENTE_APELLIDO TEXT," +
                    " $DOCENTE_TIPO INTEGER,  " +
                    "$DOCENTE_FOTO TEXT" +
                    ")")
        db?.execSQL(createTableProduct)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_DOCENTE")
        onCreate(db)
    }

    fun insertDocente(docente: Docente): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DOCENTE_ID, docente.docenteId)
        contentValues.put(DOCENTE_NOMBRE, docente.nombre)
        contentValues.put(DOCENTE_APELLIDO, docente.apellido)
        contentValues.put(DOCENTE_TIPO, docente.tipoDocente)
        contentValues.put(DOCENTE_FOTO, docente.foto)
        val success = db.insert(TABLE_DOCENTE,
            null,
            contentValues)
        db.close()
        return success
    }
    fun updateDocente(docente: Docente): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(DOCENTE_NOMBRE, docente.nombre)
        contentValues.put(DOCENTE_APELLIDO, docente.apellido)
        contentValues.put(DOCENTE_TIPO, docente.tipoDocente)
        contentValues.put(DOCENTE_FOTO, docente.foto)
        val success = db.update(
            TABLE_DOCENTE,
            contentValues,
            "$DOCENTE_ID = ?",
            arrayOf(docente.docenteId.toString())
        )
        db.close()
        return success
    }

    fun deleteDocente(docenteId: Int): Int {
        val db = this.writableDatabase
        val success = db.delete(TABLE_DOCENTE, "$DOCENTE_ID = ?", arrayOf(docenteId.toString()))
        db.close()
        return success
    }

    fun getDocente(docenteId: Int): Docente? {
        val db = this.writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_DOCENTE WHERE $DOCENTE_ID = ?"
        db.rawQuery(selectQuery, arrayOf(docenteId.toString())).use { // .use requires API 16
            if (it.moveToFirst()) {
                return Docente(
                    docenteId = it.getInt(0),
                    nombre = it.getString(1),
                    apellido = it.getString(2),
                    tipoDocente = it.getInt(3),
                    foto = it.getString(4),
                )
            }
        }
        return null
    }

    @SuppressLint("Range")
    fun getAllDocentes(): ArrayList<Docente> {
        val docenteList: ArrayList<Docente> = ArrayList()
        val query = "SELECT * FROM $TABLE_DOCENTE"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(query)
            return ArrayList()
        }
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(DOCENTE_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(DOCENTE_NOMBRE))
                val apellido = cursor.getString(cursor.getColumnIndex(DOCENTE_APELLIDO))
                val tipoDocnete = cursor.getInt(cursor.getColumnIndex(DOCENTE_TIPO))
                val foto = cursor.getString(cursor.getColumnIndex(DOCENTE_FOTO))

                val docente = Docente(
                    docenteId = id,
                    nombre = nombre,
                    apellido = apellido,
                    tipoDocente = tipoDocnete,
                    foto = foto
                )

                docenteList.add(docente)

            } while (cursor.moveToNext())
        }
        return docenteList
    }
}