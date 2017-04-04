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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moviedatas.Controller.FilterPanelController;
import moviedatas.Controller.MovieListController;
import moviedatas.Controller.SortPanelController;
import moviedatas.Model.Actor;
import moviedatas.Model.Director;
import moviedatas.Model.Movie;
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
        ArrayList<Movie> movies = movieListController.getMovies();
        //Log.e(movies.size());
        //Log.e(movies.get(1));
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
        
        ArrayList<Movie> moviesSorted =spc.byBudget(fpc.bySize(movies, 50)); 
        for (int i = 0; i < moviesSorted.size(); i++) {
            Log.e(moviesSorted.get(i).getTitle()+ " "+ moviesSorted.get(i).getBudget());
        }
        
        //Log.e(movies.get(0).getActors().get(0));
        
        /*
        //1. Create the frame.
        JFrame frame = new JFrame("Movies Open Datas by Harp-e");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<JLabel> labels = new ArrayList();
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < movies.size(); i++) {
            labels.add(new JLabel( movies.get(i).getTitle()));
            moviePanel.add(labels.get(i));
        }
        JScrollPane scrollPanel = new JScrollPane(moviePanel);

        //3. Create components and put them in the frame.
        //...create emptyLabel...
        frame.getContentPane().add(scrollPanel, BorderLayout.CENTER);

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true); 
        //ArrayList<Movie> movies = new ArrayList<>();
        //FilterController.filter(10,SortController.byTitle(movies));

        */
    
    }

}
