package co.yovany.androidtestproject.utilities;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yovany.androidtestproject.model.Notes;

public class ChartUtility {

    private static List<Entry> entries;

    /*----------------------------------------------------------------------------------------------
     * Contruye una Lista de entradas dependiendo del estudiante seleccionado
     *
     * @param student : Codigo del estudiante
     * @param type : tipo de entradas a solicitar
     *      +DATE : obtiene (notas,fechas)
     *      +Default : obtiene (notas,tipo_actividad)
     *
     * @return <code>List<Entry></code> : lista de entradas*/
    public static List<Entry> buildStudentEntries(int student, String type) {
        Vector<String> values;

        switch (type) {
            case "DATE":
                values = Notes.buildDateValues(student);
                break;
            default:
                values = Notes.buildTaskValues(student, type);
        }

        List<Entry> listEntries = new ArrayList<>();

        for (String value : values) {
            String[] elements = value.split("-");
            listEntries.add(new Entry(
                    Float.parseFloat(elements[1]),
                    Float.parseFloat(elements[0])));
        }

        return listEntries;
    }
}
