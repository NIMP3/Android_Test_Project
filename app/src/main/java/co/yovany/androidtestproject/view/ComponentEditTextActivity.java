package co.yovany.androidtestproject.view;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import co.yovany.androidtestproject.R;

public class ComponentEditTextActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_edit_text);

        final TextInputLayout tilError1 = findViewById(R.id.textInputLayout4);
        final TextInputLayout tilError2 = findViewById(R.id.textInputLayout5);

        EditText etError1 = findViewById(R.id.editText4);
        EditText etError2 = findViewById(R.id.editText5);

        etError1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > tilError1.getCounterMaxLength())
                    tilError1.setError("Ha excedido el maximo numero de caracteres");
                else
                    tilError1.setError(null);
            }
        });


        etError2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > tilError2.getCounterMaxLength())
                    tilError2.setError("Ha excedido el maximo numero de caracteres");
                else
                    tilError2.setError(null);
            }
        });
    }
}
