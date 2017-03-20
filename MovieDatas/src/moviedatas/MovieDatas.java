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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Hello world");
        String everything;
        BufferedReader br = new BufferedReader(new FileReader("./src/moviedatas/MovieDatas.json"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }
        
        JSONArray movieDatas = (JSONArray) JSONValue.parse(everything);
        JSONObject movie = (JSONObject) movieDatas.get(1);
        System.out.println(movie);
        System.out.println(movie.get("movie_title"));
        //1. Create the frame.
        JFrame frame = new JFrame("FrameDemo");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel myLabel = new JLabel(movie.get("movie_title").toString());
        ArrayList<JLabel> labels = new ArrayList();
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < movieDatas.size(); i++) {
            labels.add(new JLabel(((JSONObject) movieDatas.get(i)).get("movie_title").toString()));
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
