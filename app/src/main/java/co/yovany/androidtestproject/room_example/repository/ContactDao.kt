package co.yovany.androidtestproject.room_example.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import co.yovany.androidtestproject.room_example.model.Contact

@Dao
interface ContactDao {
    @Insert
    fun insert(contact: Contact)

    @Update
    fun update(vararg  contact: Contact)

    @Delete
    fun delete(vararg contact: Contact)

    @Query("SELECT * FROM ${Contact.TABLE_NAME} ORDER BY last_name, first_name")
    fun getOrderedSchedule() : LiveData<List<Contact>>
}