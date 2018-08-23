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
        list.add(new Task(2,"TRABAJO"));
        list.add(new Task(3,"EXPOSICIÓN"));

        return list;
    }

    /*----------------------------------------------------------------------------------------------
    * Obtiene un vector con los nombres de las actividades creadas hasta el momento
    *
    * @return <code>String[] names</code> : Vector de nombres de actividades*/
    public static String[] getTasksNames() {
        String[] names = new String[tasks.size()];
        for (int i=0; i<tasks.size(); i++) names[i] = tasks.get(i).getType();
        return names;
    }

    /*==============================================================================================
    GETTER AND SETTER
     */

    public static ArrayList<Task> getTasks() {
        return tasks;
    }
}
