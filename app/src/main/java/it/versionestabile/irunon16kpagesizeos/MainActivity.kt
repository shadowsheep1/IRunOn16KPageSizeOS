package it.versionestabile.irunon16kpagesizeos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import it.versionestabile.irunon16kpagesizeos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pageSize = getPageSize()

        if (pageSize == 16384) {
            binding.statusTitleText.text = getString(R.string.is_16k_page_os)
            binding.statusIcon.setImageResource(R.drawable.ic_check_circle)
            binding.statusIcon.setColorFilter(ContextCompat.getColor(this, R.color.status_ok_green))
        } else {
            binding.statusTitleText.text = getString(R.string.not_16k_page_os, pageSize / 1024)
            binding.statusIcon.setImageResource(R.drawable.ic_info_circle)
            binding.statusIcon.setColorFilter(ContextCompat.getColor(this, R.color.status_info_blue))
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