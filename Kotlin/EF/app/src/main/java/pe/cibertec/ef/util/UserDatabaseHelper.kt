package pe.cibertec.ef.util

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import pe.cibertec.ef.model.Usuario

class UsuarioDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "usuarios.db"
        private const val DATABASE_VERSION = 3
        private const val TABLE_USUARIO = "tb_usuario"
        private const val USUARIO_ID = "id"
        private const val USUARIO_USER = "user"
        private const val USUARIO_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableUsuario =
            ("CREATE TABLE $TABLE_USUARIO " +
                    "(  $USUARIO_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " $USUARIO_USER TEXT," +
                    " $USUARIO_PASSWORD TEXT" +
                    ")")
        db?.execSQL(createTableUsuario)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USUARIO")
        onCreate(db)
    }



    fun insertUsuario(usuario: Usuario): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(USUARIO_USER, usuario.user)
        contentValues.put(USUARIO_PASSWORD, usuario.password)
        val success = db.insert(TABLE_USUARIO,
            null,
            contentValues)
        db.close()
        return success
    }



    fun getUsuarioByUserAndPassword(user: String, password: String): Usuario? {
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_USUARIO WHERE $USUARIO_USER = ? AND $USUARIO_PASSWORD = ?"
        db.rawQuery(selectQuery, arrayOf(user, password)).use {
            if (it.moveToFirst()) {
                return Usuario(
                    id = it.getInt(0),
                    user = it.getString(1), // Columna del usuario
                    password = it.getString(2) // Columna de la contraseña
                )
            }
        }
        return null
    }


}
