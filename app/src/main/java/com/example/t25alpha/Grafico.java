package com.example.t25alpha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;

public class Grafico extends AppCompatActivity {
    private BarChart barChart;
    private String[]staturday = new String[]{"Prueba1, Prueba2"};
    private int[]datos = new int[]{25,20,35,12,1};
    private int[]colors=new int[]{Color.BLACK,Color.RED,Color.GREEN,Color.BLUE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        barChart = (BarChart)findViewById(R.id.graficobarras);


    }
    private Chart getSameChart(Chart chart, String description, int textColor, int background,int animation){
    chart.setDescription(description);
    chart.setBackgroundColor(background);
    return chart;
    }
}
