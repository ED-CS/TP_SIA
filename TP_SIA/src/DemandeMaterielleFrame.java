import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.SpinnerNumberModel;

public class DemandeMaterielleFrame extends JFrame {
	 
	private Connection conn;
	private Statement statement;
	private ResultSet resultSet;
	private int res;
	private int id_mat;
	private JTextField tfIdMat =new JTextField();
	private JTextField tfIdPesonne;
	private JTextField tfNomPersonne;
	private JTextField tfPrenomPersonne;
	private ButtonGroup group ;
	private JRadioButton rdbtnid;
	private JRadioButton rdbtnTnfPer;
	private JTable table;
	private DefaultTableModel model;
	private boolean choixInfo = false;
	private JSpinner spFHeur;
	private JSpinner spDMinute;
	private JSpinner spFMinute;
	private JSpinner psDHeur;
	
	
	public DemandeMaterielleFrame(Connection conn, String id_mat) {
		this.conn= conn;
		this.id_mat = Integer.parseInt(id_mat);
		tfIdMat.setText(id_mat);
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initialize();
		
	}
	private void initialize() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Mat\u00E9rielle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(50, 42, 116, 31);
		getContentPane().add(lblNewLabel);
		
		tfIdMat.setEnabled(false);
		tfIdMat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfIdMat.setBounds(170, 42, 171, 31);
		getContentPane().add(tfIdMat);
		tfIdMat.setColumns(10);
		
		JLabel label = new JLabel("Nom personne");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(50, 208, 98, 31);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Prenom Personne");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(50, 249, 116, 31);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("ID Personne");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(50, 133, 116, 31);
		getContentPane().add(label_2);
		
		tfIdPesonne = new JTextField();
		tfIdPesonne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfIdPesonne.setColumns(10);
		tfIdPesonne.setBounds(170, 133, 130, 31);
		getContentPane().add(tfIdPesonne);
		
		tfNomPersonne = new JTextField();
		tfNomPersonne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNomPersonne.setColumns(10);
		tfNomPersonne.setBounds(170, 207, 130, 30);
		getContentPane().add(tfNomPersonne);
		
		tfPrenomPersonne = new JTextField();
		tfPrenomPersonne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPrenomPersonne.setColumns(10);
		tfPrenomPersonne.setBounds(170, 248, 130, 30);
		getContentPane().add(tfPrenomPersonne);
		
		
		rdbtnid = new JRadioButton("ID:");
		rdbtnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfNomPersonne.setEnabled(false);;
				tfPrenomPersonne.setEnabled(false);
				choixInfo = false;
			}
		});
		rdbtnid.setSelected(true);
		rdbtnid.setBounds(50, 93, 127, 25);
		getContentPane().add(rdbtnid);
		
		rdbtnTnfPer = new JRadioButton("Information Presonnele");
		rdbtnTnfPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfIdPesonne.setEnabled(false);
				choixInfo = true;
			}
		});
		rdbtnTnfPer.setBounds(50, 173, 171, 25);
		getContentPane().add(rdbtnTnfPer);
		group = new ButtonGroup();
		group.add(rdbtnid);
		group.add(rdbtnTnfPer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 293, 441, 130);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nom", "Prenom", "Poste", "Email"
				}
			);
		table.setModel(model);
		
		JButton btnVerifierPesonne = new JButton("V\u00E9rifier");
		btnVerifierPesonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNomPersonne.getText().equals("")&&tfPrenomPersonne.getText().equals("")) {
					errorPan erreur = new errorPan("le nom ou le prenom est vide");
				}else {
					try {
						String request = "SELECT * from personne where nom_per ='"+tfNomPersonne.getText()+"' and prenom_per = '"+tfPrenomPersonne.getText()+"';";
						resultSet = statement.executeQuery( request);  
					    while(resultSet.next()) {
					    	model.addRow(new Object[]{
					    			resultSet.getObject(1)
					    			, resultSet.getObject(2)
					    			, resultSet.getObject(3)
					    			, resultSet.getObject(4)
					    			, resultSet.getObject(5)});
					    } 
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    
				}
			}
		});
		btnVerifierPesonne.setBounds(347, 211, 144, 25);
		getContentPane().add(btnVerifierPesonne);
		
		JButton btnAjouterPersonne = new JButton("Ajouter Personne");
		btnAjouterPersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 AjouterPersonneFrame pe = new AjouterPersonneFrame(conn,tfNomPersonne.getText(),tfPrenomPersonne.getText());
			}
		});
		btnAjouterPersonne.setBounds(347, 252, 144, 25);
		getContentPane().add(btnAjouterPersonne);
		
		JLabel label_3 = new JLabel("Date Debut");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(50, 453, 98, 31);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Date Fin");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(50, 495, 88, 31);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Heur");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(299, 453, 54, 31);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Heur");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(299, 495, 54, 31);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Munite");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(423, 451, 68, 31);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Minute");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(423, 495, 68, 31);
		getContentPane().add(label_8);
		
		psDHeur = new JSpinner();
		psDHeur.setModel(new SpinnerNumberModel(8, 8, 16, 1));
		psDHeur.setBounds(357, 451, 54, 31);
		getContentPane().add(psDHeur);
		
		spFHeur = new JSpinner();
		spFHeur.setModel(new SpinnerNumberModel(8, 8, 16, 1));
		spFHeur.setBounds(357, 495, 54, 31);
		getContentPane().add(spFHeur);
		
		spDMinute = new JSpinner();
		spDMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spDMinute.setBounds(515, 451, 54, 31);
		getContentPane().add(spDMinute);
		
		spFMinute = new JSpinner();
		spFMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spFMinute.setBounds(515, 495, 54, 31);
		getContentPane().add(spFMinute);
		
		JDateChooser DateDebutChooser = new JDateChooser();
		DateDebutChooser.setBounds(150, 451, 120, 30);
		getContentPane().add(DateDebutChooser);
		
		JDateChooser DateFinChooser = new JDateChooser();
		DateFinChooser.setBounds(150, 497, 120, 30);
		getContentPane().add(DateFinChooser);
		
		JButton btnValid = new JButton("valid\u00E9");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sd1 = new SimpleDateFormat("yyMMdd");
				String dateDebut = sd.format(DateDebutChooser.getDate());
				String dated=  sd1.format(DateDebutChooser.getDate());
				String dateFin = sd.format(DateFinChooser.getDate());
				String datef=  sd1.format(DateDebutChooser.getDate());
				if(Integer.parseInt(dated)>Integer.parseInt(datef)) {
					errorPan er = new errorPan("date debut seperieur a la date de fin");
				}
				else {
					int heurD, heurF,minutD,minutF;
					heurD = Integer.parseInt(psDHeur.getValue().toString());
					heurF = Integer.parseInt(spFHeur.getValue().toString());
					minutD = Integer.parseInt(spDMinute.getValue().toString());
					minutF = Integer.parseInt(spFMinute.getValue().toString());
					
					if(choixInfo) {
						
						
						
					}else {
						int id_personne= Integer.parseInt(tfIdPesonne.getText());
						int id_demande_materielle = 0;
						String request = "insert into demande_reservation_materielle (id_per)values("+id_personne+");";
						try {
							res = statement.executeUpdate( request);
							resultSet = statement.executeQuery("select id_dmd from demande_reservation_materielle;");  
							while(resultSet.next()) {
							    id_demande_materielle = resultSet.getInt(1);
							}
							request = "insert into reservation_materielle values("+id_demande_materielle+","+DateDebutChooser.getDate()+","+DateFinChooser.getDate()+","+id_mat+","+heurD+","+heurF+","+minutD+","+minutF+");";
							res = statement.executeUpdate( request);				
							if(res==1) {
								successPan s = new successPan("demande ajouter",null);
							}else {
								errorPan er = new errorPan("demande n'est pas ajouter");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}						
					}
					
				}
				
				
				
			}
		});
		btnValid.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnValid.setBounds(438, 567, 120, 35);
		getContentPane().add(btnValid);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAnnuler.setBounds(299, 567, 120, 35);
		getContentPane().add(btnAnnuler);
		
		
		setTitle("Matérielle");
		setResizable(false);
		setBounds(500, 200, 630, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
