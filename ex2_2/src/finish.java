

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class finish extends JFrame {

	JPanel contentPane;
	JTable table;
	public finish() {
		setBounds(100, 100, 644, 468);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 10, 555, 400);
		contentPane.add(scrollPane);	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"名称", "单价", "数量", "总价"
			}
		));
		scrollPane.setViewportView(table);
	}
}
