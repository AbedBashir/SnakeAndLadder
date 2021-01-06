/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author abedb
 */
public class Q5 extends JFrame{
            public JRadioButton answer1,answer2,answer3;
            public JButton qbtn;
            public JLabel lblquestion;
            public ButtonGroup g1;
            
           public Q5(){
                                    this.setLayout(null); 
                                    answer1 = new JRadioButton(); 
                                    answer2 = new JRadioButton();
                                    answer3 = new JRadioButton();
                                    qbtn = new JButton("Submit"); 
                                    g1 = new ButtonGroup(); 
                                    lblquestion = new JLabel("Which one is faster?"); 
                                    answer1.setText("Array");  
                                    answer2.setText("Stack"); 
                                    answer3.setText("Queue");                                   
                                    answer1.setBounds(120, 30, 120, 50); 
                                    answer2.setBounds(250, 30, 80, 50); 
                                    answer3.setBounds(370, 30, 120, 50);
                                    qbtn.setBounds(125, 90, 80, 30); 
                                    lblquestion.setBounds(0, 0, 150, 150); 
                                    this.add(answer1); 
                                    this.add(answer2); 
                                    this.add(answer3);
                                    this.add(qbtn); 
                                    this.add(lblquestion); 
                                    g1.add(answer1); 
                                    g1.add(answer2); 
                                    g1.add(answer3); 
                                    
                                    qbtn.addActionListener(new ActionListener(){
                                                public void actionPerformed(ActionEvent e){ 
                                                            String qual = " "; 
                                                                if (answer1.isSelected()) { 
                                                                    qual = "Array";
                                                                    JOptionPane.showMessageDialog(null, "CORRECT");                                                                   
                                                                } 
                                                                else if (answer2.isSelected()) { 
                                                                    qual = "Stack"; 
                                                                    JOptionPane.showMessageDialog(null, "WRONG");                                          
                                                                } 
                                                                else if (answer3.isSelected()){ 
                                                                    qual = "Queue"; 
                                                                    JOptionPane.showMessageDialog(null, "WRONG");
                                                                }
                                                        JOptionPane.showMessageDialog(Q5.this, qual); 

                                                            } 
                                                   });
                           } 
}
