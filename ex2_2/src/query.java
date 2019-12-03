

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class query extends JFrame {

	private JPanel contentPane;
	JLabel label2 ;
	JLabel label3 ;
	JLabel label4 ;
	JLabel label5 ;
	JLabel label6 ;          
    JButton button1;
    JButton button2;

	public query() {
		setBounds(100, 100, 541, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("名称:");
		label.setBounds(32, 36, 36, 15);
		contentPane.add(label);
		
		label2 = new JLabel("");
		label2.setBounds(69, 36, 58, 15);
		contentPane.add(label2);
		
		label3 = new JLabel("数量:");
		label3.setBounds(205, 36, 36, 15);
		contentPane.add(label3);
		
		label4 = new JLabel("");
		label4.setBounds(251, 36, 47, 15);
		contentPane.add(label4);
		
		label5 = new JLabel("单价:");
		label5.setBounds(347, 36, 30, 15);
		contentPane.add(label5);
		
		label6 = new JLabel("");
		label6.setBounds(387, 36, 36, 15);
		contentPane.add(label6);
		
		button1 = new JButton("删除");
		button1.setBounds(80, 248, 97, 23);
		contentPane.add(button1);
		
		button2 = new JButton("购买");
		button2.setBounds(312, 248, 97, 23);
		contentPane.add(button2);
	}
}
