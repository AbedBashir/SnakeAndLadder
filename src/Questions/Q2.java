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
public class Q2 extends JFrame{
            public JRadioButton answer1,answer2,answer3;
            public JButton qbtn;
            public JLabel lblquestion;
            public ButtonGroup g1;
            
           public Q2(){
                                    this.setLayout(null); 
                                    answer1 = new JRadioButton(); 
                                    answer2 = new JRadioButton();
                                    answer3 = new JRadioButton();
                                    qbtn = new JButton("Submit"); 
                                    g1 = new ButtonGroup(); 
                                    lblquestion = new JLabel("How Long Is The Eiffel Tower?"); 
                                    answer1.setText("1063 ft");  
                                    answer2.setText("1065 ft"); 
                                    answer3.setText("1070 ft");                                   
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
                                                                    qual = "1063 ft";
                                                                    JOptionPane.showMessageDialog(null, "CORRECT");                                                                   
                                                                } 
                                                                else if (answer2.isSelected()) { 
                                                                    qual = "1065 ft"; 
                                                                    JOptionPane.showMessageDialog(null, "WRONG");                                          
                                                                } 
                                                                else if (answer3.isSelected()){ 
                                                                    qual = "1070 ft"; 
                                                                    JOptionPane.showMessageDialog(null, "WRONG");
                                                                }
                                                        JOptionPane.showMessageDialog(Q2.this, qual); 

                                                            } 
                                                   });
                           } 
}
