package com.example.practical6___1110

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.practical6.R
import com.example.practical6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        videoPlayer()
        binding.btnSwitch.setOnClickListener{
            Intent(this, YoutubeActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    private fun videoPlayer(){
        val mediaController = MediaController(this)
        val uri:Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.thestoryoflight)
        binding.myVideoView.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myVideoView)
        binding.myVideoView.setVideoURI(uri)
        binding.myVideoView.requestFocus()
        binding.myVideoView.start()
    }
}