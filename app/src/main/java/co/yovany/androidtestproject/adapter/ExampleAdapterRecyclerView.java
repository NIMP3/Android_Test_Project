package co.yovany.androidtestproject.adapter;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Example;
import co.yovany.androidtestproject.view.ComponentEditTextActivity;
import co.yovany.androidtestproject.view.MainActivity;
import co.yovany.androidtestproject.view.TinderSwipeActivity;

public class ExampleAdapterRecyclerView extends RecyclerView.Adapter<ExampleAdapterRecyclerView.ExampleViewHolder> {

    private ArrayList<Example> examples;
    private Activity activity;
    private int resource;

    public ExampleAdapterRecyclerView(ArrayList<Example> examples, Activity activity, int resource) {
        this.examples = examples;
        this.activity = activity;
        this.resource = resource;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        final Example example = examples.get(position);

        Picasso.get().load(example.getPictureExample()).into(holder.ivPictureExample);
        holder.tvTitleExample.setText(example.getTitleExample());
        holder.tvDescriptionExample.setText(example.getDescriptionExample());

        holder.cvExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateExample(example.getCodeExample());
            }
        });
    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder {

        private CardView cvExample;
        private ImageView ivPictureExample;
        private TextView tvTitleExample;
        private TextView tvDescriptionExample;

        public ExampleViewHolder(View itemView) {
            super(itemView);

            cvExample = itemView.findViewById(R.id.cvExample);
            ivPictureExample = itemView.findViewById(R.id.ivPictureExample);
            tvTitleExample = itemView.findViewById(R.id.tvTitleExample);
            tvDescriptionExample = itemView.findViewById(R.id.tvDescriptionExample);
        }
    }

    /*----------------------------------------------------------------------------------------------
    Evaluar el tipo de Ejemplo seleccionado y ejecutar una determinada acción
     */
    public void evaluateExample(int code) {
        Intent intent;
        switch (code) {
            case 1:
                intent = new Intent(activity, ComponentEditTextActivity.class);
                activity.startActivity(intent);
                break;
            case 2:
                intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                break;
            case 3:
                intent = new Intent(activity, TinderSwipeActivity.class);
                activity.startActivity(intent);
                break;
        }
    }
}
