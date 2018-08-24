package co.yovany.androidtestproject.model;

import java.util.ArrayList;

public class Tasks {

    private static ArrayList<Task> tasks = buildTasks();
    private static final float day = 1/31;

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

        list.add(new Task(1,"EXAMEN",3*day+2));
        list.add(new Task(2,"EXAMEN",4*day+3));
        list.add(new Task(3,"EXAMEN",10*day+5));
        list.add(new Task(4,"EXAMEN",15*day+6));
        list.add(new Task(5,"EXAMEN",29*day+10));

        list.add(new Task(6,"TRABAJO",2*day+1));
        list.add(new Task(7,"TRABAJO",4*day+1));
        list.add(new Task(8,"TRABAJO",9*day+3));
        list.add(new Task(9,"TRABAJO",20*day+9));
        list.add(new Task(10,"TRABAJO",21*day+11));

        list.add(new Task(11,"EXPOSICIÓN",1*day+2));
        list.add(new Task(12,"EXPOSICIÓN",2*day+5));
        list.add(new Task(13,"EXPOSICIÓN",18*day+10));
        list.add(new Task(14,"EXPOSICIÓN",25*day+11));
        list.add(new Task(15,"EXPOSICIÓN",31*day+12));

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
