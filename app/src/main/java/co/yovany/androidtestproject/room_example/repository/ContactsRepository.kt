package co.yovany.androidtestproject.room_example.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.os.AsyncTask
import co.yovany.androidtestproject.room_example.model.Contact

class ContactsRepository(application : Application) {
    private val contactDao : ContactDao? = ContactsDatabase.getInstance(application)?.contactDao()

    fun insert(contact: Contact) {
        if (contactDao != null) InserAsyncTask(contactDao).execute(contact)
    }

    fun getContacts() : LiveData<List<Contact>> {
        return contactDao?.getOrderedSchedule() ?: MutableLiveData<List<Contact>>()
    }

    private class InserAsyncTask(private val contactDao: ContactDao) :
            AsyncTask<Contact, Void, Void>() {
        override fun doInBackground(vararg contacts : Contact?) : Void? {
            for (contact in contacts) {
                if (contact != null) contactDao.insert(contact)
            }

            return null
        }
    }
}