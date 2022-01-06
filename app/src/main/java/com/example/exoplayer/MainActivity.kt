package com.example.exoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.exoplayer.ViewModels.ViewModelsClass
import com.example.exoplayer.databinding.ActivityMainBinding
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.ui.PlayerView

import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

class MainActivity : AppCompatActivity() {
    lateinit var exoplayer: ExoPlayer
    lateinit var exoplayer2: ExoPlayer
    lateinit var binding: ActivityMainBinding
    lateinit var viewmodel:ViewModelsClass
    var btnpress:Boolean=false
    var btnpress2:Boolean=false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel=ViewModelProvider(this).get(ViewModelsClass::class.java)


        val url =
            Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4")


        val url2 =
            Uri.parse("https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4")

        exoplayer = SimpleExoPlayer.Builder(this).build()
        exoplayer2 = SimpleExoPlayer.Builder(this).build()

        binding.exoview1.player = exoplayer
        binding.exoview2.player = exoplayer2

        val media = MediaItem.fromUri(url)
        var media2=MediaItem.fromUri(url2)

        exoplayer.setMediaItem(media)
        exoplayer2.setMediaItem(media2)

        exoplayer.prepare()
        exoplayer2.prepare()

        val btnplay=findViewById<ImageView>(R.id.btnplay)
        val btnplay2=findViewById<ImageView>(R.id.btnplay2)



        btnplay.setOnClickListener {
            if(exoplayer2.isPlaying)
            {
                exoplayer2.pause()
                btnplay2.setImageResource(R.drawable.playbtnimg)
            }
                if (exoplayer.isPlaying)
                {
                    exoplayer.pause()
                    btnplay.setImageResource(R.drawable.playbtnimg)
                }else
                {
                    exoplayer.play()
                    btnplay.setImageResource(R.drawable.pausebtnimg)
                    btnplay2.setImageResource(R.drawable.playbtnimg)
                }

        }

        btnplay2.setOnClickListener {
            if(exoplayer.isPlaying)
            { btnpress=false
                exoplayer.pause()
                btnplay.setImageResource(R.drawable.playbtnimg)
            }


            if (exoplayer2.isPlaying)
            {
                exoplayer2.pause()
                btnplay2.setImageResource(R.drawable.playbtnimg)
            }
            else
            {
                exoplayer2.play()
                btnplay2.setImageResource(R.drawable.pausebtnimg)
                btnplay.setImageResource(R.drawable.playbtnimg)
            }


        }

    }




}