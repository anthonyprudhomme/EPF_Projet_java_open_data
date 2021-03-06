/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javafx.util.Pair;
import moviedatas.Log;
import moviedatas.Model.Actor;
import moviedatas.Model.Movie;
import moviedatas.View.FilterPanelView;

public class FilterController {

    private ArrayList<Movie> bySize(ArrayList<Movie> movies, int size){
        ArrayList<Movie> returnedList;
        returnedList = new ArrayList<>(movies.subList(0, size));
        return returnedList;
    }

    private ArrayList<Movie> byGenre(ArrayList<Movie> movies, ArrayList<String> genres){
        ArrayList<Movie> returnedList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
              ArrayList<String> movieGenres = movies.get(i).getGenres();
              boolean notFound = true;
              for (int j = 0; j < movieGenres.size(); j++) {
                  for (int k = 0; k < genres.size(); k++) {
                      if(movieGenres.get(j).equalsIgnoreCase(genres.get(k)) && notFound){
                          notFound = false;
                          returnedList.add(movies.get(i));
                      }
                  }
              }
        }
        return returnedList;
    }

    private ArrayList<Movie> byDirector(ArrayList<Movie> movies, String directorName){
        ArrayList<Movie> returnedList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getDirector().getName().equalsIgnoreCase(directorName) ){
                returnedList.add(movies.get(i));
            }
        }
        return returnedList;
    }

    private ArrayList<Movie> byActor(ArrayList<Movie> movies, String actorName){
        ArrayList<Movie> returnedList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            ArrayList<Actor> movieActors = movies.get(i).getActors();
            for (int j = 0; j < movieActors.size(); j++) {
                if(movieActors.get(j).getName().equalsIgnoreCase(actorName)){
                    returnedList.add(movies.get(i));
                }
            }
        }
        return returnedList;
    }

    private ArrayList<Movie> byCountry(ArrayList<Movie> movies, ArrayList<String> countries){
        ArrayList<Movie> returnedList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            String country = movies.get(i).getCountry();
            for (int j = 0; j < countries.size(); j++) {
                if(countries.get(j).equalsIgnoreCase(country)){
                    returnedList.add(movies.get(i));
                }
            }
        }
        return returnedList;
    }

    private ArrayList<Movie> byLanguage(ArrayList<Movie> movies, ArrayList<String> languages){
        ArrayList<Movie> returnedList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            String language = movies.get(i).getLanguage();
            for (int j = 0; j < languages.size(); j++) {
                if(languages.get(j).equalsIgnoreCase(language)){
                    returnedList.add(movies.get(i));
                }
            }
        }
        return returnedList;
    }

    private ArrayList<Movie> byColor(ArrayList<Movie> movies, boolean colored){
        ArrayList<Movie> returnedList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).isColored() == colored){
                returnedList.add(movies.get(i));
            }
        }
        return returnedList;
    }

    private ArrayList<Movie> byKeywords(ArrayList<Movie> movies, ArrayList<String> keywords){
        ArrayList<Movie> returnedList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
              ArrayList<String> movieKeywords = movies.get(i).getPlotKeywords();
              boolean notFound = true;
              for (int j = 0; j < movieKeywords.size(); j++) {
                  for (int k = 0; k < keywords.size(); k++) {
                      if(movieKeywords.get(j).equalsIgnoreCase(keywords.get(k)) && notFound){
                          notFound = false;
                          returnedList.add(movies.get(i));
                      }
                  }
              }
        }
        return returnedList;
    }
    
    public ArrayList<Movie> listFilter(ArrayList<Pair<String, ArrayList<String>>> filters) {
        ArrayList<Movie> filteredMovies = MovieListController.allMovies;
        int nbSize = 0;
        boolean sizeActive = false;
        
        for (int i=0; i < filters.size(); i++) {
            switch (filters.get(i).getKey()) {
                case "Size":
                    if ( (!filters.get(i).getValue().get(0).equalsIgnoreCase("-- Size of list --"))
                            && (!filters.get(i).getValue().get(0).equalsIgnoreCase("All")) ) {
//                        filteredMovies = this.bySize(filteredMovies,
//                                Integer.parseInt(filters.get(i).getValue().get(0)));
                        nbSize = Integer.parseInt(filters.get(i).getValue().get(0));
                        sizeActive = true;
                    } else {
                        // Do nothing because we don't have a filter
                    }
                    break;
                case "Genre":
                    if(!filters.get(i).getValue().get(0).equalsIgnoreCase("All")){
                        filteredMovies = this.byGenre(filteredMovies,
                            filters.get(i).getValue());
                    } else {
                        // Do nothing because we don't have a filter
                    }
                    break;
                case "Country":
                    if(!filters.get(i).getValue().get(0).equalsIgnoreCase("All")){
                        Log.e("Filter value: " + filters.get(i).getValue());
                        filteredMovies = this.byCountry(filteredMovies,
                                filters.get(i).getValue());
                    } else {
                        // Do nothing because we don't have a filter
                    }
                    break;

                case "Language" :
                    if(!filters.get(i).getValue().get(0).equalsIgnoreCase("All")){
                        filteredMovies = this.byLanguage(filteredMovies,
                                filters.get(i).getValue());
                    } else {
                        // Do nothing because we don't have a filter
                    }
                    break;

                case "Keywords" :
                    if(!filters.get(i).getValue().get(0).equalsIgnoreCase("All")){
                        filteredMovies = this.byKeywords(filteredMovies,
                                filters.get(i).getValue());
                    } else {
                        // Do nothing because we don't have a filter
                    }
                    break;

                case "Color" :
                    boolean colored = true;
                    if(filters.get(i).getValue().get(0).equalsIgnoreCase("1")){
                        colored = true;
                    }else{
                        colored = false;
                    }
                    filteredMovies = this.byColor(filteredMovies, colored);
                    break;

                case "Actor" :
                    if(!filters.get(i).getValue().get(0).equalsIgnoreCase("All")){
                        filteredMovies = this.byActor(filteredMovies,
                                filters.get(i).getValue().get(0));
                    } else {
                        // Do nothing because we don't have a filter
                    }
                    break;

                case "Director" :
                    if(!filters.get(i).getValue().get(0).equalsIgnoreCase("All")){
                        filteredMovies = this.byDirector(filteredMovies,
                                filters.get(i).getValue().get(0));
                    } else {
                        // Do nothing because we don't have a filter
                    }
                    break;
            }
        }
        
        if (sizeActive) {
            filteredMovies = this.bySize(filteredMovies, nbSize);
        }
        
        return filteredMovies;
    }
}
