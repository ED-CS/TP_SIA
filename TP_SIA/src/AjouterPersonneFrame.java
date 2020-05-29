import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AjouterPersonneFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfNomPersonne;
	private JTextField tfPrenomPersonne;
	private JTextField tfEmailPersonne;
	private JComboBox cbPostePersonne;
	private Connection conn;
	private Statement statement;
	
	/**
	 * Create the frame.
	 */
	public AjouterPersonneFrame(Connection conn) {
		this.conn = conn;
		
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
	setBounds(100, 100, 429, 435);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Nom");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel.setBounds(45, 83, 120, 40);
	contentPane.add(lblNewLabel);
	
	tfNomPersonne = new JTextField();
	tfNomPersonne.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tfNomPersonne.setBounds(190, 84, 160, 40);
	contentPane.add(tfNomPersonne);
	tfNomPersonne.setColumns(10);
	
	JButton btnCreerPersonne = new JButton("cr\u00E9er");
	/*
	 * ajouter personne button
	 */
	btnCreerPersonne.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String NomPersonne = null;
			String PrenomPersonne = null;
			String PostePersonne = null;
			String EmailPersonne = null;
    		boolean nomPersonne = true, prenomPersonne= true, emailPersonne= true;
    		
    		NomPersonne = tfNomPersonne.getText().toUpperCase();
    		PrenomPersonne = tfPrenomPersonne.getText().toUpperCase();
    		EmailPersonne = tfEmailPersonne.getText();
    		PostePersonne = cbPostePersonne.getSelectedItem().toString();
    		
    		// Check if name is correct
    		if(!(NomPersonne.length()<=30 && NomPersonne.length()>=2 && Character.isAlphabetic(NomPersonne.charAt(0)))) {
    			nomPersonne=false;
    			tfNomPersonne.setBackground(Color.RED);
    		}
    		// Check if prenom is correct
    		if(!(PrenomPersonne.length()<=30 && PrenomPersonne.length()>=2 && Character.isAlphabetic(PrenomPersonne.charAt(0)))) {
    			prenomPersonne=false;
    			tfPrenomPersonne.setBackground(Color.RED);
    		}
    		// Check if email is correct
    		if(!(EmailPersonne.length()>=10 && Character.isAlphabetic(EmailPersonne.charAt(0)))) {
    			emailPersonne=false;
    			tfEmailPersonne.setBackground(Color.RED);
    		}
    		
    		
    		if(nomPersonne && prenomPersonne && emailPersonne ) {
					try {
						String requet = "INSERT INTO personne(nom_per,prenom_per,poste,email) "
													+"VALUES('"+NomPersonne+"','"
													+PrenomPersonne+"','"
													+PostePersonne+"','"
													+EmailPersonne+"');";
						statement.executeUpdate(requet);
						
						tfNomPersonne.setText(null);
						tfPrenomPersonne.setText(null);
						tfEmailPersonne.setText(null);
					}
					catch (SQLException o) {
						o.printStackTrace();
					}
			}
			else {
				String error =  "-Nom et prenom et Email :"
						+ "	-alphabétique.\n"
						+"	-commencer par  lettre.\n"
						+"	-entre 2 et 30 character.\n"
						+"	-Email >= 12 lettre.";
				
				@SuppressWarnings("unused")
				errorPan fail = new errorPan(error);
			}
			
		}
	});
	btnCreerPersonne.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnCreerPersonne.setBounds(240, 324, 110, 40);
	contentPane.add(btnCreerPersonne);
	
	JButton btnAnnulerPersonne = new JButton("Annuler");
	btnAnnulerPersonne.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnAnnulerPersonne.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	});
	btnAnnulerPersonne.setBounds(72, 324, 110, 40);
	contentPane.add(btnAnnulerPersonne);
	
	JLabel lblAjouterPersonne = new JLabel("Ajouter Personne");
	lblAjouterPersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblAjouterPersonne.setBounds(120, 13, 188, 33);
	contentPane.add(lblAjouterPersonne);
	
	JLabel label = new JLabel("Prenom");
	label.setFont(new Font("Tahoma", Font.BOLD, 16));
	label.setBounds(45, 136, 120, 40);
	contentPane.add(label);
	
	tfPrenomPersonne = new JTextField();
	tfPrenomPersonne.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tfPrenomPersonne.setColumns(10);
	tfPrenomPersonne.setBounds(190, 137, 160, 40);
	contentPane.add(tfPrenomPersonne);
	
	JLabel label_1 = new JLabel("Poste");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_1.setBounds(45, 189, 120, 40);
	contentPane.add(label_1);
	
	tfEmailPersonne = new JTextField();
	tfEmailPersonne.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tfEmailPersonne.setColumns(10);
	tfEmailPersonne.setBounds(190, 243, 160, 40);
	contentPane.add(tfEmailPersonne);
	
	JLabel label_2 = new JLabel("Email");
	label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_2.setBounds(45, 242, 120, 40);
	contentPane.add(label_2);
	
	cbPostePersonne = new JComboBox();
	cbPostePersonne.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cbPostePersonne.setModel(new DefaultComboBoxModel(new String[] {"Doctore", "Doctorent", "Etudaint", "Professoeur"}));
	cbPostePersonne.setBounds(190, 190, 160, 40);
	contentPane.add(cbPostePersonne);
	
	setTitle("Ajouter Personne");
	setResizable(false);
	setBounds(500, 200, 430, 430);
	setVisible(true);
	}

}
