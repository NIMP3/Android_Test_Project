package co.yovany.androidtestproject.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yovany.androidtestproject.R;
import co.yovany.androidtestproject.model.Notes;

public class MPAndroidChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpandroid_chart);

        new ToolbarOptions(this,R.id.toolbar)
                .showToolbar(getResources().getString(R.string.mpandroidchart_activity_title), false);

        LineChart lineChart = findViewById(R.id.lineChart);
        Vector<String> values = Notes.buildGraphicValues(1);
        List<Entry> entries = new ArrayList<>();

        for (String value : values) {
            String[] elements = value.split("-");
            entries.add(new Entry(
                    Float.parseFloat(elements[1]),
                    Float.parseFloat(elements[0])));
        }

        LineDataSet dataSet = new LineDataSet(entries,"RENDIMIENTO");
        dataSet.setColor(R.color.colorAccent);
        dataSet.setValueTextColor(R.color.colorPrimaryText);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); //refresh
    }
}
