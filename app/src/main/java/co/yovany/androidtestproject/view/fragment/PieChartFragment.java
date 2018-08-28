package co.yovany.androidtestproject.view.fragment;


import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;
import co.yovany.androidtestproject.utilities.ChartUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartFragment extends Fragment {

    PieChart pieChart, pieChartTask;

    public PieChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);

        pieChart = view.findViewById(R.id.pieChart);
        pieChartTask = view.findViewById(R.id.pieChartTask);

        List<PieEntry> entries = ChartUtility.buildStudentPieEntries("PERFORMANCE");
        List<PieEntry> entriesTask = ChartUtility.buildStudentPieEntries("TASK");

        PieDataSet dataSet = new PieDataSet(entries,getResources().getString(R.string.performance_legend));
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();

        //Determina el texto a visualizar cuando los datos no se han cargado
        pieChart.setNoDataText(getResources().getString(R.string.chart_message_nodata));
        pieChart.setNoDataTextColor(getResources().getColor(R.color.colorAccent));
        pieChart.setNoDataTextTypeface(Typeface.DEFAULT_BOLD);

        PieDataSet dataSetTask = new PieDataSet(entriesTask, "");

        dataSetTask.setColors(
                getResources().getColor(R.color.colorTestLine),
                getResources().getColor(R.color.colorWorkLine),
                getResources().getColor(R.color.colorExpoLine));

        dataSetTask.setValueTextColor(getResources().getColor(R.color.colorIcons));

        //Seteamos un formateador del sistema para porcentajes (%)
        dataSetTask.setValueFormatter(new PercentFormatter());

        PieData dataTask = new PieData(dataSetTask);
        pieChartTask.setData(dataTask);
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
        //Habilita/Deshabilita el movimiento del gráfico
        pieChartTask.setRotationEnabled(false);

        buildLegend();

        return view;
    }

    /*----------------------------------------------------------------------------------------------
    * Construye y configura la leyenda para el gráfico*/
    private void buildLegend() {
        Legend legend = pieChartTask.getLegend();

        //Habilita/Deshabilita la leyenda en el gráfico
        legend.setEnabled(true);

        //Determina propiedades de estilo sobre la leyenda
        legend.setTextColor(getResources().getColor(R.color.colorSecondaryText));
        legend.setTextSize(9f);
        legend.setTypeface(Typeface.DEFAULT_BOLD);

        //Determina la dirección de la leyenda
        legend.setDirection(Legend.LegendDirection.RIGHT_TO_LEFT);
        //Determina la forma de la etiqueta de cada entrada
        legend.setForm(Legend.LegendForm.CIRCLE);
        //Determina el tamaño de la forma de la etiqueta
        legend.setFormSize(5f);
        //Determina el espacio horizontal entre etiquetas
        legend.setXEntrySpace(1f);
        //Determina el espacio vertial entre etiquetas
        legend.setYEntrySpace(1f);
        //Determina la orientación de las etiquetas de la leyenda

        //Determina las propiedades de ubicación de la leyenda
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);



        //Crea contenido extra en la leyenda
        legend.setExtra(ColorTemplate.MATERIAL_COLORS, new String[] {"ITEM1","ITEM2","ITEM3"});
    }

}
