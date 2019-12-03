


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class buy2 extends JFrame implements ActionListener{

	JPanel Pane;
	JTextField textField;
	JButton button;
	JButton button2;
	JLabel label_5;
	JButton button3;
	String name;
	int price;
	int sum=0;
	public buy2(String name,int price) {
		setBounds(100, 100, 373, 245);
		Pane = new JPanel();
		setContentPane(Pane);
		Pane.setLayout(null);
		JLabel label = new JLabel("名称:");
		label.setBounds(61, 32, 35, 30);
		Pane.add(label);	
		JLabel label_1 = new JLabel(name);
		label_1.setBounds(95, 40, 58, 15);
		Pane.add(label_1);	
		JLabel label_2 = new JLabel("单价:");
		label_2.setBounds(163, 40, 35, 15);
		Pane.add(label_2);	
		JLabel label_3 = new JLabel(price+"");
		label_3.setBounds(196, 40, 23, 15);
		Pane.add(label_3);	
		button2 = new JButton("-");
		button2.setBounds(60, 120, 43, 41);
		Pane.add(button2);
		button2.addActionListener(this);
		button = new JButton("+");
		button.setBounds(151, 120, 43, 41);
		Pane.add(button);	
		button.addActionListener(this);
		button3=new JButton("加入购物车");
		button3.setBounds(250, 120, 100, 41);
		Pane.add(button3);
		button3.addActionListener(this);
		JLabel label_4 = new JLabel("总价:");
		label_4.setBounds(256, 40, 30, 15);
		Pane.add(label_4);
		label_5 = new JLabel(""+price);
		label_5.setBounds(296, 40, 35, 15);
		Pane.add(label_5);	
		textField = new JTextField();
		textField.setBounds(111, 130, 30, 21);
		Pane.add(textField);
		textField.setColumns(10);
		textField.setText("1");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button2)
		{
			String s=textField.getText();
			int cnt=Integer.parseInt(s);
			if(cnt>1)cnt--;
			String s2=cnt+"";
			textField.setText(s2);
			label_5.setText(cnt*10+"");
		}
		if(e.getSource()==button)
		{
			String s=textField.getText();
			int cnt=Integer.parseInt(s);
			cnt++;
			String s2=cnt+"";
			textField.setText(s2);
			label_5.setText(cnt*price+"");
		}
		if(e.getSource()==button3)
		{
			sum+=Integer.parseInt(textField.getText());
		}
		
	}
}
