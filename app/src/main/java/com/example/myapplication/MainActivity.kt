//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var txtTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTime = findViewById(R.id.txtTime)

        // Run a runnable to update the time every second
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                updateTime()
                handler.postDelayed(this, 1000) // 1000 milliseconds = 1 second
            }
        })
    }

    private fun updateTime() {
        try {
            // Get the current time
            val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())
            val currentTime = sdf.format(Date())

            // Update the TextView with the current time
            txtTime.text = currentTime
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
