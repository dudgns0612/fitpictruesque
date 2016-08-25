package ImageSet;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Date;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.w3c.dom.events.MouseEvent;
import java.util.*;

public class Event extends JFrame{
	double start;
	double end;
	private static final long serialVersionUTD=1L;
	Start K;
	GameWindow g;
	JButton checking[] = new JButton[16];
	int counting = 0;
	int ck[] = new int[16];
	int count =0;
	JButton mask[] = new JButton[3];
	public Event(Start K)
	{   
		this.K = K;
		K.startbtn.addActionListener(new ButtonEvent());
		K.stopbtn.addActionListener(new ButtonEvent());		
	    for(int i=0; 16>i;i++)
	    {
	    	ck[i]=0;
	    	//checking[i]=0;
	    }
	}
	
	class ButtonEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==K.startbtn)
			{
				start = System.currentTimeMillis();
				g= new GameWindow();
				g.btn[0].addActionListener(new ButtonEvent2());
				g.btn[1].addActionListener(new ButtonEvent2());
				g.btn[2].addActionListener(new ButtonEvent2());
				g.btn[3].addActionListener(new ButtonEvent2());
				g.btn[4].addActionListener(new ButtonEvent2());
				g.btn[5].addActionListener(new ButtonEvent2());
				g.btn[6].addActionListener(new ButtonEvent2());
				g.btn[7].addActionListener(new ButtonEvent2());
				g.btn[8].addActionListener(new ButtonEvent2());
				g.btn[9].addActionListener(new ButtonEvent2());
				g.btn[10].addActionListener(new ButtonEvent2());
				g.btn[11].addActionListener(new ButtonEvent2());
				g.btn[12].addActionListener(new ButtonEvent2());
				g.btn[13].addActionListener(new ButtonEvent2());
				g.btn[14].addActionListener(new ButtonEvent2());
				g.btn[15].addActionListener(new ButtonEvent2());
			}
			else if(e.getSource()==K.stopbtn)
			{
				System.exit(0);
			}
		}
	
	 }
	class ButtonEvent2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            if(e.getSource()==g.btn[0])
            {   
            	g.btn[0].setIcon(new ImageIcon("sweden.jpg"));
                ck[count] =1;
                mask[count] = g.btn[0];
                count++;
            }
            else if(e.getSource()==g.btn[1])
            {
    			g.btn[1].setIcon(new ImageIcon("bragil.jpg"));
    			ck[count] =2;
    			mask[count] = g.btn[1];
    			count++;
            }
            else if(e.getSource()==g.btn[2])
            {
            	g.btn[2].setIcon(new ImageIcon("bragil.jpg"));
            	ck[count] = 2;
            	mask[count] = g.btn[2];
            	count++;
            }
            else if(e.getSource()==g.btn[3])
            {
            	g.btn[3].setIcon(new ImageIcon("ceko.jpg"));
            	ck[count] =3;
            	mask[count] = g.btn[3];
            	count++;
            }
            else if(e.getSource()==g.btn[4])
            {
            	g.btn[4].setIcon(new ImageIcon("ceko.jpg"));
            	ck[count] = 3;
            	mask[count] = g.btn[4];
            	count++;
            }
            else if(e.getSource()==g.btn[5])
            {
            	g.btn[5].setIcon(new ImageIcon("denmak.jpg"));
            	ck[count] =4;
            	mask[count] = g.btn[5];
            	count++;
            }
            else if(e.getSource()==g.btn[6])
            {
            	g.btn[6].setIcon(new ImageIcon("denmak.jpg"));
            	ck[count] = 4;
            	 mask[count] = g.btn[6];
            	count++;
            }
            else if(e.getSource()==g.btn[7])
            {
            	g.btn[7].setIcon(new ImageIcon("serbia.png"));
            	ck[count] =5;
            	 mask[count] = g.btn[7];
            	count++;
            }
            else if(e.getSource()==g.btn[8])
            {
            	g.btn[8].setIcon(new ImageIcon("serbia.png"));
            	ck[count] = 5;
            	mask[count] = g.btn[8];
            	count++;
            }
            else if(e.getSource()==g.btn[9])
            {
            	g.btn[9].setIcon(new ImageIcon("korea.jpg"));
            	ck[count] =6;
            	mask[count] = g.btn[9];
            	count++;
            }
            else if(e.getSource()==g.btn[10])
            {
            	g.btn[10].setIcon(new ImageIcon("korea.jpg"));
            	ck[count] = 6;
            	mask[count] = g.btn[10];
            	count++;
            }
            else if(e.getSource()==g.btn[11])
            {
            	g.btn[11].setIcon(new ImageIcon("greese.jpg"));
            	ck[count] =7;
            	mask[count] = g.btn[11];
            	count++;
            }
            else if(e.getSource()==g.btn[12])
            {
            	g.btn[12].setIcon(new ImageIcon("greese.jpg"));
            	ck[count] = 7;
            	 mask[count] = g.btn[12];
            	count++;
            }
            else if(e.getSource()==g.btn[13])
            {
            	g.btn[13].setIcon(new ImageIcon("germany.jpg"));
            	ck[count] =8;
            	mask[count] = g.btn[13];
            	count++;
            }
            else if(e.getSource()==g.btn[14])
            {
            	g.btn[14].setIcon(new ImageIcon("germany.jpg"));
            	ck[count] = 8;
            	mask[count] = g.btn[14];
            	count++;
            }
            else
            {
            	g.btn[15].setIcon(new ImageIcon("sweden.jpg"));	
            	ck[count] = 1;
            	mask[count] = g.btn[15];
            	count++;
            }
            if(count == 3)
            {
                checking();
            }
            else if(count ==2)
            {
	 		   Timer m_timer = new Timer();
			   TimerTask m_task = new TimerTask() {
				
					@Override
					public void run() {
						checking();
						//setVisible(false);
					}
			};
				m_timer.schedule(m_task, 400);
            }
        }
		public void checking()
		{
			if(ck[0] != ck[1])
            {   
                mask[0].setIcon(new ImageIcon("mask.jpg"));
                mask[1].setIcon(new ImageIcon("mask.jpg"));
                if(count==3)
                mask[2].setIcon(new ImageIcon("mask.jpg"));
            }
			else if(mask[0] == mask[1])
			{
				mask[0].setIcon(new ImageIcon("mask.jpg"));
			}
			else if(ck[0]==ck[1])
			{
				mask[0].setEnabled(false);
				mask[1].setEnabled(false);
				checking[counting] = mask[0];
				counting++;
				checking[counting]= mask[1];
				counting++;
				if(counting==16)
				{   
					end = System.currentTimeMillis();
					double sucessTime = ((end-start)/1000)-5;
					Result Result1 = new Result(sucessTime,K,g);
				}
				if(count==3)
				mask[2].setIcon(new ImageIcon("mask.jpg"));
			}
            count = 0;
		}
    }
}



