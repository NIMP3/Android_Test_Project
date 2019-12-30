package co.yovany.androidtestproject.view.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.adapter.ChildAdapterRecyclerView;
import co.yovany.androidtestproject.model.Students;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildListFragment extends Fragment {


    public ChildListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvChild);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ChildAdapterRecyclerView childAdapterRecyclerView =
                new ChildAdapterRecyclerView(Students.getStudents(), getActivity(), R.layout.cardview_child);

        recyclerView.setAdapter(childAdapterRecyclerView);

        return view;
    }

}
