package ImageSet;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import javafx.event.EventHandler;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameWindow extends JFrame{
	private static final long serialVersionUTD=1L;
    JPanel cardpanel = new JPanel();
    JButton btn[] = new JButton[16];
    int checking[]=new int[16];
    boolean closecheck = false;
 
    
	public GameWindow()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("게임 화면");
		setSize(710,500);
		setLocation(600, 200);
		cardpanel.setLayout(new GridLayout(4, 4, 0, 0));
		btn[0]=(new JButton(new ImageIcon("sweden.jpg")));
		btn[1]=(new JButton(new ImageIcon("bragil.jpg")));
		btn[2]=(new JButton(new ImageIcon("bragil.jpg")));
		btn[3]=(new JButton(new ImageIcon("ceko.jpg")));
		btn[4]=(new JButton(new ImageIcon("ceko.jpg")));
		btn[5]=(new JButton(new ImageIcon("denmak.jpg")));
		btn[6]=(new JButton(new ImageIcon("denmak.jpg")));
		btn[7]=(new JButton(new ImageIcon("serbia.png")));
		btn[8]=(new JButton(new ImageIcon("serbia.png")));
		btn[9]=(new JButton(new ImageIcon("korea.jpg")));
		btn[10]=(new JButton(new ImageIcon("korea.jpg")));
		btn[11]=(new JButton(new ImageIcon("greese.jpg")));
		btn[12]=(new JButton(new ImageIcon("greese.jpg")));
		btn[13]=(new JButton(new ImageIcon("germany.jpg")));
		btn[14]=(new JButton(new ImageIcon("germany.jpg")));
		btn[15]=(new JButton(new ImageIcon("sweden.jpg")));
		//btn[15].setIcon(new ImageIcon("sweden.png"));
		random();
		add(cardpanel);
		setVisible(true);
		
		addWindowListener(new WindowEvnet());
		
		   Timer m_timer = new Timer();
		    TimerTask m_task = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					mask();
					//setVisible(false);
				}
			};
			m_timer.schedule(m_task, 5000);
	}
	public void random()
	{
		int a;
		Random rnd =new Random();
		for(int j=0;16>j;j++)
		{
			checking[j]=0;
		}
		for(int i=0; 16>i;i++)
		{
		a= rnd.nextInt(16);
			while(overlap(a) ==-1)
			{
				a= rnd.nextInt(16);
			}
			cardpanel.add(btn[a]);
		}
			
	}
		public int overlap(int r) 
	     {   
	    	 if(checking[r]==1)
	    	 {   
	    		 return -1;
	    	 }
	    	 else
	    	 {
	    		 checking[r] = 1;
	    		 return 0;
	    	 }
	     }  
	

	
	public void mask()
	{   
		if(!closecheck)
		{
	        for(int i=0; 16>i ; i++)
	        {
	        	btn[i].setIcon(new ImageIcon("mask.jpg"));
	        }
			setVisible(true);
		}
		
	}
	
	class WindowEvnet extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) {
			closecheck = true;
			dispose();
		}
	}

}

