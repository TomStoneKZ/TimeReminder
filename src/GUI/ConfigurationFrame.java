package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ConfigurationFrame extends JFrame{
	
	private static final long serialVersionUID = -7373869978898853450L;
	
	DesktopOccupy desktopOccupy;
	
	public ConfigurationFrame() {
		this.setTitle("Time Reminder");
		this.setLayout(new BorderLayout(5, 5));
		
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout(new GridLayout(3, 2, 5, 5));
		JLabel workingTimeLabel = new JLabel();
		JButton startButton = new JButton("Start");
		startButton.setBounds(new Rectangle(50, 50, 50, 50));
		startButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				ConfigurationFrame.this.setVisible(false);
				timeCount();
			}
		});
		this.add(startButton);
		this.setSize(200, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void timeCount() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						if(desktopOccupy == null) {
							desktopOccupy = new DesktopOccupy();
						}
						desktopOccupy.setVisible(true);
						desktopOccupy.startCount();
					}
				});
			}
		}, 45*60*1000, 50*60*1000);
	}

}
