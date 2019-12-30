package co.yovany.androidtestproject.room_example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import co.yovany.androidtestproject.room_example.model.Contact
import co.yovany.androidtestproject.room_example.repository.ContactsRepository

class ContactsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ContactsRepository(application)
    val contacts = repository.getContacts()

    fun saveContact(contact: Contact) {
        repository.insert(contact)
    }
}