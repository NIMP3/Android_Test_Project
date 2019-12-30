package co.yovany.androidtestproject.model;

import com.skydoves.preferenceroom.KeyName;
import com.skydoves.preferenceroom.PreferenceEntity;
import com.skydoves.preferenceroom.PreferenceFunction;
import com.skydoves.preferenceroom.TypeConverter;

@PreferenceEntity("UserProfile")
public class SettingsProfile {
    @KeyName("events") protected final boolean currentEvents = false;
    @KeyName("quotes") protected final boolean quotes = false;

   @PreferenceFunction("events")
    public boolean putEventFunction(boolean flag){
       return flag;
   }
}
