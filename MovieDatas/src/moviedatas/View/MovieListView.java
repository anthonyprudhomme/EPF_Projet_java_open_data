/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import moviedatas.Controller.MovieInfoController;
import static moviedatas.Controller.MovieInfoController.observer;
import moviedatas.Controller.MovieInfoControllerInterface;
import moviedatas.Controller.MovieListController;
import moviedatas.Controller.SortControllerInterface;
import moviedatas.Log;
import moviedatas.Model.Movie;

/**
 *
 * @author anthony
 */
public class MovieListView implements SortControllerInterface{
    private MovieListController movieListController = new MovieListController();
    JScrollPane scrollPanel;
    JPanel movieListViewPanel;
    public static SortControllerInterface observer;
    
    
    private void updateListPanel(ArrayList<Movie> movies) {
        ArrayList<JLabel> labels = new ArrayList();
        
        JPanel moviePanel = new JPanel();
        
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.PAGE_AXIS));
        
        for (int i = 0; i < movies.size(); i++) {
            labels.add(new JLabel( movies.get(i).getTitle()));
            labels.get(i).setForeground(Color.blue);
            labels.get(i).addMouseListener(new MouseAdapter() {
                
                
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel currentLabel = (JLabel) e.getSource();
                    Movie selectedMovie = Movie.getMovieFromName(movieListController.getAllMovies(), currentLabel.getText());
                    System.out.println(selectedMovie);
                    MovieInfoController.observer.newMovieSelected(selectedMovie);
                    SpiderChartView.observer.newMovieSelected(selectedMovie);
                    BarChartView.observer.newMovieSelected(selectedMovie);
                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    Font font = ((JLabel) me.getSource()).getFont();
                    Map attributes = font.getAttributes();
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
                    ((JLabel) me.getSource()).setFont(font.deriveFont(attributes)); 
                }
                
                @Override
                public void mouseExited(MouseEvent me) {
                    Font font = ((JLabel) me.getSource()).getFont();
                    Map attributes = font.getAttributes();
                    attributes.put(TextAttribute.UNDERLINE,-1);
                    ((JLabel) me.getSource()).setFont(font.deriveFont(attributes));
                }
            });
            moviePanel.add(labels.get(i));
            
        }
        
        scrollPanel = new JScrollPane(moviePanel);
        scrollPanel.setPreferredSize(new Dimension(150,150));
        
    }

    public JPanel createViewPanel() {
        
        observer = this;
        movieListViewPanel = new JPanel();
<<<<<<< HEAD
//        movieListViewPanel.setPreferredSize(new Dimension(500,500));
//        movieListViewPanel.setMaximumSize(movieListViewPanel.getPreferredSize());
=======
>>>>>>> 7fc801a976ec23d4f3ffbeb811ccb93ae6c98755
        movieListViewPanel.setLayout(new BoxLayout(movieListViewPanel, BoxLayout.PAGE_AXIS));
        
        // Create a panel for the search bar
        JPanel searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(220,100)); // Set the preferred size
        searchPanel.setMaximumSize(searchPanel.getPreferredSize()); // Apply the maximum size
        
        // Create the search bar for movies
        JTextField searchMovie = new HintTextField("Search a movie");
        searchMovie.setPreferredSize(new Dimension(200,75));
        
        // Create a variable with all movie
        movieListController.initMovies();
        ArrayList<Movie> movies = movieListController.getAllMovies();
        
        searchMovie.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (!searchMovie.getText().equals("Search a movie")) {
                    updateListPanel(movieListController.filterByTitle(movies, searchMovie.getText()));
                    movieListViewPanel.remove(1);
                    movieListViewPanel.add(scrollPanel);
                    movieListViewPanel.updateUI();
                }
            }
            
            public void removeUpdate(DocumentEvent e) {
                if (!searchMovie.getText().equals("Search a movie")) {
                    updateListPanel(movieListController.filterByTitle(movies, searchMovie.getText()));
                    movieListViewPanel.remove(1);
                    movieListViewPanel.add(scrollPanel);
                    movieListViewPanel.updateUI();
                }
            }
            
            public void insertUpdate(DocumentEvent e) {
                if (!searchMovie.getText().equals("Search a movie")) {
                    updateListPanel(movieListController.filterByTitle(movies, searchMovie.getText()));
                    movieListViewPanel.remove(1);
                    movieListViewPanel.add(scrollPanel);
                    movieListViewPanel.updateUI();
                }
            }
        });
        updateListPanel(movies);
        
        // Add the search at the panel
        searchPanel.add(searchMovie);
        
        // Add the search bar panel at the global panel
        movieListViewPanel.add(searchPanel);
        movieListViewPanel.add(scrollPanel);
        return movieListViewPanel;
    }
    
    @Override
    public void updateMovieList(ArrayList<Movie> movies) {
        updateListPanel(movies);
        movieListViewPanel.remove(1);
        movieListViewPanel.add(scrollPanel);
        movieListViewPanel.updateUI();
    }
    //Class that override the textField component to add hint to it
    class HintTextField extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;

    public HintTextField(final String hint) {
      super(hint);
      this.hint = hint;
      this.showingHint = true;
      super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
      if(this.getText().isEmpty()) {
        super.setText("");
        showingHint = false;
      }
    }
    @Override
    public void focusLost(FocusEvent e) {
      if(this.getText().isEmpty()) {
        super.setText(hint);
        showingHint = true;
      }
    }

    @Override
    public String getText() {
      return showingHint ? "" : super.getText();
    }
  }
}
