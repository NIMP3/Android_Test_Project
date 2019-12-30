package co.yovany.androidtestproject.room_example.view

import android.os.Build
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.yovany.androidtestproject.R
import co.yovany.androidtestproject.room_example.model.Contact
import co.yovany.androidtestproject.room_example.viewmodel.ContactsViewModel
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.content_form.*

class ContactActivity : AppCompatActivity() {

    private lateinit var contactsViewModel : ContactsViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        contactsViewModel = kotlin.run {
            ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        }

        fabAddContact.setOnClickListener {
            addContact()
        }
        addObserver()
    }

    private fun addObserver() {
        val observer = Observer<List<Contact>> {contacts ->
            if (contacts != null) {
                var text = ""
                for (contact in contacts)
                    text += contact.toString()
                tvContactList.text = text
            }
        }

        contactsViewModel.contacts.observe(this, observer)
    }

    private fun addContact() {
        val firstName = etFirstName.text.toString()
        val lastName =
                if (etLastName.text.toString() != "") etLastName.text.toString()
                else null
        val phone = etPhone.text.toString()

        if (firstName != "" && phone != "") contactsViewModel.saveContact(Contact(phone, firstName, lastName))
    }
}
