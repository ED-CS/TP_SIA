import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AjouterSalleFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfNomSalle;
	JSpinner spCapaciteSalle;
	private Connection conn;
	private Statement statement; 



	/**
	 * Create the frame.
	 */
	public AjouterSalleFrame(Connection conn) {
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
		setBounds(100, 100, 429, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(45, 83, 120, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("capacit\u00E9");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(45, 136, 120, 40);
		contentPane.add(lblNewLabel_1);
		
		tfNomSalle = new JTextField();
		tfNomSalle.setBounds(190, 84, 160, 40);
		contentPane.add(tfNomSalle);
		tfNomSalle.setColumns(10);
		
		JButton btnCreerSalle = new JButton("cr\u00E9er");
		
		/*
		 * Button Ajouter
		 */
		btnCreerSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NomSalle = null;
	    		int CapaciteSalle = 0;
	    		boolean nomSalle = true,capaciteSalle= true;
	    		
	    		NomSalle = tfNomSalle.getText().toUpperCase();
	    		CapaciteSalle = Integer.parseInt(spCapaciteSalle.getValue().toString());
	    		// Check if name is correct
	    		if(!(NomSalle.length()<=30 && NomSalle.length()>=2 && Character.isAlphabetic(NomSalle.charAt(0)))) {
	    			nomSalle=false;
	    			tfNomSalle.setBackground(Color.RED);
	    		}
	    		
	    		if(!(Integer.parseInt(spCapaciteSalle.getValue().toString())>=30)) {
	    			capaciteSalle=false;
	    			spCapaciteSalle.setBackground(Color.RED);
	    		}
	    		if(nomSalle && capaciteSalle ) {
						try {
							String requet = "INSERT INTO salle(nom_salle,capacite_salle) "
														+"VALUES('"+NomSalle+"',"+CapaciteSalle+");";
							statement.executeUpdate(requet);
							tfNomSalle.setText(null);
							spCapaciteSalle.setValue(0);
						}
						catch (SQLException o) {
							o.printStackTrace();
						}
				}
				else {
					String error =  "-Nom :"
							+ "	-alphanumérique.\n"
							+"	-commencer par  lettre.\n"
							+"	-entre 2 et 30 character.\n"
							+"-capacite >= 30.";
					
					@SuppressWarnings("unused")
					errorPan fail = new errorPan(error);
				}
			}
		});
		btnCreerSalle.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreerSalle.setBounds(240, 222, 110, 40);
		contentPane.add(btnCreerSalle);
		
		JButton btnAnnulerSalle = new JButton("Annuler");
		btnAnnulerSalle.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAnnulerSalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnulerSalle.setBounds(90, 222, 110, 40);
		contentPane.add(btnAnnulerSalle);
		
		JLabel lblAjouterPersonne = new JLabel("Ajouter Salle");
		lblAjouterPersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAjouterPersonne.setBounds(120, 13, 160, 33);
		contentPane.add(lblAjouterPersonne);
		
		spCapaciteSalle = new JSpinner();
		spCapaciteSalle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spCapaciteSalle.setBounds(190, 137, 160, 40);
		contentPane.add(spCapaciteSalle);
		
		setTitle("Ajouter Salle");
		setResizable(false);
		setBounds(500, 200, 430, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		}

}
