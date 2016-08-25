package ImageSet;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

public class Ranking extends JFrame{
	static double settime;
	String ID ;
	ArrayList<String> k;
	ArrayList<String> IDList;
	ArrayList<String> Last = new ArrayList<String>();
	public Ranking(double settime , String ID, ArrayList<String> k , ArrayList<String> IDList) {
		// TODO Auto-generated constructor stub
		this.k=k;
		this.ID= ID;
		this.settime = settime;
		this.IDList = IDList;
		rr(settime,IDList);
	}

	public void rr(double settime,ArrayList<String> IDList)
	{
		int data ;
		String  fname = "src/ImageSet/test.txt";
		
		try{
			BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fname),"UTF-8"));
			String time = String.valueOf(settime);
			//System.out.println(k.size());
			k.add(time);
			IDList.add(ID);
			for(int i =0; k.size()>i ;i++)
			{
			bw.write(IDList.get(i)+","+k.get(i));
			bw.flush();
			bw.newLine();
			checking();
			RankCheck();
			}
		}
		catch(FileNotFoundException e){
			System.err.println("다음 파일이 없습니다. : "+fname);
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
		//System.out.println();
	}
	public void RankCheck()
	{
		
		String text = "src/ImageSet/test.txt";
		try{ 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(text),"UTF-8"));
			for(int a=0; k.size()>a; a++)
			{   
				bw.write(IDList.get(a)+","+k.get(a));
				bw.flush();
				bw.newLine();
			}
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
	
	public void checking()
	{
		double a;
		double b;
		String tmp ;
		String tmpp;
		for(int i =0; k.size()-1>i; i++)  // 선택 정렬
		{
			for(int j = i+1; k.size()>j;j++)
			{
				 a = Double.valueOf(k.get(i));
				 b = Double.valueOf(k.get(j));
				// System.out.println(a+","+b);
				 if(a > b)
				 {
					 tmp = k.get(i);
					 k.set(i, k.get(j));
					 k.set(j, tmp);
					 tmpp = IDList.get(i);
					 IDList.set(i, IDList.get(j));
					 IDList.set(j, tmpp);
				 }
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

