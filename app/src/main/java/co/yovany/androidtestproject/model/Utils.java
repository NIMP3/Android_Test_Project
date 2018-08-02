package co.yovany.androidtestproject.model;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final String TAG = "Utils";

    public static List<Profile> loadProfiles(Context context) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

            JSONArray array = new JSONArray(loadJSONFromArray(context, "profiles.json"));
            List<Profile> profiles = new ArrayList<>();

            for (int i=0; i<array.length(); i++) {
                Profile profile = gson.fromJson(array.getString(i),Profile.class);
                profiles.add(profile);
            }

            return profiles;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String loadJSONFromArray(Context context, String jsonFileName) {
        String json = null;
        InputStream inputStream = null;

        try {
            AssetManager manager = context.getAssets();
            inputStream = manager.open(jsonFileName);

            int size = inputStream.available();
            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}
