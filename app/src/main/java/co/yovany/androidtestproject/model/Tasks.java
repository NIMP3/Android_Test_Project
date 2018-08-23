package co.yovany.androidtestproject.model;

import java.util.ArrayList;

public class Tasks {

    private static ArrayList<Task> tasks = buildTasks();

    public Tasks() {
        tasks = buildTasks();
    }

    /*==============================================================================================
     *METODOS*/

    /*----------------------------------------------------------------------------------------------
     *Construye y retorna una lista de actividades
     *
     *@return <code>ArrayList<Task></code> Lista de objetos de la clase Task
     */
    private static ArrayList<Task> buildTasks() {
        ArrayList<Task> list = new ArrayList<>();

        list.add(new Task(1,"EXAMEN"));
        list.add(new Task(2,"EXAMEN"));
        list.add(new Task(3,"EXAMEN"));
        list.add(new Task(4,"EXAMEN"));
        list.add(new Task(5,"EXAMEN"));

        list.add(new Task(6,"TRABAJO"));
        list.add(new Task(7,"TRABAJO"));
        list.add(new Task(8,"TRABAJO"));
        list.add(new Task(9,"TRABAJO"));
        list.add(new Task(10,"TRABAJO"));

        list.add(new Task(11,"EXPOSICIÓN"));
        list.add(new Task(12,"EXPOSICIÓN"));
        list.add(new Task(13,"EXPOSICIÓN"));
        list.add(new Task(14,"EXPOSICIÓN"));
        list.add(new Task(15,"EXPOSICIÓN"));

        return list;
    }

    /*----------------------------------------------------------------------------------------------
    * Obtiene una Actividad de la lista apartir su respectivo codigo
    *
    * @param code : codigo de la Actividad
    * @return <code>Task task</code> : Objeto tipo actividad/task*/

    public static Task getTask(int code) {
        for (Task task : tasks) {
            if (task.getCode() == code) return task;
        }

        return null;
    }

    /*==============================================================================================
    GETTER AND SETTER
     */

    public static ArrayList<Task> getTasks() {
        return tasks;
    }
}
