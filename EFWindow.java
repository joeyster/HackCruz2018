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
	private JTextField bsLocation;

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
		beneficialSequence.setBounds(15, 89, 544, 47);
		contentPane.add(beneficialSequence);
		beneficialSequence.setColumns(10);
		beneficialSequence.setLineWrap(true);
		
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
		deathChance.setBounds(234, 246, 86, 20);
		contentPane.add(deathChance);
		deathChance.setColumns(10);
		
		introTime = new JTextField();
		introTime.setBounds(234, 217, 86, 20);
		contentPane.add(introTime);
		introTime.setColumns(10);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnvironmentalFactor ef = new EnvironmentalFactor(beneficialSequence.getText(), deathBS.getText(), reproductiveBS.getText(), bsLocation.getText(), introTime.getText(), deathChance.getText(), reproductiveChance.getText());				
				String[] firstInputs = mwc.getArray();
				String[] secondInputs = ef.getArray();
				String[] both = new String[firstInputs.length+secondInputs.length];
				for(int i = 0; i < firstInputs.length; i++) {
					both[i] = firstInputs[i];
				}
				int j = 0;
				for(int i = firstInputs.length; i < secondInputs.length; i++) {
					both[i] = secondInputs[j];
					j++;
				}
				Application.launch(TestGraph.class, both);
			}
		});
		nextButton.setBounds(475, 302, 89, 23);
		contentPane.add(nextButton);
		
		JLabel lblReproductiveChance = new JLabel("Reproductive Chance:");
		lblReproductiveChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReproductiveChance.setBounds(15, 273, 164, 20);
		contentPane.add(lblReproductiveChance);
		
		reproductiveChance = new JTextField();
		reproductiveChance.setColumns(10);
		reproductiveChance.setBounds(234, 277, 86, 20);
		contentPane.add(reproductiveChance);
		
		JLabel lblBsReproductiveChance = new JLabel("BS Reproductive Chance:");
		lblBsReproductiveChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBsReproductiveChance.setBounds(259, 147, 199, 20);
		contentPane.add(lblBsReproductiveChance);
		
		reproductiveBS = new JTextField();
		reproductiveBS.setColumns(10);
		reproductiveBS.setBounds(473, 149, 86, 20);
		contentPane.add(reproductiveBS);
		
		deathBS = new JTextField();
		deathBS.setColumns(10);
		deathBS.setBounds(151, 147, 86, 20);
		contentPane.add(deathBS);
		
		JLabel lblBsDeathChance = new JLabel("BS Death Chance:");
		lblBsDeathChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBsDeathChance.setBounds(20, 148, 164, 14);
		contentPane.add(lblBsDeathChance);
		
		bsLocation = new JTextField();
		bsLocation.setColumns(10);
		bsLocation.setBounds(151, 174, 86, 20);
		contentPane.add(bsLocation);
		
		JLabel lblBsLocation = new JLabel("BS Location:");
		lblBsLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBsLocation.setBounds(20, 175, 164, 14);
		contentPane.add(lblBsLocation);
	}
}