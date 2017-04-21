/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import moviedatas.Controller.FilterController;
import moviedatas.Controller.MovieListController;
import moviedatas.Controller.SortController;
import moviedatas.Model.Actor;
import moviedatas.Model.Director;
import moviedatas.Model.Movie;
import moviedatas.View.FilterPanelView;
import moviedatas.View.MovieListView;
import moviedatas.View.MovieInfoView;
import moviedatas.View.SortPanelView;
//import moviedatas.View.ArchimedesSpiral;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTick;
import static org.jfree.chart.plot.PlotOrientation.VERTICAL;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author anthony
 */
public class MovieDatas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MovieListController movieListController = new MovieListController();
        movieListController.initMovies();
        ArrayList<Movie> movies = movieListController.getAllMovies();
        //Log.e(movies.size());
        //Log.e(movies.get(1));
        FilterController fpc = new FilterController();
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
        
        SortController spc = new SortController();
        
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
        
        /*ArrayList<JLabel> labels = new ArrayList();
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < movies.size(); i++) {
            labels.add(new JLabel( movies.get(i).getTitle()));
            moviePanel.add(labels.get(i));
        }
        JScrollPane scrollPanel = new JScrollPane(moviePanel);*/
        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i <= 0; i++) {
                dataset.addValue(movies.get(i).getBudget(), "Budget", new Integer(i));
        }

        for (int i = 0; i <= 0; i++) {
                dataset.addValue(movies.get(i).getGross(), "Gross", new Integer(i));
        }
        
        //final JFreeChart barChart = ChartFactory.createBarChart("Movies", "Movie", "Value (in $)", dataset, VERTICAL, true, true, false);
        //final ChartPanel cPanel = new ChartPanel(barChart);
        
        /*
        final XYSeriesCollection data = new XYSeriesCollection();
        final XYSeries series1 = new XYSeries("Movie");
                for (double theta = 0.0; theta < 360.0; theta += 72) {
            final double radius = theta;
            series1.add(theta, radius);
        }
        //final XYSeries series2 = createRandomData("Series 2", 50.0, 5.0);
        //final XYSeries series3 = createRandomData("Series 3", 25.0, 1.0);
        data.addSeries(series1);
        //data.addSeries(series2);
        //data.addSeries(series3);
        
        final JFreeChart polarChart = ChartFactory.createPolarChart("Other chart", data, true, true, true);
        PolarPlot polarPlot = (PolarPlot) polarChart.getPlot();
        polarPlot.setAngleLabelsVisible(false);
        final ChartPanel cPanel = new ChartPanel(polarChart);
            PolarPlot myPlot = new PolarPlot() {
                protected List refreshAngleTicks() {
                List ticks = new ArrayList();
                ticks.add (new NumberTick (0, "12AM", TextAnchor.CENTER, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (30, "2AM", TextAnchor.TOP_LEFT, TextAnchor.TOP_RIGHT, 0));
                ticks.add (new NumberTick (60, "4AM", TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (90, "6AM", TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (120, "8AM", TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (150, "10AM", TextAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (180, "12PM", TextAnchor.CENTER, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (210, "2PM", TextAnchor.TOP_RIGHT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (240, "4PM", TextAnchor.TOP_RIGHT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (270, "6PM", TextAnchor.TOP_RIGHT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (300, "8PM", TextAnchor.TOP_RIGHT, TextAnchor.TOP_LEFT, 0));
                ticks.add (new NumberTick (330, "10PM", TextAnchor.TOP_RIGHT, TextAnchor.TOP_LEFT, 0));

                return ticks;
            }
        };
        DefaultPolarItemRenderer renderer = new DefaultPolarItemRenderer();
        renderer.setSeriesFilled(0, true); */
        
       
        //ArchimedesSpiral as = new ArchimedesSpiral("Radar");
        //as.pack();
        //as.setVisible(true);

//3. Create components and put them in the frame.
        //----------------------------------------------------------------------
        // Sort & Filter panel
        //----------------------------------------------------------------------
        SortPanelView sortFilterView = new SortPanelView();
        FilterPanelView filterPanelView = new FilterPanelView();
        
        JPanel sortPanel = sortFilterView.createSortPanel();
        JPanel filterPanel = filterPanelView.createFilterPanel();
        JPanel sortFilterPanel = new JPanel();
        
        sortFilterPanel.setLayout(new BoxLayout(sortFilterPanel, BoxLayout.PAGE_AXIS));
        
        sortFilterPanel.add(sortPanel);
        sortFilterPanel.add(filterPanel);
        
        frame.getContentPane().add(sortFilterPanel, BorderLayout.WEST);
        //----------------------------------------------------------------------
        // Movie List Panel
        //----------------------------------------------------------------------
        MovieListView listView = new MovieListView();
        
        JPanel labelPanel = listView.createLabelPanel();
        JScrollPane scrollListPanel = listView.createListPanel(movies);
        
        JPanel globalPanel = new JPanel();
        
        globalPanel.setLayout(new BoxLayout(globalPanel, BoxLayout.PAGE_AXIS));
        
        globalPanel.add(labelPanel);
        globalPanel.add(scrollListPanel);
        
        frame.getContentPane().add(globalPanel,BorderLayout.CENTER);
        //----------------------------------------------------------------------
        // Movie Info Panel
        //----------------------------------------------------------------------
        MovieInfoView infoView = new MovieInfoView();
        
        JPanel infoPanel = infoView.createInfoPanel();
        
        frame.getContentPane().add(infoPanel, BorderLayout.EAST);
        //----------------------------------------------------------------------

//4. Size the frame.
        frame.pack();

//5. Show it.
        frame.setVisible(true); 
        //ArrayList<Movie> movies = new ArrayList<>();
        //FilterController.filter(10,SortController.byTitle(movies));
    
    }

    public JPanel createGlobalPanel() {
        SortPanelView sortFilterView = new SortPanelView();
        FilterPanelView filterPanelView = new FilterPanelView();
        
        JPanel sortPanel = sortFilterView.createSortPanel();
        JPanel filterPanel = filterPanelView.createFilterPanel();
        JPanel globalPanel = new JPanel();
        
        globalPanel.setLayout(new BoxLayout(globalPanel, BoxLayout.PAGE_AXIS));
        
        globalPanel.add(sortPanel);
        globalPanel.add(filterPanel);
        
        return globalPanel;
    }
    
}
