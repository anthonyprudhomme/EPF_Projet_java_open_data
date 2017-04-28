/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.awt.Dimension;
import javax.swing.JPanel;
import moviedatas.Controller.MovieInfoControllerInterface;
import moviedatas.Model.Movie;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import static org.jfree.chart.plot.PlotOrientation.VERTICAL;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author anthony
 */
public class BarChartView implements MovieInfoControllerInterface {

    public static MovieInfoControllerInterface observer;
    private ChartPanel cPanel;

    public JPanel initView() {
        observer = this;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0, "Budget", new Integer(1));
        dataset.addValue(0, "Gross", new Integer(1));
        JFreeChart barChart = ChartFactory.createBarChart("", "Movie", "Value (in $)", dataset, VERTICAL, true, true, false);
        cPanel = new ChartPanel(barChart);
        cPanel.setPreferredSize(new Dimension(400,300));
        return cPanel;
    }

    @Override
    public void newMovieSelected(Movie movie) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(movie.getBudget(), "Budget", new Integer(1));
        dataset.addValue(movie.getGross(), "Gross", new Integer(1));
        JFreeChart barChart = ChartFactory.createBarChart("", "Movie", "Value (in $)", dataset, VERTICAL, true, true, false);
        cPanel.setChart(barChart);
        cPanel.updateUI();
    }

}
