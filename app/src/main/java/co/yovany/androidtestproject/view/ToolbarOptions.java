package co.yovany.androidtestproject.view;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ToolbarOptions {

    private Activity activity;
    private int resource;

    public ToolbarOptions(Activity activity, int resource) {
        this.activity = activity;
        this.resource = resource;
    }

    public void showToolbar(String title, Boolean upButton) {
        Toolbar toolbar = activity.findViewById(resource);
        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        ((AppCompatActivity) activity).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
