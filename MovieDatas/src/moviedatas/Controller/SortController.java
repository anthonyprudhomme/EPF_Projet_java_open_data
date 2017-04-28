/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.Controller;

import moviedatas.Model.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import moviedatas.Log;
import moviedatas.View.MovieListView;

public class SortController {
    
    public ArrayList<Movie> byTitle(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2){
                return  movie1.getTitle().compareTo(movie2.getTitle());
            }
        });
        return movies;
    }
    
    public ArrayList<Movie> byYear(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2){
                if(movie1.getReleaseYear() > movie2.getReleaseYear()){
                return  -1;
                }
                else{
                    if(movie1.getReleaseYear() < movie2.getReleaseYear()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        return movies;
    }
    
    public ArrayList<Movie> byDuration(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2){
                if(movie1.getDuration() > movie2.getDuration()){
                return  -1;
                }
                else{
                    if(movie1.getDuration() < movie2.getDuration()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        return movies;
    }
    
    public ArrayList<Movie> byScore(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2){
                if(movie1.getScore() > movie2.getScore()){
                return  -1;
                }
                else{
                    if(movie1.getScore() < movie2.getScore()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        return movies;
    }
    
    public ArrayList<Movie> byGross(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2){
                if(movie1.getGross()> movie2.getGross()){
                return  -1;
                }
                else{
                    if(movie1.getGross() < movie2.getGross()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        return movies;
    }
    
    public ArrayList<Movie> byBudget(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2){
                if(movie1.getBudget() > movie2.getBudget()){
                return  -1;
                }
                else{
                    if(movie1.getBudget() < movie2.getBudget()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        return movies;
    }
    
    public ArrayList<Movie> byFbLikes(ArrayList<Movie> movies){
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2){
                if(movie1.getFbLikes()> movie2.getFbLikes()){
                return  -1;
                }
                else{
                    if(movie1.getFbLikes() < movie2.getFbLikes()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        return movies;
    }
    
    public void moviesSort(String type) {
        ArrayList<Movie> moviesSort = MovieListController.allMovies;
        
        switch (type) {
            case "Title":
                moviesSort = byTitle(moviesSort);
                break;
            case "Year":
                moviesSort = byYear(moviesSort);
                break;
            case "Duration":
                moviesSort = byDuration(moviesSort);
                break;
            case "Score":
                moviesSort = byScore(moviesSort);
                break;
            case "Gross":
                moviesSort = byGross(moviesSort);
                break;
            case "Budget":
                moviesSort = byBudget(moviesSort);
                break;
            case "FB":
                moviesSort = byFbLikes(moviesSort);
                break;
        }
        MovieListView.observer.updateMovieList(moviesSort);
    }
    
    public ArrayList<String> sortList() {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Title");
        list.add("Year");
        list.add("Duration");
        list.add("Score");
        list.add("Gross");
        list.add("Budget");
        list.add("Facebook likes");
        
        return list;
    }
}
