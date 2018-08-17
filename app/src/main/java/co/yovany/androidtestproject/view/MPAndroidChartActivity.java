package co.yovany.androidtestproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;

public class MPAndroidChartActivity extends AppCompatActivity implements OnChartGestureListener,
        OnChartValueSelectedListener{

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpandroid_chart);

        new ToolbarOptions(this,R.id.toolbar)
                .showToolbar(getResources().getString(R.string.mpandroidchart_activity_title), false);

        lineChart = findViewById(R.id.lineChart);
        List<Entry> entriesStudent1 = buildEntries(1);

        LineDataSet dataSet = new LineDataSet(entriesStudent1,getResources().getString(R.string.linechart_legend));

        //Controla el color de la linea del gráfico
        dataSet.setColor(getResources().getColor(R.color.colorPositiveSelection));
        //Controla el color de los valores de cada punto en el gráfico
        dataSet.setValueTextColor(getResources().getColor(R.color.colorPrimaryDark));
        //Controla el color
        dataSet.setFillColor(getResources().getColor(R.color.colorPositiveSelection));
        //Controla el color de los diferentes puntos en el gráfico
        dataSet.setCircleColor(getResources().getColor(R.color.colorAccent));

        //Destacando valores
        highlightingValues(dataSet);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); //refresh

        //Cargar propiedades
        loadPropertiesLineChart();

        lineChart.setOnChartGestureListener(this);
        lineChart.setOnChartValueSelectedListener(this);
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
    private List<Entry> buildEntries(int student) {
        Vector<String> values = Notes.buildGraphicValues(student);
        List<Entry> listEntries = new ArrayList<>();

        for (String value : values) {
            String[] elements = value.split("-");
            listEntries.add(new Entry(
                    Float.parseFloat(elements[1]),
                    Float.parseFloat(elements[0])));
        }

        return listEntries;
    }

    /*----------------------------------------------------------------------------------------------
    * Evalúa las propiedades de la clase LineChart
     */
    private void loadPropertiesLineChart() {
        //Deshabilita/Habilita todas las posibles interacciones tipo touch sobre el gráfico
        lineChart.setTouchEnabled(true);

        //Deshabilita/Habilita el evento [drag/arrastrar]
        //Evento utilizado una vez hecho zoom sobre el gráfico para asi moverse por el eje X o Y
        lineChart.setDragEnabled(true);

        //Deshabilita/Habilita el escalado en ambos ejes
        lineChart.setScaleEnabled(true);

        //Deshabilita/Habilita el escalado en el eje X
        lineChart.setScaleXEnabled(true);

        //Deshabilita/Habilita el escalado en el eje Y
        lineChart.setScaleYEnabled(true);

        /*Deshabilita/Habilita el evento Zoom a dos ejes
         * Habilitado: El evento zoom se realiza en ambos ejes en porcentajes iguales
         * Deshabilitado: El evento zoom se re realiza separadamente*/
        lineChart.setPinchZoom(true);

        /*Deshabilita/Habilita el evento Zoom a doble click
         * Default: <code>false</code>*/
        lineChart.setDoubleTapToZoomEnabled(false);

        /*Deshabilita/Habilita un movimiento de desaceleración al producirso el evento [Drag]
         * Default: <code>true</code>*/
        lineChart.setDragDecelerationEnabled(true);

        /*Controla el coeficiente de desaceleración en un rango de [0,1]
         * Valores altos: Mayor lapso de desaceleración
         * Valores bajos: Menor lapso de desaceleración*/
        lineChart.setDragDecelerationFrictionCoef(0.9f);


        lineChart.setHighlightPerDragEnabled(true);

        //Deshabilita/Habilita el resaltado al seleccionar una valor del gráfico
        lineChart.setHighlightPerTapEnabled(true);

        /*Controla la distancia maxima del punto/valor al evento [tap] del usuario sobre el gráfico
        * Default: 500dp*/
        lineChart.setMaxHighlightDistance(200);

        /*Establece un valor a resaltar en el gráfico
        * @param x
        *   Valor de un punto en el gráfico
        *   (value1 = 2) AND (value2 = 3)
        *   [2.0 >= x <= 2.4] -> valor1 resaltado
        *   [2.5 >= x <= 3] -> valor2 resaltado
        * @param dataSetIndex
        * @param callListener */

        lineChart.highlightValue(2.6f, 0, true);

        //Highlight highlight = new Highlight(3.0f, 0);
        /*Establece un valor a resaltar en el gráfico
         * @param highlight Objeto para Resaltar
         * @param callListener*/
        //lineChart.highlightValue(highlight,false);

        //Highlight[] highlights = new Highlight[2];
        //highlights[0] = new Highlight(1.0f, 0);
        //highlights[1] = new Highlight(2.0f, 0);
        /*Establece una serie de valores a resaltar
        * @param Highlight[] Vector de objetos tipo Highlight*/
        //lineChart.highlightValues(highlights);

        //Obtiene los elementos resaltados hasta el momento por el usuario
        Highlight[] highlights = lineChart.getHighlighted();
    }

    /*----------------------------------------------------------------------------------------------
    Resaltado de valores en el gráfico
     */
    private void highlightingValues(LineDataSet lineDataSet) {
        //Deshabilita/Habilita el resaltado de valores en el gráfico
        lineDataSet.setHighlightEnabled(true);
        //Deshabilita/Habilita el resaltado (lineas)
        lineDataSet.setDrawHighlightIndicators(true);
        //Controla el color del resaltado
        lineDataSet.setHighLightColor(getResources().getColor(R.color.colorNegativeSelection));
        //Deshabilita/Habilita el resaltado de la linea vertical
        lineDataSet.setDrawVerticalHighlightIndicator(true);
        //Deshabilita/Habilita el resaltado de la linea horizontal
        lineDataSet.setDrawHorizontalHighlightIndicator(true);
        //Controla el ancho de la linea resaltada (dp)
        lineDataSet.setHighlightLineWidth(2);
    }

    //Evento llamado cuando un [touch-gesture] ha empezado sobre el gráfico
    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        //Log.e("LINECHART-EVENT","START");
    }

    /*Evento llamado cuando un [touch-gesture] ha terminado sobre el gráfico
    * Ejemplo (ACTION_UP, ACTION_CANCEL)*/
    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        //Log.e("LINECHAR-EVENT","END");
    }

    //Evento llamado cuando se produce una presión larga sobre el gráfico
    @Override
    public void onChartLongPressed(MotionEvent me) {
        //Log.e("LINECHART-EVENT","LONG-PRESSED");
    }

    //Evento llamado cuando se produce un [Double-tapped] sobre el gráfico
    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        //Log.e("LINECHART-EVENT","DOUBLE-TAPPED");
    }

    //Evento llamado cuando se produce un [Single-tapped] sobre el gráfico
    @Override
    public void onChartSingleTapped(MotionEvent me) {
        //Log.e("LINECHART-EVENT","SINGLE-TAPPED");
    }

    //Evento llamado cuando se produce un [Fling-gesture] sobre el gráfico
    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
        //Log.e("LINECHART-EVENT","FLING-GESTURE");
    }

    //Evento llamado cuando se produce cuando el gráfico es escalado/zoom
    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        //Log.e("LINECHART-EVENT","SCALE");
    }

    //Evento llamado cuando se produce cuando el gráfico es movido/transladado via [drag-gesture]
    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        //Log.e("LINECHART-EVENT","TRANSLATE");
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.e("HIGHLIGHT",""+h.toString());
    }

    @Override
    public void onNothingSelected() {

    }
}
