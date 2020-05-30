import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class WB_ReservationMaterielle extends JFrame {

	private JPanel contentPane;
	private Connection conn;
	private Statement statement;
	private ResultSet resultSet;
	private JTable table;
	private JRadioButton rdbtnTout;
	private JRadioButton rdbtnDisponible;
	private ButtonGroup group;
	private DefaultTableModel model;
	private int id_max;
	private JButton btnInformationMaterielle;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WB_ReservationMaterielle frame = new WB_ReservationMaterielle(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WB_ReservationMaterielle(Connection conn) {
		
		this.conn= conn;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		initialize();
	}	
		/**
		 * Initialize the contents of the frame.
		 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 81, 462, 398);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nom", "Emplacement", "Date Achat", "Date Garantie"
				}
			) {
				private static final long serialVersionUID = 4749360580822762641L;
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setModel(model);
		/*
		 * Radio button tout
		 */
		
		rdbtnTout = new JRadioButton("Touts");
		rdbtnTout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    resultSet = statement.executeQuery("SELECT * from materielle");  
				    while(resultSet.next()) {
				    	model.addRow(new Object[]{resultSet.getObject(1), resultSet.getObject(2), resultSet.getObject(3), resultSet.getObject(4), resultSet.getObject(4)});
				    	id_max = resultSet.getInt(1);
				    } 
				} 
				catch(SQLException e1) {
				      System.out.println(e1.getMessage());
				}	
			}
		});
		rdbtnTout.setBounds(187, 498, 127, 25);
		rdbtnTout.setSelected(true);
		contentPane.add(rdbtnTout);
		/*
		 * radio button disponible
		 */
		rdbtnDisponible = new JRadioButton("Disponible");
		rdbtnDisponible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    resultSet = statement.executeQuery("SELECT * from materielle where id_mat not in(select id_mat from ligne_demande_materielle)");  
				    while(resultSet.next()) {
				    	model.addRow(new Object[]{resultSet.getObject(1), resultSet.getObject(2), resultSet.getObject(3), resultSet.getObject(4), resultSet.getObject(5)});
				    	id_max = resultSet.getInt(1);
				    } 
				} 
				catch(SQLException e1) {
				      System.out.println(e1.getMessage());
				}	
			}
		});
		rdbtnDisponible.setBounds(350, 498, 127, 25);
		contentPane.add(rdbtnDisponible);
		
		group = new ButtonGroup();
		group.add(rdbtnDisponible);
		group.add(rdbtnTout);
		
		/*
		 * nformation button
		 */
		btnInformationMaterielle = new JButton("Information");
		btnInformationMaterielle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInformationMaterielle.setBounds(611, 124, 130, 35);
		contentPane.add(btnInformationMaterielle);
	}	
	
}
