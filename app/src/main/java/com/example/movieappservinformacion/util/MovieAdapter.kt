package com.example.movieappservinformacion.util

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappservinformacion.DetailActivity
import com.example.movieappservinformacion.R
import com.example.movieappservinformacion.models.Movie
import java.util.ArrayList


class MovieAdapter(
    private val mContext: Context, //  AppDatabase db;
    var listDatos: ArrayList<Movie>?
) : RecyclerView.Adapter<MovieAdapter.ViewHolderDatos>(), View.OnClickListener {
    private var listener: View.OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatos {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, null, false)
        view.setOnClickListener(this)
        return ViewHolderDatos(view)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolderDatos, position: Int) {
        val poster = "https://image.tmdb.org/t/p/w500"
        holder.title.setText(listDatos!![position])
        holder.release.setText(listDatos!![position])
        Glide.with(holder.itemView).load(poster + listDatos!![position])
            .into(holder.poster_path)
        holder.itemView.setOnClickListener {
            Log.d(ContentValues.TAG, "onClick: clicked on: " + listDatos!![position])
            Toast.makeText(mContext, listDatos!![position].getTitle(), Toast.LENGTH_SHORT).show()
            val intent = Intent(mContext, DetailActivity::class)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("image_url", poster + listDatos!![position].getPoster())
            intent.putExtra("title", listDatos!![position].getTitle())
            intent.putExtra("release", listDatos!![position].getRelease())
            intent.putExtra("Overview", listDatos!![position].getOverview())
            intent.putExtra("popularity", listDatos!![position].getPopularity())
            intent.putExtra("vote", listDatos!![position].getVote_average())
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return if (listDatos == null) 0 else listDatos!!.size
    }

    fun setOnClickListener(listener: View.OnClickListener?) {
        this.listener = listener
    }

    override fun onClick(v: View) {
        if (listener != null) {
            listener!!.onClick(v)
            println("quedo")
        }
    }

    class ViewHolderDatos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.movie_title)
        var release: TextView = itemView.findViewById(R.id.release)
        var poster_path: ImageView = itemView.findViewById(R.id.imageView)

    }
}