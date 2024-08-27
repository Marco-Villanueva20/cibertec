package pe.cibertec.dami.recyclerapplication

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AcelerometroActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var acelerometerInfo :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acelerometro)

        acelerometerInfo = findViewById(R.id.lblAcelerometer)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )

        }


    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            val sides = event.values[0]
            val upDown = event.values[1]
            acelerometerInfo.apply {
                rotationX=upDown * 3f
                rotationY=sides * 3f
                rotation=-sides
                translationX =sides * -10
                translationX=upDown * 10
            }
            val color = if(upDown.toInt()==0&&sides.toInt()==0) Color.GREEN else Color.RED

            val mensaje:String =" Orientación Vertical: ${upDown}\n" +
                    "Orientación Horizontal: $sides"

            acelerometerInfo.text=mensaje
            acelerometerInfo.setBackgroundColor(color)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }
}