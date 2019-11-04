package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StartBookingUI {
	JFrame frame;
	

	public void showUI() {
		BookConcertUI bcUI = new BookConcertUI();
		JTabbedPane jtp = new JTabbedPane();
 
		frame = new JFrame("BookingUI");
		frame.setPreferredSize(new Dimension(550, 800)); // dimensions are the opposite from VisitorUI
		frame.getContentPane().setLayout(new BorderLayout());
		frame.pack();
		frame.getContentPane().add(bcUI);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(jtp);
		jtp.addTab("Book Concert", bcUI);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
		jtp.addTab("Book Band", jp1);
		jtp.addTab("Update Band", jp2);

	}

	public static void main(String[] args) {
		StartBookingUI ui = new StartBookingUI();
		ui.showUI();

	}

}
