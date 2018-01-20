import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldG;
	private JTextField textFieldT;
	private JTextField textFieldC;
	private JTextArea cellSequence;
	private JTextField timeFrame;
	private JTextField updateInterval;
	private JTextField factorAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel StarterBacteria = new JLabel("Starter Bacteria");
		StarterBacteria.setBounds(15, 19, 316, 29);
		StarterBacteria.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(StarterBacteria);
		
		JLabel lblCellSequence = new JLabel("Cell Sequence (Valid characters are A,T,G,C):");
		lblCellSequence.setToolTipText("");
		lblCellSequence.setBounds(15, 79, 402, 20);
		lblCellSequence.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCellSequence);
		
		JLabel mutationRate = new JLabel("Mutation Rate (0-1, 4 decimal places):");
		mutationRate.setBounds(15, 167, 316, 20);
		mutationRate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(mutationRate);
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(337, 167, 11, 20);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblA);
		
		JLabel lblT = new JLabel("T");
		lblT.setBounds(454, 167, 10, 20);
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblT);
		
		JLabel lblG = new JLabel("G");
		lblG.setBounds(337, 192, 11, 20);
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblG);
		
		JLabel lblC = new JLabel("C");
		lblC.setBounds(454, 192, 10, 20);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblC);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(358, 169, 86, 20);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldG = new JTextField();
		textFieldG.setBounds(358, 194, 86, 20);
		contentPane.add(textFieldG);
		textFieldG.setColumns(10);
		
		textFieldT = new JTextField();
		textFieldT.setBounds(473, 169, 86, 20);
		contentPane.add(textFieldT);
		textFieldT.setColumns(10);
		
		textFieldC = new JTextField();
		textFieldC.setBounds(473, 194, 86, 20);
		contentPane.add(textFieldC);
		textFieldC.setColumns(10);
		
		cellSequence = new JTextArea();
	
		cellSequence.setBounds(15, 109, 544, 47);
		contentPane.add(cellSequence);
		cellSequence.setColumns(10);
		cellSequence.setLineWrap(true);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String randomHundred = "";
				Random rng = new Random();
				for(int i = 0; i < 100; i++) {
					int randomInt = rng.nextInt(4);
					switch(randomInt) {
						case 0: randomHundred += "A";
								break;
						case 1: randomHundred += "T";
								break;
						case 2: randomHundred += "C";
								break;
						case 3: randomHundred += "G";
								break;
					}
				}
				cellSequence.setText(randomHundred);
			}
		});
		btnRandom.setBounds(470, 80, 89, 23);
		contentPane.add(btnRandom);
		
		JLabel lblTimeFrameseconds = new JLabel("Time Frame (seconds):");
		lblTimeFrameseconds.setBounds(15, 222, 164, 14);
		lblTimeFrameseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblTimeFrameseconds);
		
		JLabel lblUpdateIntervalseconds = new JLabel("Update Interval (seconds):");
		lblUpdateIntervalseconds.setBounds(15, 247, 188, 20);
		lblUpdateIntervalseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblUpdateIntervalseconds);
		
		timeFrame = new JTextField();
		timeFrame.setBounds(221, 221, 86, 20);
		contentPane.add(timeFrame);
		timeFrame.setColumns(10);
		
		updateInterval = new JTextField();
		updateInterval.setBounds(221, 247, 86, 20);
		contentPane.add(updateInterval);
		updateInterval.setColumns(10);
		
		JLabel lblHowManyEnvironment = new JLabel("How many environment factors?");
		lblHowManyEnvironment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHowManyEnvironment.setBounds(15, 285, 235, 20);
		contentPane.add(lblHowManyEnvironment);
		
		factorAmount = new JTextField();
		factorAmount.setBounds(260, 287, 86, 20);
		contentPane.add(factorAmount);
		factorAmount.setColumns(10);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EFWindow efw = new EFWindow();
				efw.setVisible(true);
			}
		});
		nextButton.setBounds(475, 302, 89, 23);
		contentPane.add(nextButton);
	}
}