package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class VisitorUI extends JPanel implements ActionListener {
	// For upper panel
	private JLabel lblTitle = new JLabel("SCHEDULE");

	// For middple panel
	private JLabel lblDay = new JLabel("DAY");
	private JLabel lblScene = new JLabel("SCENE");
	private JLabel lblTest1 = new JLabel("test 1");
	private JLabel lblTest2 = new JLabel("test 2");

	String[] strDays = { "Thursday", "Friday", "Saturday" };
	JComboBox<String> listDays = new JComboBox<String>(strDays);
	String[] strScenes = { "Scene A", "Scene B", "Scene C" };
	JComboBox<String> listScenes = new JComboBox<String>(strScenes);

	JButton btnDaysOK = new JButton("OK");
	JButton btnScenesOK = new JButton("OK");

	// For bottom panel
	private JLabel lblBand = new JLabel("SCENE");
	private JLabel lblStart = new JLabel("START");
	private JLabel lblFinish = new JLabel("FINISH");
	private JLabel lblInfo = new JLabel("INFO");

	// For areaBottomPanel
	private JTextArea taTest = new JTextArea();
//	private JTextArea taBand = new JTextArea();
//	private JTextArea taStart = new JTextArea();
//	private JTextArea taFinish = new JTextArea();
//	private JTextArea taInfo = new JTextArea();

	// Other instance variables
	private JFrame frame;
	private Font fontFirstTitle = new Font("SansSerif", Font.PLAIN, 30);
	private Font fontSecondTitle = new Font("SansSerif", Font.PLAIN, 18);
	private Font fontText = new Font("SansSerif", Font.ROMAN_BASELINE, 15);

	Color clrBackground = new Color(55, 55, 55);
	Color clrSpotifyGreen = new Color(78, 183, 57);
	Color clrWhite = new Color(220, 219, 219);

	/**
	 * Constructor
	 * 
	 */
	public VisitorUI() {
		setBackground(clrBackground);

		btnDaysOK.setEnabled(false);
		btnScenesOK.addActionListener(this);

		// DropDown for lblday and lblscene
		listDays.setSelectedIndex(2); // 0 = thursday
		listDays.addActionListener(this);
//		
		listScenes.setSelectedIndex(2); // 0 = scene A
		listScenes.addActionListener(this);

		add(upperPanel());
		add(middlePanel());
		add(bottomPanel());
		add(areaBottomPanel());
	}

	public JPanel upperPanel() {
		JPanel upperpanel = new JPanel(new BorderLayout()); // left, center, right?
//		GridLayout gridInBorder = new GridLayout(1,4); //put in the south of the borderlayout
		upperpanel.setBackground(clrBackground);
		upperpanel.setPreferredSize(new Dimension(800, 40));

		lblTitle.setFont(fontFirstTitle);
		lblTitle.setForeground(clrSpotifyGreen);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);

		upperpanel.add(lblTitle, BorderLayout.CENTER); //west?????

		return upperpanel;
	}

	public JPanel middlePanel() {
		JPanel middlepanel = new JPanel(new GridLayout(1, 4));
		middlepanel.setBackground(clrBackground);
		middlepanel.setPreferredSize(new Dimension(800, 80));

		lblDay.setFont(fontSecondTitle);
		lblDay.setForeground(clrWhite);
		lblDay.setHorizontalAlignment(JLabel.CENTER);
		lblDay.setSize(200, 20);

		lblScene.setFont(fontSecondTitle);
		lblScene.setForeground(clrWhite);
		lblScene.setHorizontalAlignment(JLabel.CENTER);
		lblScene.setSize(200, 20);

//		lblTest1.setFont(fontSecondTitle);
//		lblTest1.setForeground(clrWhite);
//		lblTest1.setHorizontalAlignment(JLabel.CENTER);
//		lblTest1.setSize(200, 20);
//
//		lblTest2.setFont(fontSecondTitle);
//		lblTest2.setForeground(clrWhite);
//		lblTest2.setHorizontalAlignment(JLabel.CENTER);
//		lblTest2.setSize(200, 20);

		((JLabel) listScenes.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		listScenes.setFont(fontText);
		listScenes.setSize(200, 30);

		((JLabel) listDays.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		listDays.setFont(fontText);
		listDays.setSize(200, 30);

//		middlepanel.add(listScenes, BorderLayout.CENTER);
		middlepanel.add(lblDay, BorderLayout.WEST);
		middlepanel.add(listDays, BorderLayout.WEST);
		middlepanel.add(lblScene, BorderLayout.EAST);
		middlepanel.add(listScenes, BorderLayout.EAST);

		return middlepanel;
	}

	/*
	 * In order to get a dynamic gridlayout: create variables for row and col.
	 * Create a grid with a parameter containing the variables. Call setters for the
	 * variables. Lastly, add the grid to the panel
	 * 
	 * create a panel just for lbls and another one for dynamic grid
	 */
	public JPanel bottomPanel() {
		JPanel bottompanel = new JPanel(new GridLayout(1, 4));
		bottompanel.setBackground(clrBackground);
		bottompanel.setPreferredSize(new Dimension(800, 80));

		lblBand.setFont(fontSecondTitle);
		lblBand.setForeground(clrWhite);
		lblBand.setHorizontalAlignment(JLabel.CENTER);
		lblBand.setSize(100, 50);

		lblStart.setFont(fontSecondTitle);
		lblStart.setForeground(clrWhite);
		lblStart.setHorizontalAlignment(JLabel.CENTER);
		lblStart.setSize(100, 50);

		lblFinish.setFont(fontSecondTitle);
		lblFinish.setForeground(clrWhite);
		lblFinish.setHorizontalAlignment(JLabel.CENTER);
		lblFinish.setSize(100, 50);

		lblInfo.setFont(fontSecondTitle);
		lblInfo.setForeground(clrWhite);
		lblInfo.setHorizontalAlignment(JLabel.CENTER);
		lblInfo.setSize(100, 50);

		bottompanel.add(lblBand);
		bottompanel.add(lblStart);
		bottompanel.add(lblFinish);
		bottompanel.add(lblInfo);

		return bottompanel;

	}

	public JPanel areaBottomPanel() {
		int newRows = 1;
		JPanel areabottompanel = new JPanel(new GridLayout(newRows, 4));
		areabottompanel.setBackground(Color.BLACK);
		areabottompanel.setPreferredSize(new Dimension(800, 250));
		
//		((GridLayout) areabottompanel).setRows(newRows); // should be used when adding new rows

//		taTest.setPreferredSize(new Dimension(50, 60));
//		taTest.setBorder(BorderFactory.createLineBorder(Color.BLACK));

//		taStart.setPreferredSize(new Dimension(150, 60));
//		taStart.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//
//		taFinish.setPreferredSize(new Dimension(150, 60));
//		taFinish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//
//		taFinish.setPreferredSize(new Dimension(150, 60));
//		taFinish.setBorder(BorderFactory.createLineBorder(Color.BLACK));

//		areabottompanel.add(taTest);
//		areabottompanel.add(taStart);
//		areabottompanel.add(taFinish);
//		areabottompanel.add(taInfo);

//		JScrollPane scroll = new JScrollPane(areabottompanel());
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setBounds(800, 500, 40, 295); //(550, 400, 50, 400)
//		areabottompanel.add(scroll);

		return areabottompanel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == listScenes) {
			JComboBox<String> cbOne = (JComboBox<String>) e.getSource();
			String strScenes = (String) cbOne.getSelectedItem();

			switch (strScenes) {
			case "Scene A":
				lblScene.setForeground(Color.RED);
				break;
			case "Scene B":
				lblScene.setForeground(Color.YELLOW);
				break;
			case "Scene C":
				lblScene.setForeground(Color.BLUE);
				break;
			default:
				lblScene.setForeground(Color.WHITE);
			}
		}

		if (e.getSource() == listDays) {
			JComboBox<String> cbTwo = (JComboBox<String>) e.getSource();
			String strDays = (String) cbTwo.getSelectedItem();

			switch (strDays) {
			case "Thursday":
				lblDay.setForeground(Color.RED);
				break;
			case "Friday":
				lblDay.setForeground(Color.YELLOW);
				break;
			case "Saturday":
				lblDay.setForeground(Color.BLUE);
				break;
			default:
				lblDay.setForeground(Color.WHITE);
			}
		}

	}

	public void showUI() {
		frame = new JFrame("VisitorUI");
		frame.setPreferredSize(new Dimension(850, 550));
		frame.getContentPane().setLayout(new BorderLayout());
		frame.pack();
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		VisitorUI ui = new VisitorUI();
		ui.showUI();

	}

}
