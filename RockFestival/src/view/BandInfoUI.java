package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.PsqlController;
import model.ArtistInBand;
import model.Band;

public class BandInfoUI extends JPanel implements ActionListener {
	PsqlController controller = new PsqlController();
	
	private JLabel lblTitle = new JLabel("BAND INFORMATION");
	private JTextArea taDisplay = new JTextArea();
	private JButton btnShow = new JButton("SHOW");

	String[] strBands;
	JComboBox<String> listBands;

	// Other instance variables
	private JFrame frame;
	private Font fontFirstTitle = new Font("SansSerif", Font.PLAIN, 30);
	private Font fontSecondTitle = new Font("SansSerif", Font.PLAIN, 18);
	private Font fontText = new Font("SansSerif", Font.ROMAN_BASELINE, 15);

	Color clrBackground = new Color(55, 55, 55);
	Color clrSpotifyGreen = new Color(78, 183, 57);
	Color clrWhite = new Color(220, 219, 219);

	public BandInfoUI() {
		ArrayList<Band> bandsFromDB = controller.selectBand(null);
		strBands = new String[bandsFromDB.size()+1];
		strBands[0] = "<select band>";
		for(int i = 0; i<bandsFromDB.size(); i++) {
			System.out.println(bandsFromDB.get(i).getName());
			strBands[i+1] = bandsFromDB.get(i).getName();
		}
		listBands = new JComboBox<String>(strBands);
		
		setBackground(clrBackground);

		listBands.setSelectedIndex(0); // 0 =default
		listBands.addActionListener(this);
		
		btnShow.addActionListener(this);

		add(upperPanel());
		add(middlePanel());
		add(bottomPanel());
	}

	public JPanel upperPanel() {
		JPanel upperpanel = new JPanel(new BorderLayout());
		upperpanel.setBackground(clrBackground);
		upperpanel.setPreferredSize(new Dimension(800, 40));

		lblTitle.setFont(fontFirstTitle);
		lblTitle.setForeground(clrSpotifyGreen);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);

		upperpanel.add(lblTitle, BorderLayout.CENTER);

		return upperpanel;
	}

	public JPanel middlePanel() {
		JPanel middlepanel = new JPanel(new GridLayout(1, 4));
		middlepanel.setBackground(clrBackground);
		middlepanel.setPreferredSize(new Dimension(800, 80));

		((JLabel) listBands.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		listBands.setFont(fontText);
		listBands.setSize(200, 70);

		btnShow.setFont(fontSecondTitle);
		btnShow.setBackground(clrSpotifyGreen);
		btnShow.setForeground(clrWhite);
		btnShow.setHorizontalAlignment(JLabel.CENTER);
		btnShow.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnShow.setSize(500, 50);
		btnShow.setOpaque(true);

		middlepanel.add(listBands, BorderLayout.NORTH);
		middlepanel.add(btnShow, BorderLayout.CENTER);
		

		return middlepanel;

	}

	public JPanel bottomPanel() {
		JPanel bottompanel = new JPanel(new GridLayout(1, 4));
		bottompanel.setBackground(clrBackground);
		bottompanel.setPreferredSize(new Dimension(800, 350));

		taDisplay.setBounds(0, 200, 800, 350);
		taDisplay.setEnabled(true); // false

		bottompanel.add(taDisplay, BorderLayout.CENTER);

		return bottompanel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnShow) {
			System.out.println("button pressed");
			//get value of band drop-down
			JComboBox<String> band = (JComboBox<String>) listBands;
			String strBand = (String) band.getSelectedItem();
			Band bandInfo = controller.selectBand("name='"+strBand+"'").get(0);
			String info = "Band: " + bandInfo.getName() + "\nCountry: " + bandInfo.getCountry()
			+ "\nInfo " + bandInfo.getInfo() + "\nmembers: ";
			ArrayList<ArtistInBand> artists = controller.selectArtistInBand("band='"+strBand+"'");
			for(int i=0; i<artists.size();i++) {
				info += "\n"+controller.selectArtist("id="+artists.get(i).getArtist()).get(0).getName() 
						+ " - " + artists.get(i).getRole();
			}
			System.out.println(info);
			taDisplay.setText(info);
			
		}

	}

	public void showUI() {
		frame = new JFrame("BandInfoUI");
		frame.setPreferredSize(new Dimension(850, 550));
		frame.getContentPane().setLayout(new BorderLayout());
		frame.pack();
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		BandInfoUI ui = new BandInfoUI();
		ui.showUI();

	}

}
