import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class ReservationMaterielle extends JFrame {
	private JPanel contentPane;
	private Connection conn;
	private Statement statement;
	private ResultSet resultSet;
	private JTable table;
	private JRadioButton rdbtnTout;
	private JRadioButton rdbtnDisponible;
	private ButtonGroup group;
	private DefaultTableModel model;
	private JButton btnInformationMaterielle;
	private JButton btnSortir;
	private JButton btnDesponibilite;
	private JButton button;
	

	/**
	 * Create the frame.
	 */
	public ReservationMaterielle(Connection conn) {
		this.conn= conn;
		initialize();
		try {
			statement = conn.createStatement();
			model.setRowCount(0);
		    resultSet = statement.executeQuery("SELECT * from materielle where id_mat not in(select id_mat from reservation_materielle)");  
		    while(resultSet.next()) {
		    	model.addRow(new Object[]{resultSet.getObject(1), resultSet.getObject(2), resultSet.getObject(3), resultSet.getObject(4), resultSet.getObject(5)});
		    } 
		} 
		catch(SQLException e1) {
		      System.out.println(e1.getMessage());
		}
	}	
		/**
		 * Initialize the contents of the frame.
		 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 81, 462, 398);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nom", "Emplacement", "Date Achat", "Date Garantie"
				}
			);
		table.setModel(model);
		/*
		 * Radio button tout
		 */
		
		rdbtnTout = new JRadioButton("Touts");
		rdbtnTout.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnTout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					model.setRowCount(0);
				    resultSet = statement.executeQuery("SELECT * from materielle");  
				    while(resultSet.next()) {
				    	model.addRow(new Object[]{resultSet.getObject(1), resultSet.getObject(2), resultSet.getObject(3), resultSet.getObject(4), resultSet.getObject(5)});				 
				    } 
				} 
				catch(SQLException e1) {
				      System.out.println(e1.getMessage());
				}	
			}
		});
		rdbtnTout.setBounds(187, 498, 127, 25);
		
		contentPane.add(rdbtnTout);
		/*
		 * radio button disponible
		 */
		rdbtnDisponible = new JRadioButton("Disponible");
		rdbtnDisponible.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnDisponible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					model.setRowCount(0);
				    resultSet = statement.executeQuery("SELECT * from materielle where id_mat not in(select id_mat from reservation_materielle);");  
				    while(resultSet.next()) {
				    	model.addRow(new Object[]{resultSet.getObject(1), resultSet.getObject(2), resultSet.getObject(3), resultSet.getObject(4), resultSet.getObject(5)});		
				    } 
				} 
				catch(SQLException e1) {
				      System.out.println(e1.getMessage());
				}	
			}
		});
		rdbtnDisponible.setBounds(350, 498, 127, 25);
		rdbtnDisponible.setSelected(true);
		contentPane.add(rdbtnDisponible);
		
		group = new ButtonGroup();
		group.add(rdbtnDisponible);
		group.add(rdbtnTout);
		
		/*
		 * Information button
		 */
		btnInformationMaterielle = new JButton("Information");
		btnInformationMaterielle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInformationMaterielle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = null;
				int i = table.getSelectedRow();
				int j = 0;
				String value = table.getValueAt(i, j).toString();
				try {
				 resultSet = statement.executeQuery("SELECT * from materielle where id_mat = "+value);
				    if(resultSet.next()) {
				    	message = "ID Matérielle: "+resultSet.getObject(1)
	    				 +"\nNom MAtérielle: "+resultSet.getObject(2)
	    				 +"\nEmplacement: "+resultSet.getObject(3)
	    				 +"\nDate Achat: "+resultSet.getObject(4)
	    				 +"\nDate Garantie: "+resultSet.getObject(5);				   
				    	} 
				    successPan s = new successPan(message,null);
				} 
				catch(SQLException e2) {
				      System.out.println(e2.getMessage());
				}
				
			}
		});
		btnInformationMaterielle.setBounds(591, 181, 160, 35);
		contentPane.add(btnInformationMaterielle);
		
		/*
		 * Sortir Button
		 */
		btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSortir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSortir.setBounds(621, 577, 130, 35);
		contentPane.add(btnSortir);
		/*
		 * Disponibilité Button
		 */
		btnDesponibilite = new JButton("Disponibilit\u00E9");
		btnDesponibilite.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDesponibilite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				int j = 0;
				String value = table.getValueAt(i, j).toString();
				
				DesponibiliteFrame des = new DesponibiliteFrame(conn, value);
			}
		});
		btnDesponibilite.setBounds(591, 230, 160, 35);
		contentPane.add(btnDesponibilite);
		/*
		 * button demande materielle
		 */
		
		button = new JButton("Demande Mat\u00E9rielle");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				int j = 0;
				String value = table.getValueAt(i, j).toString();

				DemandeMaterielleFrame demande = new DemandeMaterielleFrame(conn,value);
				
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(591, 133, 160, 35);
		contentPane.add(button);
		
		setTitle("Matérielle");
		setResizable(false);
		setBounds(500, 200, 800, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}	
}
