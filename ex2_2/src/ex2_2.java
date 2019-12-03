
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
class thing
{
	int id;
	String name;
	int price;
	int cnt;
}
public class ex2_2 extends JFrame implements ActionListener{
	JTextField text1=new JTextField(10);
	JButton button1=new JButton("搜索");
	JButton button2=new JButton();
	JButton button3=new JButton("已购买");
	JTabbedPane pane=new JTabbedPane();
	JPanel panel1=new JPanel();
	buy2 goods[]=new buy2[105];
	thing things[]=new thing[105];
	thing already_buy[]=new thing[1005];
	shopping_cart hh=new shopping_cart(new Object[][]{{"1","2","3","4","5"}} );
	JScrollPane spane;
	query que=new query();
	finish final_buy=new finish();
	static Object a[][];
	static Object name[]={"记录号","名称","单价","数量","总价"};
	buy2 s=new buy2("黄智", 10);
	int xb=0;
	int xb_ab=0;
	public static void main(String[] args) {
		ex2_2 t=new ex2_2();
	}
	ex2_2()
	{
		
		setBounds(0,0,420,500);
		panel1.setLayout(null);
		ImageIcon icon = new ImageIcon("012.png");
		button2.setIcon(icon);
		panel1.add(button2);
		button2.setBounds(100, 120, 200, 200);
		button2.addActionListener(this);
		panel1.add(button3);
		button3.setBounds(160, 350, 80, 30);
		panel1.add(text1);
		text1.setBounds(70, 50, 120 ,30);
		panel1.add(button1);
		button1.setBounds(250, 50, 80, 30);
		button1.addActionListener(this);
		hh.button.addActionListener(this);
		que.button1.addActionListener(this);
		que.button2.addActionListener(this);
		button3.addActionListener(this);
		add(panel1);
//		pane.addTab("首页",new JLabel(""));
//		pane.addTab("已购买",new JLabel(""));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		goods_information t=new goods_information();
		hh.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				button2.setEnabled(true);
			}
		});
		final_buy.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				button3.setEnabled(true);
			}
		});
		for(int i=0;i<15;i++)
		{
			goods[i]=new buy2(t.name[i],t.price[i]);
			goods[i].name=t.name[i];
			goods[i].price=t.price[i];
			int rt=i;
			goods[i].addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					int flag=0;
					System.out.println(goods[rt].sum);
					for(int j=0;j<xb;j++)
					{
						if(things[j].name.equals(goods[rt].name))
						{
							flag=1;
							things[j].cnt+=goods[rt].sum;
							break;
						}
					}
					if(flag==0)
					{
						things[xb]=new thing();
						things[xb].id=xb;
						things[xb].name=goods[rt].name;
						things[xb].price=goods[rt].price;
						things[xb].cnt=goods[rt].sum;
						xb++;
					}
					button1.setEnabled(true);
				}
			});
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)
		{
			if(text1.getText().length()==0)
			{
				JOptionPane.showMessageDialog(new JLabel(), "搜索不能为空");
			}
			else {
//				button1.setEnabled(false);
				for(int i=0;i<15;i++)
				{
					if(text1.getText().equals(goods[i].name))
					{
						button1.setEnabled(false);
						goods[i].setVisible(true);
						break;
					}
				}
//				s.setVisible(true);
			}
			
			
		}
		if(e.getSource()==button2)
		{
			button2.setEnabled(false);
			Object ss[][]=new Object[xb][5];
			for(int i=0;i<xb;i++)
			{
				ss[i][0]=things[i].id+"";
				ss[i][1]=things[i].name;
				ss[i][2]=things[i].price+"";
				ss[i][3]=things[i].cnt+"";
				ss[i][4]=things[i].price*things[i].cnt+"";
			}
//			hh=new shopping_cart(ss);
			hh.table_1.setModel(new DefaultTableModel(
					ss,
					new String[] {
						"记录号", "名称", "单价", "数量", "总价"
					}
				));
			hh.setVisible(true);
			//ImageIcon icon = new ImageIcon("image.jpg");
		}
		if(e.getSource()==hh.button)
		{
			int number=Integer.parseInt(hh.textField.getText());
			if(number<xb)
			{
				que.label2.setText(things[number].name);
				que.label4.setText(things[number].cnt+"");
				que.label6.setText(things[number].price+"");
				que.setVisible(true);
			}		
		}
		if(e.getSource()==que.button1 || e.getSource()==que.button2)
		{
			if(e.getSource()==que.button2)
			{
				int flag=0;
				int cntt=Integer.parseInt(hh.textField.getText());
				for(int i=0;i<xb_ab;i++)
				{
					if(things[cntt].name.equals(already_buy[i].name))
					{
						flag=1;
						already_buy[i].cnt+=things[cntt].cnt;
					}
				}
				if(flag==0)
				{
					already_buy[xb_ab]=new thing();
					already_buy[xb_ab].name=things[cntt].name;
					already_buy[xb_ab].cnt=things[cntt].cnt;
					already_buy[xb_ab].price=things[cntt].price;
					xb_ab++;
				}
			}
			for(int i=Integer.parseInt(hh.textField.getText());i<xb-1;i++)
			{
				things[i].id=things[i+1].id-1;
				things[i].name=things[i+1].name;
				things[i].price=things[i+1].price;
				things[i].cnt=things[i+1].cnt;			
			}
			xb--;
			Object ss[][]=new Object[xb][5];
			for(int i=0;i<xb;i++)
			{
				ss[i][0]=things[i].id+"";
				ss[i][1]=things[i].name;
				ss[i][2]=things[i].price+"";
				ss[i][3]=things[i].cnt+"";
				ss[i][4]=things[i].price*things[i].cnt+"";
			}
			hh.table_1.setModel(new DefaultTableModel(
					ss,
					new String[] {
						"记录号", "名称", "单价", "数量", "总价"
					}
				));
			que.setVisible(false);
		}
		if(e.getSource()==button3)
		{
			Object ss[][]=new Object[xb_ab][4];
			for(int i=0;i<xb_ab;i++)
			{
				ss[i][0]=already_buy[i].name;
				ss[i][1]=already_buy[i].price+"";
				ss[i][2]=already_buy[i].cnt+"";
				ss[i][3]=already_buy[i].price*already_buy[i].cnt+"";
			}
			button3.setEnabled(false);
			final_buy.table.setModel(new DefaultTableModel(
					ss,
					new String[] {
						"名称", "单价", "数量", "总价"
					}
				));
			final_buy.setVisible(true);
		}
		// TODO Auto-generated method stub	
	}
	
	
}
