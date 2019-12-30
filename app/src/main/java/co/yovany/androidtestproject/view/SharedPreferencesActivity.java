package co.yovany.androidtestproject.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.view.fragment.SharedPreferencesFragment;

public class SharedPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        getFragmentManager().beginTransaction()
                .replace(R.id.containerSharedPreferences, new SharedPreferencesFragment())
                .commit();
    }
}
