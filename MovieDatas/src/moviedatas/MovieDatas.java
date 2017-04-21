/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import moviedatas.Controller.FilterPanelController;
import moviedatas.Controller.MovieInfoController;
import moviedatas.Controller.MovieInfoControllerInterface;
import moviedatas.Controller.MovieListController;
import moviedatas.Controller.SortPanelController;
import moviedatas.Model.Actor;
import moviedatas.Model.Director;
import moviedatas.Model.Movie;
import moviedatas.View.BarChartView;
import moviedatas.View.GlobalChart;
import moviedatas.View.MovieInfoView;
import moviedatas.View.MovieListView;
import moviedatas.View.SpiderChartView;
import moviedatas.View.SpiderWebChart;
import moviedatas.View.TextAreaInButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTick;
import static org.jfree.chart.plot.PlotOrientation.VERTICAL;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author anthony
 */
public class MovieDatas{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FilterPanelController fpc = new FilterPanelController();
        //Log.e("By size: " + fpc.bySize(movies, 50).size());
        /*ArrayList<Movie> moviesFiltered =fpc.byActor(movies, "Wes Studi"); 
        for (int i = 0; i < moviesFiltered.size(); i++) {
            Log.e(moviesFiltered.get(i).getTitle() + " "+ moviesFiltered.get(i).getActors().get(0).getName()
            + " "+ moviesFiltered.get(i).getActors().get(1).getName()
            + " "+ moviesFiltered.get(i).getActors().get(2).getName());
        }*/
        /*ArrayList<Movie> moviesFiltered =fpc.byDirector(movies, "James Cameron"); 
        for (int i = 0; i < moviesFiltered.size(); i++) {
            Log.e(moviesFiltered.get(i).getTitle() + " "+ moviesFiltered.get(i).getDirector().getName());
        }*/
        /*ArrayList<Movie> moviesFiltered =fpc.byColor(movies, false); 
        for (int i = 0; i < moviesFiltered.size(); i++) {
            Log.e(moviesFiltered.get(i).getTitle() + " "+ moviesFiltered.get(i).isColored());
        }*/
        /*ArrayList<String> countries = new ArrayList<>();
        countries.add("France");
        countries.add("Germany");
        ArrayList<Movie> moviesFiltered =fpc.byCountry(movies, countries); 
        for (int i = 0; i < moviesFiltered.size(); i++) {
            Log.e(moviesFiltered.get(i).getTitle() + " "+ moviesFiltered.get(i).getCountry());
        }*/
        
        /*ArrayList<String> genres = new ArrayList<>();
        genres.add("Action");
        genres.add("Fantasy");
        ArrayList<Movie> moviesFiltered =fpc.byGenre(movies, genres); 
        for (int i = 0; i < moviesFiltered.size(); i++) {
            Log.e(moviesFiltered.get(i).getTitle());
            for (int j = 0; j < moviesFiltered.get(i).getGenres().size(); j++) {
                Log.e(moviesFiltered.get(i).getGenres().get(j));
            }
            Log.e("------------------------------- ");
        }*/
        
        /*ArrayList<String> keywords = new ArrayList<>();
        keywords.add("Marriage");
        keywords.add("Future");
        ArrayList<Movie> moviesFiltered =fpc.byKeywords(movies, keywords); 
        for (int i = 0; i < moviesFiltered.size(); i++) {
            Log.e(moviesFiltered.get(i).getTitle());
            for (int j = 0; j < moviesFiltered.get(i).getPlotKeywords().size(); j++) {
                Log.e(moviesFiltered.get(i).getPlotKeywords().get(j));
            }
            Log.e("------------------------------- ");
        }*/
        
        /*ArrayList<String> languages = new ArrayList<>();
        languages.add("French");
        languages.add("German");
        ArrayList<Movie> moviesFiltered =fpc.byLanguage(movies, languages); 
        for (int i = 0; i < moviesFiltered.size(); i++) {
            Log.e(moviesFiltered.get(i).getTitle() + " "+ moviesFiltered.get(i).getLanguage());
        }*/
        
        SortPanelController spc = new SortPanelController();
        
        /*ArrayList<Movie> moviesSorted =spc.byTitle(fpc.bySize(movies, 50)); 
        for (int i = 0; i < moviesSorted.size(); i++) {
            Log.e(moviesSorted.get(i).getTitle());
        }*/
        
        /*ArrayList<Movie> moviesSorted =spc.byBudget(fpc.bySize(movies, 50)); 
        for (int i = 0; i < moviesSorted.size(); i++) {
            Log.e(moviesSorted.get(i).getTitle()+ " "+ moviesSorted.get(i).getBudget());
        }*/
        
        //Log.e(movies.get(0).getActors().get(0));
        
        
        //1. Create the frame.
        JFrame frame = new JFrame("Movies Open Datas by Harp-e");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //final JFreeChart barChart = ChartFactory.createBarChart("Movies", "Movie", "Value (in $)", dataset, VERTICAL, true, true, false);
        //final ChartPanel cPanel = new ChartPanel(barChart);
        
        MovieListView movieListView = new MovieListView();
        JPanel movieListPanel = movieListView.createViewPanel();
        TitledBorder moviesTitle;
        moviesTitle = BorderFactory.createTitledBorder("Movies");
        movieListPanel.setBorder(moviesTitle);
        

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        //Left panel
        JPanel leftPanel = new JPanel();
        TitledBorder filterTitle;
        filterTitle = BorderFactory.createTitledBorder("Filters and sort");
        leftPanel.setBorder(filterTitle);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Test1");
        comboBox.addItem("Test2");
        leftPanel.add(comboBox);
        
        
        
        //Right Panel
//        JPanel rightPanel = new JPanel();
//        JLabel rightLabel = new JLabel("Right Panel");
//        rightPanel.add(rightLabel);
        MovieInfoController movieInfoController = new MovieInfoController();
        JPanel rightPanel = movieInfoController.initView();
        TitledBorder infoTitle;
        infoTitle = BorderFactory.createTitledBorder("Informations");
        rightPanel.setBorder(infoTitle);
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);
        topPanel.add(movieListPanel, BorderLayout.CENTER);
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        
        
        JPanel middlePanel = new JPanel();
        SpiderChartView spiderChartView = new SpiderChartView();
        middlePanel.add(spiderChartView.initView());
        frame.getContentPane().add(middlePanel, BorderLayout.CENTER);
        
        BarChartView barChartView = new BarChartView();
        middlePanel.add(barChartView.initView());
        
        JPanel bottomPanel = new JPanel();
        GlobalChart globalChartView = new GlobalChart();
        bottomPanel.add(globalChartView.initView());
        
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true); 
        //ArrayList<Movie> movies = new ArrayList<>();
        //FilterController.filter(10,SortController.byTitle(movies));
    
    }
    
    

}
