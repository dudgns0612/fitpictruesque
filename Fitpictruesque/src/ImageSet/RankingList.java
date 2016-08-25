package ImageSet;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RankingList extends JFrame{
	private static final Component JTextFiled = null;
	JLabel JL[] ;
	JTextField JT[] = new JTextField[10];
	JPanel JP = new JPanel();
	JPanel JPcenter =new JPanel();
	ArrayList<String> data;
	ArrayList<String> IDList;
	public RankingList(ArrayList<String> data , ArrayList<String> IDList)
	{  
			setTitle("랭킹 보기");
			this.data = data;
			this.IDList = IDList;
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setSize(300,500);
			for(int i=0; 10>i ;i++)
			{
				JT[i]= new JTextField();
				JPcenter.add(JT[i]);
			}
			for(int i =0 ; data.size()>i ; i++)
			{
				if(i<10)
				{
				JT[i].setText(IDList.get(i)+" : "+data.get(i));
				}
			}
			JP.add(new JLabel("1등"));
			JP.add(new JLabel("2등"));
			JP.add(new JLabel("3등"));
			JP.add(new JLabel("4등"));
			JP.add(new JLabel("5등"));
			JP.add(new JLabel("6등"));
			JP.add(new JLabel("7등"));
			JP.add(new JLabel("8등"));
			JP.add(new JLabel("9등"));
			JP.add(new JLabel("10등"));
			JP.setLayout(new GridLayout(10, 1));
			JPcenter.setLayout(new GridLayout(10, 1,0,3));
			add(new JLabel("순  위"),"North");
			add(new JLabel(" "),"South");
			add(new JLabel("  "),"East");
			add(JP,"West");
			add(JPcenter,"Center");
			setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
