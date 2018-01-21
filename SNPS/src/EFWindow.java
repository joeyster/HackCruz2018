import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.application.Application;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class EFWindow extends JFrame {

	private JPanel contentPane;
	private JTextArea beneficialSequence;
	private JTextField deathChance;
	private JTextField introTime;
	private JTextField reproductiveChance;
	private JTextField reproductiveBS;
	private JTextField deathBS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EFWindow frame = new EFWindow(null);
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
	public EFWindow(MWConnector mwc) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEF = new JLabel("Environmental Factor");
		lblEF.setBounds(15, 19, 316, 29);
		lblEF.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblEF);
		
		JLabel lblBeneficialSequence = new JLabel("Beneficial Sequence (BS):");
		lblBeneficialSequence.setBounds(15, 59, 365, 20);
		lblBeneficialSequence.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblBeneficialSequence);
		
		beneficialSequence = new JTextArea();
		beneficialSequence.setText("AAAAAA");
		beneficialSequence.setBounds(15, 89, 544, 47);
		contentPane.add(beneficialSequence);
		beneficialSequence.setColumns(10);
		beneficialSequence.setLineWrap(true);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String randomHundred = "";
				Random rng = new Random();
				for(int i = 0; i < 5; i++) {
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
				beneficialSequence.setText(randomHundred);
			}
		});
		btnRandom.setBounds(470, 60, 89, 23);
		contentPane.add(btnRandom);
		
		JLabel lblTimeFrameseconds = new JLabel("Death Chance:");
		lblTimeFrameseconds.setBounds(15, 247, 164, 14);
		lblTimeFrameseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblTimeFrameseconds);
		
		JLabel lblUpdateIntervalseconds = new JLabel("Introduction time (seconds):");
		lblUpdateIntervalseconds.setBounds(15, 215, 214, 20);
		lblUpdateIntervalseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblUpdateIntervalseconds);
		
		deathChance = new JTextField();
		deathChance.setText("1");
		deathChance.setBounds(234, 246, 86, 20);
		contentPane.add(deathChance);
		deathChance.setColumns(10);
		
		introTime = new JTextField();
		introTime.setText("15");
		introTime.setBounds(234, 217, 86, 20);
		contentPane.add(introTime);
		introTime.setColumns(10);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnvironmentalFactor ef = new EnvironmentalFactor(beneficialSequence.getText(), deathBS.getText(), reproductiveBS.getText(), introTime.getText(), deathChance.getText(), reproductiveChance.getText());				
				String[] firstInputs = mwc.getArray();
				String[] secondInputs = ef.getArray();
				String[] both = new String[firstInputs.length+secondInputs.length];
				for(int i = 0; i < firstInputs.length; i++) {
					both[i] = firstInputs[i];
				}
				int j = 0;
				for(int i = firstInputs.length; j < secondInputs.length; i++) {
					both[i] = secondInputs[j];
					j++;
				}
				
				if(beneficialSequence.getText().equals("") ||  
						deathChance.getText().equals("") ||  
						introTime.getText().equals("") ||  
						reproductiveChance.getText().equals("") ||  
						reproductiveBS.getText().equals("") ||  
						deathBS.getText().equals("")) {
							EmptyError ee = new EmptyError();
							ee.setVisible(true);
				}
				else if(!beneficialSequence.getText().matches("[ATCG]*")) {
						CellSeqError cse = new CellSeqError();
						cse.setVisible(true);
				}
				else if(!deathChance.getText().matches("[.0-9]*") || 
						!introTime.getText().matches("[.0-9]*") ||  
						!reproductiveChance.getText().matches("[.0-9]*") ||  
						!reproductiveBS.getText().matches("[.0-9]*") ||  
						!deathBS.getText().matches("[.0-9]*")) {
							IntegerOnlyError ioe = new IntegerOnlyError();
							ioe.setVisible(true);
				}
				else if (Double.parseDouble(introTime.getText()) >= Double.parseDouble(firstInputs[1])) {
					IntroductionError iee = new IntroductionError();
					iee.setVisible(true);
				}
				else if (Double.parseDouble(deathChance.getText()) > 1.0 || Double.parseDouble(deathChance.getText()) < 0.0 || 
						Double.parseDouble(reproductiveChance.getText()) > 1.0 || Double.parseDouble(reproductiveChance.getText()) < 0.0 || 
						Double.parseDouble(reproductiveBS.getText()) > 1.0 || Double.parseDouble(reproductiveBS.getText()) < 0.0 || 
						Double.parseDouble(deathBS.getText()) > 1.0 || Double.parseDouble(deathBS.getText()) < 0.0) {
							BetweenZeroAndOne bzao = new BetweenZeroAndOne();
							bzao.setVisible(true);
							System.out.println(Double.parseDouble(introTime.getText()));
							System.out.println(Double.parseDouble(firstInputs[1]));
							
				}
				else {
					dispose();
					Application.launch(TestGraph.class, both);
				}							
			}
		});
		nextButton.setBounds(475, 302, 89, 23);
		contentPane.add(nextButton);
		
		JLabel lblReproductiveChance = new JLabel("Reproductive Chance:");
		lblReproductiveChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReproductiveChance.setBounds(15, 273, 164, 20);
		contentPane.add(lblReproductiveChance);
		
		reproductiveChance = new JTextField();
		reproductiveChance.setText("0.5");
		reproductiveChance.setColumns(10);
		reproductiveChance.setBounds(234, 277, 86, 20);
		contentPane.add(reproductiveChance);
		
		JLabel lblBsReproductiveChance = new JLabel("BS Reproductive Chance:");
		lblBsReproductiveChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBsReproductiveChance.setBounds(259, 147, 199, 20);
		contentPane.add(lblBsReproductiveChance);
		
		reproductiveBS = new JTextField();
		reproductiveBS.setText("0.9");
		reproductiveBS.setColumns(10);
		reproductiveBS.setBounds(473, 149, 86, 20);
		contentPane.add(reproductiveBS);
		
		deathBS = new JTextField();
		deathBS.setText("0.1");
		deathBS.setColumns(10);
		deathBS.setBounds(151, 147, 86, 20);
		contentPane.add(deathBS);
		
		JLabel lblBsDeathChance = new JLabel("BS Death Chance:");
		lblBsDeathChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBsDeathChance.setBounds(20, 148, 164, 14);
		contentPane.add(lblBsDeathChance);
	}
}