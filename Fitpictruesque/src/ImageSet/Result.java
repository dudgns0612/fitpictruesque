package ImageSet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Result extends JFrame{
	Result result = this;
	JPanel panelCenter = new JPanel();
	JPanel panelCenterInput = new JPanel();
	JPanel paneDown = new JPanel();
	JPanel paneUp = new JPanel();
	JLabel la2 = new JLabel("아이디를 입력하세요.");
	JTextField idta = new JTextField();// 이름 받는  텍스트 변수
	JLabel la1 = new JLabel("맞추는데 걸린 당신의 시간초 입니다.");
	JTextField ta = new JTextField();
	JButton ranking = new JButton("랭킹 등록");
	JButton cancel = new JButton("나가기");
	String s;
	Start K;
	GameWindow g;
	ArrayList<String> IDList = new ArrayList<String>();
	double Settime;
	String IDname; // 아이디를 담는 변수
	
	boolean rankingconfirm = false;
	public Result(double time, Start s, GameWindow g) {
		// TODO Auto-generated constructor stub
		this.K = s;
		this.g = g;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,300);
		setTitle("결과");
		ResultEnd(time);
		ranking.addActionListener(new ButtonEvent());
		cancel.addActionListener(new ButtonEvent());
		setVisible(true);
	}
	public void ResultEnd(double time)
	{        
		     time = (Math.round(time * 1000d))/ 1000d; 
		     Settime = time;
		     s=String.valueOf(time);
		     ta.setText(s);
		     panelCenterInput.setLayout(new GridLayout(4, 1,0,13));
		     panelCenterInput.add(la1);
		     panelCenterInput.add(ta);
		     panelCenterInput.add(la2);
		     panelCenterInput.add(idta); //이름을 받는 텍스트
		     panelCenter.setLayout(new BorderLayout(100,100));
		     panelCenter.add(panelCenterInput,"Center");
		     paneDown.add(ranking);
		     paneDown.add(cancel);
		     add(paneUp,"North");
		     add(paneDown , "South");
		     add(new Label(""),"West");
		     add(new Label(""),"East");
		     add(panelCenter,"Center");
	}
    class ButtonEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == ranking)
			{  
			   if(!rankingconfirm)
			   {
				   if(idta.getText()==null)
				   {
					   idta.setText("이름없음");
				   }
				   IDname = idta.getText();
				   Ranking Rank = new Ranking(Settime , IDname ,K.rankList , K.IDList);
				   JOptionPane.showMessageDialog(result, "랭킹이 등록 되었습니다.", "랭킹등록",JOptionPane.INFORMATION_MESSAGE);
				   rankingconfirm = true;
			   }
			   else
			   {
				   int check = JOptionPane.showConfirmDialog(result, "이미 등록 되었습니다. 종료하시겠습니까?");
				   if(check == 0)
				   {
					   System.exit(0);
				   }
				   else if(check == 1)
				   {
					    dispose();
						K.dispose();
						g.dispose();
						Start start = new Start("같은 그림 찾기");
						Event event = new Event(start);
				   }
			   }
			}
			else if(e.getSource() == cancel)
			{
				dispose();
				K.dispose();
				g.dispose();
				Start start = new Start("같은 그림 찾기");
				Event event = new Event(start);
			}
		}
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

     
