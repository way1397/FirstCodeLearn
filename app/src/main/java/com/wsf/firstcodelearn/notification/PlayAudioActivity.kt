package com.wsf.firstcodelearn.notification

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.wsf.firstcodelearn.R
import com.wsf.firstcodelearn.kotlinlearn.beginsWith
import kotlinx.android.synthetic.main.activity_play_audio.*

class PlayAudioActivity : AppCompatActivity() {

    private val mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_audio)
        initMediaPlayer()
        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        video_view.setVideoURI(uri)
        btn_play.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }
        btn_pause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }
        btn_stop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.reset()
                initMediaPlayer()
            }
        }

        btn_video_play.setOnClickListener {
            if (!video_view.isPlaying) {
                video_view.start()
            }
        }

        btn_video_pause.setOnClickListener {
            if (video_view.isPlaying) {
                video_view.pause()
            }
        }

        btn_video_replay.setOnClickListener {
            if (video_view.isPlaying) {
                video_view.resume()
            }
        }
    }

    private fun initMediaPlayer() {
        val assetManager = assets
        val fd = assetManager.openFd("music.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
        video_view.suspend()
    }
}