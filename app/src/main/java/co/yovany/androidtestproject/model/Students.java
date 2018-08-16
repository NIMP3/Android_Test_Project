package co.yovany.androidtestproject.model;

import java.util.ArrayList;

public class Students {

    private static ArrayList<Student> students = buildStudents();

    public Students() {
        students = buildStudents();
    }

    /*==============================================================================================
    *METODOS*/

    /*----------------------------------------------------------------------------------------------
    *Construye y retorna una lista de estudiantes
    *
    *@return <code>ArrayList<Student></code> Lista de objetos de la clase Student
     */

    private static ArrayList<Student> buildStudents() {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(1,"Juan Carlos","1095643423","https://www.tgh.org/sites/default/files/lunchbox871.jpg"));
        list.add(new Student(2,"Jessica Marcela","1085423125","https://www.paintlounge.ca/wp-content/uploads/2017/07/kids.jpg"));
        list.add(new Student(3,"Jesús Daniel","1088456923","https://321talentshowcase.com/wp-content/uploads/2012/10/Lucas-Sanson-Headshot-819x1024.jpg"));

        return list;
    }

    /*==============================================================================================
    GETTER AND SETTER
     */
    public static ArrayList<Student> getStudents() {
        return students;
    }
}
