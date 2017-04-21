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
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import moviedatas.Controller.MovieInfoController;
import static moviedatas.Controller.MovieInfoController.observer;
import moviedatas.Controller.MovieInfoControllerInterface;
import moviedatas.Controller.MovieListController;
import moviedatas.Log;
import moviedatas.Model.Movie;

/**
 *
 * @author anthony
 */
public class MovieListView {
    
    private MovieListController movieListController = new MovieListController();
    JScrollPane scrollPanel;
    
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
                    Movie selectedMovie = Movie.getMovieFromName(movieListController.getMovies(), currentLabel.getText());
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
        
        JPanel movieListViewPanel = new JPanel();
        movieListViewPanel.setLayout(new BoxLayout(movieListViewPanel, BoxLayout.PAGE_AXIS));
        
        JTextField searchMovie = new HintTextField("Search a movie");
        movieListController.initMovies();
        ArrayList<Movie> movies = movieListController.getMovies();
        searchMovie.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateListPanel(movieListController.filterByTitle(movies, searchMovie.getText()));
                movieListViewPanel.remove(2);
                movieListViewPanel.add(scrollPanel);
                movieListViewPanel.updateUI();
            }
            public void removeUpdate(DocumentEvent e) {
                updateListPanel(movieListController.filterByTitle(movies, searchMovie.getText()));
                movieListViewPanel.remove(2);
                movieListViewPanel.add(scrollPanel);
                movieListViewPanel.updateUI();
            }
            public void insertUpdate(DocumentEvent e) {
                updateListPanel(movieListController.filterByTitle(movies, searchMovie.getText()));
                movieListViewPanel.remove(2);
                movieListViewPanel.add(scrollPanel);
                movieListViewPanel.updateUI();
            }
        });
        searchMovie.setPreferredSize(new Dimension(50,50));
        updateListPanel(movies);
        
        movieListViewPanel.add(searchMovie);
        movieListViewPanel.add(scrollPanel);
        return movieListViewPanel;
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
