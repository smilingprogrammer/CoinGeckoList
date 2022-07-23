package com.example.coingeckolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coingeckolist.db.dao.ListDao
import com.example.coingeckolist.db.entity.ListEntity

@Database(entities = [ListEntity::class], version = 1)
abstract class ListDatabase: RoomDatabase() {

    abstract fun listDao(): ListDao

    companion object {
        @Volatile private var instance: ListDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, ListDatabase::class.java, "note.db").build()
    }
}