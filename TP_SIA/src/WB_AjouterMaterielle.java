import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class WB_AjouterMaterielle extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomMaterielle;
	private JTextField tfDateAchatMaterielle;
	private JTextField tfFinGarantieMaterielle;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WB_AjouterMaterielle frame = new WB_AjouterMaterielle(null);
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
	public WB_AjouterMaterielle(Connection conn) {
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
		
		JButton btnCreerMaterielle = new JButton("cr\u00E9er");
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
	}
}
