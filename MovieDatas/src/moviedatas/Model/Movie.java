/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package moviedatas.Model;

import java.util.ArrayList;

/**
 *
 * @author anthony
 */
public class Movie {
    String title;
    int releaseYear;
    ArrayList<String> genres;
    int duration;
    int directorId;
    ArrayList<Integer> actorsId;
    double score;
    long gross;
    long budget;
    String country;
    String language;
    boolean colored;
    String linkToInformation;
    ArrayList<String> plotKeywords;
    int fbLikes;
    
    public Movie(String title, int releaseYear, ArrayList<String> genres, int duration, int directorId, ArrayList<Integer> actorsId, double score, long gross, long budget, String country, String language, boolean colored, String linkToInformation, ArrayList<String> plotKeywords,int fbLikes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.duration = duration;
        this.directorId = directorId;
        this.actorsId = actorsId;
        this.score = score;
        this.gross = gross;
        this.budget = budget;
        this.country = country;
        this.language = language;
        this.colored = colored;
        this.linkToInformation = linkToInformation;
        this.plotKeywords = plotKeywords;
        this.fbLikes = fbLikes;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getReleaseYear() {
        return releaseYear;
    }
    
    public ArrayList<String> getGenres() {
        return this.genres;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    private int getDirectorId() {
        return this.directorId;
    }
    
    private ArrayList<Integer> getActorsId() {
        return this.actorsId;
    }
    
    public ArrayList<Actor> getActors(){
        // 
        ArrayList<Actor> actors = new ArrayList<>();
        for (int i = 0; i < this.actorsId.size(); i++) {
            actors.add(Actor.actors.get(this.actorsId.get(i)));
        }
        return actors;
    }
    
    public double getScore() {
        return this.score;
    }
    
    public long getGross() {
        return this.gross;
    }
    
    public long getBudget() {
        return this.budget;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public String getLanguage() {
        return this.language;
    }
    
    public boolean isColored() {
        return this.colored;
    }
    
    public String getLinkToInformation() {
        return this.linkToInformation;
    }
    
    public ArrayList<String> getPlotKeywords() {
        return this.plotKeywords;
    }
    
    public int getFbLikes(){
        return this.fbLikes;
    }
    
    @Override
    public String toString(){
        return this.title + " "+ this.releaseYear + " "+ this.genres + " "+this.duration + " DirecId "+
                this.directorId + " ActId "+ this.actorsId.size() + " "+ this.score + " "+
                this.gross + " "+ this.budget + " " + this.country + " "+this.language+ " "+ this.colored + " "+
                this.linkToInformation + " "+ this.plotKeywords + " " + this.fbLikes;
    }

    public Director getDirector() {
        return Director.directors.get(this.directorId);
    }
}
