package co.yovany.androidtestproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.adapter.StudentAdapterRecyclerView;
import co.yovany.androidtestproject.model.Student;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        RecyclerView recyclerView = findViewById(R.id.rvStudetList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        StudentAdapterRecyclerView studentAdapterRecyclerView =
                new StudentAdapterRecyclerView(buildStudents(), this, R.layout.cardview_student);
        recyclerView.setAdapter(studentAdapterRecyclerView);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (dy >= 0) {
                    recyclerView.smoothScrollToPosition(layoutManager.findLastVisibleItemPosition());
                }
                else {
                    recyclerView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition());
                }
            }
        });
    }

    private ArrayList<Student> buildStudents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1,"Juan Carlos","1095643423",3, 4, 15,"https://www.tgh.org/sites/default/files/lunchbox871.jpg"));
        students.add(new Student(2,"Jessica Marcela","1085423125",3, 4, 15,"https://www.paintlounge.ca/wp-content/uploads/2017/07/kids.jpg"));
        students.add(new Student(3,"Jesús Daniel","1088456923",3, 4, 15,"https://321talentshowcase.com/wp-content/uploads/2012/10/Lucas-Sanson-Headshot-819x1024.jpg"));


        return students;
    }
}
