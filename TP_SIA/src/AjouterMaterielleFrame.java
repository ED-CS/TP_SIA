import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class AjouterMaterielleFrame extends JFrame{
	
	private JPanel contentPane;
	private JTextField tfNomMaterielle;
	private Connection conn;
	private JSpinner spAchatAnnee;
	private JSpinner spAchatMoins;
	private JSpinner spAchatJour;
	private JSpinner spGarantieAnnee;
	private JSpinner spGarantieMoins;
	private JSpinner spGarantieJour;
	private JComboBox cbEmplacementMaterielle;
	
	/**
	 * Create the frame.
	 */
	public AjouterMaterielleFrame(Connection conn) {
		this.conn = conn;
		initialize();
	}
		/**
		 * Initialize the contents of the frame.
		 */
	private void initialize() {
	
	this.conn = conn;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 500, 430);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Nom");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel.setBounds(45, 84, 120, 40);
	contentPane.add(lblNewLabel);
	
	tfNomMaterielle = new JTextField();
	tfNomMaterielle.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tfNomMaterielle.setBounds(113, 84, 237, 40);
	contentPane.add(tfNomMaterielle);
	tfNomMaterielle.setColumns(10);
	/*
	 * Creer button 
	 */
	JButton btnCreerMaterielle = new JButton("cr\u00E9er");
	btnCreerMaterielle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String AchatAnnee = spAchatAnnee.getValue().toString();
			
			System.out.println(AchatAnnee);
			/*
			String NomMaterielle = tfNomMaterielle.getText();
			int AchatJour = Integer.parseInt(spAchatJour.getValue().toString());
			int AchatAnnee = Integer.parseInt(spAchatAnnee.getValue().toString());
			int AchatMoins = Integer.parseInt(spAchatMoins.getValue().toString());
			int GarantieAnnee = Integer.parseInt(spGarantieAnnee.getValue().toString());
			int GarantieMoins = Integer.parseInt(spGarantieMoins.getValue().toString());
			int GarantieJour = Integer.parseInt(spGarantieJour.getValue().toString());
			String EmplacementMaterielle = cbEmplacementMaterielle.getSelectedItem().toString();
			
    		boolean achatJour = true, achatAnnee= true, achatMoins= true , emailPersonne= true , garantieAnnee= true , garantieJour= true,
    				garantieMoins = true, nomMaterielle= true, emplacementMaterielle= true,achat = true, garantie = true;
    		if((AchatAnnee>=2020)&&(AchatMoins>0)&&(AchatMoins<=12)) {
    			if((AchatMoins==2)) {
    				if(achat) {}
    			}
    		}
    		
    		
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
			*/
		}
	});
	
	
	btnCreerMaterielle.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnCreerMaterielle.setBounds(304, 362, 110, 40);
	contentPane.add(btnCreerMaterielle);
	
	JButton btnAnnulerMaterielle = new JButton("Annuler");
	btnAnnulerMaterielle.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnAnnulerMaterielle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	});
	btnAnnulerMaterielle.setBounds(168, 362, 110, 40);
	contentPane.add(btnAnnulerMaterielle);
	
	JLabel lblAjouterPersonne = new JLabel("Ajouter Mat\u00E9rielle");
	lblAjouterPersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblAjouterPersonne.setBounds(101, 13, 190, 33);
	contentPane.add(lblAjouterPersonne);
	
	JLabel label = new JLabel("Achat:");
	label.setFont(new Font("Tahoma", Font.BOLD, 16));
	label.setBounds(45, 136, 56, 40);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("Garantie:");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_1.setBounds(273, 136, 77, 40);
	contentPane.add(label_1);
	
	JLabel label_2 = new JLabel("Emplacement");
	label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_2.setBounds(45, 297, 120, 40);
	contentPane.add(label_2);
	
	cbEmplacementMaterielle = new JComboBox();
	cbEmplacementMaterielle.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cbEmplacementMaterielle.setBounds(190, 297, 275, 40);
	contentPane.add(cbEmplacementMaterielle);
	
	JLabel lblAnne = new JLabel("Ann\u00E9e");
	lblAnne.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblAnne.setBounds(113, 156, 50, 16);
	contentPane.add(lblAnne);
	
	JLabel lblMoins = new JLabel("moins");
	lblMoins.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblMoins.setBounds(113, 196, 50, 16);
	contentPane.add(lblMoins);
	
	JLabel lblJour = new JLabel("jour");
	lblJour.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblJour.setBounds(113, 240, 41, 16);
	contentPane.add(lblJour);
	
	JLabel label_3 = new JLabel("Ann\u00E9e");
	label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
	label_3.setBounds(362, 156, 50, 16);
	contentPane.add(label_3);
	
	JLabel label_4 = new JLabel("moins");
	label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	label_4.setBounds(362, 196, 50, 16);
	contentPane.add(label_4);
	
	JLabel label_5 = new JLabel("jour");
	label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
	label_5.setBounds(362, 240, 41, 16);
	contentPane.add(label_5);
	
	spAchatJour = new JSpinner();
	spAchatJour.setFont(new Font("Tahoma", Font.PLAIN, 16));
	spAchatJour.setBounds(175, 233, 60, 30);
	contentPane.add(spAchatJour);
	
	spAchatAnnee = new JSpinner();
	spAchatAnnee.setModel(new SpinnerDateModel(new Date(1590706800000L), new Date(1590706800000L), null, Calendar.YEAR));
	spAchatAnnee.setFont(new Font("Tahoma", Font.PLAIN, 16));
	spAchatAnnee.setBounds(0, 367, 165, 30);
	contentPane.add(spAchatAnnee);
	
	spAchatMoins = new JSpinner();
	spAchatMoins.setFont(new Font("Tahoma", Font.PLAIN, 16));
	spAchatMoins.setBounds(175, 189, 60, 30);
	contentPane.add(spAchatMoins);
	
	spGarantieAnnee = new JSpinner();
	spGarantieAnnee.setFont(new Font("Tahoma", Font.PLAIN, 16));
	spGarantieAnnee.setBounds(422, 149, 60, 30);
	contentPane.add(spGarantieAnnee);
	
	spGarantieMoins = new JSpinner();
	spGarantieMoins.setFont(new Font("Tahoma", Font.PLAIN, 16));
	spGarantieMoins.setBounds(422, 189, 60, 30);
	contentPane.add(spGarantieMoins);
	
	spGarantieJour = new JSpinner();
	spGarantieJour.setFont(new Font("Tahoma", Font.PLAIN, 16));
	spGarantieJour.setBounds(422, 233, 60, 30);
	contentPane.add(spGarantieJour);
	
	setTitle("Ajouter Matérielle");
	setResizable(false);
	setBounds(500, 200, 500, 450);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
}
