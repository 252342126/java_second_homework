

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class shopping_cart extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JScrollPane scrollPane;
	public JTable table_1;
	JButton button;
	public shopping_cart(Object ss[][]) {
		setBounds(100, 100, 644, 468);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(90, 34, 124, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		button = new JButton("查询记录号");
		button.setBounds(284, 34, 162, 30);
		contentPane.add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 112, 504, 276);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			ss,
			new String[] {
					"记录号", "名称", "单价", "数量", "总价"
			}
		));
		scrollPane.setViewportView(table_1);
	}
}

