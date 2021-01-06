package snakeandladder;


import Questions.A1;
import Questions.A2;
import Questions.A3;
import Questions.A4;
import Questions.A5;
import Questions.A6;
import Questions.A7;
import Questions.Q1;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//1 Player 1 RED
//2 Player 2 BLACK
//3 Player 3 WHITE
//Snake's Head DARK_GRAY
//Snake's Tail CYAN
//Ladder's Start ORANGE
//Ladder's End YELLOW

public class SnakeAndLadder extends JFrame {

	public JPanel contentPane;
	private player nameFrame;
	public static GridPanel gridPanel;
	public SidePanel sidePanel;
	public JButton btn;
	public JLabel lblMessage, lblTurn, lblGot;
	public static int snakes[][], ladders[][];
	public String name1, question;
	public int N, currentPlayer;
	public int pos1;
	private String winner;
	private int winnersteps;
	private static Random generator;
	public static int dimension = 10;
	public static int Nsnakes, Nladders;
	private int steps1 = 0;
	final static Color snakehead = Color.DARK_GRAY, snaketail = Color.CYAN,
			ladderstart = Color.MAGENTA, ladderend = Color.PINK;
	static Color oddCell = Color.WHITE, evenCell = Color.WHITE;
	private JMenu mnAboutMe;
	private JMenuItem mntmNewMenuItem;
        
        

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeAndLadder frame = new SnakeAndLadder();
					frame.setInitial();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SnakeAndLadder() throws InterruptedException {
		setResizable(false);
		setForeground(Color.BLACK);
		setBackground(Color.YELLOW);
		setTitle("Snake and Ladder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		generator = new Random();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                reinitialise();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SnakeAndLadder.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		mnNewMenu.add(mntmNewGame);

		

		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mntmInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Instructions is = new Instructions();
			is.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmInstructions);
		
		mnAboutMe = new JMenu("About");
		menuBar.add(mnAboutMe);
		
		mntmNewMenuItem = new JMenuItem("About Me");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutMe obj = new AboutMe();
				obj.setVisible(true);
			}
		});
		mnAboutMe.add(mntmNewMenuItem);
				
		gridPanel = new GridPanel(dimension);
		gridPanel.setBounds(0, 0, 508, 551);
		contentPane.add(gridPanel);

		btn = new JButton("Roll Dice");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				diceRolled();
			}
		});
		btn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btn.setBounds(585, 482, 128, 33);
		contentPane.add(btn);

		sidePanel = new SidePanel();
		sidePanel.setBounds(528, 0, 225, 284);
		contentPane.add(sidePanel);

		lblMessage = new JLabel("Snake at Position 45 got you!!", JLabel.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblMessage.setBounds(518, 295, 285, 33);
		contentPane.add(lblMessage);


		lblGot = new JLabel("", JLabel.CENTER);
		lblGot.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblGot.setBounds(585, 425, 145, 17);
		contentPane.add(lblGot);

		setLocationRelativeTo(null);

		setVisible(false);
		nameFrame = new player(this);
		nameFrame.setVisible(true);
	}

	public void diceRolled() {
		lblMessage.setText("");
		int total = dimension * dimension;
		int jump = generator.nextInt(6) + 1;// 1 to 6   
		lblGot.setText("You got " + jump);
		if (currentPlayer == 1) {
			steps1++;
			sidePanel.setScore(steps1);
			int newposition = pos1 + jump;
                        
			if (newposition == total) {
				JOptionPane.showMessageDialog(null, "Congratulations " + name1
						+ "!! You have won the game in  " + steps1 + " steps");
				btn.setEnabled(false);
				winner = name1;
				winnersteps = steps1;
			}

			for (int i = 0; i < Nsnakes; ++i) {
				if (snakes[i][0] == newposition) {
					lblMessage.setText("Snake at board position " + newposition
							+ " got you!!");
					newposition = snakes[i][1];
					break;
				}
			}
			for (int i = 0; i < Nladders; ++i) {
				if (ladders[i][0] == newposition) {
					lblMessage.setText("You are up through ladder at position "
							+ newposition + " !");
					newposition = ladders[i][1];
					if (newposition == total) {// Ladder directly to win.
						JOptionPane.showMessageDialog(null, "Congratulations "
								+ name1 + "!! You have won the game in  "
								+ steps1 + " steps");
						btn.setEnabled(false);
						winner = name1;
						winnersteps = steps1;
					}
					break;
				}
			}

			if (newposition > total) {
				lblMessage.setText("You need " + (total - pos1) + " to win!!");
				newposition = pos1;
			}

			gridPanel.grid[newposition].setBackground(Color.RED);
			if (newposition != pos1 )// Get the original colour of the cell
			{
				if (pos1 % 2 == 1)
					gridPanel.grid[pos1].setBackground(oddCell);
				else
					gridPanel.grid[pos1].setBackground(evenCell);
			} 
			pos1 = newposition;
                                                                    
                        //here is when the player arrive to the question position and he has to answer it                                                   
                        switch(newposition){
                            case 7: 
                                A1 a1 = new A1();                                    
                                a1.setVisible(true); 
                                break;
                            case 23:
                                A2 a2 = new A2();                                    
                                a2.setVisible(true);
                                break;
                            case 36:
                                A3 a3 = new A3();                                    
                                a3.setVisible(true);
                                break;
                            case 48:
                                A4 a4 = new A4();                                    
                                a4.setVisible(true);
                                break;
                            case 55:
                                A5 a5 = new A5();                                    
                                a5.setVisible(true);
                                break;
                            case 78:
                                A6 a6 = new A6();                                    
                                a6.setVisible(true);
                                break;
                            case 94:
                                A7 a7 = new A7();                                    
                                a7.setVisible(true);
                                break;                            
                            default:
                                break;
                        }
             }
        }
        
	public void reinitialise() throws InterruptedException {
		// TODO Auto-generated method stub

		setVisible(false);
		nameFrame = new player(this);
		nameFrame.setVisible(true);
                
		pos1=0;
		steps1=0;

		gridPanel.setVisible(false);
		gridPanel = new GridPanel(dimension);
		gridPanel.setBounds(0, 0, 508, 551);
		contentPane.add(gridPanel);

		setPositions();

		sidePanel.setVisible(false);
		sidePanel = new SidePanel();
		sidePanel.setBounds(528, 0, 225, 284);
		contentPane.add(sidePanel);

		
	}

	public static void setInitial() {
		// TODO Auto-generated method stub
		snakes = new int[8][2];// Maximum no. of snakes
		ladders = new int[8][2];// Maximum no. of ladders
                
		Nsnakes = 8;
		Nladders = 8;
		// Setting default position of snakes and ladders
		snakes[0][0] = 17;
		snakes[0][1] = 7;
                
		snakes[1][0] = 54;
		snakes[1][1] = 34;
                
		snakes[2][0] = 62;
		snakes[2][1] = 19; 
                
		snakes[3][0] = 64;
		snakes[3][1] = 60; 
                
		snakes[4][0] = 87;
		snakes[4][1] = 36;
                 
		snakes[5][0] = 93;
		snakes[5][1] = 73;
                 
		snakes[6][0] = 95;
		snakes[6][1] = 75;
                 
		snakes[7][0] = 98;
		snakes[7][1] = 79;
                
                
		ladders[0][0] = 1;
		ladders[0][1] = 38;
                
		ladders[1][0] = 4;
		ladders[1][1] = 14;
                
		ladders[2][0] = 9;
		ladders[2][1] = 31;
                
		ladders[3][0] = 21;
		ladders[3][1] = 42;
                
		ladders[4][0] = 28;
		ladders[4][1] = 84;
                
		ladders[5][0] = 51;
		ladders[5][1] = 67;
                
		ladders[6][0] = 72;
		ladders[6][1] = 91;
		
		ladders[7][0] = 80;
		ladders[7][1] = 99;
	
		setPositions();
                

                
	}

	public static void setPositions() {

		for (int i = 0; i < Nsnakes; ++i) {
			gridPanel.grid[snakes[i][0]].setBackground(snakehead);
			gridPanel.grid[snakes[i][1]].setBackground(snaketail);

		}
		for (int i = 0; i < Nladders; ++i) {
			gridPanel.grid[ladders[i][0]].setBackground(ladderstart);
			gridPanel.grid[ladders[i][1]].setBackground(ladderend);

		}

	}
}