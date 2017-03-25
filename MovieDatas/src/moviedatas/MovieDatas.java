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
import moviedatas.Controller.MovieListController;
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
        //1. Create the frame.
        JFrame frame = new JFrame("Harp-e Movies Open Datas");

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
    
    }

}
