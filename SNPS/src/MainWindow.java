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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

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
		setBounds(100, 100, 589, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel StarterBacteria = new JLabel("Single Nucleotide Polymorphism Simulator (SNPS)");
		StarterBacteria.setBounds(15, 19, 533, 29);
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
		textFieldA.setText(".01");
		textFieldA.setBounds(358, 169, 86, 20);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldG = new JTextField();
		textFieldG.setText(".01");
		textFieldG.setBounds(358, 194, 86, 20);
		contentPane.add(textFieldG);
		textFieldG.setColumns(10);
		
		textFieldT = new JTextField();
		textFieldT.setText(".01");
		textFieldT.setBounds(473, 169, 86, 20);
		contentPane.add(textFieldT);
		textFieldT.setColumns(10);
		
		textFieldC = new JTextField();
		textFieldC.setText(".01");
		textFieldC.setBounds(473, 194, 86, 20);
		contentPane.add(textFieldC);
		textFieldC.setColumns(10);
		
		cellSequence = new JTextArea();
		cellSequence.setBounds(15, 109, 544, 47);
		contentPane.add(cellSequence);
		cellSequence.setColumns(10);
		cellSequence.setLineWrap(true);
		
		JButton btnRandom = new JButton("Random");
		//randomizes sequence with 100 nucleotides
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
		lblTimeFrameseconds.setBounds(15, 345, 164, 14);
		lblTimeFrameseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblTimeFrameseconds);
		
		JLabel lblUpdateIntervalseconds = new JLabel("Update Interval (seconds):");
		lblUpdateIntervalseconds.setBounds(15, 370, 188, 20);
		lblUpdateIntervalseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblUpdateIntervalseconds);
		
		timeFrame = new JTextField();
		timeFrame.setText("30");
		timeFrame.setBounds(221, 344, 86, 20);
		contentPane.add(timeFrame);
		timeFrame.setColumns(10);
		
		updateInterval = new JTextField();
		updateInterval.setText("1");
		updateInterval.setBounds(221, 370, 86, 20);
		contentPane.add(updateInterval);
		updateInterval.setColumns(10);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			//checks for invalid inputs. should be better way to do this!
			public void actionPerformed(ActionEvent arg0) {	
				double aTo = Double.parseDouble(textField.getText()) + Double.parseDouble(textField_1.getText()) + Double.parseDouble(textField_2.getText());
				double tTo = Double.parseDouble(textField_3.getText()) + Double.parseDouble(textField_4.getText()) + Double.parseDouble(textField_5.getText());
				double gTo = Double.parseDouble(textField_6.getText()) + Double.parseDouble(textField_7.getText()) + Double.parseDouble(textField_8.getText());
				double cTo = Double.parseDouble(textField_9.getText()) + Double.parseDouble(textField_10.getText()) + Double.parseDouble(textField_11.getText());
				double mutationA = Double.parseDouble(textFieldA.getText());
				double mutationG = Double.parseDouble(textFieldG.getText());
				double mutationT = Double.parseDouble(textFieldT.getText());
				double mutationC = Double.parseDouble(textFieldC.getText());
				if(textFieldA.getText().equals("") ||  
				textFieldG.getText().equals("") ||  
				textFieldT.getText().equals("") ||  
				textFieldC.getText().equals("") ||  
				cellSequence.getText().equals("") ||  
				timeFrame.getText().equals("") ||  
				updateInterval.getText().equals("") ||  
				textField.getText().equals("") ||  
				textField_1.getText().equals("") ||  
				textField_2.getText().equals("") ||  
				textField_3.getText().equals("") ||  
				textField_4.getText().equals("") ||  
				textField_5.getText().equals("") ||  
				textField_6.getText().equals("") ||  
				textField_7.getText().equals("") ||  
				textField_8.getText().equals("") ||  
				textField_9.getText().equals("") ||  
				textField_10.getText().equals("") ||  
				textField_11.getText().equals("")) {
					EmptyError ee = new EmptyError();
					ee.setVisible(true);
				}
				
				else if(!cellSequence.getText().matches("[ATCG]*")) {
					CellSeqError cse = new CellSeqError();
					cse.setVisible(true);
				}
				
				else if(!textField.getText().matches("[.0-9]*") ||  
				!textField_1.getText().matches("[.0-9]*") ||  
				!textField_2.getText().matches("[.0-9]*") ||  
				!textField_3.getText().matches("[.0-9]*") ||  
				!textField_4.getText().matches("[.0-9]*") ||  
				!textField_5.getText().matches("[.0-9]*") ||  
				!textField_6.getText().matches("[.0-9]*") ||  
				!textField_7.getText().matches("[.0-9]*") ||  
				!textField_8.getText().matches("[.0-9]*") ||  
				!textField_9.getText().matches("[.0-9]*") ||  
				!textField_10.getText().matches("[.0-9]*") ||  
				!textField_11.getText().matches("[.0-9]*")) {
					DecimalOnlyError doe = new DecimalOnlyError();
					doe.setVisible(true);
				}
				else if(aTo != 1.0 || tTo != 1.0 || gTo != 1.0 || cTo != 1.0) {
						EqualHundredError ehe = new EqualHundredError();
						ehe.setVisible(true);
				}
				
				else if(!textFieldA.getText().matches("[.0-9]*") || 
				!textFieldG.getText().matches("[.0-9]*") ||  
				!textFieldT.getText().matches("[.0-9]*") ||  
				!textFieldC.getText().matches("[.0-9]*") ||  
				!timeFrame.getText().matches("[0-9]*") ||  
				!updateInterval.getText().matches("[0-9]*")) {
					IntegerOnlyError ioe = new IntegerOnlyError();
					ioe.setVisible(true);
				} 
			

				else if (mutationA > 1.0 || mutationA < 0.0 || 
				mutationG > 1.0 || mutationG < 0.0 || 
				mutationT > 1.0 || mutationT < 0.0 || 
				mutationC > 1.0 || mutationC < 0.0) {
					BetweenZeroAndOne bzao = new BetweenZeroAndOne();
					bzao.setVisible(true);
				}
				
				
				
				else if(Double.parseDouble(updateInterval.getText()) >= Double.parseDouble(timeFrame.getText())) {
					UpdateIntervalError uie = new UpdateIntervalError();
					uie.setVisible(true);
				}
				else {
					MWConnector mwc = new MWConnector(cellSequence.getText(), textFieldA.getText(),  textFieldT.getText(), textFieldG.getText(), textFieldC.getText(), textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText(), textField_8.getText(), textField_9.getText(), textField_10.getText(), textField_11.getText(), timeFrame.getText(), updateInterval.getText());
					EFWindow efw = new EFWindow(mwc);
					efw.setVisible(true);
					dispose();		
				}
			}
		});
		nextButton.setBounds(470, 377, 89, 23);
		contentPane.add(nextButton);
		
		JLabel lblAMutationTo = new JLabel("A Mutation To:");
		lblAMutationTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAMutationTo.setBounds(15, 230, 107, 20);
		contentPane.add(lblAMutationTo);
		
		JLabel lblT_1 = new JLabel("T");
		lblT_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblT_1.setBounds(153, 228, 11, 20);
		contentPane.add(lblT_1);
		
		textField = new JTextField();
		textField.setText(".33");
		textField.setColumns(10);
		textField.setBounds(174, 230, 86, 20);
		contentPane.add(textField);
		
		JLabel lblG_1 = new JLabel("G");
		lblG_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblG_1.setBounds(270, 228, 18, 20);
		contentPane.add(lblG_1);
		
		textField_1 = new JTextField();
		textField_1.setText(".33");
		textField_1.setColumns(10);
		textField_1.setBounds(289, 230, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblC_1 = new JLabel("C");
		lblC_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblC_1.setBounds(385, 228, 11, 20);
		contentPane.add(lblC_1);
		
		textField_2 = new JTextField();
		textField_2.setText(".34");
		textField_2.setColumns(10);
		textField_2.setBounds(406, 230, 86, 20);
		contentPane.add(textField_2);
		
		JLabel lblTMutationTo = new JLabel("T Mutation To:");
		lblTMutationTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTMutationTo.setBounds(15, 257, 107, 20);
		contentPane.add(lblTMutationTo);
		
		JLabel label_4 = new JLabel("A");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(153, 255, 11, 20);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setText(".33");
		textField_3.setColumns(10);
		textField_3.setBounds(174, 257, 86, 20);
		contentPane.add(textField_3);
		
		JLabel lblG_2 = new JLabel("G");
		lblG_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblG_2.setBounds(270, 255, 18, 20);
		contentPane.add(lblG_2);
		
		textField_4 = new JTextField();
		textField_4.setText(".33");
		textField_4.setColumns(10);
		textField_4.setBounds(289, 257, 86, 20);
		contentPane.add(textField_4);
		
		JLabel lblC_2 = new JLabel("C");
		lblC_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblC_2.setBounds(385, 255, 11, 20);
		contentPane.add(lblC_2);
		
		textField_5 = new JTextField();
		textField_5.setText(".34");
		textField_5.setColumns(10);
		textField_5.setBounds(406, 257, 86, 20);
		contentPane.add(textField_5);
		
		JLabel lblGMutationTo = new JLabel("G Mutation To:");
		lblGMutationTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGMutationTo.setBounds(15, 285, 107, 20);
		contentPane.add(lblGMutationTo);
		
		JLabel label_8 = new JLabel("A");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(153, 283, 11, 20);
		contentPane.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setText(".33");
		textField_6.setColumns(10);
		textField_6.setBounds(174, 285, 86, 20);
		contentPane.add(textField_6);
		
		JLabel label_9 = new JLabel("T");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_9.setBounds(270, 283, 10, 20);
		contentPane.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setText(".33");
		textField_7.setColumns(10);
		textField_7.setBounds(289, 285, 86, 20);
		contentPane.add(textField_7);
		
		JLabel lblC_3 = new JLabel("C");
		lblC_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblC_3.setBounds(385, 283, 11, 20);
		contentPane.add(lblC_3);
		
		textField_8 = new JTextField();
		textField_8.setText(".34");
		textField_8.setColumns(10);
		textField_8.setBounds(406, 285, 86, 20);
		contentPane.add(textField_8);
		
		JLabel lblCMutationTo = new JLabel("C Mutation To:");
		lblCMutationTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCMutationTo.setBounds(15, 313, 107, 20);
		contentPane.add(lblCMutationTo);
		
		JLabel label_12 = new JLabel("A");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_12.setBounds(153, 311, 11, 20);
		contentPane.add(label_12);
		
		textField_9 = new JTextField();
		textField_9.setText(".33");
		textField_9.setColumns(10);
		textField_9.setBounds(174, 313, 86, 20);
		contentPane.add(textField_9);
		
		JLabel label_13 = new JLabel("T");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_13.setBounds(270, 311, 10, 20);
		contentPane.add(label_13);
		
		textField_10 = new JTextField();
		textField_10.setText(".33");
		textField_10.setColumns(10);
		textField_10.setBounds(289, 313, 86, 20);
		contentPane.add(textField_10);
		
		JLabel lblG_3 = new JLabel("G");
		lblG_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblG_3.setBounds(385, 311, 11, 20);
		contentPane.add(lblG_3);
		
		textField_11 = new JTextField();
		textField_11.setText(".34");
		textField_11.setColumns(10);
		textField_11.setBounds(406, 313, 86, 20);
		contentPane.add(textField_11);
	}
}