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
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;


public class player extends JFrame {

	public JPanel contentPane ,panel ,panel1, panel2;
	public JTextField playerName;
	public JButton rdbtn;
	public JButton btnDone;
	public final ButtonGroup Group = new ButtonGroup();
	public SnakeAndLadder frame;
	public String pName;

		/**
	 * Create the frame.
     * @param mf
	 */
	public player(SnakeAndLadder mf) {
		setTitle("Snake and Ladder");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frame=mf;
		
		btnDone = new JButton("Done");	

		btnDone.addActionListener((ActionEvent e) -> {
                    pName = playerName.getText();
                    
                    if(rdbtn.isSelected() && (pName.isEmpty()))
                        JOptionPane.showMessageDialog(null, "Empty Fields" ,"Error!!" ,JOptionPane.ERROR_MESSAGE);
                    else
                    {
                       
                        frame.sidePanel.player.setText(pName);
                        frame.name1 =pName;
                        frame.pos1 =1;
                        frame.sidePanel.setScore(0);
                        frame.currentPlayer =1;
                        frame.N =1;
                       
                        
                        
                        
                        frame.lblMessage.setText("");
                        frame.setVisible(true);
                        dispose();
                        JOptionPane.showMessageDialog(null, pName +" your colour is RED!!");
                        frame.gridPanel.grid[1].setBackground(Color.RED);
                        
                    }
                });
                
		btnDone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnDone.setBounds(157, 228, 89, 23);
		btnDone.setVisible(false);
		contentPane.add(btnDone);

		
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setBounds(0, 84, 434, 81);
		panel1.setVisible(false);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 176, 424, 41);
		panel2.setVisible(false);
		contentPane.add(panel2);
		panel2.setLayout(null);		
		
		JLabel label = new JLabel("Enter Your Name", SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(115, 7, 196, 32);
		panel.add(label);
		
		rdbtn = new JButton("START");
		Group.add(rdbtn);
		rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			panel1.setVisible(true);
			btnDone.setVisible(true);
			}
		});
		rdbtn.setBounds(50, 49, 160, 23);
		panel.add(rdbtn);
		
		
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPlayer.setBounds(94, 11, 67, 22);
		panel1.add(lblPlayer);
		
		
		playerName = new JTextField();
		playerName.setBounds(232, 14, 86, 20);
		panel1.add(playerName);
		playerName.setColumns(10);
                
	}
        
}