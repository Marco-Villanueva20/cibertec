package pe.cibertec.proyecto.util

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import pe.cibertec.proyecto.model.Producto

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "proyecto.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_PRODUCTO = "tb_producto"
        private const val PRODUCTO_ID = "id"
        private const val PRODUCTO_NOMBRE = "nombre"
        private const val PRODUCTO_DESCRIPCION = "descripcion"
        private const val PRODUCTO_PRECIO = "precio"
        private const val PRODUCTO_CANTIDAD = "cantidad"
        private const val PRODUCTO_MARCA = "marca"
        private const val PRODUCTO_TIPOANIMAL = "tipoAnimal"
        private const val PRODUCTO_IMG = "img"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableProduct =
            ("CREATE TABLE $TABLE_PRODUCTO " +
                    "(  $PRODUCTO_ID TEXT PRIMARY KEY,"
                    + " $PRODUCTO_NOMBRE TEXT," +
                    " $PRODUCTO_DESCRIPCION TEXT," +
                    " $PRODUCTO_PRECIO REAL,  " +
                    " $PRODUCTO_CANTIDAD INTEGER,  " +
                    "$PRODUCTO_MARCA TEXT," +
                    "$PRODUCTO_TIPOANIMAL TEXT," +
                    "$PRODUCTO_IMG TEXT" +
                    ")")
        db?.execSQL(createTableProduct)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCTO")
        onCreate(db)
    }

    fun insertProducto(producto: Producto): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(PRODUCTO_ID, producto.id)
        contentValues.put(PRODUCTO_NOMBRE, producto.nombre)
        contentValues.put(PRODUCTO_DESCRIPCION, producto.descripcion)
        contentValues.put(PRODUCTO_PRECIO, producto.precio)
        contentValues.put(PRODUCTO_CANTIDAD, producto.cantidad)
        contentValues.put(PRODUCTO_MARCA, producto.marca)
        contentValues.put(PRODUCTO_TIPOANIMAL, producto.tipoAnimal)
        contentValues.put(PRODUCTO_IMG, producto.img)
        val success = db.insert(TABLE_PRODUCTO,
            null,
            contentValues)
        db.close()
        return success
    }

    fun getProducto(productoId: String): Producto? {
        val db = this.writableDatabase
        val selectQuery = "SELECT  * FROM $TABLE_PRODUCTO WHERE $PRODUCTO_ID = ?"
        db.rawQuery(selectQuery, arrayOf(productoId)).use { // .use requires API 16
            if (it.moveToFirst()) {
                return Producto(
                    id = it.getString(0),
                    nombre = it.getString(1),
                    descripcion = it.getString(2),
                    precio = it.getDouble(3),
                    cantidad = it.getInt(4),
                    marca = it.getString(5),
                    tipoAnimal = it.getString(6),
                    img = it.getString(7)
                )
            }
        }
        return null
    }

    @SuppressLint("Range")
    fun getAllProductos(): ArrayList<Producto> {
        val productoList: ArrayList<Producto> = ArrayList()
        val query = "SELECT * FROM $TABLE_PRODUCTO"
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
                val id = cursor.getString(cursor.getColumnIndex(PRODUCTO_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(PRODUCTO_NOMBRE))
                val descripcion = cursor.getString(cursor.getColumnIndex(PRODUCTO_DESCRIPCION))
                val precio = cursor.getDouble(cursor.getColumnIndex(PRODUCTO_PRECIO))
                val cantidad = cursor.getInt(cursor.getColumnIndex(PRODUCTO_CANTIDAD))
                val marca = cursor.getString(cursor.getColumnIndex(PRODUCTO_MARCA))
                val tipoAnimal = cursor.getString(cursor.getColumnIndex(PRODUCTO_TIPOANIMAL))
                val img = cursor.getString(cursor.getColumnIndex(PRODUCTO_IMG))

                val producto = Producto(
                    id = id,
                    nombre = nombre,
                    descripcion = descripcion,
                    precio = precio,
                    cantidad = cantidad,
                    marca = marca,
                    tipoAnimal = tipoAnimal,
                    img = img
                )

                productoList.add(producto)

            } while (cursor.moveToNext())
        }
        cursor.close()
        return productoList
    }
}
