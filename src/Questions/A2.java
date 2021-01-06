/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import javax.swing.JFrame;

/**
 *
 * @author abedb
 */
public class A2 extends JFrame{ 
    // Driver code. 
    public A2() 
            
     { // Creating object of demo class. 
        this.setLayout(null); 

        Q2 q = new Q2(); 
  
        // Setting Bounds of JFrame. 
        q.setBounds(100, 100, 400, 200); 
  
        // Setting Title of frame. 
        q.setTitle("Question"); 
  
        // Setting Visible status of frame as true. 
        q.setVisible(true); 
    } 

} 
