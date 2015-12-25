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
import javax.swing.SwingUtilities;

public class DesktopOccupy extends JFrame{
	
	private static final long serialVersionUID = 2456477465891685954L;
	private long targetTime;
	private long currentTime;
	private long distTime;
	private long minutes, seconds;
	private Timer timer = new Timer();
	private JLabel label;
	
	public DesktopOccupy() {
		this.setUndecorated(true);
		this.setTitle("注意休息");
		this.setLayout(new FlowLayout());
		label = new JLabel();
		label.setFont(new Font("Dialog", 1, 24));
		label.setForeground(Color.BLUE);
		label.setHorizontalTextPosition(JLabel.CENTER);
		this.add(label);
		this.setVisible(true);
		this.setDefaultCloseOperation(0);
		this.setAlwaysOnTop(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		
		this.addWindowFocusListener(new WindowFocusListener() {
			
			public void windowLostFocus(WindowEvent arg0) {
				DesktopOccupy.this.requestFocus();
				DesktopOccupy.this.setLocation(0, 0);
			}
			
			public void windowGainedFocus(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		this.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowIconified(WindowEvent arg0) {
				DesktopOccupy.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
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
	}
	
	public void startCount() {
		currentTime = System.currentTimeMillis();
		targetTime = currentTime + 5*60*1000;
		timer.schedule(new TimerTask() {
			
			public void run() {
				currentTime = System.currentTimeMillis();
				distTime = targetTime - currentTime;
				if(distTime < 0) {
					this.cancel();
					timer.purge();
					DesktopOccupy.this.dispose();
				}
				minutes = distTime/1000/60;
				seconds = distTime/1000%60;
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						label.setText("还剩 " + minutes + " 分 " + seconds + " 秒， 出去走走");
					}
				});
			}
		}, 0, 1000);
	}
}
