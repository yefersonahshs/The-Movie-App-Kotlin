package com.example.movieappservinformacion.entitys

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MovieEntity.TABLE_NAME)
class MovieEntity {
    @JvmField
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    var id1: Long = 0

    @JvmField
    @ColumnInfo(name = "id")
    var id: String? = null

    @JvmField
    @ColumnInfo(name = "title")
    var title: String? = null

    @JvmField
    @ColumnInfo(name = "poster")
    var poster: String? = null

    @JvmField
    @ColumnInfo(name = "release")
    var release: String? = null

    @JvmField
    @ColumnInfo(name = "overview")
    var overview: String? = null

    @JvmField
    @ColumnInfo(name = "popularity")
    var popularity: String? = null

    @JvmField
    @ColumnInfo(name = "vote_average")
    var vote_average: String? = null

    companion object {
        /** The name of the Cheese table.  */
        const val TABLE_NAME = "Movie"
        const val COLUMN_NAME = "name"

        /** The name of the ID column.  */
        const val COLUMN_ID = BaseColumns._ID
    }
}