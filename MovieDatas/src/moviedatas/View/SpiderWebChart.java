/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

/**
 *
 * @author anthony
 */
/* ------------------------
* SpiderWebChartDemo1.java
* ------------------------
* (C) Copyright 2005-2008, by Object Refinery Limited.
*
*/

//package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

/**
* A simple demonstration application showing how to create a spider chart.
*/
public class SpiderWebChart extends ApplicationFrame {

    public DefaultCategoryDataset dataset;

    public SpiderWebPlot plot;

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    
    private ChartPanel chartPanel;
    public SpiderWebChart(String title,int duration, double ratio, double score, double recency, int fbLikes) {
        super(title);
        chartPanel = (ChartPanel)createDemoPanel(duration,ratio,score,recency,fbLikes);
        chartPanel.setPreferredSize(new Dimension(300,300));
    }
    
    public ChartPanel getPanel(){
        return this.chartPanel;
    }

    /**
     * Returns a sample dataset.
     *
     * @return The dataset.
     */
    private static CategoryDataset createDataset(int duration, double ratio, double score, double recency, int fbLikes) {

        // row keys...
        String series1 = "Movie";
        // column keys...
        String category1 = "Duration (min)";
        String category2 = "Ratio Gross/Budget";
        String category3 = "Score";
        String category4 = "Recency";
        String category5 = "FaceBook Likes";

        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(duration, series1, category1);
        dataset.addValue(ratio, series1, category2);
        dataset.addValue(score, series1, category3);
        dataset.addValue(recency, series1, category4);
        dataset.addValue(fbLikes, series1, category5);

        return dataset;

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset) {
        SpiderWebPlot plot = new SpiderWebPlot(dataset);
        plot.setStartAngle(54);
        plot.setInteriorGap(0.40);
        //plot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        JFreeChart chart = new JFreeChart("",
                TextTitle.DEFAULT_FONT, plot, false);
        LegendTitle legend = new LegendTitle(plot);
        legend.setPosition(RectangleEdge.BOTTOM);
        chart.addSubtitle(legend);
        //ChartUtilities.applyCurrentTheme(chart);
        return chart;
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    
    private  JFreeChart spiderChart;
    public  JPanel createDemoPanel(int duration, double ratio, double score, double recency, int fbLikes) {
        spiderChart = createChart(createDataset(duration,ratio,score,recency,fbLikes));
        return new ChartPanel(spiderChart);
    }
    
    public void refreshChart(JPanel panel,int duration, double ratio, double score, double recency, int fbLikes) {
        panel.removeAll();
        panel.revalidate(); // This removes the old chart 
        spiderChart = createChart(createDataset(duration,ratio,score,recency,fbLikes));
        spiderChart.clearSubtitles();
        chartPanel = new ChartPanel(spiderChart); 
        panel.setLayout(new BorderLayout()); 
        panel.add(chartPanel); 
        panel.setPreferredSize(new Dimension(300,300));
        panel.repaint(); // This method makes the new chart appear
    }
    
    


}