/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.screens;

/**
 *
 * @author rahumathulla
 */
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
  
public class BarChartExample extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public BarChartExample(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    XYDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart = ChartFactory.createTimeSeriesChart(
        "Time Series Chart Example | WWW.BORAJI.COM", // Chart
        "Date", // X-Axis Label
        "Number", // Y-Axis Label
        dataset); 
  
    ChartPanel panel=new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private XYDataset createDataset() {  
        TimeSeriesCollection dataset = new TimeSeriesCollection();

    TimeSeries series1 = new TimeSeries("Series1");
    series1.add(new Day(1, 1, 2017), 50);
    series1.add(new Day(2, 1, 2017), 40);
    series1.add(new Day(3, 1, 2017), 45);
    series1.add(new Day(4, 1, 2017), 30);
    series1.add(new Day(5, 1, 2017), 50);
    series1.add(new Day(6, 1, 2017), 45);
    series1.add(new Day(7, 1, 2017), 60);
    series1.add(new Day(8, 1, 2017), 45);
    series1.add(new Day(9, 1, 2017), 55);
    series1.add(new Day(10, 1, 2017), 48);
    series1.add(new Day(11, 1, 2017), 60);
    series1.add(new Day(12, 1, 2017), 45);
    series1.add(new Day(13, 1, 2017), 65);
    series1.add(new Day(14, 1, 2017), 45);
    series1.add(new Day(15, 1, 2017), 55);
    dataset.addSeries(series1);

      TimeSeries series2 = new TimeSeries("Series2");
    series2.add(new Day(1, 1, 2017), 40);
    series2.add(new Day(2, 1, 2017), 35);
    series2.add(new Day(3, 1, 2017), 26);
    series2.add(new Day(4, 1, 2017), 45);
    series2.add(new Day(5, 1, 2017), 40);
    series2.add(new Day(6, 1, 2017), 35);
    series2.add(new Day(7, 1, 2017), 45);
    series2.add(new Day(8, 1, 2017), 48);
    series2.add(new Day(9, 1, 2017), 31);
    series2.add(new Day(10, 1, 2017), 32);
    series2.add(new Day(11, 1, 2017), 21);
    series2.add(new Day(12, 1, 2017), 35);
    series2.add(new Day(13, 1, 2017), 10);
    series2.add(new Day(14, 1, 2017), 25);
    series2.add(new Day(15, 1, 2017), 15);
    dataset.addSeries(series2);
    return dataset;
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      BarChartExample example=new BarChartExample("Sales Trend Analysis");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}  
