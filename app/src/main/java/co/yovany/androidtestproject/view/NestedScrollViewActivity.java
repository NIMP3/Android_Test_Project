package co.yovany.androidtestproject.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.view.fragment.BarChartFragment;
import co.yovany.androidtestproject.view.fragment.ChildListFragment;

public class NestedScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_view);
        new ToolbarOptions(this,R.id.toolbar)
                .showToolbar(getResources().getString(R.string.child_performance_title),false);

        launchFragment(new BarChartFragment(), R.id.containerGraphic);
        launchFragment(new ChildListFragment(), R.id.containerChildList);
    }


    /*==============================================================================================
    * FUNCIONES*/

    /*----------------------------------------------------------------------------------------------
    * Lanza un fragmento determinado en la actividad actual
    * @param resource : recurso [framelayout] en el que se inflara el fragmento
    * @param fragment : fragmento que se va a lanzar*/
    private void launchFragment(Fragment fragment, int resource) {
        getSupportFragmentManager().beginTransaction()
                .replace(resource, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
