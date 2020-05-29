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

public class WB_AjouterPersonne extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomPersonne;
	private JTextField tfPrenomPersonne;
	private JTextField tfEmailPersonne;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WB_AjouterPersonne frame = new WB_AjouterPersonne(null);
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
	public WB_AjouterPersonne(Connection conn) {
		this.conn = conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(45, 83, 120, 40);
		contentPane.add(lblNewLabel);
		
		tfNomPersonne = new JTextField();
		tfNomPersonne.setBounds(190, 84, 160, 40);
		contentPane.add(tfNomPersonne);
		tfNomPersonne.setColumns(10);
		
		JButton btnCreerPersonne = new JButton("cr\u00E9er");
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
		tfPrenomPersonne.setColumns(10);
		tfPrenomPersonne.setBounds(190, 137, 160, 40);
		contentPane.add(tfPrenomPersonne);
		
		JLabel label_1 = new JLabel("Poste");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(45, 189, 120, 40);
		contentPane.add(label_1);
		
		tfEmailPersonne = new JTextField();
		tfEmailPersonne.setColumns(10);
		tfEmailPersonne.setBounds(190, 243, 160, 40);
		contentPane.add(tfEmailPersonne);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(45, 242, 120, 40);
		contentPane.add(label_2);
		
		JComboBox cbPostePersonne = new JComboBox();
		cbPostePersonne.setBounds(190, 190, 160, 40);
		contentPane.add(cbPostePersonne);
	}
}
