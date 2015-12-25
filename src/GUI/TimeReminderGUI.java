package GUI;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TimeReminderGUI{
	DesktopOccupy desktopOccupy;
	
	public TimeReminderGUI() {
		final JFrame frame = new JFrame("时间提醒");
		JButton startButton = new JButton("开始计时");
		startButton.setBounds(new Rectangle(50, 50, 50, 50));
		startButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				timeCount();
			}
		});
		frame.add(startButton);
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new TimeReminderGUI();
			}
		});
	}
	
	public void timeCount() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						if(desktopOccupy == null) {
							System.out.println("a");
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
