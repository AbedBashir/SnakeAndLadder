/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

/**
 *
 * @author abedb
 */
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Timer;
import java.util.TimerTask;


public class SidePanel extends JPanel {
	private final JTextField score;
	private JTextField cTimer;
	public JLabel player, Time;

	/**
	 * Create the panel.
	 */
	public SidePanel() throws InterruptedException {
		setLayout(null);
		
		player = new JLabel("Player ");
		player.setFont(new Font("Times New Roman", Font.BOLD, 16));
		player.setBounds(44, 35, 85, 32);
		add(player);
		
		
		score = new JTextField();
		score.setEditable(false);
		score.setBounds(139, 43, 38, 20);
		add(score);
		score.setColumns(10);
                
                Time = new JLabel("Timer: ");
                Time.setVisible(true);
                Time.setFont(new Font("Times New Roman", Font.BOLD, 16));
                Time.setBounds(44, 150, 85, 32);
                add(Time);
               
                
                cTimer = new JTextField("00:00");
		cTimer.setEditable(false);
		cTimer.setBounds(139, 152, 80, 25);
		add(cTimer);
		cTimer.setColumns(10);
                cTimer.setVisible(true);
                
                        
        }
	
	
	public void setScore(int x){
            score.setText(""+x);	
        }
       
}
              

  


