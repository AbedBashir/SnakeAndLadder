/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import snakeandladder.Instructions;
import snakeandladder.SnakeAndLadder;




/**
 *
 * @author abedb
 */
public class Q1 extends JFrame{
            private static Random generator;
            public JRadioButton answer1,answer2,answer3;
            public JButton qbtn;
            public JLabel lblquestion;
            public ButtonGroup g1;
            
           
            
           public Q1() throws InterruptedException{
                                    answer1 = new JRadioButton(); 
                                    answer2 = new JRadioButton();
                                    answer3 = new JRadioButton();
                                    qbtn = new JButton("Submit"); 
                                    g1 = new ButtonGroup(); 
                                    lblquestion = new JLabel("What Do We Call The Baby Lion?"); 
                                    answer1.setText("cheetah");  
                                    answer2.setText("cub"); 
                                    answer3.setText("tiger");                                   
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
                                    
                                                SnakeAndLadder snl = new SnakeAndLadder();
                                    
                                    qbtn.addActionListener(new ActionListener(){
                                                public void actionPerformed(ActionEvent e){ 
                                                            String qual = " "; 
                                                                if (answer1.isSelected()) { 
                                                                    qual = "cheetah";
                                                                    JOptionPane.showMessageDialog(null, "WRONG");
                                                                        qbtn.addActionListener(new ActionListener() {
                                                                                public void actionPerformed(ActionEvent arg0) {
                                                                                int jump1 = generator.nextInt(6) + 1;
                                                                                snl.pos1 = snl.pos1 - jump1;
                                                                              }
                                                                        });
                                                                } 
                                                                else if (answer2.isSelected()) { 
                                                                    qual = "cub"; 
                                                                    JOptionPane.showMessageDialog(null, "CORRECT");
                                                                    qbtn.addActionListener(new ActionListener() {
                                                                                public void actionPerformed(ActionEvent arg0) {
                                                                                int jump1 = generator.nextInt(6) + 1;
                                                                                snl.pos1 = snl.pos1 + jump1; }
                                                                        });
                                                                } 
                                                                else if (answer3.isSelected()){ 
                                                                    qual = "tiger"; 
                                                                    JOptionPane.showMessageDialog(null, "WRONG");
                                                                    qbtn.addActionListener(new ActionListener() {
                                                                                public void actionPerformed(ActionEvent arg0) {
                                                                                int jump1 = generator.nextInt(6) + 1;
                                                                                snl.pos1 = snl.pos1 - jump1; }
                                                                        });
                                                                }
                                                        JOptionPane.showMessageDialog(Q1.this, qual); 

                                                            } 
                                                   });
                           } 
}
           
           

