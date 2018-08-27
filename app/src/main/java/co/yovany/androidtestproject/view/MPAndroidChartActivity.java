package co.yovany.androidtestproject.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.view.fragment.BarChartFragment;
import co.yovany.androidtestproject.view.fragment.LineChartFragment;
import co.yovany.androidtestproject.view.fragment.PieChartFragment;

public class MPAndroidChartActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpandroid_chart);

        new ToolbarOptions(this,R.id.toolbar)
                .showToolbar(getResources().getString(R.string.mpandroidchart_activity_title), false);

        BottomNavigationView bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnNavigationItemSelectedListener(this);
        bottomBar.setSelectedItemId(R.id.itemChartBasic);
    }

    /*==============================================================================================
    * FUNCIONES*/

    /*----------------------------------------------------------------------------------------------
    * Lanza un Fragmento dentro de la actividad
    *
    * @param fragment : Fragmento para ser lanzado
    * @param resource : Recurso en donde se inflara el fragmento*/
    private void launchFragment(Fragment fragment,  int resource) {
        getSupportFragmentManager().beginTransaction()
                .replace(resource, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int resource = R.id.containerPrincipalGraphic;

        switch (item.getItemId()) {
            case R.id.itemChartBasic:
                launchFragment(new LineChartFragment(), resource);
                break;
            case R.id.itemChartBar:
                launchFragment(new BarChartFragment(), resource);
                break;
            case R.id.itemChartPie:
                launchFragment(new PieChartFragment(), resource);
                break;
        }
        return true;
    }
}
