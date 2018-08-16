package co.yovany.androidtestproject.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Student;
import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapterRecyclerView extends RecyclerView.Adapter<StudentAdapterRecyclerView.StudentViewHolder> {

    private ArrayList<Student> students;
    private Activity activity;
    private int resource;

    public StudentAdapterRecyclerView(ArrayList<Student> students, Activity activity, int resource) {
        this.students = students;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, int position) {
        Student student = students.get(position);

        Picasso.get().load(student.getAvatar()).into(holder.ivPictureStudent);
        holder.tvNamePictureStudent.setText(student.getName());
        holder.tvIdStudent.setText(student.getId());

        holder.cbAssistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    holder.cbMissing.setChecked(false);
                    holder.cbMissingExcuse.setChecked(false);
                }
            }
        });

        holder.cbMissing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.cbAssistance.setChecked(false);
                    holder.cbMissingExcuse.setChecked(false);
                }
            }
        });

        holder.cbMissingExcuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.cbAssistance.setChecked(false);
                    holder.cbMissing.setChecked(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPictureStudent;
        private TextView tvNamePictureStudent;
        private TextView tvIdStudent;
        private CheckBox cbAssistance;
        private CheckBox cbMissing;
        private CheckBox cbMissingExcuse;

        public StudentViewHolder(View itemView) {
            super(itemView);

            ivPictureStudent = itemView.findViewById(R.id.ivPictureStudent);
            tvNamePictureStudent = itemView.findViewById(R.id.tvNameStudent);
            tvIdStudent = itemView.findViewById(R.id.tvIdStudent);

            cbAssistance = itemView.findViewById(R.id.cbAssistance);
            cbMissing = itemView.findViewById(R.id.cbMissing);
            cbMissingExcuse = itemView.findViewById(R.id.cbMissingExcuse);
        }
    }
}
