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
import javax.swing.JSpinner;

public class WB_AjouterSalle extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomSalle;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WB_AjouterSalle frame = new WB_AjouterSalle(null);
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
	public WB_AjouterSalle(Connection conn) {
		this.conn = conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 347);
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
		
		JSpinner spCapaciteSalle = new JSpinner();
		spCapaciteSalle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spCapaciteSalle.setBounds(190, 137, 160, 40);
		contentPane.add(spCapaciteSalle);
		
		
	}
}
