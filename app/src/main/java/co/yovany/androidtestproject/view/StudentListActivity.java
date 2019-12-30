package co.yovany.androidtestproject.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.adapter.StudentAdapterRecyclerView;
import co.yovany.androidtestproject.model.Students;

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
                new StudentAdapterRecyclerView(Students.getStudents(), this, R.layout.cardview_student);
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
}
