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

public class AjouterMaterielleFrame extends JFrame{
	
	private JPanel contentPane;
	private JTextField tfNomMaterielle;
	private JTextField tfDateAchatMaterielle;
	private JTextField tfFinGarantieMaterielle;
	private Connection conn;
	
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
	setBounds(100, 100, 430, 430);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Nom");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel.setBounds(45, 83, 120, 40);
	contentPane.add(lblNewLabel);
	
	tfNomMaterielle = new JTextField();
	tfNomMaterielle.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tfNomMaterielle.setBounds(190, 84, 160, 40);
	contentPane.add(tfNomMaterielle);
	tfNomMaterielle.setColumns(10);
	/*
	 * Ajouter button 
	 */
	JButton btnCreerMaterielle = new JButton("cr\u00E9er");
	btnCreerMaterielle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/*
			
			String NomMaterielle = null;
    		String DateAchat = null;
    		String DateFinGarentie = null;
    		String Emplacement = null;
    		String error = null;
    		boolean exist =false;
    		boolean nomMaterielle = true,dateAchat= true,dateFinGarentie= true,emplacement = true;
    		
    		NomMaterielle = tfNomMaterielle.getText().toUpperCase();
    		// Check if name is correct
    		if(!(NomMaterielle.length()<=30 && NomMaterielle.length()>=2 && Character.isAlphabetic(NomMaterielle.charAt(0)))) {
    			tfNomMaterielle=false;
    			tfNomMaterielle.setBackground(Color.RED);
    		}
    		// Check if Price is empty
    		if(price_textField.getText().equals("")) {
    			price = false;
    			price_textField.setBackground(Color.RED);
    		}
    		// Check if Quanity is empty
    		if(quantity_textField.getText().equals("")) {
    			quantity = false;
    			quantity_textField.setBackground(Color.RED);
    		}
    		if(name && price && quantity) {
				product_price = Double.parseDouble(price_textField.getText());
				product_quantity = Integer.parseInt(quantity_textField.getText()) ;
				for(i = 0;i<model.getRowCount();i++) {
					if(table.getValueAt(i, 1).equals(product_name)) {
						exist = true;
						break;
					}
				}
				if(!exist) {
					try {
						id_max++;
						String requet = "INSERT INTO products(product_id,product_Name, product_Price, product_Quantity) "
													+"VALUES("+id_max+",'"+product_name+"',"+product_price+","+product_quantity+")";
						statement.executeUpdate(requet);
						model.addRow(new Object[]{id_max, product_name, product_price, product_quantity});
						
						name_textField.setText(null);
						price_textField.setText(null);
						quantity_textField.setText(null);
						exist = false;
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					error =   "this product already exist \n"
							+ "the id: "+model.getValueAt(i, 0);
					
					@SuppressWarnings("unused")
					errorPan fail = new errorPan(error);
				}
			}
			else {
				error =  "-Name :"
						+ "	-must be alphanumeric.\n"
						+"	-start with a letter.\n"
						+"	-between 2 and 30 character.\n"
						+"-Price and Quantity can't be empty.";
				
				@SuppressWarnings("unused")
				errorPan fail = new errorPan(error);
			}
			*/
		}
	});
	
	
	btnCreerMaterielle.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnCreerMaterielle.setBounds(240, 324, 110, 40);
	contentPane.add(btnCreerMaterielle);
	
	JButton btnAnnulerMaterielle = new JButton("Annuler");
	btnAnnulerMaterielle.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnAnnulerMaterielle.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	});
	btnAnnulerMaterielle.setBounds(72, 324, 110, 40);
	contentPane.add(btnAnnulerMaterielle);
	
	JLabel lblAjouterPersonne = new JLabel("Ajouter Mat\u00E9rielle");
	lblAjouterPersonne.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblAjouterPersonne.setBounds(101, 13, 190, 33);
	contentPane.add(lblAjouterPersonne);
	
	JLabel label = new JLabel("Date Achat");
	label.setFont(new Font("Tahoma", Font.BOLD, 16));
	label.setBounds(45, 136, 120, 40);
	contentPane.add(label);
	
	tfDateAchatMaterielle = new JTextField();
	tfDateAchatMaterielle.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tfDateAchatMaterielle.setColumns(10);
	tfDateAchatMaterielle.setBounds(190, 137, 160, 40);
	contentPane.add(tfDateAchatMaterielle);
	
	JLabel label_1 = new JLabel("Fin Garantie");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_1.setBounds(45, 189, 120, 40);
	contentPane.add(label_1);
	
	JLabel label_2 = new JLabel("Emplacement");
	label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	label_2.setBounds(45, 242, 120, 40);
	contentPane.add(label_2);
	
	tfFinGarantieMaterielle = new JTextField();
	tfFinGarantieMaterielle.setFont(new Font("Tahoma", Font.PLAIN, 16));
	tfFinGarantieMaterielle.setColumns(10);
	tfFinGarantieMaterielle.setBounds(190, 190, 160, 40);
	contentPane.add(tfFinGarantieMaterielle);
	
	JComboBox cbEmplacementMaterielle = new JComboBox();
	cbEmplacementMaterielle.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cbEmplacementMaterielle.setBounds(190, 243, 160, 40);
	contentPane.add(cbEmplacementMaterielle);
	
	setTitle("Ajouter Matérielle");
	setResizable(false);
	setBounds(500, 200, 430, 430);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	}

}
