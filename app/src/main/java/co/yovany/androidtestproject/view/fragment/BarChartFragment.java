package co.yovany.androidtestproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;
import co.yovany.androidtestproject.model.Students;
import co.yovany.androidtestproject.utilities.ChartUtility;

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
        BarChart barChartGroup = view.findViewById(R.id.barChartGroup);

        //Contruye las entradas para los gráficos
        //Primer Gráfico
        List<BarEntry> entries = ChartUtility.buildStudentBarEntries(1,"DATE");
        //Segundo Gráfico
        List<BarEntry> entriesTest = ChartUtility.buildStudentBarEntries(1,"EXAMEN");
        List<BarEntry> entriesWork = ChartUtility.buildStudentBarEntries(1,"TRABAJO");
        List<BarEntry> entriesExpo = ChartUtility.buildStudentBarEntries(1,"EXPOSICIÓN");

        //Seteamos las entradas a los datos del gráfico
        //Primer Gráfico
        BarDataSet dataSet = new BarDataSet(entries, Students.getNameStudent(1));
        //Segundo Gráfico
        BarDataSet dataSetTest = new BarDataSet(entriesTest, getResources().getString(R.string.test_legend));
        BarDataSet dataSetWork = new BarDataSet(entriesWork, getResources().getString(R.string.work_legend));
        BarDataSet dataSetExpo = new BarDataSet(entriesExpo, getResources().getString(R.string.exposition_legend));

        dataSetTest.setColor(getResources().getColor(R.color.colorTestLine));
        dataSetWork.setColor(getResources().getColor(R.color.colorWorkLine));
        dataSetExpo.setColor(getResources().getColor(R.color.colorExpoLine));

        //Enviamos los datos a los respectivos Gráficos
        //Primer Gráfico
        BarData barData = new BarData(dataSet);
        //Determina el ancho de las barras
        barData.setBarWidth(0.9f);
        barChart.setData(barData);
        barChart.setFitBars(true);
        barChart.invalidate();
        //Segundo Gráfico
        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetTest);
        dataSets.add(dataSetWork);
        dataSets.add(dataSetExpo);
        BarData barDataGroup = new BarData(dataSets);
        barDataGroup.setBarWidth(0.9f);
        barChartGroup.setData(barDataGroup);
        barChart.setFitBars(true);
        barChartGroup.invalidate();


        //Establecemos las propiedades por default para los Ejes(X,Y) de los Gráficos
        //Primer Gráfico
        XAxis xAxis = barChart.getXAxis();
        YAxis yAxisLeft = barChart.getAxisLeft();
        YAxis yAxisRight = barChart.getAxisRight();
        ChartUtility.buildAxesProperties(xAxis,yAxisLeft,yAxisRight);
        //Segundo Gráfico
        XAxis xAxis2 = barChartGroup.getXAxis();
        YAxis yAxis2Left = barChartGroup.getAxisLeft();
        YAxis yAxis2Right = barChartGroup.getAxisRight();
        ChartUtility.buildAxesProperties(xAxis2,yAxis2Left,yAxis2Right);

        return view;
    }

    /*==============================================================================================
     * FUNCIONES
     */
}
