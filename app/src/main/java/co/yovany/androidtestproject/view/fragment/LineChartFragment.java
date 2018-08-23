package co.yovany.androidtestproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.utilities.ChartUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class LineChartFragment extends Fragment {

    private LineChart lineChart;

    public LineChartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_line_chart, container, false);

        lineChart = view.findViewById(R.id.lineChart);

        List<Entry> entriesTest = ChartUtility.buildStudentEntries(1,"EXAMEN");
        List<Entry> entriesWork = ChartUtility.buildStudentEntries(1,"TRABAJO");
        List<Entry> entriesExpo = ChartUtility.buildStudentEntries(1,"EXPOSICIÓN");

        LineDataSet dataSetTest = new LineDataSet(entriesTest, getResources().getString(R.string.test_legend));
        LineDataSet dataSetWork = new LineDataSet(entriesWork, getResources().getString(R.string.work_legend));
        LineDataSet dataSetExpo = new LineDataSet(entriesExpo, getResources().getString(R.string.exposition_legend));

        dataSetTest.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSetWork.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSetExpo.setAxisDependency(YAxis.AxisDependency.LEFT);

        dataSetTest.setColor(getResources().getColor(R.color.colorTestLine));
        dataSetWork.setColor(getResources().getColor(R.color.colorWorkLine));
        dataSetExpo.setColor(getResources().getColor(R.color.colorExpoLine));

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetTest);
        dataSets.add(dataSetWork);
        dataSets.add(dataSetExpo);

        LineData lineData = new LineData(dataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();

        return view;
    }

}
