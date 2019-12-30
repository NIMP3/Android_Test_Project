package co.yovany.androidtestproject.room_example.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.annotation.NonNull

@Entity (tableName = Contact.TABLE_NAME) data class Contact (
        @ColumnInfo(name = "phone_number") @NonNull val phoneNumber : String,
        @ColumnInfo(name = "first_name") @NonNull val firstName : String,
        @ColumnInfo(name = "last_name") val  lastName : String? = null
) {
    companion object {
        const val TABLE_NAME = "contact"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    var contactId : Int = 0

    override fun toString(): String {
        return """
            ------------------------
            Nombre: $firstName
            Apellido: $lastName
            Teléfono: $phoneNumber
        """.trimMargin()
    }
}