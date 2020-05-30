import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;

public class AjouterMaterielleFrame extends JFrame{
	
	private JPanel contentPane;
	private JTextField tfNomMaterielle;
	private Connection conn;
	private Statement stm;
	private JComboBox cbEmplacementMaterielle;
	private JDateChooser dcspAchatAnnee;
	private JDateChooser dcGarientieAnnee;
	
	/**
	 * Create the frame.
	 */
	public AjouterMaterielleFrame(Connection conn) {
		this.conn = conn;
		
		try {
			stm = conn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
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
	tfNomMaterielle.setBounds(186, 84, 190, 40);
	contentPane.add(tfNomMaterielle);
	tfNomMaterielle.setColumns(10);
	/*
	 * Creer button 
	 */
	JButton btnCreerMaterielle = new JButton("cr\u00E9er");
	btnCreerMaterielle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String NomMaterielle = tfNomMaterielle.getText();
			SimpleDateFormat sd = new SimpleDateFormat("yyMMdd");
			String AchatAnnee = sd.format(dcspAchatAnnee.getDate()) ;
			String GarientieAnnee = sd.format(dcGarientieAnnee.getDate()) ;
			String EmplacementMaterielle = cbEmplacementMaterielle.getSelectedItem().toString();
			
			
			boolean date= true, nomMaterielle= true;
			
			// vérifier si nom materielle est correcte
			if(!(NomMaterielle.length()<=30 && NomMaterielle.length()>=2 && Character.isAlphabetic(NomMaterielle.charAt(0)))) {
				nomMaterielle=false;
				tfNomMaterielle.setBackground(Color.RED);
			}
			// vérifier si date est correcte
			if(Integer.parseInt(AchatAnnee)>Integer.parseInt(GarientieAnnee)) {
				date = false;
			}
			//i
    		if(date && nomMaterielle) {
					try {
						String requet = "INSERT INTO materielle(nom_mat,emplacement,achat,garantie) "
													+"VALUES('"+NomMaterielle+"','"
													+EmplacementMaterielle+"','"
													+AchatAnnee+"','"
													+GarientieAnnee+"');";
						stm.executeUpdate(requet);
						
						tfNomMaterielle.setText(null);
					}
					catch (SQLException o) {
						o.printStackTrace();
					}
			}
			else {
				if(date==false){
					String error =  "-Date :"
							+"	-Date de Achat suparieur a Date Garantie .";
					@SuppressWarnings("unused")
					errorPan fail = new errorPan(error);
				}else{
					String error =  "-Nom et prenom et Email :"
							+ "	-alphanumérique.\n"
							+"	-commencer par  lettre.\n"
							+"	-entre 2 et 30 character.\n";
					@SuppressWarnings("unused")
					errorPan fail = new errorPan(error);
				}
			}
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
	label.setBounds(45, 137, 56, 40);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("Garantie:");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_1.setBounds(45, 190, 77, 40);
	contentPane.add(label_1);
	
	JLabel label_2 = new JLabel("Emplacement");
	label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_2.setBounds(45, 243, 120, 40);
	contentPane.add(label_2);
	
	cbEmplacementMaterielle = new JComboBox();
	cbEmplacementMaterielle.setModel(new DefaultComboBoxModel(new String[] {"secrétariat des études", "l’accueil"}));
	cbEmplacementMaterielle.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cbEmplacementMaterielle.setBounds(186, 243, 275, 40);
	contentPane.add(cbEmplacementMaterielle);
	
	dcspAchatAnnee = new JDateChooser();
	dcspAchatAnnee.setBounds(186, 137, 190, 40);
	contentPane.add(dcspAchatAnnee);
	
	dcGarientieAnnee = new JDateChooser();
	dcGarientieAnnee.setBounds(186, 190, 190, 40);
	contentPane.add(dcGarientieAnnee);
	
	setTitle("Ajouter Matérielle");
	setResizable(false);
	setBounds(500, 200, 500, 450);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}
}
