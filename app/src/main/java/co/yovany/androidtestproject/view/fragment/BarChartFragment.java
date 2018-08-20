package co.yovany.androidtestproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarChartFragment extends Fragment {


    public BarChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);

        BarChart barChart = view.findViewById(R.id.barChart);
        List<BarEntry> entries = buildEntries(1);
        BarDataSet dataSet = new BarDataSet(entries, getResources().getString(R.string.linechart_legend));

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.invalidate();

        return view;
    }

    /*==============================================================================================
     * FUNCIONES
     */

    /*----------------------------------------------------------------------------------------------
     * Contruye una Lista de entradas dependiendo del estudiante seleccionado
     *
     * @param student : Codigo del estudiante
     *
     * @return <code>List<Entry></code> : lista de entradas*/
    private List<BarEntry> buildEntries(int student) {
        Vector<String> values = Notes.buildGraphicValues(student);
        List<BarEntry> listEntries = new ArrayList<>();

        for (String value : values) {
            String[] elements = value.split("-");
            listEntries.add(new BarEntry(
                    Float.parseFloat(elements[1]),
                    Float.parseFloat(elements[0])));
        }

        return listEntries;
    }
}
