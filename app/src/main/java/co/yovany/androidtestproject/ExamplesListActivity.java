package co.yovany.androidtestproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;

import co.yovany.androidtestproject.adapter.ExampleAdapterRecyclerView;
import co.yovany.androidtestproject.model.Example;
import co.yovany.androidtestproject.room_example.view.ContactActivity;
import co.yovany.androidtestproject.view.ComponentEditTextActivity;
import co.yovany.androidtestproject.view.ComponentIntentActivity;
import co.yovany.androidtestproject.view.LottieActivity;
import co.yovany.androidtestproject.view.MPAndroidChartActivity;
import co.yovany.androidtestproject.view.MainActivity;
import co.yovany.androidtestproject.view.NestedScrollViewActivity;
import co.yovany.androidtestproject.view.SharedPreferencesActivity;
import co.yovany.androidtestproject.view.StudentListActivity;
import co.yovany.androidtestproject.view.TinderSwipeActivity;
import co.yovany.androidtestproject.view.ToolbarOptions;

/*
 * @author Edwin Yovany Orbes Villacorte
 *
 * Manejo de un RecyclerView con una lista de ejemplos para controlar la creación de nuevas Pruebas
 * de componentes*/

public class ExamplesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_list);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("TOKEN", "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        Log.d("TOKEN", token);
                    }
                });

        new ToolbarOptions(this,R.id.toolbar).showToolbar(
                getResources().getString(R.string.title_examples_list),
                false);

        RecyclerView recyclerViewExampleList = findViewById(R.id.rvExamplesList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewExampleList.setLayoutManager(linearLayoutManager);

        ExampleAdapterRecyclerView exampleAdapterRecyclerView =
                new ExampleAdapterRecyclerView(buildExamplesList(), this, R.layout.cardview_example);

        recyclerViewExampleList.setAdapter(exampleAdapterRecyclerView);
    }

    /*==============================================================================================
    FUNCIONES
     */

    /*----------------------------------------------------------------------------------------------
    *Construye una lista con base en los ejemplos creados
    *
    *@return <code>ArrayList<Example></code> listado de ejemplos
     */
    private ArrayList<Example> buildExamplesList() {
        ArrayList<Example> examples = new ArrayList<>();

        examples.add(new Example(1,"TextInputLayout","En este ejemplo se evaluaran las caracteristicas de TextInputLayout","https://i.imgur.com/1TqeLKl.png", ComponentEditTextActivity.class));
        examples.add(new Example(2,"ConstraintLayout","En este ejemplo se evaluaran las caracteristicas de ConstraintLayout","https://i.imgur.com/1TqeLKl.png", MainActivity.class));
        examples.add(new Example(3,"Tinder Swipe Example","En este ejemplo se evaluaran las caracteristicas del ejemplo Tinder Swipe Example","https://i.imgur.com/1TqeLKl.png", TinderSwipeActivity.class));
        examples.add(new Example(4,"Settings Activity Example","En este ejemplo se estudiaran los componentes de un SettingsActivity creado por Android","https://i.imgur.com/1TqeLKl.png", SettingsActivity.class));
        examples.add(new Example(5,"RecyclerView by Cardview","En este ejemplo se evaluara un recyclerview en el que el Scroll se hace por CardView","https://i.imgur.com/1TqeLKl.png", StudentListActivity.class));
        examples.add(new Example(6,"MPAndroidChart Example","En este ejemplo se evaluaran las caracteristicas de MPAndroidChart para el manejo de gráficos","https://i.imgur.com/1TqeLKl.png", MPAndroidChartActivity.class));
        examples.add(new Example(7,"NestedScrollView Example","En este ejemplo se evaluaran las caracteristicas de NestedScrollView","https://i.imgur.com/1TqeLKl.png", NestedScrollViewActivity.class));
        examples.add(new Example(8,"Intent Example","En este ejemplo se evaluaran las caracteristicas de Intent","https://i.imgur.com/1TqeLKl.png", ComponentIntentActivity.class));
        examples.add(new Example(9,"Shared Preferences Example","En este ejemplo se evaluaran las caracteristicas de Shared Preferences","https://i.imgur.com/1TqeLKl.png", SharedPreferencesActivity.class));
        examples.add(new Example(10,"Lottie Example","En este ejemplo se evaluaran las caracteristicas de Lottie","https://i.imgur.com/1TqeLKl.png", LottieActivity.class));
        examples.add(new Example(11,"Room Example","En este ejemplo se evaluaran las caracteristicas de la Libreria Room","https://i.imgur.com/1TqeLKl.png", ContactActivity.class));

        return examples;
    }
}
