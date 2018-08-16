package co.yovany.androidtestproject.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Notes {

    private static ArrayList<Note> notes = buildNotes();

    public Notes() {
        notes = buildNotes();
    }

    /*==============================================================================================
    *METODOS
     */

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
        //Notas del segundo Estudiante de la lista
        list.add(new Note(3,2.9,1,2));
        list.add(new Note(4,4.9,2,2));
        //Notas del tercer Estudiante de la lista
        list.add(new Note(5,3.1,1,3));
        list.add(new Note(6,4.0,2,3));

        return list;
    }

    /*----------------------------------------------------------------------------------------------
    * Genera los valores [X,Y] de la gráfica de rendimiento - Actividad
    * Eje X : Valores de las notas de cada actividad
    * Eje Y : Fechas de las actividades
    *
    * @return <code></code> Listado de valores tipo String
     */
    public static Vector<String> buildGraphicValues(int student) {
        Vector<String> values = new Vector<>();
        ArrayList<Task> tasks = Tasks.getTasks();

        for (Note note : notes) {
            if (note.getStudent() == student){
                for (Task task : tasks) {
                    if (task.getCode() == note.getTask()) {
                        values.add(
                                note.getValue() + "-" +
                                task.getCode());
                        break;
                    }
                }
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
