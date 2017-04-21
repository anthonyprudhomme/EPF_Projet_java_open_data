/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moviedatas.Controller.FilterController;
import moviedatas.Controller.MovieListController;
import moviedatas.Model.Movie;

/**
 *
 * @author anthony
 */
public class FilterPanelView {
//    public Pair<boolean, int> sizeF = new Pair<>();
    
    private FilterController filterPC = new FilterController();
    private ArrayList< Pair<String, ArrayList<String>> > filters = new ArrayList<>();
    
    public JPanel createFilterPanel() {
        // Create the global panel with all filters
        JPanel filterPanel = new JPanel();
        // The components of the panel are place verticaly
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.PAGE_AXIS));
        
        // Create the label of the panel
        JLabel labelPanel = new JLabel("Filters");
        
        // Resize the panel in order not to be too large
        filterPanel.setPreferredSize(new Dimension(250,700));
        
        // Create all buttons and filter
        JComboBox comboSize = comboSize();
        JComboCheckBox comboGenre = comboGenre();
        JPanel searchBarDir = searchDirector();
        JPanel searchBarAct = searchActor();
        JComboCheckBox comboCountries = comboCountry();
        JComboCheckBox comboLanguages = comboLanguage();
        JPanel colorPanel = createColorPanel();
        JComboCheckBox comboKeywords = comboKeyword();
        
        // Add all components at the panel
        filterPanel.add(labelPanel);
        filterPanel.add(comboSize);
        filterPanel.add(comboGenre);
        filterPanel.add(searchBarDir);
        filterPanel.add(searchBarAct);
        filterPanel.add(comboCountries);
        filterPanel.add(comboLanguages);
        filterPanel.add(comboKeywords);
        filterPanel.add(colorPanel);
        
        // Add listener for each ComboBox
        comboGenre.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                JComboCheckBox currentItem = (JComboCheckBox) e.getSource();
                addGlobalInformations("Genre",currentItem.getSelectedValues());
            }
        });
        comboCountries.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                JComboCheckBox currentItem = (JComboCheckBox) e.getSource();
                addGlobalInformations("Country",currentItem.getSelectedValues());
            }
        });
        comboLanguages.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                JComboCheckBox currentItem = (JComboCheckBox) e.getSource();
                addGlobalInformations("Language",currentItem.getSelectedValues());
            }
        });
        comboKeywords.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                JComboCheckBox currentItem = (JComboCheckBox) e.getSource();
                addGlobalInformations("Keywords",currentItem.getSelectedValues());
            }
        });
        
        comboSize.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                JComboBox currentItem = (JComboBox) e.getSource();
                ArrayList<String> size = new ArrayList<>();
                size.add((String)currentItem.getSelectedItem());
                addGlobalInformations("Size",size);
            }
        });
        
        // Return the global panel
        return filterPanel;
    }
    
    private JComboBox comboSize() {
        JComboBox comboSize = new JComboBox();
        comboSize.addItem("-- Size of list --"); // If it's this, all movies
        comboSize.addItem("1");
        comboSize.addItem("10");
        comboSize.addItem("50");
        comboSize.addItem("100");
        comboSize.addItem("200");
        
        return comboSize;
    }
    
    private JComboCheckBox comboGenre() {
        // Recupe all genres of MovieListController
        ArrayList<String> genres = MovieListController.allGenres;
        JComboCheckBox comboGenre = new JComboCheckBox();
        
        // Create a CheckBox in the ComboBox for each genre
        comboGenre.addItem("-- Genre --");
        for (int i = 1; i < genres.size(); i++) {
            comboGenre.addItem( new JCheckBox(genres.get(i)) );
        }
        
        // Return the ComboBox
        return comboGenre;
    }
    
    private JPanel searchDirector() {
        JPanel directorPanel = new JPanel();
        // Resize the panel in order not to be too large
        directorPanel.setPreferredSize(new Dimension(200,75));
        
        // Create the search bar with a text which can be hide
        HintTextField searchBar = new HintTextField("Search a director");
        searchBar.setPreferredSize(new Dimension(200,50));
        
        // Add the search bar at the panel
        directorPanel.add(searchBar);
        
        // Return the panel
        return directorPanel;
    }
    
    private JPanel searchActor() {
        JPanel actorPanel = new JPanel();
        // Resize the panel in order not to be too large
        actorPanel.setPreferredSize(new Dimension(200,75));
        
        // Create the search bar with a text which can be hide
        HintTextField searchBar = new HintTextField("Search an actor");
        searchBar.setPreferredSize(new Dimension(200,50));
        
        // Add the search bar at the panel
        actorPanel.add(searchBar);
        
        // Return the panel
        return actorPanel;
    }
    
    private JComboCheckBox comboCountry() {
        // Recupe all countries of MovieListController
        ArrayList<String> countries = MovieListController.allCountries;
        JComboCheckBox comboCountries = new JComboCheckBox();
        
        // Create a CheckBox in the ComboBox for each country
        comboCountries.addItem("-- Country --");
        for (int i = 1; i < countries.size(); i++) {
            comboCountries.addItem( new JCheckBox(countries.get(i)) );
        }
        
        // Return the ComboBox
        return comboCountries;
    }
    
    private JComboCheckBox comboLanguage() {
        // Recupe all languages of MovieListController
        ArrayList<String> languages = MovieListController.allLanguages;
        JComboCheckBox comboLanguages = new JComboCheckBox();
        
        // Create a CheckBox in the ComboBox for each language
        comboLanguages.addItem("-- Language --");
        for (int i = 1; i < languages.size(); i++) {
            comboLanguages.addItem( new JCheckBox(languages.get(i)) );
        }
        
        // Return the ComboBox
        return comboLanguages;
    }
    
    private JPanel createColorPanel() {
        // Create the panel
        JPanel colorPanel = new JPanel();
        
        // Create 2 CheckBox for color & no color
        JCheckBox color = new JCheckBox("Color");
        JCheckBox noColor = new JCheckBox("B&W");
        
//        color.addActionListener (new ActionListener () {
//            public void actionPerformed(ActionEvent e) {
//                JCheckBox currentItem = (JCheckBox) e.getSource();
//                addGlobalInformations("Color",(String)Boolean.toString(currentItem.isSelected()));
//            }
//        });
//        
//        noColor.addActionListener (new ActionListener () {
//            public void actionPerformed(ActionEvent e) {
//                JCheckBox currentItem = (JCheckBox) e.getSource();
//                addGlobalInformations("Color",(String)Boolean.toString(currentItem.isSelected()));
//            }
//        });
        
        // Add the 2 CheckBox at the panel
        colorPanel.add(color);
        colorPanel.add(noColor);
        
        
        
        // Return the panel
        return colorPanel;
    }
    
    private JComboCheckBox comboKeyword() {
        // Recupe all keywords of MovieListController
        ArrayList<String> keywords = MovieListController.allKeywords;
        JComboCheckBox comboKeywords = new JComboCheckBox();
        
        // Create a CheckBox in the ComboBox for each keyword
        comboKeywords.addItem("-- Keywords --");
        for (int i = 1; i < keywords.size(); i++) {
            comboKeywords.addItem( new JCheckBox(keywords.get(i)) );
        }
        
        // Return the ComboBox
        return comboKeywords;
    }
    
    private void addGlobalInformations(String nameFilter, ArrayList<String> value) {        
        Pair<String, ArrayList<String>> newFilter = new Pair<>(nameFilter, value);
        filters.add(newFilter);
        ArrayList<Movie> filteredMovies = filterPC.listFilter(filters);
        MovieListView.observer.updateMovieList(filteredMovies);
    }
}
