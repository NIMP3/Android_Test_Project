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
        list.add(new Note(1,4.5,1,1));
        list.add(new Note( 2,3.8,2,1));
        list.add(new Note( 3,2.8,3,1));
        list.add(new Note( 4,5.0,4,1));
        list.add(new Note( 5,3.7,5,1));

        list.add(new Note(6,1.5,6,1));
        list.add(new Note( 7,3.0,7,1));
        list.add(new Note( 8,4.8,8,1));
        list.add(new Note( 9,4.5,9,1));
        list.add(new Note( 10,3.9,10,1));

        list.add(new Note(11,4.1,11,1));
        list.add(new Note( 12,3.2,12,1));
        list.add(new Note( 13,2.0,13,1));
        list.add(new Note( 14,3.4,14,1));
        list.add(new Note( 15,4.6,15,1));

        //Notas del segundo Estudiante de la lista
        list.add(new Note(16,2.5,1,2));
        list.add(new Note( 17,3.8,2,2));
        list.add(new Note( 18,4.4,3,2));
        list.add(new Note( 19,2.3,4,2));
        list.add(new Note( 20,3.1,5,2));

        list.add(new Note(21,5.0,6,2));
        list.add(new Note( 22,4.3,7,2));
        list.add(new Note( 23,4.9,8,2));
        list.add(new Note( 24,5.0,9,2));
        list.add(new Note( 25,4.2,10,2));

        list.add(new Note(26,4.0,11,2));
        list.add(new Note( 27,3.0,12,2));
        list.add(new Note( 28,2.9,13,2));
        list.add(new Note( 29,4.4,14,2));
        list.add(new Note( 30,3.6,15,2));
        //Notas del tercer Estudiante de la lista
        list.add(new Note(31,3.1,1,3));
        list.add(new Note(32,4.0,2,3));

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
                        values.add(note.getValue() + "-" + task.getCode());
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
                if (task != null) values.add(note.getValue() + "-" + task.getCode());
            }
        }

        return values;
    }

    /*==============================================================================================
    GETTER AND SETTER
     */
    public static ArrayList<Note> getNotes() {
        return notes;
    }
}
