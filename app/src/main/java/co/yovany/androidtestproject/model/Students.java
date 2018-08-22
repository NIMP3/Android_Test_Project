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
        list.add(new Student(4,"Jesús Daniel","1088456923","https://321talentshowcase.com/wp-content/uploads/2012/10/Lucas-Sanson-Headshot-819x1024.jpg"));
        list.add(new Student(5,"Jesús Daniel","1088456923","https://321talentshowcase.com/wp-content/uploads/2012/10/Lucas-Sanson-Headshot-819x1024.jpg"));

        return list;
    }

    /*----------------------------------------------------------------------------------------------
    * Obtiene el nombre de un Estudiante a través de su respectivo codigo
    *
    * @param code : Codigo del estudiante a buscar
    * @return name : Nombre del estudiante*/
    public static String getNameStudent( int code) {
        String name = "";

        for (Student student : students) {
            if (student.getCode() == code) {
                name = student.getName();
                break;
            }
        }

        return name;
    }

    /*==============================================================================================
    GETTER AND SETTER
     */
    public static ArrayList<Student> getStudents() {
        return students;
    }
}
