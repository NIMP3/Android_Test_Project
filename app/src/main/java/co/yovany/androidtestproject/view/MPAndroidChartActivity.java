package co.yovany.androidtestproject.view;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.XAxisRenderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;
import co.yovany.androidtestproject.model.Students;

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
        List<Entry> entriesStudent2 = buildEntries(2);


        LineDataSet dataSet1 =
                new LineDataSet(entriesStudent1, Students.getNameStudent(1));
        LineDataSet dataSet2 =
                new LineDataSet(entriesStudent2, Students.getNameStudent(2));

        dataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);

        //Controla el color de la linea del gráfico
        dataSet1.setColor(getResources().getColor(R.color.colorLineStudent1));
        dataSet2.setColor(getResources().getColor(R.color.colorLineStudent2));
        //Controla el color de los valores de cada punto en el gráfico
        dataSet1.setValueTextColor(getResources().getColor(R.color.colorValueLabel));
        dataSet2.setValueTextColor(getResources().getColor(R.color.colorValueLabel));
        //Controla el color
        //dataSet1.setFillColor(getResources().getColor(R.color.colorPositiveSelection));
        //Controla el color de los diferentes puntos en el gráfico
        dataSet1.setCircleColor(getResources().getColor(R.color.colorAccent));
        dataSet2.setCircleColor(getResources().getColor(R.color.colorAccent));

        //Destacando valores
        highlightingValues(dataSet1);

        //Construye una lista de grupos de datos para englobar en este case al Estudiante 1 y 2
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);

        LineData lineData = new LineData(dataSets);
        lineChart.setData(lineData);
        lineChart.invalidate(); //refresh

        //Cargar propiedades
        loadPropertiesLineChart();

        lineChart.setOnChartGestureListener(this);
        lineChart.setOnChartValueSelectedListener(this);

        buildAxis();
        stylingAxis();
        buildLimitLines();
    }

    /*==============================================================================================
    * FUNCIONES
     */

    /*----------------------------------------------------------------------------------------------
    * Determina Lineas Limites para los Ejes (X o Y)*/
    private void buildLimitLines() {
        YAxis yAxisLeft = lineChart.getAxisLeft();

        LimitLine limitLine = new LimitLine(4.5f, "Linea Limite");
        limitLine.setLineColor(getResources().getColor(R.color.colorLimitLine));
        limitLine.setLineWidth(2f);
        limitLine.setTextColor(getResources().getColor(R.color.colorPrimaryText));
        limitLine.setTextSize(18f);

        yAxisLeft.addLimitLine(limitLine);
    }

    /*----------------------------------------------------------------------------------------------
    * Determina los diferentes estilos sobre los Ejes (X, Y)*/
    private void stylingAxis() {
        XAxis xAxis = lineChart.getXAxis();
        //Determina el color de las etiquetas del Eje (X o Y)
        xAxis.setTextColor(getResources().getColor(R.color.colorXAxisLabel));
        //Determina el tamaño de letra (dp) de las etiquetas del Eje (X o Y)
        xAxis.setTextSize(18);
        //Determina el tipo de letra de las etiquetas del Eje (X o Y)
        xAxis.setTypeface(Typeface.DEFAULT_BOLD);
        //Determina el color de la linea del Eje (X o Y)
        xAxis.setAxisLineColor(getResources().getColor(R.color.colorXAxisLabel));
        //Determina el ancho de la linea del Eje (X o Y)
        xAxis.setAxisLineWidth(2);

        YAxis yAxisLeft = lineChart.getAxisLeft();
        yAxisLeft.setTextColor(getResources().getColor(R.color.colorYAxisLabel));
        yAxisLeft.setTypeface(Typeface.DEFAULT_BOLD);
        //Determina el color del Grid para el Eje (X o Y)
        yAxisLeft.setGridColor(getResources().getColor(R.color.colorGridAxis));
        //Determina el ancho del Grid para el Eje (X o Y)
        yAxisLeft.setGridLineWidth(2);
        yAxisLeft.setAxisLineColor(getResources().getColor(R.color.colorYAxisLabel));
        /*Habilita una linea punteada para el Eje (X o Y)
        * lineLenght : Tamaño de la linea
        * spaceLenght : Espacio entre cada linea
        * phace : */
        yAxisLeft.enableGridDashedLine(2,3,0);
    }

    /*----------------------------------------------------------------------------------------------
    * Determina las diferentes propiedades de los Ejes (X,Y)*/
    private void buildAxis() {
        //Propiedades para el Eje X
        XAxis xAxis = lineChart.getXAxis();
        /*Habilita/Deshabilita todas las carateristicas del eje (X o Y)
        * Default : true*/
        xAxis.setEnabled(true);
        /*Habilita/Deshabilita las etiquetas (numeros) del eje (X o Y)
        * Default : true*/
        xAxis.setDrawLabels(true);
        /*Habilita/Deshabilita las lineas del Eje (X o Y)
        * Default : true*/
        xAxis.setDrawGridLines(false);
        /*Controla el valor maximo o minimo del Eje (X o Y)
        * Es mejor que este valor sea calculado automaticamente dependienteo de los datos seteados*/
        xAxis.setAxisMaximum(3.0f);
        xAxis.setAxisMinimum(1.0f);
        /*Controla el numero de Etiquetas (numeros) sobre el eje (X o Y)
        * force : true -> los valores de las etiquetas seran exactos dependiendo de los datos seteados
        * force : false -> los valores de las etiquetas seran aproximados*/
        xAxis.setLabelCount(3,true);
        /*Determina la ubicación de las etiquetas del Eje
        * BOTTOM : Abajo
        * BOTTOM_INSIDE : Abajo pero dentro del gráfico
        * TOP : Arriba
        * TOP_INSIDE : Ariba pero dentro del gráfico
        * BOTH_SIDED : Ambos lados (ARRIBA Y ABAJO)
        *
        * Default : TOP*/
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        /*Controla el intervalo entre cada uno de los valores del Eje (X o Y)*/
        xAxis.setGranularity(1);
        /*Habilita/Deshabilita */
        xAxis.setGranularityEnabled(false);
        /*Determina el angulo de las etiquetas sobre el Eje X
        * Solo en el eje X*/
        xAxis.setLabelRotationAngle(45f);

        //Propiedades para el Eje Y parte izquierdo
        YAxis yAxisLeft = lineChart.getAxisLeft();
        /*Invierte los valores del gráfico (valores altos en la parte inferior y viceversa)
        * Solo en el eje Y*/
        yAxisLeft.setInverted(false);
        /*Controla el espacio en porcentaje del valor mas alto en comparación con el valor maximo
        * del eje y viceversa en la parte inferior del gráfico
        * Solo en el eje Y*/
        yAxisLeft.setSpaceTop(0f);
        yAxisLeft.setSpaceBottom(0f);
        yAxisLeft.setLabelCount(6, true);
        /*Determina la ubicación de las etiquetas del Eje
        * INSIDE_CHART : Dentro del gráfico
        * OUTSIDE_CHART : Fuera del gráfico
        *
        * Default : OUTSIDE_CHART*/
        yAxisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxisLeft.setGranularity(1);
        yAxisLeft.setGranularityEnabled(true);
        yAxisLeft.setAxisMinimum(0f);
        yAxisLeft.setAxisMaximum(5f);
        /*Habilita/Deshabilita el dibujar la linea cero
        * Determina algunas propiedades sobre la Linea cero*/
        yAxisLeft.setDrawZeroLine(true);
        yAxisLeft.setZeroLineWidth(3f);
        yAxisLeft.setZeroLineColor(getResources().getColor(R.color.colorZeroLine));

        //Propiedades para el Eje Y parte derecha
        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setDrawLabels(false);
    }

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
