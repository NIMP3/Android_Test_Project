package co.yovany.androidtestproject.view.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.realm.implementation.RealmRadarDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Developer;
import co.yovany.androidtestproject.model.Skill;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherChartFragment extends Fragment {


    public OtherChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_other_chart, container, false);

        RadarChart radarChart = view.findViewById(R.id.radarChart);

        Realm.init(view.getContext());
        Realm realm = Realm.getDefaultInstance();

        //Obtenemos y comprobamos el total de desarrolladores
        long total = realm.where(Developer.class).count();
        if (total == 0) {
            //Asignamos un Desarrollador por default
            realm.beginTransaction();
            Developer developer = new Developer(1,"Edwin Yovany");
            realm.copyToRealm(developer);
            realm.commitTransaction();

            //Asignamos los skills del desarrollador
            realm.beginTransaction();
            ArrayList<Skill> skills = new ArrayList<>();
            skills.add(new Skill(1,"JAVA",4.0f,0));
            skills.add(new Skill(1,"KOTLIN",2.5f,1));
            skills.add(new Skill(1,"PHP",3.0f,2));
            skills.add(new Skill(1,"POSTGRESQL",3.0f,3));
            skills.add(new Skill(1,"MYSQL",2.0f,4));
            skills.add(new Skill(1,"JAVASCRIPT",3.5f,5));

            for (Skill skill : skills) realm.copyToRealm(skill);
            realm.commitTransaction();
        }

        //Realizamos una consulta para obtener los skills
        final RealmResults<Skill> results = realm.where(Skill.class).findAll();

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return results.get((int) value).getName();
            }
        };

        RealmRadarDataSet<Skill> dataSet = new RealmRadarDataSet<>(results,"score");
        dataSet.setColor(getResources().getColor(R.color.colorAccent));
        dataSet.setLabel(getResources().getString(R.string.skill_legend));
        RadarData data = new RadarData(dataSet);
        radarChart.setData(data);
        radarChart.invalidate();

        YAxis yAxis = radarChart.getYAxis();
        yAxis.setGranularity(1);
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(5);

        XAxis xAxis = radarChart.getXAxis();

        return view;
    }

}
