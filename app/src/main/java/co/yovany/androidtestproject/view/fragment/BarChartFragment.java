package co.yovany.androidtestproject.view.fragment;


import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Students;
import co.yovany.androidtestproject.utilities.ChartUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarChartFragment extends Fragment {

    BarChart barChart, barChartGroup, barChartStacked, barChartH;
    BarData barData;
    FloatingActionButton fabNewGroup;

    public BarChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);

        barChart = view.findViewById(R.id.barChart);
        barChartGroup = view.findViewById(R.id.barChartGroup);
        barChartStacked = view.findViewById(R.id.barChartStacked);
        barChartH = view.findViewById(R.id.barChartHorizontal);

        fabNewGroup = view.findViewById(R.id.fabNewGroup);

        buildBarChart(view);
        buildBarChartGroup(view);
        buildBarChartStacked(view);
        buildBarChartH(view);

        modifyViewport();

        fabNewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewGroup();
            }
        });

        return view;
    }

    /*==============================================================================================
     * FUNCIONES
     */

    /*----------------------------------------------------------------------------------------------
    * Añade un grupo de datos al gráfico en tiempo de ejecución*/
    private void addNewGroup() {
        List<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(4.12f,3.0f)); //fecha : 12 de Abril, valor nota : 3.0
        entries.add(new BarEntry(7.23f,4.1f)); //fecha : 23 de Julio, valor nota : 4.1
        entries.add(new BarEntry(8.09f,3.8f)); //fecha : 9 de Agosto, valor nota : 3.8

        BarDataSet barDataSet = new BarDataSet(entries,getResources().getString(R.string.barchart_new_data));
        barData.addDataSet(barDataSet);
        barData.notifyDataChanged();
        barChart.notifyDataSetChanged();
        barChart.invalidate();

        //Resetea el zoom, (zoom out) establece el gráfico en su posición original
        barChart.fitScreen();

        fabNewGroup.setVisibility(View.GONE);
    }

    /*----------------------------------------------------------------------------------------------
    * Construye el primer Gráfico de Barras*/
    private void buildBarChart(View view) {
        List<BarEntry> entries = ChartUtility.buildStudentBarEntries(1,"DATE");
        BarDataSet dataSet = new BarDataSet(entries, Students.getNameStudent(1));

        barData = new BarData(dataSet);
        //Determina el ancho de las barras
        barData.setBarWidth(0.9f);
        barChart.setData(barData);
        barChart.setFitBars(true);
        barChart.invalidate();

        //Establecemos las propiedades por default para los Ejes(X,Y) del gráfico
        ChartUtility.buildAxesProperties(
                barChart.getXAxis(),
                barChart.getAxisLeft(),
                barChart.getAxisRight());

        //Habilita/Deshabilita dibujar los valores sobre cada barra despues de su valor maximo
        barChart.setDrawValueAboveBar(false);
        //Habilita/Deshabilita dibujar una area gris detras de la barra y despues del valor maximo
        barChart.setDrawBarShadow(true);
        ChartUtility.buildNoData(barChart, view.getContext());
    }

    /*----------------------------------------------------------------------------------------------
    * Construye el segundo Gráfico de Barras por grupos*/
    private void buildBarChartGroup(View view) {
        List<BarEntry> entriesTest = ChartUtility.buildStudentBarEntries(1,"EXAMEN");
        List<BarEntry> entriesWork = ChartUtility.buildStudentBarEntries(1,"TRABAJO");
        List<BarEntry> entriesExpo = ChartUtility.buildStudentBarEntries(1,"EXPOSICIÓN");

        BarDataSet dataSetTest = new BarDataSet(entriesTest, getResources().getString(R.string.test_legend));
        BarDataSet dataSetWork = new BarDataSet(entriesWork, getResources().getString(R.string.work_legend));
        BarDataSet dataSetExpo = new BarDataSet(entriesExpo, getResources().getString(R.string.exposition_legend));

        //Establece los colores de cada grupo de datos
        dataSetTest.setColor(getResources().getColor(R.color.colorTestLine));
        dataSetWork.setColor(getResources().getColor(R.color.colorWorkLine));
        dataSetExpo.setColor(getResources().getColor(R.color.colorExpoLine));

        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetTest);
        dataSets.add(dataSetWork);
        dataSets.add(dataSetExpo);
        BarData barDataGroup = new BarData(dataSets);
        barDataGroup.setBarWidth(0.9f);
        barChartGroup.setData(barDataGroup);
        barChart.setFitBars(true);
        barChartGroup.invalidate();

        //Establecemos las propiedades por default para los Ejes(X,Y) del gráfico
        ChartUtility.buildAxesProperties(
                barChartGroup.getXAxis(),
                barChartGroup.getAxisLeft(),
                barChartGroup.getAxisRight());

        ChartUtility.buildNoData(barChartGroup, view.getContext());

        barChartGroup.animateY(3000, Easing.EasingOption.EaseInOutCirc);
    }

    /*----------------------------------------------------------------------------------------------
    * Construye el tercer Gráfico de Barras con datos apilados*/
    private void buildBarChartStacked(View view) {
        List<BarEntry> entriesStacked = new ArrayList<>();
        entriesStacked.add(new BarEntry(0f, new float[]{10, 20, 30}));

        BarDataSet dataSetStacked = new BarDataSet(entriesStacked,getResources().getString(R.string.barchart_stacked_legend));
        dataSetStacked.setColors(ColorTemplate.MATERIAL_COLORS);
        //Etiquetas para los datos del gráfico
        dataSetStacked.setStackLabels(new String[] {"PRIMERO","SEGUNDO","TERCERO"});

        BarData barDataStacked = new BarData(dataSetStacked);
        barChartStacked.setData(barDataStacked);
        barChartStacked.invalidate();

        ChartUtility.buildNoData(barChartStacked, view.getContext());
    }

    /*----------------------------------------------------------------------------------------------
    * Construye el cuarto Gráfico de Barras Horizontal*/
    private void buildBarChartH(View view) {
        List<BarEntry> entriesH = ChartUtility.buildStudentBarEntries(2,"DATE");
        BarDataSet dataSetH = new BarDataSet(entriesH, Students.getNameStudent(2));

        BarData barDataH = new BarData(dataSetH);
        barChartH.setData(barDataH);
        barChartH.invalidate();

        ChartUtility.buildAxesProperties(
                barChartH.getXAxis(),
                barChartH.getAxisLeft(),
                barChartH.getAxisRight());

        ChartUtility.buildNoData(barChartH, view.getContext());
    }

    /*----------------------------------------------------------------------------------------------
    * Modifica la ventana (Viewport) del primer gráfico*/
    private void modifyViewport() {
        /*Determina el rango maximo de valores que se visualizan en el gráfico
        * NOTA: El valor no debe ser inferior al total de entradas en el gráfico*/
        barChart.setVisibleXRangeMaximum(12f);
        /*Determina el rango minimo de valores que se visualizan en el gráfico
        * NOTA: Limita el zoom al rango minimo*/
        barChart.setVisibleXRangeMinimum(5f);
        /*NOTA: El valor puede ser inferior al total de entradas en el gráfico*/
        barChart.setVisibleYRangeMaximum(5f, barChart.getAxisLeft().getAxisDependency());
        barChart.setVisibleYRangeMinimum(5f, barChart.getAxisLeft().getAxisDependency());

        //Añade un tamaño extra a las compensaciones calculadas por la libreria
        barChart.setExtraOffsets(0,0,0,15);
        //Realiza un zoom de 1.4f
        //barChart.zoomIn();
        //Realiza un zoom out de 0.7f
        //barChart.zoomOut();

        //Realiza una animación de izquierda a derecha de cada valor en el gráfico
        //barChart.animateX(3000);
        //Realiza una animación de abajo a arriba de cada valor en el gráfico
        //barChart.animateY(3000);
        //Realiza una animación en los dos Ejes
        //barChart.animateXY(2000,2000);

        //Aplicando tipos de animaciones
        //barChart.animateX(3000, Easing.EasingOption.EaseInBounce);
        barChart.animateY(3000, Easing.EasingOption.EaseOutBounce);
    }
}
