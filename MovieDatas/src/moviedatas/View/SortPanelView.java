/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatas.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import static javafx.beans.binding.Bindings.concat;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moviedatas.Controller.FilterController;
import moviedatas.Controller.MovieListController;
import moviedatas.Controller.SortController;

/**
 *
 * @author anthony
 */
public class SortPanelView {
    private SortController sc = new SortController();
    
    public JPanel createSortPanel() {
        JPanel sortPanel = new JPanel();
        JLabel labelPanel = new JLabel("Sort the list");
        
        sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.PAGE_AXIS));
        
        // comboBox: sortBy
        SortController sortPC = new SortController();
        ArrayList<String> sortList = sortPC.sortList();
        
        JComboBox sortBy = new JComboBox();
        sortBy.addItem("-- Sort by --"); // better if it's not possible to selection this item
        for (int i = 0; i < sortList.size(); i++) {
            sortBy.addItem(sortList.get(i));
        }
        
        sortBy.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                changeSort((String) ((JComboBox)e.getSource()).getSelectedItem() );
            }
        });
        
        sortPanel.add(labelPanel);
        sortPanel.add(sortBy);
        
        return sortPanel;
    }
    
    private void changeSort(String type) {
        sc.moviesSort(type);
    }
}
