package co.yovany.androidtestproject.view.fragment;


import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.github.mikephil.charting.formatter.PercentFormatter;

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

        //Determina el texto a visualizar cuando los datos no se han cargado
        pieChart.setNoDataText(getResources().getString(R.string.chart_message_nodata));
        pieChart.setNoDataTextColor(getResources().getColor(R.color.colorAccent));
        pieChart.setNoDataTextTypeface(Typeface.DEFAULT_BOLD);

        dataSet = new PieDataSet(entriesTask, "");

        dataSet.setColors(
                getResources().getColor(R.color.colorTestLine),
                getResources().getColor(R.color.colorWorkLine),
                getResources().getColor(R.color.colorExpoLine));

        dataSet.setValueTextColor(getResources().getColor(R.color.colorIcons));

        //Seteamos un formateador del sistema para porcentajes (%)
        dataSet.setValueFormatter(new PercentFormatter());

        data = new PieData(dataSet);
        pieChartTask.setData(data);
        pieChartTask.invalidate();

        //Determina el radio del agujero
        pieChart.setHoleRadius(5f);
        //Determina el radio del circulo con transparencia
        pieChart.setTransparentCircleRadius(70f);
        //Determina el color del circulo con transparencia
        pieChart.setTransparentCircleColor(getResources().getColor(R.color.colorTransparentPieChart));
        //Determina la transparencia [0-255] para el circulo interno
        pieChart.setTransparentCircleAlpha(100);

        //Habilita/Deshabilita del circulo interno
        pieChartTask.setDrawHoleEnabled(false);

        Description descriptionTask = new Description();
        descriptionTask.setText(getResources().getString(R.string.performance_legend));
        descriptionTask.setPosition(230f,10f);
        descriptionTask.setTextAlign(Paint.Align.RIGHT);
        descriptionTask.setTextColor(getResources().getColor(R.color.colorAccent));
        descriptionTask.setTextSize(12f);
        descriptionTask.setTypeface(Typeface.DEFAULT_BOLD);
        pieChartTask.setDescription(descriptionTask);

        //Determina el angulo paximo para dibujar el gráfico (360 = circulo completo)
        pieChartTask.setMaxAngle(360f);

        return view;
    }

}
