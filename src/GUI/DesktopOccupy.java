package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DesktopOccupy {

	private long targetTime;
	private long currentTime;
	private long distTime;
	private long minutes, seconds;
	
	public DesktopOccupy() {
		final Timer timer = new Timer();
		final JFrame frame = new JFrame();
		frame.setUndecorated(true);
		frame.setTitle("注意休息");
		frame.setLayout(new FlowLayout());
		final JLabel label = new JLabel();
		label.setFont(new Font("Dialog", 1, 24));
		label.setForeground(Color.BLUE);
		label.setHorizontalTextPosition(JLabel.CENTER);
		frame.add(label);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(0);
		frame.setAlwaysOnTop(true);
//		frame.setAutoRequestFocus(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
		frame.addWindowFocusListener(new WindowFocusListener() {
			
			public void windowLostFocus(WindowEvent arg0) {
				frame.requestFocus();
				frame.setLocation(0, 0);
			}
			
			public void windowGainedFocus(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowIconified(WindowEvent arg0) {
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
			
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		currentTime = System.currentTimeMillis();
		targetTime = currentTime + 5*60*1000;
		timer.schedule(new TimerTask() {
			
			public void run() {
				currentTime = System.currentTimeMillis();
				distTime = targetTime - currentTime;
				if(distTime < 0) {
					frame.dispose();
					timer.cancel();
				}
				minutes = distTime/1000/60;
				seconds = distTime/1000%60;
				label.setText("还剩 " + minutes + " 分 " + seconds + " 秒， 出去走走");
			}
		}, 0, 1000);
		
	}
}
