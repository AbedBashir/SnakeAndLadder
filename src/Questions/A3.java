package Questions;

import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abedb
 */
public class A3 extends JFrame{ 
    // Driver code. 
    public A3() 
            
     { // Creating object of demo class. 
                                             this.setLayout(null); 

        Q3 q = new Q3(); 
  
        // Setting Bounds of JFrame. 
        q.setBounds(100, 100, 400, 200); 
  
        // Setting Title of frame. 
        q.setTitle("Question"); 
  
        // Setting Visible status of frame as true. 
        q.setVisible(true); 
    } 

} 