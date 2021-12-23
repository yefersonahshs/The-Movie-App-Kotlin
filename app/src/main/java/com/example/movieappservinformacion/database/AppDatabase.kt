package com.example.movieappservinformacion.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieappservinformacion.Config.constants
import com.example.movieappservinformacion.entitys.MovieEntity
import com.example.movieappservinformacion.interfaces.MovieDao

@Database(entities = [MovieEntity::class], version = 0)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao? //que permisos va tener listar, eliminar, update, insertar

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? { //instancia para bd
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    constants.BD_NAME
                )
                    .allowMainThreadQueries() //.fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE //no usar mas instancias de las que se necesita
        }

        fun destroyInstance() { //si la appa ya no usara la bd se destruye instancia
            INSTANCE = null
        }

        private val sInstance //variable.
                : AppDatabase? = null
    }
}