import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class DemandeMaterielleFrame extends JFrame {
	 
	private Connection conn;
	private int id_mat;
	private JTextField tfIdMat;
	
	public DemandeMaterielleFrame(Connection conn, int id_mat) {
		this.conn= conn;
		this.id_mat = id_mat;
		initialize();
		
	}
	private void initialize() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Mat\u00E9rielle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(50, 81, 116, 31);
		getContentPane().add(lblNewLabel);
		
		tfIdMat = new JTextField();
		tfIdMat.setEnabled(false);
		tfIdMat.setText(Integer.toString(id_mat));
		tfIdMat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfIdMat.setBounds(207, 81, 171, 31);
		getContentPane().add(tfIdMat);
		tfIdMat.setColumns(10);
		initialize();
		
		
	}

}
