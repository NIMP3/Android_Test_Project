package co.yovany.androidtestproject.adapter;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Student;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChildAdapterRecyclerView extends RecyclerView.Adapter<ChildAdapterRecyclerView.ChildViewHolder> {

    private ArrayList<Student> children;
    private Activity activity;
    private int resource;

    public ChildAdapterRecyclerView(ArrayList<Student> children, Activity activity, int resource) {
        this.children = children;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        Student child = children.get(position);

        Picasso.get().load(child.getAvatar()).into(holder.civChildPicture);
        holder.tvChildName.setText(child.getName());
        holder.tvChildId.setText(child.getId());
    }

    @Override
    public int getItemCount() {
        return children.size();
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView civChildPicture;
        private TextView tvChildName;
        private TextView tvChildId;

        public ChildViewHolder(View itemView) {
            super(itemView);

            civChildPicture = itemView.findViewById(R.id.civChildPicture);
            tvChildName = itemView.findViewById(R.id.tvChildName);
            tvChildId = itemView.findViewById(R.id.tvChildId);
        }
    }
}
