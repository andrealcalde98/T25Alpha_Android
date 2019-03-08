package com.example.t25alpha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class Grafico extends AppCompatActivity {
    private BarChart barChart;
    private String[]staturday = new String[]{"Prueba1", "Prueba2","Prueba3"};
    private int[]datos = new int[]{3,20,35};
    private int[]colors=new int[]{Color.BLACK,Color.RED,Color.GREEN};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        barChart = (BarChart)findViewById(R.id.graficobarras);
        createCharts();


    }
    private Chart getSameChart(Chart chart, String description,int animation){
    chart.getDescription().setText(description);
    chart.getDescription().setTextSize(15);
    chart.animateY(animation);
    legend(chart);
    return chart;
    }

    private void legend(Chart chart){
    Legend legend =chart.getLegend();
    legend.setForm(Legend.LegendForm.CIRCLE);
    legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

    ArrayList<LegendEntry>entries = new ArrayList<>();
    for (int i = 0; i < staturday.length; i++){
        LegendEntry entry = new LegendEntry();
        entry.formColor=colors[i];
        entry.label=staturday[i];
        entries.add(entry);
    }
    legend.setCustom(entries);

    }
    private ArrayList<BarEntry>getBarEntries(){
        ArrayList<BarEntry>entries=new ArrayList<>();
        for (int i = 0; i < staturday.length; i++)
            entries.add(new BarEntry(i,datos[i]));
        return entries;
    }

    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(staturday));

    }

    private void axisLeft(YAxis axis){
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);
    }

    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }

    public void createCharts(){
        barChart=(BarChart)getSameChart(barChart,"Series",3000);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());
    }

    private DataSet getData(DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }

    private BarData getBarData(){
        BarDataSet barDataSet=(BarDataSet)getData(new BarDataSet(getBarEntries(),""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData=new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }
}
