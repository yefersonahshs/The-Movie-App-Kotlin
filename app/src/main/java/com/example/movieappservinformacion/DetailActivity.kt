package com.example.movieappservinformacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(TAG, "onCreate: started.")
        incomingIntent
    }

    private val incomingIntent: Unit
        private get() {
            Log.d(TAG, "getIncomingIntent: checking for incoming intents.")
            if (intent.hasExtra("image_url") && intent.hasExtra("title")) {
                Log.d(TAG, "getIncomingIntent: found intent extras.")
                val imageUrl = intent.getStringExtra("image_url")
                val title = intent.getStringExtra("title")
                val release = intent.getStringExtra("release")
                val Overview = intent.getStringExtra("Overview")
                val popularity = intent.getStringExtra("popularity")
                val vote = intent.getStringExtra("vote")
                setImage(imageUrl, title, release, Overview, popularity, vote)
            }
        }

    private fun setImage(
        imageUrl: String?,
        title: String?,
        release: String?,
        Overview: String?,
        popularity: String?,
        vote: String?
    ) {
        Log.d(TAG, "setImage: setting te image and name to widgets.")
        val name = findViewById<TextView>(R.id.title_id)
        name.text = title
        val release_id = findViewById<TextView>(R.id.release_id)
        release_id.text = release
        val overview = findViewById<TextView>(R.id.description_id)
        overview.text = Overview
        val popularitytv = findViewById<TextView>(R.id.popularity_id)
        popularitytv.text = popularity
        val votetv = findViewById<TextView>(R.id.vote_id)
        votetv.text = vote
        val image = findViewById<ImageView>(R.id.imageView2)
        Glide.with(this)
            .asBitmap()
            .load(imageUrl)
            .into(image)
    }

    companion object {
        private const val TAG = "DetailActivity"
    }
}