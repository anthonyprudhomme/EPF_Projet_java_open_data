/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import moviedatas.Controller.MovieListController;
import moviedatas.Controller.MovieListControllerInterface;
import moviedatas.Model.Movie;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import static org.jfree.chart.plot.PlotOrientation.VERTICAL;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author anthony
 */
public class GlobalChart implements MovieListControllerInterface {

    public static MovieListControllerInterface observer;
    private ChartPanel cPanel;

    public JPanel initView() {
        observer = this;
        ArrayList<Movie> movies = MovieListController.allMovies;
         XYSeries series = new XYSeries("Movie");
        for (int i = 0; i < movies.size(); i++) {
            Movie currentMovie = movies.get(i);
            series.add(currentMovie.getGross(), currentMovie.getScore());
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart scatterPlot = ChartFactory.createScatterPlot("", "Gross (in $)", "Score", dataset, VERTICAL, true, true, false);
        
        cPanel = new ChartPanel(scatterPlot);
        cPanel.setPreferredSize(new Dimension(500,250));
        return cPanel;
    }

    @Override
    public void movieListHasCHanged(ArrayList<Movie> movies) {
        XYSeries series = new XYSeries("Movie");
        for (int i = 0; i < movies.size(); i++) {
            Movie currentMovie = movies.get(i);
            series.add(currentMovie.getGross(), currentMovie.getScore());
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart scatterPlot = ChartFactory.createScatterPlot("", "Gross (in $)", "Score", dataset, VERTICAL, true, true, false);
        cPanel.setChart(scatterPlot);
        cPanel.updateUI();
    }

}
