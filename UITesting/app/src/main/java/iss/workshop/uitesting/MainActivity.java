package iss.workshop.uitesting;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BarChart barchart = findViewById(R.id.barchart);
       // PieChart piechart = findViewById(R.id.piechart);

        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Mon");
        xAxisLabel.add("Tue");
        xAxisLabel.add("Wed");
        xAxisLabel.add("Thu");
        xAxisLabel.add("Fri");
        xAxisLabel.add("Sat");
        xAxisLabel.add("Sun");

        //number of covid positive
        ArrayList<BarEntry> covidPlus = new ArrayList<>();
        covidPlus.add(new BarEntry(0, 30));
        covidPlus.add(new BarEntry(1, 12));
        covidPlus.add(new BarEntry(2, 11));
        covidPlus.add(new BarEntry(3, 45));
        covidPlus.add(new BarEntry(4, 89));
        covidPlus.add(new BarEntry(5, 45));
        covidPlus.add(new BarEntry(6, 89));



        BarDataSet barDataSet = new BarDataSet(covidPlus, "Covid-Positive");
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barchart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLabel));
        barchart.setFitBars(true);
        barchart.setData(barData);
        barchart.setVisibleXRangeMinimum(5);
        barchart.getDescription().setText("Covid-19 Cases");
        barchart.animateY(2000);

        ArrayList<PieEntry> gender = new ArrayList<>();
        gender.add(new PieEntry(200,"Male" ));
        gender.add(new PieEntry(23, "Female"));

        PieDataSet pieDataSet = new PieDataSet(gender, "Genders");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

       /* piechart.setData(pieData);
        piechart.setHoleRadius(0.0f);
        piechart.getDescription().setEnabled(false);
        piechart.animate();*/


    }
}