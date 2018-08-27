package co.yovany.androidtestproject.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Notes {

    private static ArrayList<Note> notes = buildNotes();

    public Notes() {
        notes = buildNotes();
    }

    /*==============================================================================================
    *METODOS*/

    /*----------------------------------------------------------------------------------------------
     *Construye y retorna una lista de notas
     *
     *@return <code>ArrayList<Notes></code> Lista de objetos de la clase Note
     */
    private static ArrayList<Note> buildNotes() {
        ArrayList<Note> list = new ArrayList<>();

        //Notas del primer Estudiante de la lista
        list.add(new Note(1,4.5f,1,1));
        list.add(new Note( 2,3.8f,2,1));
        list.add(new Note( 3,2.8f,3,1));
        list.add(new Note( 4,5.0f,4,1));
        list.add(new Note( 5,3.7f,5,1));

        list.add(new Note(6,1.5f,6,1));
        list.add(new Note( 7,3.0f,7,1));
        list.add(new Note( 8,4.8f,8,1));
        list.add(new Note( 9,4.5f,9,1));
        list.add(new Note( 10,3.9f,10,1));

        list.add(new Note(11,4.1f,11,1));
        list.add(new Note( 12,3.2f,12,1));
        list.add(new Note( 13,2.0f,13,1));
        list.add(new Note( 14,3.4f,14,1));
        list.add(new Note( 15,4.6f,15,1));

        //Notas del segundo Estudiante de la lista
        list.add(new Note(16,2.5f,1,2));
        list.add(new Note( 17,3.8f,2,2));
        list.add(new Note( 18,4.4f,3,2));
        list.add(new Note( 19,2.3f,4,2));
        list.add(new Note( 20,3.1f,5,2));

        list.add(new Note(21,5.0f,6,2));
        list.add(new Note( 22,4.3f,7,2));
        list.add(new Note( 23,4.9f,8,2));
        list.add(new Note( 24,5.0f,9,2));
        list.add(new Note( 25,4.2f,10,2));

        list.add(new Note(26,4.0f,11,2));
        list.add(new Note( 27,3.0f,12,2));
        list.add(new Note( 28,2.9f,13,2));
        list.add(new Note( 29,4.4f,14,2));
        list.add(new Note( 30,3.6f,15,2));
        //Notas del tercer Estudiante de la lista
        list.add(new Note(31,3.1f,1,3));
        list.add(new Note(32,4.0f,2,3));

        return list;
    }


    /*----------------------------------------------------------------------------------------------
     * Obtiene un vector con los nombres de las actividades creadas hasta el momento
     *
     * @return <code>String[] names</code> : Vector de nombres de actividades*/
    public static String[] getTasksNames(int student) {
        List<String> values = new ArrayList<>();
        String[] names;

        for (Note note : notes) {
            if (note.getStudent() == student){
                Task task = Tasks.getTask(note.getTask());
                if (task != null) values.add(task.getType());
            }
        }

        names = new String[values.size()];
        for (int i=0; i<names.length; i++) names[i] = values.get(i);

        return names;
    }

    /*----------------------------------------------------------------------------------------------
    * Obtiene un listado de notas con base en el tipo de actividad seleccionada
    *
    * @param student : Codigo del estudiante seleccionado
    * @param type : Tipo de Actividad (EXAMEN, TRABAJO, EXPOSICION ...)
    * @return <code>Vector<String> values</code> : valores para los ejes (X,Y) del gráfico*/
    public static Vector<String> buildTaskValues(int student, String type) {
        Vector<String> values = new Vector<>();

        for (Note note : notes) {
            if (note.getStudent() == student) {
                Task task = Tasks.getTask(note.getTask());
                if (task != null) {
                    if (task.getType().equals(type))
                        values.add(task.getDate() + "-" + note.getValue());
                }
            }
        }

        return values;
    }

    /*----------------------------------------------------------------------------------------------
    * Genera los valores [X,Y] de la gráfica de rendimiento - Actividad
    * Eje X : Valores de las notas de cada actividad
    * Eje Y : Fechas de las actividades
    *
    * @param student : codigo del estudiante
    * @return <code>ArrayList<Task></code> : Listado de valores tipo String
     */
    public static Vector<String> buildDateValues(int student) {
        Vector<String> values = new Vector<>();

        for (Note note : notes) {
            if (note.getStudent() == student) {
                Task task = Tasks.getTask(note.getTask());
                if (task != null) values.add(task.getDate() + "-" + note.getValue());
            }
        }

        return values;
    }

    /*----------------------------------------------------------------------------------------------
    * Genera un listado de porcentajes de estudiantes que obtuvieron un determinado desempeño
    * Desempeño del estudiante (SUPERIOR, ALTO, BASICO y BAJO)
    *
    * @return <code>float[] percentages</code> : Porcentaje de estudiantes que obtuvieron un
    * determinado desempeño*/
    public static float[] percentageByPerformance() {
        float[] percentages = new float[] {0,0,0,0};
        float value;

        for (Note note : notes) {
            value = note.getValue();
            if (value >= 0 && value <= 2.9) percentages[0]++;
            else if (value >= 3.0 && value <= 3.9) percentages[1]++;
            else if (value >= 4.0 && value <= 4.5) percentages[2]++;
            else percentages[3]++;
        }

        for (int i=0; i<percentages.length; i++) percentages[i] = percentages[i]*100/notes.size();


        return percentages;
    }

    /*----------------------------------------------------------------------------------------------
    * Genera un listado de porcentajes de actividades desarrolladas en un curso
    *
    * @return <code>float[] percentages</code> : Porcentaje de actividades desarrolladas*/
    public static float[] percentageByTask() {
        float[] percentages = new float[] {0,0,0};
        float value;

        for (Note note : notes) {
            Task task = Tasks.getTask(note.getTask());
            if (task != null) {
                switch (task.getType()) {
                    case "EXAMEN":
                        percentages[0]++;
                        break;
                    case "TRABAJO":
                        percentages[1]++;
                        break;
                    default:
                        percentages[2]++;
                        break;
                }
            }
        }

        for (int i=0; i<percentages.length; i++) percentages[i] = percentages[i]*100/notes.size();
        return percentages;
    }

    /*==============================================================================================
    GETTER AND SETTER
     */
    public static ArrayList<Note> getNotes() {
        return notes;
    }
}
