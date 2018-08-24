package co.yovany.androidtestproject.utilities;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yovany.androidtestproject.model.Notes;

public class ChartUtility {

    /*----------------------------------------------------------------------------------------------
    * Construye una Lista de entradas para un BarChart dependiendo del estudiante seleccionado
    *
    * @param student : Codigo del estudiante
    *
    * @return <code>List<BarEntry></code> : lista de entradas*/
    public static List<BarEntry> buildStudentBarEntries(int student, String type) {
        List<BarEntry> entries = new ArrayList<>();
        Vector<String> values;

        switch (type) {
            case "DATE":
                values = Notes.buildDateValues(student);
                break;
            default:
                values = Notes.buildTaskValues(student, type);
        }

        for (String value : values) {
            String[] elements = value.split("-");
            entries.add(new BarEntry(
                    Float.parseFloat(elements[0]),
                    Float.parseFloat(elements[1])));
        }

        return entries;
    }

    /*----------------------------------------------------------------------------------------------
     * Contruye una Lista de entradas para un LineChart dependiendo del estudiante seleccionado
     *
     * @param student : Codigo del estudiante
     * @param type : tipo de entradas a solicitar
     *      +DATE : obtiene (notas,fechas)
     *      +Default : obtiene (notas,tipo_actividad)
     *
     * @return <code>List<Entry></code> : lista de entradas*/
    public static List<Entry> buildStudentEntries(int student, String type) {
        List<Entry> listEntries = new ArrayList<>();
        Vector<String> values;

        switch (type) {
            case "DATE":
                values = Notes.buildDateValues(student);
                break;
            default:
                values = Notes.buildTaskValues(student, type);
        }

        for (String value : values) {
            String[] elements = value.split("-");
            listEntries.add(new Entry(
                    Float.parseFloat(elements[0]),
                    Float.parseFloat(elements[1])));
        }

        return listEntries;
    }

    /*----------------------------------------------------------------------------------------------
    * Construye un Formateador de valores con los meses de un año
    *
    * @return <code>IAxisValuesFormatter</code> : Formateador de meses para el eje X de un gráfico*/
    public static IAxisValueFormatter buildXAxisMonthFormatter() {
        final String[] months = new String[] {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};

        return new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return months[(int) value-1];
            }
        };
    }

    /*----------------------------------------------------------------------------------------------
    * Construye las caracteristicas por default para los Ejes X y Y de un gráfico
    *
    * @param xAxis : Eje X
    * @param yAxisLeft : Eje Y izquierdo
    * @param yAxisRight : Eje Y derecho*/
    public static void buildAxesProperties(XAxis xAxis, YAxis yAxisLeft, YAxis yAxisRight) {
        //Propiedades para el Eje X
        xAxis.setGranularity(1f);
        xAxis.setAxisMinimum(1f);
        xAxis.setAxisMaximum(12f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(ChartUtility.buildXAxisMonthFormatter());
        xAxis.setLabelCount(12,true);

        //Propiedades para el Eje Y izquierdo
        yAxisLeft.setGranularity(1f);
        yAxisLeft.setAxisMinimum(0f);
        yAxisLeft.setAxisMaximum(5);
        yAxisLeft.setLabelCount(5,true);

        //Propiedades para el Eje Y derecho
        yAxisRight.setEnabled(false);
    }
}
