package it.versionestabile.irunon16kpagesizeos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import it.versionestabile.irunon16kpagesizeos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pageSize = getPageSize()

        binding.sampleText.text =
            buildString {
                append("Page size: ")
                append(pageSize)
                append(" bytes\n")
                append(if (pageSize == 16384) "16 KB pages detected" else "NOT 16 KB pages")
            }
    }

    /**
     * A native method that is implemented by the 'irunon16kpagesizeos' native library,
     * which is packaged with this application.
     */
    external fun getPageSize(): Int

    companion object {
        // Used to load the 'irunon16kpagesizeos' library on application startup.
        init {
            System.loadLibrary("irunon16kpagesizeos")
        }
    }
}