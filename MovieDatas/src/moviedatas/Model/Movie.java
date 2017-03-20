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
    String genre;
    int duration;
    Director director;
    ArrayList<Actor> actors;
    double score;
    int gross;
    int budget;
    String country;
    String language;
    boolean colored;
    String linkToInformation;
    ArrayList<String> plotKeywords;
    
    public Movie(String title, int releaseYear, String genre, int duration, Director director, ArrayList<Actor> actors, double score, int gross, int budget, String country, String language, boolean colored, String linkToInformation, ArrayList<String> plotKeywords) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.actors = actors;
        this.score = score;
        this.gross = gross;
        this.budget = budget;
        this.country = country;
        this.language = language;
        this.colored = colored;
        this.linkToInformation = linkToInformation;
        this.plotKeywords = plotKeywords;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public double getScore() {
        return score;
    }

    public int getGross() {
        return gross;
    }

    public int getBudget() {
        return budget;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isColored() {
        return colored;
    }

    public String getLinkToInformation() {
        return linkToInformation;
    }

    public ArrayList<String> getPlotKeywords() {
        return plotKeywords;
    }
}
