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
					EFWindow frame = new EFWindow();
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
	public EFWindow() {
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
		lblBeneficialSequence.setBounds(15, 148, 365, 20);
		lblBeneficialSequence.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblBeneficialSequence);
		
		beneficialSequence = new JTextArea();
		beneficialSequence.setBounds(15, 178, 544, 47);
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
		btnRandom.setBounds(470, 149, 89, 23);
		contentPane.add(btnRandom);
		
		JLabel lblTimeFrameseconds = new JLabel("Death Chance");
		lblTimeFrameseconds.setBounds(15, 91, 164, 14);
		lblTimeFrameseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblTimeFrameseconds);
		
		JLabel lblUpdateIntervalseconds = new JLabel("Introduction time (seconds):");
		lblUpdateIntervalseconds.setBounds(15, 59, 214, 20);
		lblUpdateIntervalseconds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblUpdateIntervalseconds);
		
		deathChance = new JTextField();
		deathChance.setBounds(224, 90, 86, 20);
		contentPane.add(deathChance);
		deathChance.setColumns(10);
		
		introTime = new JTextField();
		introTime.setBounds(224, 59, 86, 20);
		contentPane.add(introTime);
		introTime.setColumns(10);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		nextButton.setBounds(475, 302, 89, 23);
		contentPane.add(nextButton);
		
		JLabel lblReproductiveChance = new JLabel("Reproductive Chance");
		lblReproductiveChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReproductiveChance.setBounds(15, 117, 164, 20);
		contentPane.add(lblReproductiveChance);
		
		reproductiveChance = new JTextField();
		reproductiveChance.setColumns(10);
		reproductiveChance.setBounds(224, 116, 86, 20);
		contentPane.add(reproductiveChance);
		
		JLabel lblBsReproductiveChance = new JLabel("BS Reproductive Chance");
		lblBsReproductiveChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBsReproductiveChance.setBounds(15, 263, 199, 20);
		contentPane.add(lblBsReproductiveChance);
		
		reproductiveBS = new JTextField();
		reproductiveBS.setColumns(10);
		reproductiveBS.setBounds(224, 262, 86, 20);
		contentPane.add(reproductiveBS);
		
		deathBS = new JTextField();
		deathBS.setColumns(10);
		deathBS.setBounds(224, 236, 86, 20);
		contentPane.add(deathBS);
		
		JLabel lblBsDeathChance = new JLabel("BS Death Chance");
		lblBsDeathChance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBsDeathChance.setBounds(15, 237, 164, 14);
		contentPane.add(lblBsDeathChance);
	}
}