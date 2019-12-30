package co.yovany.androidtestproject.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.skydoves.preferenceroom.InjectPreference;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.ISettingsProfileComponent;
import co.yovany.androidtestproject.model.SettingsProfile;

public class SettingsProfileActivity extends AppCompatActivity {

    @InjectPreference
    public ISettingsProfileComponent component;

    @InjectPreference
    public SettingsProfile settingsProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_profile);


    }
}
