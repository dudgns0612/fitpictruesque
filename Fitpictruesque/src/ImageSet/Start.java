package ImageSet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.*;



public class Start extends JFrame{
    private static final long serialVersionUID=1L;
	Event event;
    JPanel gstart = new JPanel();
    JButton startbtn = new JButton("S~tart");
    JButton stopbtn = new JButton("S~top");
    ArrayList<String> rankList;
    ArrayList<String> IDList;
	public Start(String name)
	{
		readFile();
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("메뉴");
		JMenuItem item = new JMenuItem("랭킹 보기");
		menu.add(item);
		menubar.add(menu);
		add(menubar,BorderLayout.NORTH);
	
		
	    addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RankingList(rankList, IDList);
			}
		});
		
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setLocation(550, 200);
    	setSize(600,500);
    	setTitle(name);
        makeS();
    	setVisible(true);
    	
    	
    }
	public void makeS()
	{   
		ImageIcon img = new ImageIcon("main.jpg");
    	JLabel ground = new JLabel(img);
    	startbtn.setBackground(Color.gray);
    	startbtn.setForeground(Color.white);
    	stopbtn.setBackground(Color.gray);
    	stopbtn.setForeground(Color.white);
    	gstart.setLayout(new GridLayout(1, 2,0,0));
        gstart.add(startbtn);
        gstart.add(stopbtn);
        add(ground,"Center");
        add(gstart,"South");
	}
    
	public void readFile()
	{
		rankList = new ArrayList<String>();
		IDList = new ArrayList<String>();
		File file = new File("src/ImageSet/test.txt");
		
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/ImageSet/test.txt"), "UTF-8"));
			while(true)
			{
				String tmp = br.readLine();
				if(tmp==null) break;
				String[] count = tmp.split(",");
				rankList.add(count[1]);
				IDList.add(count[0]);
			}
		}
		catch(IOException e) {
			System.err.println(e);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stubS
		Start kim = new Start("같은 그림 찾기");
		Event k = new Event(kim); 
	}
}
