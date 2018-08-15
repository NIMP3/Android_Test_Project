package co.yovany.androidtestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.yovany.androidtestproject.adapter.ExampleAdapterRecyclerView;
import co.yovany.androidtestproject.model.Example;
import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.view.ComponentEditTextActivity;
import co.yovany.androidtestproject.view.MainActivity;
import co.yovany.androidtestproject.view.StudentListActivity;
import co.yovany.androidtestproject.view.TinderSwipeActivity;

public class ExamplesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_list);

        showToolbar(getResources().getString(R.string.title_examples_list),false);

        RecyclerView recyclerViewExampleList = findViewById(R.id.rvExamplesList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewExampleList.setLayoutManager(linearLayoutManager);

        ExampleAdapterRecyclerView exampleAdapterRecyclerView =
                new ExampleAdapterRecyclerView(buildExamplesList(), this, R.layout.cardview_example);

        recyclerViewExampleList.setAdapter(exampleAdapterRecyclerView);
    }

    /*----------------------------------------------------------------------------------------------
    Construir un listado de ejemplos
     */
    private ArrayList<Example> buildExamplesList() {
        ArrayList<Example> examples = new ArrayList<>();

        examples.add(new Example(1,"TextInputLayout","En este ejemplo se evaluaran las caracteristicas de TextInputLayout","https://i.imgur.com/1TqeLKl.png", ComponentEditTextActivity.class));
        examples.add(new Example(2,"ConstraintLayout","En este ejemplo se evaluaran las caracteristicas de ConstraintLayout","https://i.imgur.com/1TqeLKl.png", MainActivity.class));
        examples.add(new Example(3,"Tinder Swipe Example","En este ejemplo se evaluaran las caracteristicas del ejemplo Tinder Swipe Example","https://i.imgur.com/1TqeLKl.png", TinderSwipeActivity.class));
        examples.add(new Example(4,"Settings Activity Example","En este ejemplo se estudiaran los componentes de un SettingsActivity creado por Android","https://i.imgur.com/1TqeLKl.png", SettingsActivity.class));
        examples.add(new Example(5,"RecyclerView by Cardview","En este ejemplo se evaluara un recyclerview en el que el Scroll se hace por CardView","https://i.imgur.com/1TqeLKl.png", StudentListActivity.class));

        return examples;
    }

    /*----------------------------------------------------------------------------------------------
    Mostrar el toolbar con determinadas caracteristicas
     */
    public void showToolbar(String title, Boolean upButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


}
