package co.yovany.androidtestproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;
import co.yovany.androidtestproject.utilities.ChartUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartFragment extends Fragment {


    public PieChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);

        PieChart pieChart = view.findViewById(R.id.pieChart);
        PieChart pieChartTask = view.findViewById(R.id.pieChartTask);

        List<PieEntry> entries = ChartUtility.buildStudentPieEntries("PERFORMANCE");
        List<PieEntry> entriesTask = ChartUtility.buildStudentPieEntries("TASK");

        PieDataSet dataSet = new PieDataSet(entries,getResources().getString(R.string.performance_legend));
        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();

        dataSet = new PieDataSet(entriesTask, getResources().getString(R.string.performance_legend));

        dataSet.setColors(
                getResources().getColor(R.color.colorTestLine),
                getResources().getColor(R.color.colorWorkLine),
                getResources().getColor(R.color.colorExpoLine));

        data = new PieData(dataSet);
        pieChartTask.setData(data);
        pieChartTask.invalidate();

        //Determina el radio del circulo interno
        pieChart.setHoleRadius(5f);
        pieChart.setTransparentCircleColor(getResources().getColor(R.color.colorWorkLine));

        //Habilita/Deshabilita del circulo interno
        pieChartTask.setDrawHoleEnabled(false);

        return view;
    }

}
