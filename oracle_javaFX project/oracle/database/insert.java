package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

public class insert extends JFrame {

	Connection conn;
	
	private JPanel contentPane;
	private JTextField input;
	private JButton insert_record;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField user_id_1;
	private JTextField name_1;
	private JTextField pass_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTable table;
	private JPanel panel;
	private JTextField edit_id;
	private JTextField edit_name;
	private JTextField edit_pass;
	private JButton edit_rec;
	private JPanel panel_2;
	private JLabel ladd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert frame = new insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void con() throws Exception {
		conn = connect.getConnection();
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public insert() throws Exception {
		
		con();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 485);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "NEW USER", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(16, 19, 211, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("USER ID");
		lblNewLabel.setBounds(6, 19, 46, 14);
		panel.add(lblNewLabel);
		
		user_id_1 = new JTextField();
		user_id_1.setBounds(102, 16, 86, 20);
		panel.add(user_id_1);
		user_id_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(6, 58, 46, 14);
		panel.add(lblNewLabel_1);
		
		name_1 = new JTextField();
		name_1.setBounds(102, 55, 86, 20);
		panel.add(name_1);
		name_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(6, 109, 70, 17);
		panel.add(lblNewLabel_2);
		
		pass_1 = new JTextField();
		pass_1.setBounds(102, 107, 86, 20);
		panel.add(pass_1);
		pass_1.setColumns(10);
		
		insert_record = new JButton("ADD USER");
		insert_record.setBounds(23, 159, 113, 23);
		panel.add(insert_record);
		
		ladd = new JLabel("new user");
		ladd.setBounds(10, 193, 191, 14);
		panel.add(ladd);
		insert_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int user_id = Integer.parseInt(user_id_1.getText());
				String name = name_1.getText();
				String pass = pass_1.getText();
				
				try {
					// Statement stmt = conn.createStatement();
					
				//	String in = "INSERT INTO users VALUES(' " + name + " ', ' " + pass + " ', ' " + user_id + " ')";
					
					// its best to use the prepared statement
					
					PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(?, ?, ?)");
					ps.setString(1, name);
					ps.setString(2, pass);
					ps.setInt(3, user_id);
					
					ps.execute();
					
					ps.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ladd.setText("user " + name + " has been added");
				
			}
		});
		
		table = new JTable();
		table.setAutoscrolls(false);
		table.setIgnoreRepaint(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	//	table.setTableHeader("User");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"USER ID", "NAME", "PASSWORD"},
			},
			new String[] {
				"USER ID", "NAME", "PASSWORD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(41, 313, 444, 122);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("DISPLAY RECORDS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel tablemodel =  (DefaultTableModel) table.getModel();
				try {

					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM users ");
					
					System.out.println("USER ID  |  NAME     |   PASSWORD");
					System.out.println("=================================");
					
					while(rs.next()) {
					int id = rs.getInt("user_id");
					String name = rs.getString("name");
					String pass = rs.getString("pass");
					
					System.out.println(id + "        |  " + name + "  |    " + pass);
					
				tablemodel.addRow(new Object[] {id, name, pass});
				
					}
					
					st.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(41, 263, 142, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "EDIT USER", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(325, 19, 211, 207);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("USER ID");
		lblNewLabel_3.setBounds(6, 19, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		edit_id = new JTextField();
		edit_id.setColumns(10);
		edit_id.setBounds(102, 16, 86, 20);
		panel_1.add(edit_id);
		
		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setBounds(6, 58, 46, 14);
		panel_1.add(lblNewLabel_1_1);
		
		edit_name = new JTextField();
		edit_name.setColumns(10);
		edit_name.setBounds(102, 55, 86, 20);
		panel_1.add(edit_name);
		
		JLabel lblNewLabel_2_1 = new JLabel("PASSWORD");
		lblNewLabel_2_1.setBounds(6, 109, 70, 17);
		panel_1.add(lblNewLabel_2_1);
		
		edit_pass = new JTextField();
		edit_pass.setColumns(10);
		edit_pass.setBounds(102, 107, 86, 20);
		panel_1.add(edit_pass);
		
		JButton update_user = new JButton("UPDATE USER");
		update_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PreparedStatement pst  = conn.prepareStatement("UPDATE users SET name=?, pass=?, user_id=? WHERE user_id=?");
					pst.setString(1, edit_name.getText());
					pst.setString(2, edit_pass.getText());
					pst.setInt(3, Integer.parseInt(edit_id.getText()));
					pst.setInt(4, Integer.parseInt(edit_id.getText()));
					pst.executeUpdate();
					System.out.println("UPDATE SUCCESSFUL");
					pst.close();
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				btnNewButton.doClick();
			}
		});
		update_user.setBounds(23, 159, 139, 23);
		panel_1.add(update_user);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "EDIT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(226, 237, 310, 65);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton delete_rec = new JButton("DELETE RECORDS");
		delete_rec.setBounds(142, 16, 142, 23);
		panel_2.add(delete_rec);
		
		edit_rec = new JButton("EDIT RECORD");
		edit_rec.setBounds(6, 16, 113, 23);
		panel_2.add(edit_rec);
		
		JLabel lblNewLabel_4 = new JLabel("SELECT A ROW FROM THE TABLE");
		lblNewLabel_4.setBounds(16, 40, 217, 14);
		panel_2.add(lblNewLabel_4);
		edit_rec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel m = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				String idd = (m.getValueAt(row, 0)).toString();
				String namee = (m.getValueAt(row, 1)).toString();
				String passs = (m.getValueAt(row, 2)).toString();
				
				edit_id.setText(idd);
				edit_name.setText(namee);
				edit_pass.setText(passs);
				
			}
		});
		delete_rec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = table.getSelectedRow();
				int iid = (int) table.getValueAt(r, 0);
				
				try {
					PreparedStatement ppt = conn.prepareStatement("DELETE FROM users WHERE user_id=? ");
					
					ppt.setInt(1, iid);
					
					ppt.executeUpdate();
					
					System.out.println("RECORD HAS BEEN DELETED");
					ppt.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				btnNewButton.doClick();
				
			}
		});
		
	
	}
}
