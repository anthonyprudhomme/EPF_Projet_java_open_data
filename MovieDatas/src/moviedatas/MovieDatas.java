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
import moviedatas.Controller.FilterController;
import javax.swing.border.TitledBorder;
import moviedatas.Controller.MovieInfoController;
import moviedatas.Controller.MovieInfoControllerInterface;
import moviedatas.Controller.MovieListController;
import moviedatas.Controller.SortController;
import moviedatas.Model.Actor;
import moviedatas.Model.Director;
import moviedatas.Model.Movie;
import moviedatas.View.FilterPanelView;
import moviedatas.View.MovieListView;
import moviedatas.View.MovieInfoView;
import moviedatas.View.SortPanelView;
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

public class MovieDatas{

    public static void main(String[] args) {
        FilterController fpc = new FilterController();
        
        SortController spc = new SortController();        
        
//1. Create the frame.
        JFrame frame = new JFrame("Movies Open Datas by Harp-e");
        frame.setPreferredSize(new Dimension(1280,800));

//2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MovieListView movieListView = new MovieListView();
        JPanel movieListPanel = movieListView.createViewPanel();
        TitledBorder moviesTitle;
        moviesTitle = BorderFactory.createTitledBorder("Movies");
        movieListPanel.setBorder(moviesTitle);
        
//3. Create components and put them in the frame.
        //----------------------------------------------------------------------
        // Sort & Filter panel (right)
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
        // Movie Info Panel (left)
        //----------------------------------------------------------------------
        MovieInfoController movieInfoController = new MovieInfoController();
        JPanel movieInfoView = movieInfoController.initView();
        TitledBorder infoTitle;
        infoTitle = BorderFactory.createTitledBorder("Informations");
        movieInfoView.setBorder(infoTitle);
        //----------------------------------------------------------------------
        // Movie List Panel (middle)
        //----------------------------------------------------------------------   
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setPreferredSize(new Dimension(1280,400));
        listPanel.add(sortFilterPanel, BorderLayout.WEST);
        listPanel.add(movieInfoView, BorderLayout.EAST);
        listPanel.add(movieListPanel, BorderLayout.CENTER);
        frame.getContentPane().add(listPanel, BorderLayout.NORTH);
        //----------------------------------------------------------------------
        // Charts Panel (bottom)
        //----------------------------------------------------------------------
        JPanel chartPanel = new JPanel();
        
        // Spider chart Panel
        //______________________________________________________________________
        // Create the panel
        JPanel spiderPanel = new JPanel(); 
        // Create the view
        SpiderChartView spiderChartView = new SpiderChartView();
        // Create a tilte
        TitledBorder spiderTitle;
        // Put a border around the title
        spiderTitle = BorderFactory.createTitledBorder("Spider chart");
        // Put the border on the panel
        spiderPanel.setBorder(spiderTitle);
        // Put the view on the panel
        spiderPanel.add(spiderChartView.initView());
        // Put the spider panel on the global panel
        chartPanel.add(spiderPanel);
        //______________________________________________________________________
        
        // Bar chart Panel
        //______________________________________________________________________
        JPanel barPanel = new JPanel();
        BarChartView barChartView = new BarChartView();
        TitledBorder barTitle;
        barTitle = BorderFactory.createTitledBorder("Bar chart");
        barPanel.setBorder(barTitle);
        barPanel.add(barChartView.initView());
        chartPanel.add(barPanel);
        //______________________________________________________________________
        
        // Global chart Panel
        //______________________________________________________________________
        JPanel globalChartPanel = new JPanel();
        GlobalChart globalChartView = new GlobalChart();
        TitledBorder globalTitle;
        globalTitle = BorderFactory.createTitledBorder("Global chart");
        globalChartPanel.setBorder(globalTitle);
        globalChartPanel.add(globalChartView.initView());
        chartPanel.add(globalChartPanel);
        //______________________________________________________________________
        
        frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
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
