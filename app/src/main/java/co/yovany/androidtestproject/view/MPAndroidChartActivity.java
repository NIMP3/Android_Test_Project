package co.yovany.androidtestproject.view;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;

public class MPAndroidChartActivity extends AppCompatActivity implements OnChartGestureListener {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpandroid_chart);

        new ToolbarOptions(this,R.id.toolbar)
                .showToolbar(getResources().getString(R.string.mpandroidchart_activity_title), false);

        lineChart = findViewById(R.id.lineChart);
        Vector<String> values = Notes.buildGraphicValues(1);
        List<Entry> entries = new ArrayList<>();

        for (String value : values) {
            String[] elements = value.split("-");
            entries.add(new Entry(
                    Float.parseFloat(elements[1]),
                    Float.parseFloat(elements[0])));
        }

        LineDataSet dataSet = new LineDataSet(entries,getResources().getString(R.string.linechart_legend));
        dataSet.setColor(R.color.colorPositiveSelection);
        dataSet.setValueTextColor(R.color.colorNegativeSelection);
        dataSet.setFillColor(R.color.colorPositiveSelection);
        dataSet.setCircleColor(getResources().getColor(R.color.colorAccent));

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); //refresh

        //Cargar propiedades
        loadPropertiesLineChart();

        lineChart.setOnChartGestureListener(this);
    }

    /*==============================================================================================
    * FUNCIONES
     */

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
}
