/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moviedatas.Model.Movie;

/**
 *
 * @author anthony
 */
public class MovieListView {
    public JScrollPane createListPanel(ArrayList<Movie> movies) {
        ArrayList<JLabel> labels = new ArrayList();
        
        JPanel moviePanel = new JPanel();
        
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.PAGE_AXIS));
        
        for (int i = 0; i < movies.size(); i++) {
            labels.add(new JLabel( movies.get(i).getTitle()));
            moviePanel.add(labels.get(i));
        }
        
        JScrollPane scrollPanel = new JScrollPane(moviePanel);
        scrollPanel.setPreferredSize(new Dimension(150,500));
        
        return scrollPanel;
    }

    public JPanel createLabelPanel() {
        JPanel labelPanel = new JPanel();
        
        JLabel namePanel = new JLabel("Movie List");
        
        labelPanel.add(namePanel);
        
        return labelPanel;
    }
}
