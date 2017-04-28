/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moviedatas.Model.Movie;

/**
 *
 * @author anthony
 */
public class MovieInfoView {    
    
    private JPanel infoPanel;
    public JPanel createViewPanel() {
        //Panel that will contain the informations about the movie and the title of the section
        JPanel movieInfoPanel = new JPanel();
        movieInfoPanel.setLayout(new BoxLayout(movieInfoPanel, BoxLayout.PAGE_AXIS));
        //Panel that will contain the informations about the movie
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
        
        //Adding those panels to the main panel
        movieInfoPanel.add(infoPanel);
        
        return movieInfoPanel;        
    }
    
    public JPanel getInfoPanel(){
        return infoPanel;
    }
    
    public void updateInformations(JPanel infoPanel, Movie movie){
        if(infoPanel.getComponents().length == 0){
            if(movie!= null){
                //Filling every JLabel with movie informations
                JLabel movieTitle = new JLabel("► Title : "+ movie.getTitle());
                JLabel realeaseYear = new JLabel("► Release year : "+ movie.getReleaseYear());
                String genres = "";
                int nbGenresToShow = movie.getGenres().size();
                if(nbGenresToShow > 3){
                    nbGenresToShow = 3;
                }
                for (int i = 0; i < nbGenresToShow; i++) {
                    genres = genres +" "+ movie.getGenres().get(i);
                }
                JLabel genre = new JLabel("► Genre : "+ genres);
                JLabel duration = new JLabel("► Duration : "+ movie.getDuration());
                JLabel director = new JLabel("► Director : "+ movie.getDirector().getName());
                String actors = "";
                ArrayList<JLabel> labels = new ArrayList<>();
                for (int i = 0; i < movie.getActors().size(); i++) {
                    labels.add(new JLabel(" - "+movie.getActors().get(i).getName()));
                }
                JLabel actor = new JLabel("► Actors : ");
                JLabel score = new JLabel("► Score : "+ movie.getScore());
                JLabel gross = new JLabel("► Gross : "+ movie.getGross());
                JLabel budget = new JLabel("► Budget : "+ movie.getBudget());
                JLabel country = new JLabel("► Country : "+ movie.getCountry());
                JLabel language = new JLabel("► Language : "+ movie.getLanguage());
                String isColored = "Yes";
                if(!movie.isColored()){
                    isColored = "No";
                }
                JLabel colored = new JLabel("► Colored : "+isColored);
                JLabel fbLikes = new JLabel("► Facebook Likes : "+ movie.getFbLikes());
//                JLabel linkToInformations = new JLabel("► Link to information : "+ movie.getLinkToInformation());
//                String keywordStr = "";
//                for (int i = 0; i < movie.getPlotKeywords().size(); i++) {
//                    keywordStr = keywordStr +" "+ movie.getPlotKeywords().get(i);
//                }
//                JLabel keywords = new JLabel("► Keywords : "+ keywordStr);

                //Adding JLabel with informations to JPanel containing those informations
                infoPanel.add(movieTitle);
                infoPanel.add(realeaseYear);
                infoPanel.add(genre);
                infoPanel.add(duration);
                infoPanel.add(director);
                infoPanel.add(actor);
                for (int i = 0; i < labels.size(); i++) {
                    infoPanel.add(labels.get(i));
                }
                infoPanel.add(score);
                infoPanel.add(gross);
                infoPanel.add(budget);
                infoPanel.add(country);
                infoPanel.add(language);
                infoPanel.add(colored);
                infoPanel.add(fbLikes);
//                infoPanel.add(linkToInformations);
//                infoPanel.add(keywords);
            }
        }else{
            ((JLabel)infoPanel.getComponents()[0]).setText("► Title : "+ movie.getTitle());
            ((JLabel)infoPanel.getComponents()[1]).setText("► Release year : "+ movie.getReleaseYear());
            String genres = "";
            int nbGenresToShow = movie.getGenres().size();
            if(nbGenresToShow > 3){
                nbGenresToShow = 3;
            }
            for (int i = 0; i < nbGenresToShow; i++) {
                genres = genres +" "+ movie.getGenres().get(i);
            }
            ((JLabel)infoPanel.getComponents()[2]).setText("► Genre : "+ genres);
            ((JLabel)infoPanel.getComponents()[3]).setText("► Duration : "+ movie.getDuration());
            ((JLabel)infoPanel.getComponents()[4]).setText("► Director : "+ movie.getDirector().getName());
            String actors = "";
            for (int i = 0; i < movie.getActors().size(); i++) {
                if(i == 0){
                    actors = movie.getActors().get(i).getName();
                }else{
                    actors = actors +" - "+ movie.getActors().get(i).getName();
                }
            }
            ((JLabel)infoPanel.getComponents()[5]).setText("► Actors : ");
            int offset = movie.getActors().size();
            switch (movie.getActors().size()) {
                case 3:
                    ((JLabel)infoPanel.getComponents()[6]).setText(" - "+ movie.getActors().get(0).getName());
                    ((JLabel)infoPanel.getComponents()[7]).setText(" - "+ movie.getActors().get(1).getName());
                    ((JLabel)infoPanel.getComponents()[8]).setText(" - "+ movie.getActors().get(2).getName());
                    break;
                case 2:
                    ((JLabel)infoPanel.getComponents()[6]).setText(" - "+ movie.getActors().get(0).getName());
                    ((JLabel)infoPanel.getComponents()[7]).setText(" - "+ movie.getActors().get(1).getName());
                    break;
                case 1:
                    ((JLabel)infoPanel.getComponents()[6]).setText(" - "+ movie.getActors().get(0).getName());
                    break;
                default:
                    break;
            }
            
            ((JLabel)infoPanel.getComponents()[6+offset]).setText("► Score : "+ movie.getScore());
            ((JLabel)infoPanel.getComponents()[7+offset]).setText("► Gross : "+ movie.getGross());
            ((JLabel)infoPanel.getComponents()[8+offset]).setText("► Budget : "+ movie.getBudget());
            ((JLabel)infoPanel.getComponents()[9+offset]).setText("► Country : "+ movie.getCountry());
            ((JLabel)infoPanel.getComponents()[10+offset]).setText("► Language : "+ movie.getLanguage());
            String isColored = "Yes";
            if(!movie.isColored()){
                isColored = "No";
            }
            ((JLabel)infoPanel.getComponents()[11+offset]).setText("► Colored : "+isColored);
            ((JLabel)infoPanel.getComponents()[12+offset]).setText("► Facebook Likes : "+ movie.getFbLikes());
        }
        infoPanel.updateUI();
    }
}
