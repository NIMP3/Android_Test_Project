package co.yovany.androidtestproject.room_example.repository

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import co.yovany.androidtestproject.room_example.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao

    companion object {
        private const val DATABASE_NAME = "socore_database"

        @Volatile
        private var INSTANCE : ContactsDatabase? = null

        fun getInstance(context: Context) : ContactsDatabase? {
            INSTANCE
                    ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactsDatabase::class.java,
                        DATABASE_NAME
                ).build()
            }

            return INSTANCE
        }
    }
}